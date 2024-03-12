/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangbanpizza;

/**
 *
 * @author HP
 */
import cuahangbanpizza.DTO.KhachHang;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

//implements ThaoTac
public class DanhSachKhachHang {
	KhachHang[] kh;
	private int n;
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTOR
	public DanhSachKhachHang(){
            kh = new KhachHang[1];
            n = 1;
	}

    public KhachHang[] getKh() {
        return kh;
    }

    public void setKh(KhachHang[] kh) {
        this.kh = kh;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
        
	//CÁC HÀM NHẬP XUẤT
	public void nhapDanhSach() {
		System.out.print("Nhập vào số lượng khách hàng: ");
		n = sc.nextInt();
		kh = new KhachHang[n];
		for(int i = 0; i < n; i++) {
			System.out.print("\n\t\t\t\t\t\tKHÁCH HÀNG THỨ " + (i + 1) + "\n");
			kh[i] = new KhachHang();
                        kh[i].taoMaTuDong();
			kh[i].nhap();
			if(i > 0){
			}
		}
	}
        public void xuatDanhSach() {
			System.out.println("\t\t\t\t\t\t=======DANH SÁCH KHÁCH HÀNG=======");
			System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
			try {
				for(int i = 0; i < n; i++) {
					System.out.format("|| %4s |",(i + 1));
					kh[i].xuat();
			}
				
			}catch(NullPointerException npe) {

			}
			
			System.out.println("==========================================================================================================================================================");
	}
	
	//CÁC THAO TÁC TRÊN DANH SÁCH KHÁCH HÀNG
	//=====ĐƯA DỮ LIỆU CỦA KHÁCH HÀNG VÀO HOÁ ĐƠN=====
	public String truyenDuLieu_KH_Ten(String makhachhang) {
		for(int i = 0; i < n; i++) {
			if(kh[i].getMakh().indexOf(makhachhang) != -1) {
				return kh[i].getTen();
			}
		}
		return null;
	}
        public String truyenDuLieu_KH_Ho(String makhachhang) {
		for(int i = 0; i < n; i++) {
			if(kh[i].getMakh().indexOf(makhachhang) != -1) {
				return kh[i].getHo();
			}
		}
		return null;
	}
	//=====KIỂM TRA SỰ TỒN TẠI CỦA KHÁCH HÀNG TRONG DANH SÁCH=====
	public boolean xetTonTai(String makhachhang) {
		for(int i = 0; i < n; i++) {
			if(kh[i].getMakh().indexOf(makhachhang) != -1){
				return true;
			}
		}
		return false;
	}
	//======TÌM KIẾM THEO HỌ VÀ TÊN LÓT, TÊN=======
	public boolean timKiem_Ten(String ten) {
		for(int i = 0; i < n; i++) {
			if(kh[i].getTen().indexOf(ten) != -1) {
				return true;
			}
			else if(kh[i].getTen().indexOf(ten) != -1) {
				return true;
			}
		}
		return false;
	}
	
	//THÊM MỘT KHÁCH HÀNG VÀO DANH SÁCH
//	@Override
	public void them() {
                System.out.print("nhập số lượng khách hàng cần thêm: ");
                int sl = sc.nextInt();
                sc.nextLine();
                n += sl;
		kh = Arrays.copyOf(kh, n);
		for(int i = n - sl; i < n; i++) {
                    System.out.print("\n\t\t\t\t\t\tKHÁCH HÀNG THỨ " + (i + 1) + "\n");
                    kh[i] = new KhachHang();
                    kh[i].taoMaTuDong();
                    kh[i].nhap();			
		}
		
	}
	//=====XOÁ MỘT KHÁCH HÀNG TRONG DANH SÁCH=====
//	@Override
	public void xoa(String manv) {
		boolean flag = false;
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(kh[i].getMakh().indexOf(manv) != -1) {
				flag = true;
				j = i;
				break;
			}
		}
		for(int i = j; i < n - 1; i++) {
			kh[i] = kh[i + 1];
		} 
		n--;
		if(flag)
			System.out.println("\nĐã xoá thành công khách hàng");
		else 
			System.err.println("\nKhông tìm thấy khách hàng cần xoá");
	}
	//====SỬA THÔNG TIN KHÁCH HÀNG=====(Yến - sửa ở nv, ncc)
	public void sua() {
            int luaChon = 0;
            do {
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Sửa thông tin khách hàng");
            System.out.println("\t\t\t\t\t\t2. Thoát");
            do{
            System.out.print("Lựa chọn của bạn là: ");
            luaChon = sc.nextInt();  sc.nextLine();
            if(luaChon < 1 || luaChon > 2)
		System.err.println("\nBạn đã nhập sai lựa chọn của mình. Xin mời nhập lại");
            } while(luaChon < 1 || luaChon > 2);
            
            if(luaChon == 1){
                System.out.print("Nhập mã khách hàng muốn sửa: ");
                String maSua = sc.nextLine();
                for(int i = 0; i < n; i++) {
                    if(kh[i].getMakh().contains(maSua)){
                        kh[i] = new KhachHang();
                        kh[i].setMakh(maSua);
                        kh[i].nhap();
                    }
                }   
            } 
	}while(luaChon != 2); 
	}
	//=====TÌM KIẾM KHÁCH HÀNG=====
	public void timKiem_MaKhachHang(String makh) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
		
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getMakh().indexOf(makh) != -1) {
				System.out.format("|| %4s |", i + 1);
				kh[i].xuat();	
				break;
			}
		}
		System.out.println("==========================================================================================================================================================");
	}
	public void timKiem_Ho(String ho) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getHo().indexOf(ho) != -1) {
				System.out.format("|| %4s |", i + 1);
				kh[i].xuat();	
			}
		}
		System.out.println("==========================================================================================================================================================");
	}
	public void timKiem_Ten() {
            System.out.print("Nhập vào tên mà bạn muốn tìm: ");
            String ten = sc.nextLine();
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getTen().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				kh[i].xuat();	
			}
		}
		System.out.println("==========================================================================================================================================================");
	}
	public void timKiem() {
		int select = 0;
		while(true) {
			System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để tìm kiếm khách hàng theo mã");
			System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để tìm kiếm khách hàng theo họ");
			System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để tìm kiếm khách hàng theo tên");
			System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để thoát");
			System.out.print("Lựa chọn của bạn là: ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1:
					System.out.print("Nhập vào mã khách hàng cần tìm: ");
					String makh = sc.nextLine();
					timKiem_MaKhachHang(makh);
					break;
				case 2:
					System.out.print("Nhập vào họ bạn muốn tìm: ");
					String ho = sc.nextLine();
					timKiem_Ho(ho);
					break;
				case 3:					
					timKiem_Ten();
					break;
				case 4: 
					return;
				default:
					System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
					break;
			}
		}
		
	}
	//====KẾT THÚC TÌM KIẾM KHÁCH HÀNG=====
        
        
	//====THAO TÁC THỐNG KÊ==========
        public void thongKeTheoTen(String ten) {
	int count = 0;
	System.out.println("\t\t\t\t\t\t======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getTen().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				kh[i].xuat();	
			}
		}
		System.out.println("Tên khách hàng: " + ten + ", Số lượng: " + count);
		System.out.println("==========================================================================================================================================================");
	
}
public void thongKeTheoHo(String ho) {
	      int count = 0;
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getHo().indexOf(ho) != -1) {
				System.out.format("|| %4s |", i + 1);
                                count++;
				kh[i].xuat();	
			}
		}
		System.out.println("Họ khách hàng: " + ho + ", Số lượng: " + count);
		System.out.println("==========================================================================================================================================================");
	
}
public void thongKeTheoGioiTinh(String gt) {
	int count = 0;
	System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================================================================");
			System.out.format("|| %4s | %8s | %28s | %15s | %6s | %13s | %50s ||\n", "STT", "MÃ KH", "HỌ VÀ TÊN CỦA KHÁCH HÀNG", "NGÀY SINH", "GIỚI", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(kh[i].getGioitinh().indexOf(gt) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				kh[i].xuat();	
			}
		}
		
		System.out.println("Thống kê giới tính" + gt + " của khách hàng có số lượng: " + count);
		System.out.println("==========================================================================================================================================================");
	
	
}
public void thongKe() {
Scanner sc = new Scanner(System.in);
int select = 0;
while(true) {
	System.out.println("\n\t\t\t\t\t\t1.Thống kê khách hàng theo tên"); 
	System.out.println("\t\t\t\t\t\t2.Thống kê khách hàng theo họ");
	System.out.println("\t\t\t\t\t\t3.Thống kê khách hàng theo giới tính");
	System.out.println("\t\t\t\t\t\t4. thoát");
	System.out.print("Lựa chọn của bạn là: ");
	select = sc.nextInt();
	sc.nextLine();
	switch(select) {
		case 1:
			System.out.print("Nhập vào tên khách hàng cần thống kê: ");
			String tenKH = sc.nextLine();
			thongKeTheoTen(tenKH);
			break;
		case 2:
			System.out.print("Nhập vào họ khách hàng bạn muốn thống kê: ");
			String hoKH = sc.nextLine();
		   thongKeTheoHo(hoKH);
			break;
		case 3:
			System.out.print("Nhập vào giới tính khách hàng bạn muốn thống kê: ");
			String gt = sc.nextLine();
		        thongKeTheoGioiTinh(gt);
			break;
		case 4: 
			return;
		default:
			System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
			break;
	}
}
}
//        =======KẾT THÚC THỐNG KÊ===========
	public void thaoTac() {
		int select = 0;
		String makh = "";
		loop:
			while(true) {
				System.out.println("\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
				System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để thêm khách hàng");
				System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để xoá khách hàng");
				System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để sửa thông tin khách hàng");
				System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để tìm kiếm khách hàng");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 5 để xuất danh sách");
				System.out.println("\t\t\t\t\t\t6.Ấn phím 6 để thống kê ");
				System.out.println("\t\t\t\t\t\t7.Ấn phím 7 để dừng các thao tác");
				System.out.print("\nLựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
						them();
						break;
					case 2:
						System.out.print("Nhập vào mã khách hàng cần xoá: ");
						makh = sc.nextLine();
						xoa(makh);
						break;
					case 3:
						sua();
						break;
					case 4:
						timKiem();
						break;
					case 5: 
						xuatDanhSach();
						break;
					case 6:
						thongKe();
						break;
					case 7:
						break loop;
					default:
						System.err.println("Bạn đã nhập sai lựa chọn");
						break;
				}
			}
	}
	
	//ĐỌC FILE GHI FILE
        
        //ĐỌC GHI FILE
    public void docFile(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            n = Integer.parseInt(input.readLine());
            kh = new KhachHang[n];
            for(int i=0; i < n; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String makh = ar[0];
                String ho = ar[1];
                String ten = ar[2];
                String gioitinh= ar[3];
                String ngaysinh= ar[4];
		String sdt = ar[5];
		String diachi = ar[6];  
                kh[i] = new KhachHang(makh, ho, ten, gioitinh, ngaysinh, sdt, diachi);
        }
            input.close();
            int id = kh[n-1].change(kh[n-1].getMakh());
            KhachHang.init(id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
  
    
    public void ghiFile(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            String s;
            s = n + "\n";
            fw.write(s);
            for(KhachHang k : kh){
                s = k.getMakh()+ ";" + k.getHo() + ";" + k.getTen() + ";" + k.getGioitinh() + ";" + k.getNgaysinh() + ";" + k.getSdt() + ";" + k.getDiachi() + "\n";
                fw.write(s);
            }
            fw.close();            
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}