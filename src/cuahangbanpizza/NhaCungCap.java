package cuahangbanpizza;

import java.util.Scanner;

public class NhaCungCap {
    	Scanner sc = new Scanner(System.in);
	private String mancc, tenncc, sdt, diachi;
        private static int stt = 1;
	//CONSTRUCTOR
	public NhaCungCap() {
		mancc = "";
                tenncc = "";
                sdt ="";
		diachi = "";
	}
	public NhaCungCap(NhaCungCap a) {
		mancc = a.mancc;
                tenncc = a.tenncc;
		sdt = a.sdt;
		diachi = a.diachi;
	}

    public NhaCungCap(String mancc,String tenncc, String sdt, String diachi) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.sdt = sdt;
        this.diachi = diachi;
    }
	//SETTER    GETTER

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMancc() {
        return mancc;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    //KHỞI TẠO MÃ TỰ ĐỘNG
        public int change(String maHoaDon){
            String id = maHoaDon.substring(3, 6 );
            return Integer.parseInt(id);
        }
    
        public static void init(int id){
            stt = id+1;
        }
        public void taoMaTuDong(){
            mancc = String.format("NCC%03d", (stt++));
            System.out.println("Mã nhà cung cấp là: " + mancc);
        }
    public void nhap() {
        System.out.print("Nhập tên nhà cung cấp: ");
        tenncc = sc.nextLine();
      
	do {
		System.out.print("Số điện thoại (nhập đúng 10 số): ");
		sdt = sc.nextLine();
		if(sdt.length() != 10) {
			System.err.println("Bạn đã nhập thiếu hoặc thừa số");
		}
	}while(sdt.length() != 10);
		
	System.out.print("Địa chỉ: ");
	diachi = sc.nextLine();
    }

     public void xuat() {
	System.out.format(" %8s | %16s | %11s | %50s||\n", mancc, tenncc, sdt, diachi);
    }
}
