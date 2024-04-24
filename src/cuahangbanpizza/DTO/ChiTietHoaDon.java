/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DTO;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    private int maHD;
    private int maSP;
    private int soLuong;
    private int donGia;
    private double thanhTien;

    public ChiTietHoaDon() {
        
    }
    
    public ChiTietHoaDon(int maHD, int maSP, int soLuong, int donGia, double thanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    public ChiTietHoaDon(ChiTietHoaDon c) {
        this.maHD = c.maHD;
        this.maSP = c.maSP;
        this.soLuong = c.soLuong;
        this.donGia = c.donGia;
        this.thanhTien = c.thanhTien;
    }

    public int getMaHoaDon() {
        return maHD;
    }

    public void setMaHoaDon(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSanPham() {
        return maSP;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSP = maSP;
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

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
