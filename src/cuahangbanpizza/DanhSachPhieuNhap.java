package cuahangbanpizza;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cuahangbanpizza.DTO.ChiTietPhieuNhap;
import cuahangbanpizza.DTO.PhieuNhap;
import cuahangbanpizza.DTO.NhanVien;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author HP
 */
public class DanhSachPhieuNhap {
    DanhSachNhanVien dsnv = new DanhSachNhanVien();
    DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();
    Scanner sc = new Scanner(System.in);
    
    private PhieuNhap[] pn;
    private int sizePN;
    
    public DanhSachPhieuNhap() {
          pn = new PhieuNhap[1];
          sizePN = 1;
     }

    public DanhSachNhanVien getNv() {
        return dsnv;
    }

    public void setNv(DanhSachNhanVien nv) {
        this.dsnv = nv;
    }

    public DanhSachNhaCungCap getNcc() {
        return dsncc;
    }

    public void setNcc(DanhSachNhaCungCap ncc) {
        this.dsncc = ncc;
    }

    public PhieuNhap[] getPn() {
        return pn;
    }

    public void setPn(PhieuNhap[] pn) {
        this.pn = pn;
    }
    
     public int getSizePN() {
        return sizePN;
    }

    public void setSizePN(int sizePN) {
        this.sizePN = sizePN;
    }
    
   
   // ========= THAO TÁC NHẬP CHI TIẾT PHIẾU NHẬP ===============
    public void nhapDanhSach(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc) throws IOException{
	System.out.print("Nhập vào số lượng phieu nhap : ");
        sizePN = sc.nextInt();sc.nextLine();
        if(sizePN > 0){
                        pn = new PhieuNhap[sizePN];
			for(int i = 0; i < sizePN; i++) {
				System.out.print("\n\t\t\t\t\t\tPHIẾU NHẬP THỨ " + (i + 1) + "\n");
				pn[i] = new PhieuNhap();
                                pn[i].taoMaTuDong();
				pn[i].nhap(dssp, dsnv, dsncc);
			}
                        
        }else{
            System.out.println("Số lượng phiếu nhập phải lớn hơn 0");
        }              
}
    // ========= THAO TÁC XUẤT CHI TIẾT PHIẾU NHẬP ===============
    public void xuatDanhSachPN() {
		System.out.println("\t\t\t\t\t\t=======DANH SÁCH PHIẾU NHẬP=======");
		System.out.println("==============================================================================================================================================");
		try {
			for(int i = 0; i < sizePN; i++) {
                                System.out.println("\n\t\t\t\t\t\tPHIẾU NHẬP THỨ " + (i +1));
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
//                		System.out.format("|| %4s | %8s  | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n", "STT","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
//                                System.out.format("|| %4s |", (i + 1));
				pn[i].xuat();
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

			}
		}catch(NullPointerException npe) {
			
		}
		System.out.println("==============================================================================================================================================");
                 System.out.println("Tổng tiền của toàn bộ phiếu nhập: " + TinhTongTien());
    }
    
    public double TinhTongTien() {
        double tongTien = 0.0;
        for (int i = 0; i < sizePN; i++) {
            if (pn[i] != null) {
                tongTien += pn[i].getTongTien();
            }
        }
        return tongTien;
    }
    
    
      // ========= THAO TÁC THÊM ===============
    public void them(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc) throws IOException {
        System.out.print("Nhập vào số lượng phiếu nhập muốn thêm: ");
        int sl = sc.nextInt();
        sizePN += sl;
	pn = Arrays.copyOf(pn, sizePN);		
	for(int i = sizePN - sl; i < sizePN; i++) {
            System.out.print("\n\t\t\t\t\t\tPHIẾU NHẬP THỨ " + (i + 1) + "\n");
            pn[i] = new PhieuNhap();
            pn[i].taoMaTuDong();
            pn[i].nhap(dssp, dsnv, dsncc);
        }
    }
    
    // ========= THAO TÁC XÓA ===============
    public void xoa(DanhSachSanPham dssp) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhập mã phiếu nhập bạn muốn xóa: ");
    String ma = sc.nextLine();

    boolean found = false;

    for (int i = 0; i < pn.length; i++) {
        if (pn[i] != null && pn[i].getMaPN().equals(ma)) {
            ChiTietPhieuNhap[] ct = pn[i].getCtpn();

            for (int j = 0; j < ct.length; j++) {
                dssp.giamSL_SP(ct[j].getMasp(), ct[j].getSoluong());
            }
            if (i == pn.length - 1) {
                pn[i] = null;
                sizePN--;
            } else {
                for (int k = i; k < pn.length - 1; k++) {
                    pn[k] = pn[k + 1];
                }
                sizePN--;
            }
            found = true;
            break;
        }
    }

    if (found) {
        System.out.println("Đã xóa phiếu nhập có mã: " + ma);
    } else {
        System.out.println("Không tìm thấy mã phiếu nhập: " + ma);
    }
}
    
    // ========= THAO TÁC SỬA ===============
    public void sua(DanhSachSanPham sp, DanhSachNhanVien nv, DanhSachNhaCungCap ncc) throws IOException{
        int luaChon = 0;
	do {
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Sửa thông tin phiếu nhập");
            System.out.println("\t\t\t\t\t\t2. Thoát");
            do{
            System.out.print("Lựa chọn của bạn là: ");
            luaChon = sc.nextInt();  sc.nextLine();
            if(luaChon < 1 || luaChon > 2)
		System.err.println("\nBạn đã nhập sai lựa chọn của mình. Xin mời nhập lại");
            } while(luaChon < 1 || luaChon > 2);
            
            if(luaChon == 1){
                System.out.print("Nhập mã phiếu nhập muốn sửa: ");
                String maSua = sc.nextLine();
                for(int i = 0; i < sizePN; i++) {
                    if(pn[i].getMaPN().contains(maSua)){
                        ChiTietPhieuNhap[] ct = pn[i].getCtpn();
                         for (int j = 0; j < ct.length; j++) {
                            sp.giamSL_SP(ct[j].getMasp(), ct[j].getSoluong());
                        }
                        pn[i] = new PhieuNhap();
                        pn[i].setTongTien(0);
                        pn[i].setMaPN(maSua);
                        pn[i].nhap(sp, nv, ncc);
                        for(int j = 0; j < pn[i].getSlCTPN(); j++)
                            pn[i].getCtpn()[j].setMapn(maSua);
                    }
                }   
            } 
	}while(luaChon != 2);               
    }
    
    
  // ========= THAO TÁC TÌM ===============
    public void tim(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc){
        //Menu tim
        int luaChon;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Tìm phiếu nhập theo mã phiếu nhập.");
            System.out.println("\t\t\t\t\t\t2. Tìm phiếu nhập theo mã nhân viên.");
            System.out.println("\t\t\t\t\t\t3. Tìm phiếu nhập theo mã nhà cung cấp.");
            System.out.println("\t\t\t\t\t\t4. Thoat.");
            System.out.print("Mời bạn nhập lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
                case 1:
                    timPhieuNhapTheoMaPN();
                    break;
                case 2:
                    timPhieuNhapTheoMaNV(dsnv);
                    break;
                case 3:
                    timPhieuNhapTheoMaNCC(dsncc);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Da thoat khoi chuong trinh.");
                    break;
            }
                
        }
        while (luaChon >= 1 && luaChon < 3);
    }
    
    
    
    public void timPhieuNhapTheoMaPN(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào mã phiếu nhập cần tìm: ");
        String ma = sc.nextLine();
        boolean found = false;
        for(int i = 0; i < pn.length; i++){
            if(pn[i] != null && pn[i].getMaPN().equals(ma)){
                found = true;
                System.out.println("Thông tin phiếu nhập cần tìm: ");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|| %4s | %8s  | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n", "STT","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
                System.out.format("|| %4s |", (i + 1));
		pn[i].xuat();
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        if(!found)
            System.out.println("Không tìm thấy phiếu nhập!");
    }
    
    public boolean timCTHoaDonTheoMaPN(String ma){
        boolean found = false;
        for(int i = 0; i < pn.length; i++){
            if(pn[i] != null && pn[i].getMaPN().equals(ma)){
                found = true;
            }
        }
        return found;
    }
    
    public void timPhieuNhapTheoMaNV(DanhSachNhanVien dsnv){
        NhanVien [] dsnvTemp = dsnv.getNv();
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String manv = sc.nextLine();
        if(dsnv.xetTonTai(manv)){
            System.out.println("Thông tin phiếu nhập do nhân viên mang mã " + manv +" phụ trách là:");
            for(PhieuNhap p : pn){
                if(p.getMaNV().equals(manv)){
                     System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                     System.out.format("|| %8s | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
                     p.xuat();
                     System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                }
            }
        }
        else{
            System.out.println("Mã nhân viên bạn vừa nhập không tồn tại.");
        }
    }
    
    public void timPhieuNhapTheoMaNCC(DanhSachNhaCungCap dsncc){
        System.out.print("Nhập mã nhà cung cấp cần tìm: ");
        String mancc = sc.nextLine();
        if(dsncc.xetTonTai(mancc)){
            System.out.println("Thông tin phiếu nhập của nhà cung cấp mang mã " + mancc +" là:");
            for(PhieuNhap p : pn){
                if(p.getMaNCC().contains(mancc)){
                   System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                     System.out.format("|| %8s | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
                     p.xuat();
                     System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                }
            }
        }
        else{
            System.out.println("Mã nhà cung cấp bạn vừa nhập không tồn tại.");
        }
    }

 //    ==========THAO TÁC THỐNG KÊ=============
    //      ----THỐNG KÊ THEO QUÝ----------
    public double [] chi(String year) throws ParseException{
        double [] thu = new double [5];
        for(int i = 0; i < sizePN; i++){
             Date namLap = new SimpleDateFormat("dd/MM/yyyy").parse(pn[i].getNgayLap());
            String namLapString = new SimpleDateFormat("yyyy").format(namLap);
            if(year.contains(namLapString)){
                Date ngay = new SimpleDateFormat("dd/MM/yyyy").parse(pn[i].getNgayLap());
                // Lấy tháng
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(ngay);
                int thang = calendar.get(Calendar.MONTH) + 1;
                int quy = thang / 3 + 1;
                switch(quy){
                    case 1: 
                        thu[0] += pn[i].getTongTien();
                        break;
                    case 2: 
                        thu[1] += pn[i].getTongTien();
                        break;
                    case 3: 
                        thu[2] += pn[i].getTongTien();
                        break;
                    case 4: 
                        thu[3] += pn[i].getTongTien();
                        break;
                    default:
                        break;   
                } 
            }
        }
        thu[4] = thu[0] + thu[1] + thu[2] + thu[3];     
        return thu;
    }
    
    public void tongDoanhThuTheoMaNhanVien(String maNV) {
        double tongChi = 0.0;
        int count = 0;
	System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        System.out.println("==============================================================================================================================================");        
        for (int i = 0; i < sizePN; i++) {            
            if (pn[i].getMaNV().contains(maNV)) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|| %4s | %8s  | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n", "STT","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
                System.out.format("|| %4s |", (i + 1));
                pn[i].xuat();
                count++;
                tongChi += pn[i].getTongTien();
            }
        }
        System.out.println("Nhân viên mang mã: " + maNV + " phụ trách " + count + " phiếu nhập, tổng tiền tất cả phiếu nhập là: " + tongChi + "\n");
        System.out.println("==============================================================================================================================================");        
    }

    public void tongDoanhThuTheoNhaCungCap(String mancc) {
        double tongChi = 0;
        int count = 0;
        System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        System.out.println("==============================================================================================================================================");        
        for (int i = 0; i < sizePN; i++) {            
            if (pn[i].getMaNCC().contains(mancc)) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
               System.out.format("|| %4s | %8s  | %8s | %10s | %20s | %10s | %15s | %15s | %15s ||\n", "STT","MAPN","MANV","HỌ NHÂN VIÊN " , "TÊN NHÂN VIÊN ","MANCC", "TÊN NHÀ CUNG CẤP", "NGÀY", "TỔNG TIỀN");
                System.out.format("|| %4s |", (i + 1));
                pn[i].xuat();
                count++;
                tongChi += pn[i].getTongTien();
            }
        }
        System.out.println("Số phiếu nhập thuộc nhà cung cấp mang mã " + mancc + "có :" + count + " phiếu nhập\n Tổng tiền tất cả phiếu nhập là: " + tongChi + "\n");
        System.out.println("============================================================================================================================================"); 
    }
    
    public void thongKe() throws ParseException {
        int choice = 0;
        do{
            System.out.println("\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Thống kê tổng chi theo mã nhân viên.");
            System.out.println("\t\t\t\t\t\t2. Thống kê tổng chi theo mã nhà cung cấp.");
            System.out.println("\t\t\t\t\t\t3. Thống kê tổng chi theo quý.");
            System.out.println("\t\t\t\t\t\t4. Thoát thao tác.");
            System.out.print("Chọn loại thống kê: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.print("Nhập mã nhân viên: ");
                String maNhanVien = sc.nextLine();
                tongDoanhThuTheoMaNhanVien(maNhanVien);
            }
            if(choice == 2){
                System.out.print("Nhập mã nhà cung cấp: ");
                String maKhachHang = sc.nextLine();
                tongDoanhThuTheoNhaCungCap(maKhachHang);
            }
            if(choice == 3){
                System.out.print("Nhập năm cần thống kê: ");
                String year = sc.nextLine();
                double [] thuNhap = new double[5];
                thuNhap = chi(year);
                System.out.format("|| %10s | %10s | %10s | %10s | %10s ||\n", "QUÝ 1", "QUÝ 2", "QUÝ 3", "QUÝ 4", "CẢ NĂM");
                System.out.format("|| %10.0f | %10.0f | %10.0f | %10.0f | %10.0f ||\n", thuNhap[0], thuNhap[1], thuNhap[2], thuNhap[3], thuNhap[4]);
            }
            if(choice == 4)
                System.out.println("Dừng thao tác.");
            if(choice < 1 || choice > 4)
                System.out.println("Lựa chọn không hợp lệ");
        
        }while(choice != 4);
    }
    //=========KẾT THÚC THAO TÁC THỐNG KÊ==========
  
    public void thaoTac(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc) throws IOException, ParseException {
		int select = 0;
                String maPN = "";
		while(true) {
				System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
				System.out.println("\t\t\t\t\t\t1.Ấn phím 1 để thêm phiếu nhập");
				System.out.println("\t\t\t\t\t\t2.Ấn phím 2 để xoá phiếu nhập hàng");
				System.out.println("\t\t\t\t\t\t3.Ấn phím 3 để sửa thông tin phiếu nhập hàng");
				System.out.println("\t\t\t\t\t\t4.Ấn phím 4 để tìm kiếm phiếu nhập hàng");
				System.out.println("\t\t\t\t\t\t5.Ấn phím 5 để xuất danh sách phiếu nhập hàng");
                                System.out.println("\t\t\t\t\t\t6.Ấn phím 6 để thống kê");
				System.out.println("\t\t\t\t\t\t7.Ấn phím 7 để dừng các thao tác");
				System.out.print("\nLựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
//                                                NhapDanhSach(dssp, dsnv, dsncc);
						them(dssp, dsnv, dsncc);
                                                break;
                                        case 2:
						xoa(dssp);
						break;
					case 3:
						sua(dssp, dsnv, dsncc);
						break;
					case 4:
						tim(dssp, dsnv, dsncc);
						break;
					case 5: 
						xuatDanhSachPN();
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

    
 
    
  //ĐỌC GHI FILE
   public void docFile(String fileName) {
    try {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        // Đọc và kiểm tra giá trị của sizePN
        String sizePNLine = input.readLine();
       
        sizePN = Integer.parseInt(sizePNLine);
        pn = new PhieuNhap[sizePN];

        for (int i = 0; i < sizePN; i++) {
          
            String line = input.readLine();
            String[] ar = line.split(";");
            
            String maPN = ar[0];
            String maNV = ar[1];
            String hoNV = ar[2];
            String tenNV = ar[3];
            String maNCC = ar[4];
            String tenNCC = ar[5];
            String ngayLap = ar[6];
            double tongTien = Double.parseDouble(ar[7]);

            int slChiTiet = Integer.parseInt(ar[8]);
            ChiTietPhieuNhap[] ct = new ChiTietPhieuNhap[slChiTiet];

            for (int j = 0; j < slChiTiet; j++) {
               
                line = input.readLine();
                ar = line.split(";");
                // Kiểm tra xem dòng có đúng định dạng hay không
                if (ar.length != 5) {
                    System.out.println("Dòng " + (i + 3 + j) + " của file không đúng định dạng.");
                    return;
                }

                String maSanPham = ar[1];
                int soLuong = Integer.parseInt(ar[2]);
                double donGia = Double.parseDouble(ar[3]);
                double thanhTien = Double.parseDouble(ar[4]);
                ct[j] = new ChiTietPhieuNhap(maPN, maSanPham, soLuong, donGia, thanhTien);
            }

            pn[i] = new PhieuNhap(maPN, maNV, hoNV, tenNV, maNCC, tenNCC, ngayLap, tongTien, slChiTiet, ct);
        }

        input.close();
        int id = pn[sizePN - 1].change(pn[sizePN - 1].getMaPN());
        PhieuNhap.init(id);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


public void ghiFile(String fileName) {
    try {
        FileWriter fw = new FileWriter(fileName);
        String s;
        s = sizePN + "\n";
        fw.write(s);

        for (PhieuNhap p : pn) {
            s = p.getMaPN() + ";" + p.getMaNV() + ";" + p.getHoNV() + ";" + p.getTenNV() + ";" + p.getMaNCC() + ";" + p.getTenNCC() + ";" + p.getNgayLap() + ";" + p.getTongTien() + ";" + p.getSlCTPN() + "\n";  // Phương thức getter đã được sửa cho slCT
            fw.write(s);

            ChiTietPhieuNhap[] ctTemp = p.getCtpn();

            for (ChiTietPhieuNhap ct : ctTemp) {
                s = ct.getMapn() + ";" + ct.getMasp() + ";" + ct.getSoluong() + ";" + ct.getDongia() + ";" + ct.getThanhtien() + "\n";
                fw.write(s);
            }
        }

        fw.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}

    
}