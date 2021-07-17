package com.amela.model;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ThanhPho {
    private int id;
    private String tenThanhPho;
    private String tenQuocGia;
    private float dienTich;
    private  double danSo;
    private String gdp;
    private String moTa;


    public ThanhPho() {

    }

    public ThanhPho(int id, String tenThanhPho, String tenQuocGia, float dienTich, double danSo, String gdp, String moTa) {
        this.id = id;
        this.tenThanhPho = tenThanhPho;
        this.tenQuocGia = tenQuocGia;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
    }

    public ThanhPho(String tenThanhPho, String tenQuocGia, float dienTich, double danSo, String gdp, String moTa) {
        this.tenThanhPho = tenThanhPho;
        this.tenQuocGia = tenQuocGia;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotNull
    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }
    @NotNull
    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }


    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public double getDanSo() {
        return danSo;
    }

    public void setDanSo(double danSo) {
        this.danSo = danSo;
    }
    @NotNull
    @Max(500)
    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


}
