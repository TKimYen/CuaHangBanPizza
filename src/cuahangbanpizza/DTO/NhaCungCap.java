package cuahangbanpizza.DTO;

import java.util.Scanner;

public class NhaCungCap {
    Scanner sc = new Scanner(System.in);
    private String maNCC, tenNCC, sdt, diachi;
    private static int stt = 1;
	
    public NhaCungCap() {
	maNCC = "";
        tenNCC = "";
        sdt ="";
	diachi = "";
    }
        
    public NhaCungCap(String maNCC,String tenNCC, String sdt, String diachi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.diachi = diachi;
    }
        
    public NhaCungCap(NhaCungCap a) {
        maNCC = a.maNCC;
        tenNCC = a.tenNCC;
	sdt = a.sdt;
        diachi = a.diachi;
    }

    //SETTER
    public void setMancc(String maNCC) {
        this.maNCC = maNCC;
    }
    public void setTenncc(String tenncc) {
        this.tenNCC = tenncc;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    //GETTER
    public String getMancc() {
        return maNCC;
    }
     public String getTenncc() {
        return tenNCC;
     }
     public String getSdt() {
        return sdt;
    }
    public String getDiachi() {
        return diachi;
    }

    

//    //KHỞI TẠO MÃ TỰ ĐỘNG
//        public int change(String maHoaDon){
//            String id = maHoaDon.substring(3, 6 );
//            return Integer.parseInt(id);
//        }
//    
//        public static void init(int id){
//            stt = id+1;
//        }
//        public void taoMaTuDong(){
//            maNCC = String.format("NCC%03d", (stt++));
//            System.out.println("Mã nhà cung cấp là: " + maNCC);
//        }
//    public void nhap() {
//        System.out.print("Nhập tên nhà cung cấp: ");
//        tenNCC = sc.nextLine();
//      
//	do {
//		System.out.print("Số điện thoại (nhập đúng 10 số): ");
//		sdt = sc.nextLine();
//		if(sdt.length() != 10) {
//			System.err.println("Bạn đã nhập thiếu hoặc thừa số");
//		}
//	}while(sdt.length() != 10);
//		
//	System.out.print("Địa chỉ: ");
//	diachi = sc.nextLine();
//    }
//
//     public void xuat() {
//	System.out.format(" %8s | %16s | %11s | %50s||\n", maNCC, tenNCC, sdt, diachi);
//    }
}