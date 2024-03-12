/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DTO;

//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
import cuahangbanpizza.DanhSachSanPham;
import cuahangbanpizza.DanhSachSanPham;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    Scanner sc = new Scanner(System.in);
    private String maHoaDon;
    private String maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietHoaDon() {
    }
    
    public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong, double donGia, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    public ChiTietHoaDon(ChiTietHoaDon c) {
        this.maHoaDon = c.maHoaDon;
        this.maSanPham = c.maSanPham;
        this.soLuong = c.soLuong;
        this.donGia = c.donGia;
        this.thanhTien = c.thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public void nhap(DanhSachSanPham dssp, String ma){
        maHoaDon = ma;
        do {
            dssp.xuatDanhSach();
            System.out.print("Nhập vào mã sản phẩm: ");
		maSanPham = sc.nextLine();
		if(!dssp.timKiem_MaSP(maSanPham)) {
                    System.err.println("Không tìm thấy mã sản phẩm mà bạn vừa nhập!!!");
	}
	}while(!dssp.timKiem_MaSP(maSanPham));	
        
        do{
            System.out.print("Nhap so luong: ");
            soLuong = sc.nextInt();
            if(!dssp.kiemTra_SL(soLuong,maSanPham)){
                System.err.println("\nSố lượng vượt quá mức cho phép!");
            }
        }while(!dssp.kiemTra_SL(soLuong,maSanPham));        
        donGia = dssp.timKiem_DG(maSanPham);
        thanhTien = soLuong * donGia;  
        dssp.giamSL_SP(maSanPham, soLuong);
    }
  
     public void xuat(){
//         %4s | %10s | %10s | %7s | %7s | %10s 
        System.out.format(" %10s | %11s | %8s | %7s | %10s ||\n", maHoaDon, maSanPham, soLuong, donGia, thanhTien);
    }
}
