/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangbanpizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HP
 */

public class DanhSachNhaCungCap implements ThaoTac {
	NhaCungCap[] ncc;
	private int n;
	Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public DanhSachNhaCungCap(){}

    public NhaCungCap[] getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap[] ncc) {
        this.ncc = ncc;
    }
        
	//CÁC HÀM NHẬP XUẤT
	public void nhapDanhSach() {
		System.out.print("Nhập vào số lượng nhà cung cấp: ");
		n = sc.nextInt();
		ncc = new NhaCungCap[n];
		for(int i = 0; i < n; i++) {
			System.out.print("\n\t\t\t\t\t\tNHÀ CUNG CẤP THỨ " + (i + 1) + "\n");
                        ncc[i].taoMaTuDong();
			ncc[i] = new NhaCungCap();
			ncc[i].nhap();
		}
	}

        public void xuatDanhSach() {
	        System.out.println("\t\t\t\t\t\t=======DANH SÁCH NHÀ CUNG CẤP=======");
	        System.out.println("==========================================================================================================");
		System.out.format("|| %4s | %8s | %15s | %7s     | %49s ||\n", "STT", "MÃ NCC","TÊN NHÀ CUNG CẤP", "SĐT", "ĐỊA CHỈ");
		try {
		    for(int i = 0; i < n; i++) {
			System.out.format("|| %4s |",(i + 1));
			ncc[i].xuat();
		    }	
		}catch(NullPointerException npe) {}	
		System.out.println("===========================================================================================================");
	}
	
        
	//CÁC THAO TÁC TRÊN DANH SÁCH KHÁCH HÀNG
	//=====ĐƯA DỮ LIỆU CỦA KHÁCH HÀNG VÀO HOÁ ĐƠN=====
	public String truyenDuLieu_NCC(String manhacungcap) {
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(manhacungcap) != -1) {
				return ncc[i].getTenncc();
			}
		}
		return null;
	}
	//=====KIỂM TRA SỰ TỒN TẠI CỦA KHÁCH HÀNG TRONG DANH SÁCH=====
	public boolean xetTonTai(String manhacungcap) {
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(manhacungcap) != -1){
				return true;
			}
		}
		return false;
	}
	//======TÌM KIẾM THEO HỌ VÀ TÊN LÓT, TÊN=======
	public boolean timKiemTen(String name) {
		for(int i = 0; i < n; i++) {
			if(ncc[i].getTenncc().equals(name)) {
				return true;
			}
		}
		return false;
	}
	//THÊM MỘT NHÀ CUNG CÁP VÀO DANH SÁCH
//	@Override
	public void them() {
            System.out.print("Nhập số lượng nhà cung cấp muốn thêm: ");
            int sl = sc.nextInt();
		ncc = Arrays.copyOf(ncc, n + sl);
                n += sl;
		for(int i = n - sl; i < n; i++) {
			ncc[i] = new NhaCungCap();
			System.out.print("\t\t\t\t\t\tNHÀ CUNG CẤP THỨ " + (i + 1) + "\n");
                        ncc[i].taoMaTuDong();
			ncc[i].nhap();
		}
		
	}
	//=====XOÁ MỘT NHÀ CUNG CẤP TRONG DANH SÁCH=====
//	@Override
	public void xoa(String manv) {
		boolean flag = false;
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(manv) != -1) {
				flag = true;
				j = i;
				break;
			}
		}
		for(int i = j; i < n - 1; i++) {
			ncc[i] = ncc[i + 1];
		} 
		n--;
		if(flag)
			System.out.println("\nĐã xoá thành công khách hàng");
		else 
			System.err.println("\nKhông tìm thấy nhà cung cấp cần xoá");
	}
	//====SỬA THÔNG TIN NHÀ CUNG CẤP=====
//	@Override
	public void sua() {
		int luaChon = 0;
		do {
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Sửa thông tin nhà cung cấp");
            System.out.println("\t\t\t\t\t\t2. Thoát");
            do{
            System.out.print("Lựa chọn của bạn là: ");
            luaChon = sc.nextInt();  sc.nextLine();
            if(luaChon < 1 || luaChon > 2)
		System.err.println("\nBạn đã nhập sai lựa chọn của mình. Xin mời nhập lại");
            } while(luaChon < 1 || luaChon > 2);
            
            if(luaChon == 1){
                System.out.print("Nhập mã nhà cung cấp muốn sửa: ");
                String maSua = sc.nextLine();
                for(int i = 0; i < n; i++) {
                    if(ncc[i].getMancc().contains(maSua)){
                        ncc[i] = new NhaCungCap();
                        ncc[i].setMancc(maSua);
                        ncc[i].nhap();
                    }
                }   
            } 
	}while(luaChon != 2); 
	}
        
	//=====TÌM KIẾM NHÀ CUNG CẤP=====
	public void timKiem_MaNCC(String mancc) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================");
		System.out.format("|| %4s | %8s | %15s | %7s     | %49s ||\n", "STT", "MÃ NCC","TÊN NHÀ CUNG CẤP", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(mancc) != -1) {
				System.out.format("|| %4s |", i + 1);
				ncc[i].xuat();	
				break;
			}
		}
		System.out.println("===========================================================================================================");
	}

	public void timKiem_Ten(String ten) {
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
		System.out.println("==========================================================================================================");
		System.out.format("|| %4s | %8s | %15s | %7s     | %49s ||\n", "STT", "MÃ NCC","TÊN NHÀ CUNG CẤP", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(ncc[i].getTenncc().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				ncc[i].xuat();	
			}
		}
		System.out.println("===========================================================================================================");
	}
	public void timKiem() {
		int select = 0;
		while(true) {
			System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để tìm kiếm khách hàng theo mã");
			System.out.println("\t\t\t\t\t\t3.Ấn phím 2 để tìm kiếm khách hàng theo tên");
			System.out.println("\t\t\t\t\t\t4.Ấn phím 3 để thoát");
			System.out.print("Lựa chọn của bạn là: ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1:
					System.out.print("Nhập vào mã nhà cung cấp cần tìm: ");
					String mancc = sc.nextLine();
                                        timKiem_MaNCC(mancc);
					break;
				case 2:
					System.out.print("Nhập vào tên mà bạn muốn tìm: ");
					String ten = sc.nextLine();
					timKiem_Ten(ten);
					break;
				case 3: 
					return;
				default:
					System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
					break;
			}
		}
		
	}
	//====KẾT THÚC TÌM KIẾM KHÁCH HÀNG=====
        //------------------------thống kê-----------------------------
public void thongKeTheoTen(String ten) {
    int count = 0;
   System.out.println("==========================================================================================================================================================");
		System.out.format("|| %4s | %8s | %15s | %7s     | %49s ||\n", "STT", "MÃ NCC","TÊN NHÀ CUNG CẤP", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(ncc[i].getTenncc().indexOf(ten) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				ncc[i].xuat();	
			}
		}
		System.out.println("Tên nhà cung cấp: " + ten + ", Số lượng: " + count);
		System.out.println("===========================================================================================================");
   
}

public void thongKeTheoDiaChi(String diaChi) {
    int count = 0;
   System.out.println("==========================================================================================================================================================");
		System.out.format("|| %4s | %8s | %15s | %7s     | %49s ||\n", "STT", "MÃ NCC","TÊN NHÀ CUNG CẤP", "SĐT", "ĐỊA CHỈ");
		for(int i = 0; i < n; i++) {
			if(ncc[i].getDiachi().indexOf(diaChi) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				ncc[i].xuat();	
			}
		}
		System.out.println("Địa chỉ nhà cung cấp chứa: " + diaChi + ", Số lượng: " + count);
		System.out.println("==========================================================================================================================================================");
    
}

public void thongKe() {
Scanner sc = new Scanner(System.in);
int select = 0;
while(true) {
    System.out.println("\n\t\t\t\t\t\t1.Thống kê nhà cung cấp theo tên");
    System.out.println("\t\t\t\t\t\t2.Thống kê nhà cung cấp theo địa chỉ");
    System.out.println("\t\t\t\t\t\t3.Thoát");
    System.out.print("Lựa chọn của bạn là: ");
    select = sc.nextInt();
    sc.nextLine();
    switch(select) {
        case 1:
            System.out.print("Nhập vào tên nhà cung cấp cần thống kê: ");
            String tenNcc = sc.nextLine();
            thongKeTheoTen(tenNcc);
            break;
       case 2:
       System.out.println("Nhập vào địa chỉ nhà cung cấp bạn muốn thống kê");
       String diaChi=sc.nextLine();
       thongKeTheoDiaChi(diaChi);
       break;
       case 3:
       return;
        default:
            System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
            break;
    }
}
}
//========Kết thúc thống kê=======
	public void thaoTac() {
		int select = 0;
		String manv = "";
		loop:
			while(true) {
				System.out.println("\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
				System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để thêm nhà cung cấp");
				System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để xoá nhà cung cấp");
				System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để sửa thông tin nhà cung cấp");
				System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để tìm kiếm nhà cung cấp");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 5 để xuất danh sách");
                                System.out.println("\t\t\t\t\t\t6.Ấn phím 6 để thống kê");
				System.out.println("\t\t\t\t\t\t7.Ấn phím 7 để dừng các thao tác");
				System.out.print("\nLựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
						them();
						break;
					case 2:
						System.out.print("Nhập vào mã nhà cung cấp cần xoá: ");
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
        
        public void docFile(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            n = Integer.parseInt(input.readLine());
            ncc = new NhaCungCap[n];
            for(int i=0; i < n; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String mancc = ar[0];
                String tenncc = ar[1];
		String sdt = ar[2];
		String diachi = ar[3];  
                ncc[i] = new NhaCungCap(mancc,tenncc, sdt, diachi);
        }
            input.close();
            int id = ncc[n - 1].change(ncc[n-1].getMancc());
            NhaCungCap.init(id);
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
            for(NhaCungCap nc : ncc){
                s = nc.getMancc()+ ";" + nc.getTenncc() + ";" + nc.getSdt() + ";" + nc.getDiachi() + "\n";
                fw.write(s);
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
