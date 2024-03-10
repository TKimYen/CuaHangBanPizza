package cuahangbanpizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements ThaoTac  {
	SanPham[] sp;
	private int n;
	Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public DanhSachSanPham() {}

    public SanPham[] getSp() {
        return sp;
    }

    public void setSp(SanPham[] sp) {
        this.sp = sp;
    }
        
	//NHẬP DANH SÁCH XUẤT DANH SÁCH
	public void nhapDanhSach(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh) {
		System.out.print("Nhập vào số lượng sản phẩm: ");
		n = sc.nextInt();
		sp = new SanPham[n];
		int select = 0;
		for(int i = 0; i < n; i++) {
			System.out.println("\t\t\t\t\t\t|================BẢNG LỰA CHỌN=================|");
			System.out.println("\t\t\t\t\t\t|1.Sản phẩm là pizza                           |");
			System.out.println("\t\t\t\t\t\t|2.Sản phẩm là nước                            |");
                        System.out.println("\t\t\t\t\t\t|==============================================|");
			do {
				System.out.print("Lựa chọn của bạn là gì: ");
				select = sc.nextInt();
				if(select < 1 || select > 2) {
					System.err.println("Bạn đã nhập sai lựa chọn!");
				}
			}while(select < 1 || select > 2);
			if(select == 1) {				
				System.out.print("\n\t\t\t\t\t\tSẢN PHẨM THỨ " + (i + 1) + " (PIZZA)\n");
                                sp[i] = new Pizza();
                                sp[i].taoMaTuDong();
				sp[i].nhap();
			}
			else if(select == 2) {
				System.out.print("\n\t\t\t\t\t\tSẢN PHẨM THỨ " + (i + 1) + "(NƯỚC)\n");
				sp[i] = new Nuoc();
                                sp[i].taoMaTuDong();
				sp[i].nhap();
			}
		}
	}
    public void xuatDanhSach() {
        System.out.println("\t\t\t\t\t\t======DANH SÁCH SẢN PHẨM ======");
        System.out.println("=========================================================================================" +
		"=========================================================");
        System.out.format("|| %4s |%8s | %12s | %23s | %20s | %8s | %12s | %12s | %15s ||\n",
		 "STT", "MÃ SP", "TÊN SẢN PHẨM", "LOẠI SP", "SỐ LƯỢNG", "ĐƠN GIÁ ","THƯƠNG HIỆU", "ĐẾ", "CỠ");
        try {
            for (int i = 0; i < n; i++) {
                System.out.format("|| %4s |", (i + 1));
                sp[i].xuat();
            }
        } catch (NullPointerException npe) {}
        System.out.println("==========================================================================================" +
		"========================================================");
    }
	//KẾT THÚC NHẬP, XUẤT DANH SÁCH
         
	//CẬP NHẬT SẢN PHẨM SAU KHI NHẬP HÓA ĐƠN, XÓA PHIẾU NHẬP
    public void giamSL_SP(String masp,int slGiam){
        int slMoi = 0;
        for(int i = 0; i < n; i++){
                if(sp[i].getMasp().equals(masp)){
                    slMoi = sp[i].getSl() - slGiam;
                    sp[i].setSl(slMoi);
                }                
            }
        }

        //TĂNG SỐ LƯỢNG SẢN PHẨM SAU KHI XÓA HÓA ĐƠN
        public void tangSL_SP(String masp,int slTang){
            int slMoi = 0;
            for(int i = 0; i < n; i++){
                if(sp[i].getMasp().equals(masp)){
                    slMoi = sp[i].getSl() + slTang;
                    sp[i].setSl(slMoi);
                }                
            }
        }
        //CẬP NHẬT SỐ LƯỢNG VÀ ĐƠN GIÁ SAU KHI NHẬP PHIẾU NHẬP
    public void capNhat_SP_DG_PhieuNhap(String masp,int soLuong,double dongia){
        for(int i = 0; i < n; i++){
            if(sp[i].getMasp().equals(masp)){
                int slMoi = sp[i].getSl() + soLuong;
                sp[i].setSl(slMoi);
                sp[i].setGia(dongia);
            } 
        }
    }
    
	//CÁC HÀM LIÊN KẾT VÀ KIỂM TRA TÍNH ĐÚNG SAI
	public boolean kiemTra_SL(int sl, String ma){ //Chỉ dùng khi nhập hóa đơn (số lượng bán có nhỏ hơn số sản phẩm đang có hay không)
            boolean flag = false;
            for(int i = 0; i < n; i++){
                if(sp[i].getMasp().contains(ma) && sp[i].getSl() > sl)
                    flag = true;
            }
            return flag;
        }
        
	//KẾT THÚC KIỂM TRA SỐ LƯỢNG
	public double timKiem_DG(String masanpham) {
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().indexOf(masanpham) != -1) {
				return sp[i].getGia();
			}
		}
		return 0;
	}
        
  //CÁC THAO TÁC XỬ LÝ TRÊN DANH SÁCH
        	public void them() {
            System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
            int sl = sc.nextInt();
            n += sl;
		sp = Arrays.copyOf(sp, n);
		int select;
		for(int i = n - sl; i < n; i++) {
			System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("\t\t\t\t\t\t1.Thêm sản phẩm là THUỐC");
			System.out.println("\t\t\t\t\t\t2.Thêm Sản phẩm là VẬT TƯ Y TẾ");
			System.out.println("\t\t\t\t\t\t3.Thoát khỏi việc thêm sản phẩm");
			do {
				System.out.print("Lựa chọn của bạn là: ");
				select = sc.nextInt();
				if(select < 1 || select > 2) {
					System.err.println("Bạn đã nhập sai lựa chọn của mình, xin mời nhập lại");
				}
			}while(select < 1 || select > 2);
			
                        if(select == 1) {
				sp[i] = new Pizza();
                                sp[i].taoMaTuDong();
				System.out.print("\t\t\t\t\t\tSẢN PHÂM THỨ " + (i + 1) + " (THUỐC)\n");
				sp[i].nhap();
				sc.nextLine();
			}
			else if(select == 2) {
				sp[i] = new Nuoc();
                                sp[i].taoMaTuDong();
				System.out.print("\t\t\t\t\t\tSẢN PHÂM THỨ " + (i + 1) + " (VẬT TƯ Y TẾ)\n");
				sp[i].nhap();
			}
			else if(select == 3)
				return;
		}
	}
	public void xoa(String masanpham) {
		boolean flag = false;
		int j = 0; 
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().indexOf(masanpham) != -1) {
				flag = true;
				j = i;
				break;
			}
		}
		for(int i = j; i < n - 1; i++) {
			sp[i] = sp[i + 1];
		}
		n--;
		if(flag)
			System.out.println("\nĐã xoá thành công");
		else	
			System.err.println("\nKhông tìm thấy mã sản phẩm cần xoá!!!");
	}
	
	public void sua(String msp) {
		int select = 0;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().indexOf(msp) != -1) {
                            flag = true;
                            sp[i].nhap();
			}
		}
		if(flag == false) {
			System.err.println("\nKhông tìm thấy sản phẩm mà bạn cần sửa!!!");
			return;
		}
	}
        public boolean timKiem_MaSP(String masanpham) {
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().indexOf(masanpham) != -1) {
				return true;
			}
		}
		return false;
	}
        
	public void timKiem_MSP() {
                System.out.println("Nhập vào mã sản phẩm cần tìm: ");
		String masp = sc.nextLine();
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ=======");
                System.out.println("================================================================================" +
				"==================================================================");
                System.out.format("|| %4s | %8s | %12s | %32s | %20s | %4s | %12s | %15s | %15s  | %15s  ||\n",
				 "STT", "MÃ SP", "THƯƠNG HIỆU", "TÊN SẢN PHẨM", "LOẠI SP", "SỐ LƯỢNG", "ĐƠN GIÁ ", "CẤU TRÚC", 
				 "ĐƠN VỊ TÍNH");
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().equals(masp)) {
				System.out.format("|| %4s |", i + 1);
				sp[i].xuat();	
				break;
			}
		}
               System.out.println("==============================================================================="+
			   "===================================================================");
        }
        
	public void timKiem_LoaiSP(String loaisp) {
            	
		System.out.println("\t\t\t\t\t\t=======KẾT QUẢ=======");
                System.out.println("======================================================================" +
				"============================================================================");
                System.out.format("|| %4s |%8s | %12s | %23s | %20s | %8s | %12s | %12s | %15s ||\n", 
				"STT", "MÃ SP", "THƯƠNG HIỆU", "TÊN SẢN PHẨM", "LOẠI SP", "SỐ LƯỢNG", "ĐƠN GIÁ ", 
				"CẤU TRÚC", "ĐƠN VỊ TÍNH");
                for(int i = 0; i < n; i++) {
			if(sp[i].getLoaisp().contains(loaisp)) {
				System.out.format("|| %4s |", (i + 1));
				sp[i].xuat();
			}
		}
                System.out.println("======================================================================" +
				"============================================================================");
	}
	public void timKiem() {
		int select = 0;
		loop:
		while(true) {
			System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để tìm sản phẩm theo mã sản phẩm");
			System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để tìm sản phẩm theo loại sản phẩm");
			System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để thoát");
			System.out.print("\nLựa chọn của bạn là: ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select) {
				case 1: 
                                    timKiem_MSP();
                                    break;

				case 2:
                                    System.out.print("Nhập loại bạn cần tìm(Thuốc hoặc VTYT): ");
                                    String loaisp = sc.nextLine();
                                    timKiem_LoaiSP(loaisp);
                                    break;
				case 3: 
                                    break loop;
				default:
                                    System.err.println("Bạn đã nhập sai lựa chọn.");
                                    break;
			}
		}
	}
        //=========THAO TÁC THỐNG KÊ============
	public void thongKeTheoLoai(String loai) {
        int count = 0;
		System.out.println("\t\t\t\t\t\t\t\t=======KẾT QUẢ======");
        System.out.println("============================================================================================"+
		"======================================================");		
        System.out.format("|| %4s | %8s | %28s | %10s | %5s | %15s | %15s | %13s | %20s | %15s ||\n", 
				"STT", "MÃ SP", "THƯƠNG HIỆU", "TÊN SẢN PHẨM", "LOẠI SP", "SỐ LƯỢNG", "ĐƠN GIÁ ", "CẤU TRÚC", "ĐƠN VỊ TÍNH");
        for(int i = 0; i < n; i++) {
			if(sp[i].getLoaisp().indexOf(loai) != -1) {
				System.out.format("|| %4s |", i + 1);
				count++;
				sp[i].xuat();	
			}
		}
        
        System.out.println("Loại sản phẩm: " + loai + ", Số lượng: " + count);
        System.out.println("=========================================================================================="+
		"========================================================");
        System.out.println("\nNhấn phím enter để tiếp tục");
		sc.nextLine();
    }

    public void thongKe() {
    Scanner sc = new Scanner(System.in);
    int select = 0;
    do {
        System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
        System.out.println("\t\t\t\t\t\t1.Thống kê sản phẩm theo loại.");
        System.out.println("\t\t\t\t\t\t2. thoát");
        System.out.print("Lựa chọn của bạn là: ");
        select = sc.nextInt();
        sc.nextLine();
        switch(select) {
            case 1:
                System.out.print("Nhập loại bạn muốn thống kê: ");
                String loai = sc.nextLine();
               thongKeTheoLoai(loai);
                break;
            case 2:
                System.out.print("Đã dừng các thao tác.");                
                break;
            default:
                System.err.println("Bạn đã nhập sai lựa chọn của mình. Xin mời vào lại chức năng!!!");
                break;
        }
	}while(select != 2);
    
}

	public void thaoTac(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh) {
		int select = 0;
		String masp = "";
		loop:
			while(true) {
				System.out.println("\n\t\t\t\t\t\t======CÁC THAO TÁC======");
				System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để thêm sản phẩm");
				System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để xoá sản phẩm");
				System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để sửa chi tiết sản phẩm");
				System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để tìm kiếm sản phẩm");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 5 để xuất danh sách");
                                System.out.println("\t\t\t\t\t\t5.Ấn phím 6 để thống kê");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 7 để dừng các thao tác");
				System.out.print("Lựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
                    case 1:
                        them();
						break;
					case 2:
						System.out.print("Nhập vào mã sản phẩm cần xoá: ");
						masp = sc.nextLine();
						xoa(masp);
						break;
					case 3:
						System.out.print("Nhập vào mã sản phẩm cần sửa: ");
						masp = sc.nextLine();
						sua(masp);
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
						continue loop;
				}
			}
	}

	//ĐỌC FILE, GHI FILE
        
        public void docFile(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            n = Integer.parseInt(input.readLine());
            sp = new SanPham[n];
            for(int i=0; i < n; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String loaisp = ar[0];
                String masp = ar[1];
                String tensp = ar[2];    
                int sl = Integer.parseInt(ar[3]);
                double gia = Double.parseDouble(ar[4]);
                if(ar[0].equals("Pizza")){
                    String de = ar[5];
                    String size = ar[6];
//                    Pizza(String masp, String tensp, String loaisp, int sl, double gia, String de, String size)
                    sp[i] = new Pizza(masp, tensp, loaisp, sl, gia, de, size);
                }
                if(ar[0].equals("Nuoc")){
                    String thuongHieu = ar[5];
                    sp[i] = new Nuoc(masp, tensp, loaisp, sl, gia, thuongHieu);
                }
        }
            input.close();
            int id = sp[n-1].change(sp[n-1].getMasp());
            SanPham.init(id);
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
            for(SanPham temp : sp){
                if(temp instanceof Pizza){
//                1,String masp, String thuonghieu, String tensp, String loaisp, int sl, float gia, String cautruc
                    s = temp.getLoaisp()+ ";" + temp.getMasp() + ";" + temp.getTensp() +";" 
					+ temp.getSl() + ";" + temp.getGia() + ";" + ((Pizza) temp).getDe() + ";" + ((Pizza) temp).getSize() + "\n";
                    fw.write(s);
                }
                if(temp instanceof Nuoc){
                    s = temp.getLoaisp()+ ";" + temp.getMasp() + ";" + temp.getTensp() +";" 
					+ temp.getSl() + ";" + temp.getGia() + ";" + ((Nuoc) temp).getThuongHieu() + "\n";
                    fw.write(s);
                }
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
        
}



