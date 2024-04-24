/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DTO;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class HoaDon {
    private int maHD;
    private String ngayLap;
    private int maNV;
    private int maKH;
    private double tongTien;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    
    public HoaDon() {
    }

    public HoaDon(int maHD, String ngayLap, int maNV, int maKH, Double tongTien) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
    }
    
    public HoaDon(HoaDon hd) {
        this.maHD = hd.maHD;
        this.ngayLap = hd.ngayLap;
        this.maNV = hd.maNV;
        this.maKH = hd.maKH;
        this.tongTien = hd.tongTien;
    }

    
    public int getMaHoaDon() {
        return maHD;
    }

    public void setMaHoaDon(int maHD) {
        this.maHD = maHD;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getMaNhanVien() {
        return maNV;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNV = maNV;
    }

    public int getMaKhachHang() {
        return maKH;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKH = maKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
