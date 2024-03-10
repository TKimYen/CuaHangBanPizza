/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuahangbanpizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author DELL
 */
public class DanhSachHoaDon implements ThaoTac {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private HoaDon [] hd;
    private int sizeHD;
    
    public DanhSachHoaDon() {
        hd = new HoaDon[1];
        sizeHD = 1;
    }

    public HoaDon[] getHd() {
        return hd;
    }

    public void setHd(HoaDon[] hd) {
        this.hd = hd;
    }

    public int getSizeHD() {
        return sizeHD;
    }

    public void setSizeHD(int sizeHD) {
        this.sizeHD = sizeHD;
    }

    public void nhapDanhSach(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh, DanhSachCTHD dsct) throws FileNotFoundException {
        System.out.print("Nhập vào số lượng hoá đơn: ");
        sizeHD = sc.nextInt();
        sc.nextLine();
        if (sizeHD > 0) {
//          Khởi tạo mảng hd
            hd = new HoaDon[sizeHD];
            // Nhập thông tin hóa đơn
            for (int i = 0; i < sizeHD; i++) {
                hd[i] = new HoaDon();
                hd[i].taoMaTuDong();
                hd[i].nhap(dssp, dsnv, dskh, dsct);
            }
        } 
        else {
            System.out.println("Số lượng hóa đơn phải lớn hơn 0.");
        }
    }
 
    public void them(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh, DanhSachCTHD dsct){
        int sl;
        System.out.print("Nhập vào số lượng hoá đơn: ");
        sl = sc.nextInt();
        sc.nextLine();
        sizeHD += sl;
        hd = Arrays.copyOf(hd, sizeHD);
        for(int i = sizeHD - sl; i < sizeHD; i++){
            hd[i] = new HoaDon();
            hd[i].taoMaTuDong();
            hd[i].nhap(dssp, dsnv, dskh, dsct);
        }
    }


    //////////////Xuat danh sach
     public void XuatDanhSach(DanhSachCTHD dsct) {
		System.out.println("\t\t\t\t\t\t=======DANH SÁCH HÓA ĐƠN=======");
		System.out.println("=====================================================================================================================================");
		try {
			for (int i = 0; i < sizeHD; i++) {
                                System.out.println("\n\t\t\t\t\t\tHOÁ ĐƠN THỨ " + (i + 1));
                                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
//                		System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
//                                System.out.format("|| %4s |", (i + 1));
                                    hd[i].xuat(dsct);
                                System.out.println("Tổng tiền của hóa đơn này là: " + hd[i].getTongTien());
                                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

			}
		}catch(NullPointerException npe) {
			
		}
		 System.out.println("======================================================================================================================================");
 
    }
    
//    THAO TÁC SỬA
//     update
    public void sua(DanhSachSanPham sp, DanhSachNhanVien nv, DanhSachKhachHang kh, DanhSachCTHD dsct){
        int luaChon = 0;
	do {
            System.out.println("\n\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Sửa thông tin hóa đơn");
            System.out.println("\t\t\t\t\t\t2. Thoát");
            do{
                System.out.print("Lựa chọn của bạn là: ");
                luaChon = sc.nextInt();  sc.nextLine();
                if(luaChon < 1 || luaChon > 2)
                    System.err.println("\nBạn đã nhập sai lựa chọn của mình. Xin mời nhập lại");
            } while(luaChon < 1 || luaChon > 2);
            
            if(luaChon == 1){
                System.out.print("Nhập mã hóa đơn muốn sửa: ");
                String maSua = sc.nextLine();
                for(int i = 0; i < sizeHD; i++){
                      if(hd[i].getMaHoaDon().equals(maSua)){
//                         ChiTietHoaDon[] ct = hd[i].getCthd();
//                         for (int j = 0; j < ct.length; j++) {
//                            sp.tangSL_SP(ct[j].getMaSanPham(), ct[j].getSoLuong());
//                        }
                        dsct.xoaTheoMaHD(sp, maSua);
                        hd[i].setTongTien(0);
                        hd[i].setMaHoaDon(maSua);
                        hd[i].nhap(sp, nv, kh, dsct);
//                        for(int j = 0; j < hd[i].getSlCTHD(); j++)
//                            hd[i].getCthd()[j].setMaHoaDon(maSua);
                    }
                }    
            } 
	}while(luaChon != 2);               
    }
    
    
    //* TÌM
    public void tim(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh, DanhSachCTHD dsct){
        //Menu tim
        int luaChon;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\t\t\t\t\t\t====BẢNG LỰA CHỌN=====.");
            System.out.println("\t\t\t\t\t\t1. Tìm hóa đơn theo mã hóa đơn.");
            System.out.println("\t\t\t\t\t\t2. Tìm hóa đơn theo mã nhân viên.");
            System.out.println("\t\t\t\t\t\t3. Tìm hóa đơn theo mã khách hàng.");
            System.out.println("\t\t\t\t\t\t4. Dừng các thao tác.");
            System.out.print("Mời bạn nhập lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
                case 1:
                    timHoaDonTheoMa(dsct);
                    break;
                case 2:
                    timHoaDonTheoMaNhanVien(dsnv, dsct);
                    break;
                case 3:
                    timHoaDonTheoMaKhachHang(dskh, dsct);
                    break;
                case 4:
                    System.out.println("Dừng thao tác tìm.");
                    break;
                default:
                    System.out.println("Bạn đã nhập sai lựa chọn.");
                    break;
            }
                
        }
        while (luaChon != 4);
    }
    
    public void timHoaDonTheoMa(DanhSachCTHD dsct){
        System.out.print("Nhập mã hóa đơn cần tìm: ");
        String ma = sc.nextLine();
        boolean found = false;
        System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        for(int i = 0; i < hd.length; i++){
            if(hd[i] != null && hd[i].getMaHoaDon().contains(ma)){
                found = true;
                System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|| %4s |", (i + 1));
                hd[i].xuat(dsct);
                System.out.println("Tổng tiền của hóa đơn này là: " + hd[i].getTongTien());
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                
            }
        }
        if(!found)
            System.out.println("Không tìm thấy mã hóa đơn!");
    }
    
    public boolean timHoaDonTheoMa(String ma){
        boolean found = false;
        for(int i = 0; i < hd.length; i++){
            if(hd[i] != null && hd[i].getMaHoaDon().contains(ma)){
                found = true;
            }
        }
        return found;
    }
    
    public void timHoaDonTheoMaNhanVien(DanhSachNhanVien dsnv, DanhSachCTHD dsct){
        NhanVien [] dsnvTemp = dsnv.getNv();
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String manv = sc.nextLine();
        boolean found = false;
        System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        if(dsnv.xetTonTai(manv)){
            for(int i = 0; i < sizeHD; i++){
                if(hd[i].getMaNhanVien().contains(manv)){
                    found = true;
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
                    System.out.format("|| %4s |", (i + 1));
                     hd[i].xuat(dsct);
                    System.out.println("Tổng tiền của hóa đơn này là: " + hd[i].getTongTien());
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                }    
            }
        }
        if(!found){
            System.out.println("Không tìm thấy hóa đơn thỏa yêu cầu.");
        }
    }
    
    public void timHoaDonTheoMaKhachHang(DanhSachKhachHang dskh, DanhSachCTHD dsct){
        System.out.print("Nhập mã khách hàng cần tìm: ");
        String makh = sc.nextLine();
        boolean found = false;
        System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        
        if(dskh.xetTonTai(makh)){
            for(int i = 0; i < sizeHD; i++){
                if(hd[i].getMaKhachHang().contains(makh)){                    
                    found = true;
                    System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("|| %4s |", (i + 1));
                     hd[i].xuat(dsct);
                    System.out.println("Tổng tiền của hóa đơn này là: " + hd[i].getTongTien());
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
        if(!found){
            System.out.println("Không tìm thấy hóa đơn thỏa yêu cầu.");
        }
    }
   
// ========= THAO TÁC XÓA ===============
     public void xoa(DanhSachSanPham dssp, DanhSachCTHD dsct) {
    System.out.print("Nhập mã hóa đơn bạn muốn xóa: ");
    String ma = sc.nextLine();

    boolean found = false;

    for (int i = 0; i < hd.length; i++) {
        if (hd[i] != null && hd[i].getMaHoaDon().contains(ma)) {
//            ChiTietHoaDon[] ct = hd[i].getCthd();
//
//            for (int j = 0; j < ct.length; j++) {
//                dssp.tangSL_SP(ct[j].getMaHoaDon(), ct[j].getSoLuong());
//            }
            dsct.xoaTheoMaHD(dssp, ma);
            if (i == hd.length - 1) {
                hd[i] = null;
                sizeHD--;
            } else {
                for (int k = i; k < hd.length - 1; k++) {
                    hd[k] = hd[k + 1];
                }
                sizeHD--;
            }
            found = true;
            break;
        }
    }
    if (found) {
        System.out.println("Đã xóa hóa đơn có mã: " + ma);
    } else {
        System.out.println("Không tìm thấy hóa đơn có mã : " + ma);
    }
}

    public double TinhTongTien() {
        double tongTien = 0.0;
        for (int i = 0; i < sizeHD; i++) {
            if (hd[i] != null) {
                tongTien += hd[i].getTongTien();
            }
        }
        return tongTien;
    }
      
//    ==========THAO TÁC THỐNG KÊ=============
    //      ----THỐNG KÊ THEO QUÝ----------
    public double [] thu (String year) throws ParseException{
        double [] thu = new double [5];
        for(int i = 0; i < sizeHD; i++){
            Date namLap = new SimpleDateFormat("dd/MM/yyyy").parse(hd[i].getNgayLap());
            String namLapString = new SimpleDateFormat("yyyy").format(namLap);
            if(year.contains(namLapString)){
                Date ngay = new SimpleDateFormat("dd/MM/yyyy").parse(hd[i].getNgayLap());
                // Lấy tháng
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(ngay);
                int thang = calendar.get(Calendar.MONTH) + 1;
                int quy = (thang / 3) + 1;
                switch(quy){
                    case 1: 
                        thu[0] += hd[i].getTongTien();
                        break;
                    case 2: 
                        thu[1] += hd[i].getTongTien();
                        break;
                    case 3: 
                        thu[2] += hd[i].getTongTien();
                        break;
                    case 4: 
                        thu[3] += hd[i].getTongTien();
                        break;
                    default:
                        break;   
                } 
            }
        }
        thu[4] = thu[0] + thu[1] + thu[2] + thu[3];     
        return thu;
    }
    
    public void tongDoanhThuTheoMaNhanVien(String maNV, DanhSachCTHD dsct) {
        double tongThu = 0.0;
        int count = 0;
	System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        System.out.println("==============================================================================================================================================");        
        for (int i = 0; i < sizeHD; i++) {            
            if (hd[i].getMaNhanVien().contains(maNV)) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
                System.out.format("|| %4s |", (i + 1));
                hd[i].xuat(dsct);
                count++;
                tongThu += hd[i].getTongTien();
            }
        }
        System.out.println("Nhân viên mang mã: " + maNV + " phụ trách " + count + " hóa đơn, tổng tiền tất cả hóa đơn là: " + tongThu + "\n");
        System.out.println("==============================================================================================================================================");        
    }

    public void tongDoanhThuTheoMaKhachHang(String maKH, DanhSachCTHD dsct) {
        double tongThu = 0;
        int count = 0;
        System.out.println("\t\t\t\t\t\t=======KẾT QUẢ======");
        System.out.println("==============================================================================================================================================");        
        for (int i = 0; i < sizeHD; i++) {            
            if (hd[i].getMaKhachHang().contains(maKH)) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|| %4s | %10s | %10s | %28s | %12s | %28s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "HỌ TÊN CỦA KHÁCH HÀNG", "NHÂN VIÊN PHỤ TRÁCH", "HỌ TÊN CỦA NHÂN VIÊN", "NGÀY LẬP HĐ");
                System.out.format("|| %4s |", (i + 1));
                hd[i].xuat(dsct);
                count++;
                tongThu += hd[i].getTongTien();
            }
        }
        System.out.println("Khách hàng mang mã: " + maKH + " đã mua " + count + " hóa đơn, tổng tiền tất cả hóa đơn là: " + tongThu + "\n");
        System.out.println("============================================================================================================================================"); 
    }
    
    public void thongKe(DanhSachCTHD dsct) throws ParseException {
        int choice = 0;
        do{
            System.out.println("\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
            System.out.println("\t\t\t\t\t\t1. Thống kê doanh thu theo mã nhân viên.");
            System.out.println("\t\t\t\t\t\t2. Thống kê doanh thu theo mã khách hàng.");
            System.out.println("\t\t\t\t\t\t3. Thống kê doanh thu theo quý.");
            System.out.println("\t\t\t\t\t\t4. Thoát thao tác.");
            System.out.print("Chọn loại thống kê: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.print("Nhập mã nhân viên: ");
                String maNhanVien = sc.nextLine();
                tongDoanhThuTheoMaNhanVien(maNhanVien, dsct);
            }
            if(choice == 2){
                System.out.print("Nhập mã khách hàng: ");
                String maKhachHang = sc.nextLine();
                tongDoanhThuTheoMaKhachHang(maKhachHang, dsct);
            }
            if(choice == 3){
                System.out.print("Nhập năm cần thống kê: ");
                String year = sc.nextLine();
                double [] thuNhap = new double[5];
                thuNhap = thu(year);
                System.out.format("|| %10s | %10s | %10s | %10s | %10s ||\n", "QUÝ 1", "QUÝ 2", "QUÝ 3", "QUÝ 4", "CẢ NĂM");
                System.out.format("|| %10.0f | %10.0f | %10.0f | %10.0f | %10.0f ||\n", thuNhap[0], thuNhap[1], thuNhap[2], thuNhap[3], thuNhap[4]);
            }
            if(choice == 4)
                System.out.println("Dừng thao tác.");
            if(choice < 1 || choice > 4)
                System.out.println("Lựa chọn không hợp lệ");
        
        }while(choice != 4);
    }
//    ==========KẾT THÚC THAO TÁC THỐNG KÊ=============

    public void thaoTac(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachKhachHang dskh, DanhSachCTHD dsct) throws FileNotFoundException, ParseException {
		int select = 0;
		String mahd = "";
		loop:
			while(true) {
				System.out.println("\t\t\t\t\t\t======QUẢN LÝ HÓA ĐƠN======");
				System.out.println("\t\t\t\t\t\t1. Thêm hoá đơn");
				System.out.println("\t\t\t\t\t\t2. Xoá hoá đơn");
				System.out.println("\t\t\t\t\t\t3. Sửa thông tin hoá đơn");
				System.out.println("\t\t\t\t\t\t4. Tìm kiếm hoá đơn");
				System.out.println("\t\t\t\t\t\t5. Xuất danh sách hoá đơn");
                                System.out.println("\t\t\t\t\t\t6. Thống kê");
				System.out.println("\t\t\t\t\t\t7. Dừng các thao tác");
				System.out.print("\nLựa chọn của bạn là: ");
				select = sc.nextInt();
				sc.nextLine();
				switch(select) {
					case 1:
                                                them(dssp, dsnv, dskh, dsct);
						break;
					case 2:
						xoa(dssp, dsct);
						XuatDanhSach(dsct);
						break;
					case 3:
						sua(dssp, dsnv, dskh, dsct);
						break;
					case 4:
						tim(dssp, dsnv, dskh, dsct);
						break;
					case 5: 
						XuatDanhSach(dsct);
						break;
                                        case 6: 
						thongKe(dsct);
						break;
					case 7:
						break loop;
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
            sizeHD = Integer.parseInt(input.readLine());
            hd = new HoaDon[sizeHD];
            for(int i=0; i < sizeHD; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String maHoaDon = ar[0];
                String ngayLap = ar[1];
                String maNhanVien = ar[2];
                String hoNhanVien = ar[3];
                String tenNhanVien = ar[4];
                String maKhachHang = ar[5];
                String hoKhachHang = ar[6];
                String tenKhachHang = ar[7];
                double tongTien = Double.parseDouble(ar[8]);
                
                int slChiTiet = Integer.parseInt(ar[9]);    
//                ChiTietHoaDon[] ct = new ChiTietHoaDon[slChiTiet];
//                for (int j = 0; j<slChiTiet; j++) {
//                    line = input.readLine();
//                    ar = line.split(";");
//                    maHoaDon = ar[0];
//                    String maSanPham = ar[1]; 
//                    int soLuong = Integer.parseInt(ar[2]);
//                    double donGia = Double.parseDouble(ar[3]);
//                    double thanhTien = Double.parseDouble(ar[4]);
//                    ct[j] = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia, thanhTien);
//                }
                hd[i] = new HoaDon(maHoaDon, ngayLap, maNhanVien, hoNhanVien, tenNhanVien, maKhachHang, hoKhachHang, tenKhachHang, tongTien, slChiTiet);
            }
            input.close();
            int id = hd[sizeHD-1].change(hd[sizeHD-1].getMaHoaDon());
            HoaDon.init(id);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void ghiFile(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
//            BufferedWriter bw = new BufferedWriter(fw);
            String s;
            s=sizeHD+"\n";
            fw.write(s);
            for(HoaDon h : hd){
                s = h.getMaHoaDon() + ";" + h.getNgayLap() + ";" + h.getMaNhanVien() + ";" + h.getHoNhanVien()+ ";" + h.getTenNhanVien() + ";" + h.getMaKhachHang() + ";" + h.getHoKhachHang() + ";" + h.getTenKhachHang() + ";" + h.getTongTien() + ";" + h.getSlCTHD() + "\n";
                fw.write(s);
//                ChiTietHoaDon [] ctTemp = h.getCthd();
//                for(ChiTietHoaDon ct : ctTemp){
//                    s = ct.getMaHoaDon() + ";" + ct.getMaSanPham() + ";" + ct.getSoLuong() + ";" + ct.getDonGia() + ";" + ct.getThanhTien() + "\n";
//                    fw.write(s);
//                }
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
//    public void tongTienTheoMSP(DanhSachSanPham dssp){
//        double tongTien = 0;
//        System.out.print("Nhập mã sản phẩm: ");
//        String maTim = sc.nextLine();
//        if(dssp.timKiem_MaSP(maTim)){
//            for(int i = 0; i < sizeHD; i++){
//                ChiTietHoaDon [] ct = hd[i].getCthd();
//                for(int j = 0; j < hd[i].getSlCTHD(); j++){
//                    if(ct[j].getMaSanPham().contains(maTim))
//                        tongTien += ct[j].getThanhTien();
//                }
//            }
//        }
//        System.out.println("Tổng tiền của sản phẩm mang mã " + maTim + " là: " + tongTien);        
//    }
      
}
