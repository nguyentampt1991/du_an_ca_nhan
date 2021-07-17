package com.amela.dao;

import com.amela.model.ThanhPho;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface iThanhPhoDAO {
    public void themThanhPho(ThanhPho thanhPho) throws SQLException;


    public ThanhPho chiTietThanhPho(int id);

    public List<ThanhPho> danhSachThanhPho();

    public boolean xoaThanhPho(int id) throws SQLException;

    public boolean capNhatThanhPho(ThanhPho thanhPho) throws SQLException;

}
