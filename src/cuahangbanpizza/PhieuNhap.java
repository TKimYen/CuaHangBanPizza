package cuahangbanpizza;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PhieuNhap {
    Scanner sc = new Scanner(System.in);
    
    private int slCTPN;
    private ChiTietPhieuNhap ctpn[];
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private String maPN, maNV, maNCC, ngayLap, hoNV, tenNV, tenNCC;
    private double tongTien;
    private static int stt = 1;

   public PhieuNhap() {
    tongTien = 0;
}

    public PhieuNhap(String maPN, String maNV,String hoNV, String tenNV, String maNCC, String tenNCC, String ngayLap, double tongTien, int slCTPN, ChiTietPhieuNhap[] ctpn){
        this.slCTPN = slCTPN;
        this.ctpn = ctpn;
        this.maPN= maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayLap = ngayLap;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.tenNCC = tenNCC;
        this.tongTien = tongTien;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.slCTPN = pn.slCTPN;
        this.ctpn = pn.ctpn;
        this.maPN= pn.maPN;
        this.maNV = pn.maNV;
        this.maNCC = pn.maNCC;
        this.ngayLap = pn.ngayLap;
        this.hoNV = pn.hoNV;
        this.tenNV = pn.tenNV;
        this.tenNCC = pn.tenNCC;
        this.tongTien = pn.tongTien;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    
    public void setSlCTPN(int slCTPN) {
        this.slCTPN = slCTPN;
    }

    public void setChiTietPhieuNhap(ChiTietPhieuNhap[] ctpn) {
        this.ctpn = ctpn;
    }
    
    //getter

    public String getMaPN() {
        return maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }
    public int getSlCTPN() {
        return slCTPN;
    }

    public ChiTietPhieuNhap[] getCtpn() {
        return ctpn;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    
    
    public boolean checkNL(String date) {
		df.setLenient(false);
		try {
			df.parse(date);
		}catch(ParseException e) {
			return false;
		}
		return true;
	}
    //KHỞI TẠO MÃ TỰ ĐỘNG
        public int change(String maHoaDon){
            String id = maHoaDon.substring(2, 5);
            return Integer.parseInt(id);
        }
    
        public static void init(int id){
            stt = id+1;
        }
        public void taoMaTuDong(){ 
            maPN = String.format("PN%03d",(stt++));
            System.out.println("Mã phiếu nhập là: " + maPN);
        }
        
       //NHẬP XUẤT CHI TIẾT PHIẾU NHẬP
    public void nhap(DanhSachSanPham sp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc) throws IOException {        
        System.err.println("Ngày nhập phiếu nhập phải hợp lệ theo cú pháp dd/MM/yyyy. Nếu không sẽ báo lỗi.");
	System.err.println();
        do {
            System.out.print("Ngày lập phiếu: ");
            ngayLap = sc.nextLine();
			
            if(!checkNL(ngayLap)) {
            System.err.println("Ngày tháng năm không hợp lệ. Xin mời nhập lại!");
            System.err.println();
	}
				
        }while(!checkNL(ngayLap));
        do {
            dsnv.xuatDanhSachNV();
            System.out.print("Nhập mã nhân viên phụ trách: ");
            maNV = sc.nextLine();
            if(dsnv.xetTonTai(maNV)) {
                hoNV = dsnv.truyenDuLieu_NV_Ho(maNV);
                tenNV = dsnv.truyenDuLieu_NV_Ten(maNV);
            }
            else{
                System.err.println("\nMã nhân viên không có trong danh sách!");
            }
	}while(dsnv.xetTonTai(maNV) != true);
        
        do {
            dsncc.xuatDanhSach();
            System.out.print("\nNhập mã nhà cung cấp: ");
            maNCC = sc.nextLine();
            if(dsncc.xetTonTai(maNCC)){
                tenNCC = dsncc.truyenDuLieu_NCC(maNCC);
            }
            else{
                System.err.print("Không tìm thấy nhà cung cấp. Xin mời nhập lại!!!");
                System.err.println();                    
            }
        }while(!dsncc.xetTonTai(maNCC));         
                
        System.out.print("Nhập số lượng chi tiết phiếu nhâp: ");
        slCTPN  = sc.nextInt();
        sc.nextLine();
        ctpn = new ChiTietPhieuNhap[slCTPN];
        for(int i = 0; i < slCTPN; i++){
            ctpn[i] = new ChiTietPhieuNhap();
            ctpn[i].nhap(sp, maPN);
           
        }
        tinhTongTien();
    } 
    
   public void tinhTongTien(){
            for(int i = 0; i < slCTPN; i++)
                tongTien += ctpn[i].getThanhtien();
        }
	
    public void xuat() {
//       System.out.format(" %8s  | %8s | %13s | %20s | %11s | %15s | %15s | %15s ||\n", maPN, maNV, hoNV, tenNV, maNCC, tenNCC, ngayLap, tongTien);
        System.out.println("Mã phiếu nhập: " + maPN);
        System.out.println("Ngày lập: " + ngayLap);
        System.out.println("Mã nhân viên phụ trách: " + maNV);
        System.out.println("Họ tên nhân viên phụ trách: " + hoNV + " " + tenNV);
        System.out.println("Mã nhà cung cấp: " + maNCC);
        System.out.println("Tên nhà cung cấp: " + tenNCC);
        
        System.out.println("Thông tin chi tiết phiếu nhập:");
        System.out.format("|| %4s | %8s  | %12s | %10s | %10s | %15s ||\n", "STT", " MÃ PHIẾU NHẬP", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN");
        for (int j = 0; j < slCTPN; j++) {
            System.out.format("|| %4s |", (j + 1));
            if (ctpn[j] != null) {
                ctpn[j].xuat();
            }
        }
    }

}
