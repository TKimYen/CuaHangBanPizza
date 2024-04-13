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

public class KhachHang{
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String ho;
    String ten;
    private String gioitinh, ngaysinh;
    private String maKH, sdt, diachi;
    private static int stt = 1;
    public KhachHang() {
	maKH = "";
        ho ="";
        ten ="";
        gioitinh="";
        ngaysinh="";
        sdt = "";
	diachi = "";
    }
        
    public KhachHang(String maKH,String ho, String ten, String gioitinh, String ngaysinh,  String sdt,String diachi) {
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.maKH = maKH;
        this.sdt = sdt;
        this.diachi = diachi;
    }
    public KhachHang(KhachHang a) {
	maKH = a.maKH;
        ho = a.ho;
        ten = a.ten;
        gioitinh = a.gioitinh;
        ngaysinh = a.ngaysinh;
        sdt = a.sdt;
	diachi = a.diachi;
    }

	
    //SETTER
    public void setMakh(String maKH) {
	this.maKH = maKH;
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
    public void setDiachi(String diachi) {
	this.diachi = diachi;
    }
	
    //GETTER
    public String getMakh() {
        return maKH;
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
    public String getDiachi() {
	return diachi;
    }
}
	
//	//CAC HAM KHAC
//	public boolean CheckBD(String date) {
//		df.setLenient(false);
//		try {
//			df.parse(date);
//		}catch(ParseException e) {
//			return false;
//		}
//		return true;
//	}
//        
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
//            maKH = String.format("KH%03d", (stt++));
//            System.out.println("Mã hóa đơn là: " + maKH);
//        }
//	public void nhap() {
//		System.out.print("Mời nhập họ: ");
//		ho = sc.nextLine();
//		
//		System.out.print("Mời nhập tên: ");
//		ten = sc.nextLine();
//		do {
//			System.out.print("Mời nhập giới tính(Nam hoặc Nữ): ");
//			gioitinh = sc.nextLine();
//			if(!"Nam".equals(gioitinh) && !"Nữ".equals(gioitinh)) {
//				System.out.println("\nBạn đã nhập sai dữ liệu. Xin mời nhập lại");
//			}
//		}while(!"Nam".equals(gioitinh) && !"Nữ".equals(gioitinh));
//		
//		System.err.println("\nNgày tháng năm sinh của nhân viên phải hợp lệ theo cú pháp dd/MM/yyyy. Nếu không sẽ báo lỗi");
//		do {
//			System.out.print("Ngày tháng năm sinh: ");
//			ngaysinh = sc.nextLine();
//			if(!CheckBD(ngaysinh)) {
//				System.err.print("\nNgày tháng năm sinh không hợp lệ. Xin mời nhập lại!!!");
//				System.err.println();
//			}
//		}while(!CheckBD(ngaysinh));
//		
//		do {
//			System.out.print("Số điện thoại (nhập đúng 11 số): ");
//			sdt = sc.nextLine();
//			if(sdt.length() != 11) {
//				System.err.println("Bạn đã nhập thiếu hoặc thừa số");
//			}
//		}while(sdt.length() != 11);
//		
//		System.out.print("Địa chỉ: ");
//		diachi = sc.nextLine();
//        }
////	public void xuat() {
////		System.out.format(" %8s | %17s | %28s | %15s | %6s | %13s | %30s ||\n", makh, ho, ten, ngaysinh, gioitinh, sdt, diachi);
////	}
//
//        public void xuat() {
//		System.out.format(" %8s | %28s | %15s | %6s | %13s | %50s ||\n", maKH, ho+" "+ten, ngaysinh, gioitinh, sdt, diachi);
//	}
//}