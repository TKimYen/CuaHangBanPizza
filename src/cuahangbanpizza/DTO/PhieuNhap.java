package cuahangbanpizza.DTO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PhieuNhap {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private int maPN, maNV, maNCC;
    private String ngayLap;
    private double tongTien;

    public PhieuNhap() {
        tongTien = 0;
    }

    public PhieuNhap(int maPN, int maNV, int maNCC, String ngayLap, double tongTien){
        this.maPN= maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.maPN= pn.maPN;
        this.maNV = pn.maNV;
        this.maNCC = pn.maNCC;
        this.ngayLap = pn.ngayLap;
        this.tongTien = pn.tongTien;
    }
    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    //getter

    public int getMaPN() {
        return maPN;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }
}
