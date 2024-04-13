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
}
