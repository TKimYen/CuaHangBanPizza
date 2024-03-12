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
import cuahangbanpizza.DTO.NhanVien;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;

public class DanhSachNhanVien {
	NhanVien[] nv;
	private int n;
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTOR
	public DanhSachNhanVien() {
		
	}

    public NhanVien[] getNv() {
        return nv;
    }

    public void setNv(NhanVien[] nv) {
        this.nv = nv;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
        
	//HÀM NHẬP XUẤT
    public void nhapDanhSachNV() {
        System.out.print("Nhập vào số lượng nhân viên: ");
	n = sc.nextInt();
	nv = new NhanVien[n];
	for(int i = 0; i < n; i++) {
            System.out.print("\n\t\t\t\t\t\tNHÂN VIÊN THỨ " + (i + 1) + "\n");
            nv[i].taoMaTuDong();
            nv[i] = new NhanVien();
            nv[i].nhap();
            }
    }

    public void xuatDanhSachNV() {
		
		System.out.println("\t\t\t\t\t\t=======DANH SÁCH NHÂN VIÊN=======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
                try {
			for (int i = 0; i < n; i++) {                                                         
                                System.out.format("|| %4s |", (i + 1));
                                if(nv[i] != null)
                                    nv[i].xuat();                          
                        }
		}catch(NullPointerException npe) {			
		}
		 System.out.println("================================================================================================================================");
	}
	//==============CÁC THAO TÁC TRÊN DANH SÁCH=================
	
	//=====ĐƯA DỮ LIỆU CỦA NHÂN VIÊN VÀO HOÁ ĐƠN =====
	
	public String truyenDuLieu_NV_Ho(String manhanvien) {
		for(int i = 0; i < n; i++) {
			if(nv[i].getManv().equals(manhanvien)) {
				return nv[i].getHo();
			}
		}
		return null;
	}
        public String truyenDuLieu_NV_Ten(String manhanvien) {
		for(int i = 0; i < n; i++) {
			if(nv[i].getManv().equals(manhanvien)) {
				return nv[i].getTen();
			}
		}
		return null;
	}
	//TÌM KIẾM THEO HỌ VÀ TÊN LÓT, 
	public boolean timKiem_Ten(String name) {
		for(int i = 0; i < n; i++) {
			if(nv[i].getHo().indexOf(name) != -1) {
				return true;
			}
			else if(nv[i].getTen().indexOf(name) != -1) {
				return true;
			}
		}
		return false;
	}
	
        
	//THÊM MỘT NHÂN VIÊN VÀO DANH SÁCH
//	@Override
	public void them() {
            System.out.print("Nhập số lượng nhân viên muốn thêm: ");
            int sl = sc.nextInt();
            sc.nextLine();
            n += sl;
		nv = Arrays.copyOf(nv, n);
		for(int i = n - sl; i < n; i++) {
			nv[i] = new NhanVien();
			System.out.print("\n\t\t\t\t\t\tNHÂN VIÊN THỨ " + (i + 1) + "\n");
                        nv[i].taoMaTuDong();
			nv[i].nhap();
		}
	}
	//XOÁ MỘT NHÂN VIÊN TRONG DANH SÁCH
//	@Override
	public void xoa(String manv) {
		boolean flag = false;
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(nv[i].getManv().indexOf(manv) != -1) {
				flag = true;
				j = i;
				break;
			}
		}
		for(int i = j; i < n - 1; i++) {
			nv[i] = nv[i + 1];
		} 
		n--;
		if(flag)
			System.out.println("\nĐã xoá thành công dữ liệu");
		else 
			System.err.println("\nKhông tìm thấy nhân viên cần tìm");
	}
      
	public void sua() {
	   int luaChon = 0;
		do {
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Sửa thông tin nhân viên");
            System.out.println("\t\t\t\t\t\t2. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            luaChon = sc.nextInt();  sc.nextLine();
            if(luaChon == 1){
                System.out.print("Nhập mã nhân viên muốn sửa: ");
                String maSua = sc.nextLine();
                for(int i = 0; i < n; i++) {
                    if(nv[i].getManv().contains(maSua)){
                        nv[i] = new NhanVien();
                        nv[i].setManv(maSua);
                        nv[i].nhap();
                    }
                }   
            } 
            if(luaChon ==2){
                System.out.println("Dừng thao tác!");
            }
             if(luaChon < 1 || luaChon > 2){
		System.err.println("\nBạn đã nhập sai lựa chọn của mình. Xin mời nhập lại");
             }
 
	}while(luaChon != 2);    
	}
        
        
	//TÌM KIẾM NHÂN VIÊN
        public boolean xetTonTai(String manv){
            for(int i = 0; i < n; i++){
                if(nv[i].getManv().equals(manv))
                    return true;
            }
            return false;
        }
	public void timKiem_MaNhanVien(String manv) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
		for(int i = 0; i < n; i++) {
			if(nv[i].getManv().indexOf(manv) != -1) {
				System.out.format("|| %4s |", i + 1);
				nv[i].xuat();
				break;
			}
		}
		System.out.println("================================================================================================================================");	
		System.out.println("Nhấn phím enter để tiếp tục");
		sc.nextLine();
	}
	
	public void timKiem_Ho(String ho) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
		for(int i = 0; i < n; i++) {
			if(nv[i].getHo().indexOf(ho) != -1) {
				System.out.format("|| %4s |", i + 1);
				nv[i].xuat();
			}
		}
		System.out.println("================================================================================================================================");	
		System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
	}
	public void timKiem_Ten() {
                System.out.print("Nhập vào tên mà bạn muốn tìm: ");
		String ten = sc.nextLine();
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
		for(int i = 0; i < n; i++) {
			if(nv[i].getTen().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				nv[i].xuat();	
			}
		}
		System.out.println("================================================================================================================================");	
		System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
	}
	public void timKiem() {
		int select = 0;
		while(true) {
			System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để tìm kiếm nhân viên theo mã");
			System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để tìm kiếm nhân viên theo họ");
			System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để tìm kiếm nhân viên theo tên");
			System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để thoát");
			System.out.print("\nLựa chọn của bạn là: ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1:
					System.out.print("Nhập vào mã nhân viên cần tìm: ");
					String manv = sc.nextLine();
					timKiem_MaNhanVien(manv);
					break;
				case 2:
					System.out.print("Nhập vào họ và tên lót mà bạn muốn tìm: ");
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
        //=========THAO TÁC THỐNG KÊ============
        //-------------------thống kê--------------------------change
	public void thongKeTheoTen(String ten) {
        int count = 0;
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
       for(int i = 0; i < n; i++) {
			if(nv[i].getTen().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				nv[i].xuat();	
			}
		}
        
        System.out.println("Tên nhân viên: " + ten + ", Số lượng: " + count);
                System.out.println("================================================================================================================================");	
		System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
    }
    public void thongKeTheoHo(String ho) {
        int count = 0;
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");

      for(int i = 0; i < n; i++) {
			if(nv[i].getHo().indexOf(ho) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				nv[i].xuat();	
			}
		}
       
        System.out.println("Họ nhân viên: " + ho + ", Số lượng: " + count);
                System.out.println("================================================================================================================================");	
		System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
    }
    public void thongKeTheoChucVu(String chucvu) {
        int count = 0;
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
         for(int i = 0; i < n; i++) {
			if(nv[i].getCV().indexOf(chucvu) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				nv[i].xuat();	
			}
		}
        
        System.out.println("chức vụ nhân viên: " + chucvu + ", Số lượng: " + count);
		System.out.println("================================================================================================================================");	
		System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
    }
    public void thongKe() {
    Scanner sc = new Scanner(System.in);
    int select = 0;
    while(true) {
        System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
        System.out.println("\t\t\t\t\t\t1.Thống kê nhân viên theo tên"); 
        System.out.println("\t\t\t\t\t\t2.Thống kê nhân viên theo họ");
        System.out.println("\t\t\t\t\t\t3.Thống kê nhân viên theo chức vụ");
        System.out.println("\t\t\t\t\t\t4. thoát");
        System.out.print("Lựa chọn của bạn là: ");
        select = sc.nextInt();
        sc.nextLine();
        switch(select) {
            case 1:
                System.out.print("Nhập vào tên nhân viên cần thống kê: ");
                String tenNv = sc.nextLine();
                thongKeTheoTen(tenNv);
                break;
            case 2:
                System.out.print("Nhập vào họ nhân viên bạn muốn thống kê: ");
                String hoNv = sc.nextLine();
               thongKeTheoHo(hoNv);
                break;
            case 3:
                System.out.print("Nhập vào chức vụ nhân viên bạn muốn thống kê: ");
                String chucVu = sc.nextLine();
               thongKeTheoChucVu(chucVu);
                break;
            case 4: 
                return;
            default:
                System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
                break;
        }
	}
}
    public double [] chi () throws ParseException{
        double [] chi = new double [5];
        for(int i = 0; i < n; i++){
            double luong = nv[i].getLuong();
            chi[0] += luong;                       
        }
        chi[1] = chi [0];
        chi[2] = chi [0];
        chi[3] = chi [0];
        chi[4] = chi[0] + chi[1] + chi[2] + chi[3];        
        return chi;
    }
//    ========KẾT THÚC THỐNG KÊ===========
    
    //PHƯƠNG THỨC KHÁC
    public double tongLuongNhanVien(){ //// gọi trong thống kê chi tiêu
        double tongLuong = 0;
        for(int i = 0; i < n; i++){
            tongLuong += nv[i].getLuong();
        }
        return tongLuong;
    }
    
	public void thaoTac() {
		int select = 0;
		String manv = "";
		while(true) {
				System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
				System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để thêm nhân viên");
				System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để xoá nhân viên");
				System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để sửa thông tin nhân viên");
				System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để tìm kiếm nhân viên");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 5 để xuất danh sách");
				System.out.println("\t\t\t\t\t\t6.Ấn phím 6 để thống kê danh sách nhân viên");
				System.out.println("\t\t\t\t\t\t7.Ấn phím 7 để dừng các thao tác");
				System.out.print("\nLựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
						them();
						break;
					case 2:
						System.out.print("Nhập vào mã nhân viên cần xoá: ");
						manv = sc.nextLine();
						xoa(manv);
						break;
					case 3:
						sua();
						break;
					case 4:
						timKiem();
						break;
					case 5: 
						xuatDanhSachNV();
						break;
					case 6:
                                                thongKe();
                                                break;
					case 7:
						return;
					default:
						System.err.println("Bạn đã nhập sai lựa chọn");
						break;
				}
			}
	}
	//=====================================================
	//ĐỌC GHI FILE
    public void docFile(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            n = Integer.parseInt(input.readLine());
            nv = new NhanVien[n];
            for(int i=0; i < n; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String manv = ar[0];
                String ho = ar[1];
                String ten = ar[2];
                String gioitinh= ar[3];
                String ngaysinh= ar[4];
		String sdt = ar[5];
		String chucvu = ar[6];  
                Double luong = Double.parseDouble(ar[7]);                
                nv[i] = new NhanVien(manv, ho, ten, gioitinh, ngaysinh, sdt, chucvu, luong);
        }
            input.close();
            int id = nv[n-1].change(nv[n-1].getManv());
            NhanVien.init(id);
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
            for(NhanVien nvien : nv){
                s = nvien.getManv() + ";" + nvien.getHo() + ";" + nvien.getTen() + ";" + nvien.getGioitinh() + ";" + nvien.getNgaysinh() + ";" + nvien.getSdt() + ";" + nvien.getCV() + ";" +nvien.getLuong() +"\n";
                fw.write(s);
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
