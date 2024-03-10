package cuahangbanpizza;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import java.io.DataOutputStream;
//import java.io.IOException;
import java.util.Scanner;
//import java.io.*;
/**
 *
 * @author HP
 */
public class ChiTietPhieuNhap {
    Scanner sc = new Scanner(System.in);
    
    private String maPN;
    private String masp;
    private int soluong;
    private double dongia;
    private double thanhtien;
    
    public ChiTietPhieuNhap() {}
    
    public ChiTietPhieuNhap(String mapn, String masp, int soluong, double dongia, double thanhtien) {
        this.maPN = mapn;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
    
    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn){
        this.maPN = ctpn.maPN;
        this.masp = ctpn.masp;
        this.soluong = ctpn.soluong;
        this.dongia = ctpn.dongia;
        this.thanhtien = ctpn.thanhtien;
    }
    
     public String getMapn() {
        return maPN;
    }

    public void setMapn(String mapn) {
        this.maPN = mapn;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
   public void nhap(DanhSachSanPham dssp, String ma){
       dssp.xuatDanhSach();
        maPN = ma;
        do {
            dssp.xuatDanhSach();
            System.out.print("Nhập vào mã sản phẩm: ");
            masp = sc.nextLine();
		if(!dssp.timKiem_MaSP(masp)) {
                    System.err.println("\nKhông tìm thấy mã sản phẩm mà bạn vừa nhập!!!");
	}
	}while(!dssp.timKiem_MaSP(masp));	
 
        System.out.print("Nhap so luong: ");
        soluong = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Nhap don gia: ");
        dongia = sc.nextFloat();
        dssp.capNhat_SP_DG_PhieuNhap(masp, soluong, dongia);        
        thanhtien = soluong * dongia;
    }
    public void xuat(){
        System.out.format("  %14s | %12s | %10s | %10s | %15s ||\n", maPN, masp, soluong, dongia, thanhtien); 
    }
}