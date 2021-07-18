package com.amela.controller;

import com.amela.dao.ThanhPhoDAO;
import com.amela.model.ThanhPho;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "cityServlet", urlPatterns= "/ThanhPho")
public class cityServlet extends HttpServlet {
    private ThanhPhoDAO thanhPhoDAO;


    public void init() {
        thanhPhoDAO = new ThanhPhoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":

                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "view":
                viewThanhPho(request, response);

                break;
            default:
                listCity(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("thanhPho", new ThanhPho());
        RequestDispatcher dispatcher= request.getRequestDispatcher("/city/create.jsp");
        dispatcher.forward(request,response);
    }

    private void viewThanhPho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThanhPho thanhPho = this.thanhPhoDAO.chiTietThanhPho(id);
        RequestDispatcher dispatcher;
        if (thanhPho == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("thanhPho", thanhPho);
            dispatcher = request.getRequestDispatcher("city/view.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        thanhPhoDAO.xoaThanhPho(id);

        List<ThanhPho> listThanhPho = thanhPhoDAO.danhSachThanhPho();
        request.setAttribute("listThanhPho", listThanhPho);
        RequestDispatcher dispatcher = request.getRequestDispatcher("city/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));


        ThanhPho existingThanhPho = thanhPhoDAO.chiTietThanhPho(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("city/edit.jsp");

        request.setAttribute("thanhPho", existingThanhPho);
        dispatcher.forward(request, response);
    }




    private void listCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String indexPage = request.getParameter("index");
        if (indexPage == null){
            indexPage ="1";
        }
        int index = Integer.parseInt(indexPage);
        int count = thanhPhoDAO.getTotalThanhPho();
        int endPage = count /9;
        if ( count / 9 !=0)
        {
            endPage ++;
        }
        List<ThanhPho> list = thanhPhoDAO.pageThanhPho(index);


//        List<ThanhPho> listThanhPho = thanhPhoDAO.danhSachThanhPho();
        request.setAttribute("listA", list);
//        request.setAttribute("listThanhPho",listThanhPho);
        request.setAttribute("endP",endPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/city/list.jsp");

            dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                try {
                    insertThanhPho(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateThanhPho(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }

    }



    private void updateThanhPho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("Id"));
        String tenThanhPho = request.getParameter("TenThanhPho");
        String tenQuocGia = request.getParameter("TenQuocGia");
        float dienTich = Float.parseFloat(request.getParameter("DienTich"));
        double danSo = Double.parseDouble(request.getParameter("DanSo"));
        String gdp = request.getParameter("GDP");
        String moTa = request.getParameter("MoTa");

        ThanhPho book = new ThanhPho(id, tenThanhPho, tenQuocGia, dienTich, danSo, gdp, moTa);
        thanhPhoDAO.capNhatThanhPho(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("city/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void insertThanhPho(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String tenThanhpho = request.getParameter("TenThanhPho");

        String tenQuocGia = request.getParameter("TenQuocGia");
        float dienTich = Float.parseFloat(request.getParameter("DienTich"));
        double danSo = Double.parseDouble(request.getParameter("DanSo"));
        String gdp = request.getParameter("GDP");
        String mota = request.getParameter("MoTa");
        ThanhPho thanhPho = new ThanhPho(tenThanhpho,tenQuocGia,dienTich,danSo,gdp,mota);
        thanhPhoDAO.themThanhPho(thanhPho);
        request.getRequestDispatcher("city/list.jsp").forward(request,response);




    }

}
