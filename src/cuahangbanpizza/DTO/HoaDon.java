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
    private String maHoaDon;
    private static int stt = 1;
    private String ngayLap;
    private String maNhanVien;
    private String maKhachHang;
    private double tongTien;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    
    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String ngayLap, String maNhanVien, String maKhachHang, Double tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
    }
    
    public HoaDon(HoaDon hd) {
        this.maHoaDon = hd.maHoaDon;
        this.ngayLap = hd.ngayLap;
        this.maNhanVien = hd.maNhanVien;
        this.maKhachHang = hd.maKhachHang;
        this.tongTien = hd.tongTien;
    }

    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public int change(String maHoaDon){
        String id = maHoaDon.substring(2, 5);
        return Integer.parseInt(id);
    }
    
    public static void init(int id){
        stt = id+1;
    }
    
    public void taoMaTuDong(){
        maHoaDon = String.format("HD%03d", (stt++));
    }

}
