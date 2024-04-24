/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangbanpizza.DTO;

/**
 *
 * @author HP
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
        
public class NhanVien {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private int maNV;
    private String ho, ten;
    private String gioitinh, ngaysinh, sdt, chucvu;
    private double luong;
//    private static int stt = 1;
	
    public NhanVien() {

    }
    public NhanVien(int maNV, String ho, String ten, String gioitinh, String ngaysinh, String sdt, String chucvu, double luong) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.luong = luong;
    }
    public NhanVien(NhanVien a) {
	maNV = a.maNV;
        ho = a.ho;
        ten = a.ten;
        gioitinh = a.gioitinh;
        ngaysinh = a.ngaysinh;
        sdt = a.sdt;
        chucvu = a.chucvu;
        luong = a.luong;
    }
    
    //SETTER
    public void setManv(int maNV) {
        this.maNV = maNV;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setCV(String chucvu) {
        this.chucvu = chucvu;
    }
    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    //GETTER
    public int getManv() {
	return maNV;
    }
    public String getHo() {
        return ho;
    }
    public String getTen() {
        return ten;
    }
    public String getGioitinh() {
        return gioitinh;
    }
    public String getNgaysinh() {
        return ngaysinh;
    }
    public String getSdt() {
        return sdt;
    }
    public String getCV() {
        return chucvu;
    }
    public double getLuong() {
        return luong;
    }	
}