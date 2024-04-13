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
    private String maPN, maNV, maNCC, ngayLap;
    private double tongTien;
    private static int stt = 1;

    public PhieuNhap() {
    tongTien = 0;
    }

    public PhieuNhap(String maPN, String maNV, String maNCC, String ngayLap, double tongTien){
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
        public int change(String maPhieuNhap){
            String id = maPhieuNhap.substring(2, 5);
            return Integer.parseInt(id);
        }
    
        public static void init(int id){
            stt = id+1;
        }
        public void taoMaTuDong(){ 
            maPN = String.format("PN%03d",(stt++));
        }
        
//    public void tinhTongTien(DanhSachCTPN dsct, String ma){
//        for(int i = 0; i < slCTPN; i++)
//            if(ma.contains(dsct.getCt()[i].getMaHoaDon())) //dieu kien ma hoa don trung ma chi tiet hoa don
//            tongTien += dsct.getCt()[i].getThanhTien(); 
//    }
//	
}
