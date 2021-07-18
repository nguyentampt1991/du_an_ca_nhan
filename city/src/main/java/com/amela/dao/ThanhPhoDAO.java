package com.amela.dao;

import com.amela.model.ThanhPho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ThanhPhoDAO implements iThanhPhoDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quanlythanhpho?useSSl=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thiennhan3012";
    private static final String INSERT_ThanhPho = "INSERT INTO thanhpho" + " (TenThanhPho, TenQuocGia, DienTich, DanSo, GDP, MoTa) VALUES " + "(?,?,?,?,?,?);";
    private static final String SELECT_CITY_BY_ID = "SELECT Id, TenThanhPho, TenQuocGia, DienTich, DanSo, GDP, MoTa  " + "from thanhpho where Id =?";
    private static final String SELECT_ALL_CITY = "select * from thanhpho";
    private static final String DELETE_CITY = "DELETE FROM thanhpho where id = ?;";
    private static final String UPDATE_CITY = "Update thanhpho set TenThanhPho=?, TenQuocGia=?, DienTich=?, DanSo=?, GDP =?, MoTa=? where Id = ?";


    public ThanhPhoDAO() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void themThanhPho(ThanhPho thanhPho) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ThanhPho)) {
            preparedStatement.setString(1, thanhPho.getTenThanhPho());
            preparedStatement.setString(2, thanhPho.getTenQuocGia());
            preparedStatement.setFloat(3, thanhPho.getDienTich());
            preparedStatement.setDouble(4, thanhPho.getDanSo());
            preparedStatement.setString(5, thanhPho.getGdp());
            preparedStatement.setString(6, thanhPho.getMoTa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public ThanhPho chiTietThanhPho(int id) {

        ThanhPho thanhPho = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITY_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String tenThanhPho = rs.getString("TenThanhPho");
                String tenQuocGia = rs.getString("TenQuocGia");
                float dienTich = rs.getFloat("DienTich");
                double danSo = rs.getDouble("DanSo");
                String gdp = rs.getString("GDP");
                String moTa = rs.getString("MoTa");
                thanhPho = new ThanhPho(id, tenThanhPho, tenQuocGia, dienTich, danSo, gdp, moTa);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return thanhPho;
    }

    @Override
    public List<ThanhPho> danhSachThanhPho() {
        List<ThanhPho> thanhPhos = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CITY);) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String tenThanhPho = rs.getString("TenThanhPho");
                String tenQuocGia = rs.getString("TenQuocGia");
                float dienTich = rs.getFloat("DienTich");
                double danSo = rs.getDouble("DanSo");
                String gdp = rs.getString("GDP");
                String moTa = rs.getString("MoTa");
                thanhPhos.add(new ThanhPho(id, tenThanhPho, tenQuocGia, dienTich, danSo, gdp, moTa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thanhPhos;
    }

    @Override
    public boolean xoaThanhPho(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CITY);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean capNhatThanhPho(ThanhPho thanhPho) throws SQLException {

        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CITY);) {
            statement.setString(1, thanhPho.getTenThanhPho());
            statement.setString(2, thanhPho.getTenQuocGia());
            statement.setFloat(3, thanhPho.getDienTich());
            statement.setDouble(4, thanhPho.getDanSo());
            statement.setString(5, thanhPho.getGdp());
            statement.setString(6, thanhPho.getMoTa());
            statement.setFloat(7, thanhPho.getId());


            rowUpdated = statement.executeUpdate() > 0;

        }
        return rowUpdated;

    }

   public  int  getTotalThanhPho()
   {
       String query = "select count(*) from thanhpho";
       try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(query)){
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next())
           {
               return  rs.getInt(1);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return 0;

   }
   public  List<ThanhPho> pageThanhPho(int index){
        List<ThanhPho> list = new ArrayList<>();
        String query = "select * from thanhpho LIMIT 6 OFFSET ?;";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            {
                preparedStatement.setInt(1,(index -1)*6);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("Id");
                    String tenThanhPho = rs.getString("TenThanhPho");
                    String tenQuocGia = rs.getString("TenQuocGia");
                    float dienTich = rs.getFloat("DienTich");
                    double danSo = rs.getDouble("DanSo");
                    String gdp = rs.getString("GDP");
                    String moTa = rs.getString("MoTa");
                    list.add( new ThanhPho(id,tenThanhPho,tenQuocGia,dienTich,danSo,gdp,moTa));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
   }
   public  List<ThanhPho> timKiemThanhPho(String tuKhoa)
   {
       List<ThanhPho> list = new ArrayList<>();

       String strSQL = "Select * from thanhpho where TenQuocGia Like ?"+ "OR TenThanhPho LIKE  ?";
       //Nếu tìm theo từ khóa

       try(Connection connection= getConnection(); PreparedStatement preparedStatement =connection.prepareStatement(strSQL)){
           {

                preparedStatement.setString(1,"%"+tuKhoa+"%" );
                preparedStatement.setString(2,"%"+ tuKhoa + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {

                    list.add( new ThanhPho(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getFloat(4),
                            rs.getDouble(5),
                            rs.getString(6),
                            rs.getString(7)));
                }
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }

//   public static  void main(String[] args) {
//       int a = 5;
//       int b = 7;
//       int d = a++ + ++b + a - b;
//       System.out.println(d);
//   }

}






