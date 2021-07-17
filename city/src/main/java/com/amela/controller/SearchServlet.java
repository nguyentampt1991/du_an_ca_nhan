package com.amela.controller;

import com.amela.dao.ThanhPhoDAO;
import com.amela.model.ThanhPho;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSeach = request.getParameter("tuKhoa");

        ThanhPhoDAO dao = new ThanhPhoDAO();
        List<ThanhPho> list = dao.timKiemThanhPho(txtSeach);
        request.setAttribute("listA",list);

        request.getRequestDispatcher("/city/list.jsp").forward(request,response);
    }
}
