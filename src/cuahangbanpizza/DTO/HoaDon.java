/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DTO;

//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
import cuahangbanpizza.DanhSachCTHD;
import cuahangbanpizza.DanhSachCTHD;
import cuahangbanpizza.DanhSachKhachHang;
import cuahangbanpizza.DanhSachKhachHang;
import cuahangbanpizza.DanhSachNhanVien;
import cuahangbanpizza.DanhSachNhanVien;
import cuahangbanpizza.DanhSachSanPham;
import cuahangbanpizza.DanhSachSanPham;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class HoaDon {
    private String maHoaDon;
    private static int stt = 1;
//    private ChiTietHoaDon cthd[];
    private int slCTHD;
    private String ngayLap;
    private String maNhanVien;
    private String hoNhanVien;
    private String tenNhanVien;
    private String maKhachHang;
    private String hoKhachHang;
    private String tenKhachHang;
    private double tongTien;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    
    public HoaDon() {
    }

//    public ChiTietHoaDon[] getCthd() {
//        return cthd;
//    }
//
//    public void setCthd(ChiTietHoaDon[] cthd) {
//        this.cthd = cthd;
//    }

    public HoaDon(String maHoaDon, String ngayLap, String maNhanVien, String hoNhanVien, String tenNhanVien, String maKhachHang, String hoKhachHang, String tenKhachHang, Double tongTien,int slCTHD) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maNhanVien = maNhanVien;
        this.hoNhanVien = hoNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maKhachHang = maKhachHang;
        this.hoKhachHang = hoKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
        this.slCTHD = slCTHD;
//        this.cthd = cthd;
    }
    
    public HoaDon(HoaDon hd) {
        this.maHoaDon = hd.maHoaDon;
        this.ngayLap = hd.ngayLap;
        this.slCTHD = hd.slCTHD;
//        this.cthd = hd.cthd;
        this.maNhanVien = hd.maNhanVien;
        this.hoNhanVien = hd.hoNhanVien;
        this.tenNhanVien = hd.tenNhanVien;
        this.maKhachHang = hd.maKhachHang;
        this.hoKhachHang = hd.hoKhachHang;
        this.tenKhachHang = hd.tenKhachHang;
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

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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

    public int getSlCTHD() {
        return slCTHD;
    }

    public void setSlCTHD(int slCTHD) {
        this.slCTHD = slCTHD;
    }

    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public String getHoKhachHang() {
        return hoKhachHang;
    }

    public void setHoKhachHang(String hoKhachHang) {
        this.hoKhachHang = hoKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public HoaDon(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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
        System.out.println("Mã hóa đơn là: " + maHoaDon);
    }
    
    public void nhap(DanhSachSanPham sp, DanhSachNhanVien nv, DanhSachKhachHang kh, DanhSachCTHD dsct){        
        System.err.println("Ngày nhập hoá đơn phải hợp lệ theo cú pháp dd/MM/yyyy. Nếu không sẽ báo lỗi");
	do {
            System.out.print("\nNgày lập hoá đơn: ");
            ngayLap = sc.nextLine();
            if(!CheckDate(ngayLap)) {
		System.err.println("Ngày tháng năm không hợp lệ. Xin mời nhập lại!");
            }	
	}while(!CheckDate(ngayLap));

//      NHẬP MÃ NV VÀ TRUYỀN HỌ TÊN VÀO
        do {
            nv.xuatDanhSachNV();
            System.out.print("Nhập mã nhân viên phụ trách: ");
            maNhanVien = sc.nextLine();
            if(nv.xetTonTai(maNhanVien)) {
                hoNhanVien = nv.truyenDuLieu_NV_Ho(maNhanVien);
                tenNhanVien = nv.truyenDuLieu_NV_Ten(maNhanVien);
            }
            else{
                System.err.println("Mã nhân viên không có trong danh sách!");
            }
	}while(nv.xetTonTai(maNhanVien) != true);
        
//      NHẬP MÃ KH VÀ TRUYỀN HỌ TÊN VÀO 
	do {
            kh.xuatDanhSach();
            System.out.print("Nhập mã khách hàng: ");
            maKhachHang = sc.nextLine();
            tenKhachHang = kh.truyenDuLieu_KH_Ten(maKhachHang);
            if(kh.xetTonTai(maKhachHang)){
                tenKhachHang = kh.truyenDuLieu_KH_Ten(maKhachHang);
                hoKhachHang = kh.truyenDuLieu_KH_Ho(maKhachHang);
            }
            else
		System.err.println("Mã khách hàng mà bạn vừa nhập không có trong danh sách!");
	}while(kh.xetTonTai(maKhachHang) != true);
        
        dsct.them(sp, maHoaDon);
//        cthd = new ChiTietHoaDon[slCTHD];
//        for(int i = 0; i < slCTHD; i++){
//            cthd[i] = new ChiTietHoaDon();
//            cthd[i].nhap(sp, maHoaDon);
//        }
        tinhTongTien(dsct, maHoaDon);

    }

    public boolean CheckDate(String date){
        df.setLenient(false);
        try {
            df.parse(date);
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }
    
    
    public void xuat(DanhSachCTHD dsct) {
//        "|| %4s | %10s | %10s | %20s | %12s | %20s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ"
//	System.out.format(" %10s | %13s | %28s | %19s | %28s | %15s ||\n", maHoaDon, maKhachHang,hoKhachHang+ " " + tenKhachHang, maNhanVien,hoNhanVien + " " + tenNhanVien, ngayLap);        
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Ngày lập hóa đơn: " + ngayLap);
        System.out.println("Mã khách hàng: " + maKhachHang);
        System.out.println("Họ tên khách hàng: " + hoKhachHang + " " + tenKhachHang);
        System.out.println("Mã nhân viên phụ trách: " + maNhanVien);
        System.out.println("Họ tên nhân viên phụ trách: " + hoNhanVien + " " + tenNhanVien);       
        System.out.println("Thông tin chi tiết hóa đơn:");
        System.out.format("|| %4s | %10s | %10s | %7s | %7s | %10s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN");
            for(int j = 0; j < slCTHD; j++) {
                System.out.format("|| %4s |", (j + 1));
                if(dsct.getCt()[j] != null);
                    dsct.getCt()[j] .xuat();
            }    
    }

    public void tinhTongTien(DanhSachCTHD dsct, String ma){
        //int pos = vị trí bắt đầu của ct của hóa đơn trong danh sách ct 
        for(int i = 0; i < slCTHD; i++)
            if(ma.contains(dsct.getCt()[i].getMaHoaDon()))
            tongTien += dsct.getCt()[i].getThanhTien();
    }
    
}
