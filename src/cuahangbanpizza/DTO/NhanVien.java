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
    String maNV;
    String ho;
    String ten;
    private String gioitinh, ngaysinh, sdt, chucvu;
    private double luong;
    private int n;
    private static int stt = 1;
	
    public NhanVien() {
	maNV = "";
        ho ="";
        ten ="";
        gioitinh="";
        ngaysinh="";
	sdt = "";
	chucvu = "";
	luong = 0;
    }
    public NhanVien(String maNV, String ho, String ten, String gioitinh, String ngaysinh, String sdt, String chucvu, double luong) {
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
    public void setManv(String maNV) {
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
    public String getManv() {
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
//	//CAC HAM KHAC
//	public boolean CheckNVL(String date) {
//		df.setLenient(false);
//		try {
//			df.parse(date);
//		}catch(ParseException e) {
//			return false;
//		}
//		return true;
//	}
//        //KHỞI TẠO MÃ TỰ ĐỘNG
//        public int change(String maHoaDon){
//            String id = maHoaDon.substring(2, 5);
//            return Integer.parseInt(id);
//        }
//    
//        public static void init(int id){
//            stt = id+1;
//        }
//        
//        public void taoMaTuDong(){
//            maNV = String.format("NV%03d",(stt++));
//            System.out.println("Mã nhân viên là: " + maNV);
//        }
//	public void nhap() {          
//            
//                System.out.print("Họ của nhân viên: ");
//		ho = sc.nextLine();
//		
//		System.out.print("Tên của nhân viên: ");
//		ten = sc.nextLine();
//		
//		System.out.print("Giới tính: ");
//		gioitinh = sc.nextLine();
//		
//		System.err.println("Ngày tháng năm sinh của nhân viên phải hợp lệ theo cú pháp dd/MM/yyyy. Nếu không sẽ báo lỗi");
//		do {
//			System.out.print("Ngày tháng năm sinh: ");
//			ngaysinh = sc.nextLine();
//			if(!CheckNVL(ngaysinh)) {
//				System.err.print("\nNgày tháng năm sinh không hợp lệ. Xin mời nhập lại!!!");
//				System.err.println();
//			}
//		}while(!CheckNVL(ngaysinh));
//		
//		do {
//			System.out.print("Số điện thoại (nhập đúng 11 số): ");
//			sdt = sc.nextLine();
//			if(sdt.length() != 11) {
//				System.err.println("Bạn đã nhập thiếu hoặc thừa số");
//			}
//		}while(sdt.length() != 11);
//		
//		
//		System.out.print("Chức vụ: ");
//		chucvu = sc.nextLine();
//		
//		System.out.print("Lương: ");
//		luong = sc.nextInt();
//		sc.nextLine();
//	}
//
//        public void xuat() {
//		System.out.format(" %8s | %23s | %5s | %12s | %13s | %12s | %13s ||\n", maNV, ho + " " + ten, gioitinh, ngaysinh, sdt, chucvu, luong);
//	}

}