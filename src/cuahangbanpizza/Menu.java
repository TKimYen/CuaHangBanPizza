/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Menu {
    private DanhSachHoaDon dshd;
    private DanhSachSanPham dssp;
    private DanhSachNhanVien dsnv;
    private DanhSachKhachHang dskh;
    private DanhSachNhaCungCap dsncc;
    private DanhSachPhieuNhap dspn;
    private DanhSachCTHD dsct;
    Scanner sc = new Scanner(System.in);
    
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String EMPLOYEE_USERNAME = "employee";
    private static final String EMPLOYEE_PASSWORD = "employee123";


    public Menu() {
        dshd = new DanhSachHoaDon();
        dsct = new DanhSachCTHD();
        dssp = new DanhSachSanPham();
        dsnv = new DanhSachNhanVien();
        dskh = new DanhSachKhachHang();
        dsncc = new DanhSachNhaCungCap(); 
        dspn = new DanhSachPhieuNhap();
    }
    
    public void docFileTongHop() throws FileNotFoundException{
        dshd.docFile("file/HoaDon.txt");
        dsct.docFile("file/ChiTietHoaDon.txt");
        dsnv.docFile("file/NhanVien.txt");
        dskh.docFile("file/KhachHang.txt");
        dsncc.docFile("file/NhaCungCap.txt");
        dssp.docFile("file/SanPham.txt");
        dspn.docFile("file/PhieuNhapHang.txt");
    }
    
    public void ghiFileTongHop() throws FileNotFoundException{
        dshd.ghiFile("file/HoaDon.txt");
        dsct.ghiFile("file/ChiTietHoaDon.txt");
        dsnv.ghiFile("file/NhanVien.txt");
        dskh.ghiFile("file/KhachHang.txt");
        dsncc.ghiFile("file/NhaCungCap.txt");
        dssp.ghiFile("file/SanPham.txt");
        dspn.ghiFile("file/PhieuNhapHang.txt");
    }
    
//    public void menu() throws FileNotFoundException, IOException, ParseException{
//        docFileTongHop(); //đọc toàn bộ dữ liệu vào các mảng để thực hiện quản lý
//        int luaChon;
//        loop:
//            while(true){
//                System.out.println("\t\t\t\t\t\t======BẢNG LỰA CHỌN======");
//                System.out.println("\t\t\t\t\t\t1. Quản lý sản phẩm.");
//                System.out.println("\t\t\t\t\t\t2. Quản lý nhân viên.");
//                System.out.println("\t\t\t\t\t\t3. Quản lý khách hàng.");
//                System.out.println("\t\t\t\t\t\t4. Quản lý nhà cung cấp.");
//                System.out.println("\t\t\t\t\t\t5. Quản lý hóa đơn.");
//                System.out.println("\t\t\t\t\t\t6. Quản lý nhập hàng.");
//                System.out.println("\t\t\t\t\t\t7. Thống kê thu chi theo quý.");
//                System.out.println("\t\t\t\t\t\t8. Thoát khỏi chương trình.");
//                System.out.print("Mời nhập lựa chọn của bạn: ");
//                luaChon = sc.nextInt();
//                sc.nextLine();
//                switch(luaChon){
//                    case 1:
//                        dssp.thaoTac(dssp, dsnv, dskh);
//                        break;
//                    case 2:
//                        dsnv.thaoTac();
//                        break;
//                    case 3:
//                        dskh.thaoTac();
//                        break;
//                    case 4:
//                        dsncc.thaoTac();
//                        break;
//                    case 5:
//                        dshd.thaoTac(dssp, dsnv, dskh);
//                        break;
//                    case 6:
//                        dspn.thaoTac(dssp, dsnv, dsncc);
//                        break;
//                    case 7:
//                        thongKeDoanhThu();
//                        break;
//                    case 8:
//                        ghiFileTongHop();
//                        break loop;
//                    default:
//                        System.out.println("Bạn đã nhập sai lựa chọn!");
//                        break;  
//                }                
//            }
//        sc.close();
//    }
    
    public void thongKeDoanhThu() throws ParseException{
        System.out.println("Nhập năm muốn xem thống kê: ");
        String year = sc.nextLine();
        //Thống kê nâng cao in ra thu và chi
        System.out.println("======================================================================================");
        System.out.format("|| %12s | %10s | %10s | %10s | %10s | %10s ||\n", " ","QUÝ 1", "QUÝ 2", "QUÝ 3", "QUÝ 4", "CẢ NĂM");
        double [] thu = dshd.thu(year);
        double [] chiPN = dspn.chi(year);
        double [] chiLuong = dsnv.chi();
        double [] chi = new double[5];
        double [] loiNhuan = new double[5];
        for(int i = 0; i < 5; i++){
            chi[i] = chiPN[i] + chiLuong[i];
            loiNhuan[i] = thu[i] - chi[i];
        }
        
        System.out.format("|| %12s | %10.0f | %10.0f | %10.0f | %10.0f | %10.0f ||\n", " THU ", thu[0], thu[1], thu[2], thu[3], thu[4]);
        System.out.format("|| %12s | %10.0f | %10.0f | %10.0f | %10.0f | %10.0f ||\n", " CHI ", chi[0], chi[1], chi[2], chi[3], chi[4]);
        System.out.format("|| %12s | %10.0f | %10.0f | %10.0f | %10.0f | %10.0f ||\n", " LỢI NHUẬN ", loiNhuan[0], loiNhuan[1], loiNhuan[2], loiNhuan[3], loiNhuan[4]);
        System.out.println("======================================================================================");

    }
    
    
    

    public void hienThiMenuChonChucVu() {
        System.out.println("----- MENU CHON CHUC VU -----");
        System.out.println("1. Admin");
        System.out.println("2. Nhan Vien");
        System.out.print("Nhap lua chon cua ban: ");
    }

    public boolean dangNhap() throws ParseException, IOException {
        hienThiMenuChonChucVu();
        docFileTongHop();

        int choice = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng newline

        System.out.print("Nhap ten dang nhap: ");
        String username = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String password = sc.nextLine();

        boolean isAuthenticated = false;

        switch (choice) {
            case 1:
                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    System.out.println("Dang nhap thanh cong!");
                    isAuthenticated = true;
                    hienThiMenuAdmin();
                }
                break;
            case 2:
                if (username.equals(EMPLOYEE_USERNAME) && password.equals(EMPLOYEE_PASSWORD)) {
                    System.out.println("Dang nhap thanh cong!");
                    isAuthenticated = true;
                    hienThiMenuNhanVien();
                }
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                return false;
        }

        if (!isAuthenticated) {
            System.out.println("Dang nhap that bai. Vui long kiem tra lai thong tin dang nhap.");
            return false;
        }
        
        sc.close();
        return true;
    }
    
    public void quanLySanPham() {
        System.out.println("Chuc nang quan ly San Pham");
        dssp.thaoTac(dssp, dsnv, dskh);
    }

    public void quanLyNhanVien() {
        System.out.println("Chuc nang quan ly Nhan Vien");
        dsnv.thaoTac();
    }

    public void quanLyKhachHang() {
        System.out.println("Chuc nang quan ly Khach Hang");
        dskh.thaoTac();
    }
    
    public void quanLyNhaCungCap() {
        System.out.println("Chuc nang quan ly Nha Cung Cap");
        dsncc.thaoTac();
    }

    public void quanLyHoaDon() throws FileNotFoundException, ParseException {
        System.out.println("Chuc nang quan ly Hoa Don");
        dshd.thaoTac(dssp, dsnv, dskh, dsct);        
    }

    public void quanLyPhieuNhap() throws IOException, ParseException {
        System.out.println("Chuc nang quan ly Phieu Nhap");
        dspn.thaoTac(dssp, dsnv, dsncc);
    }

    public void hienThiMenuAdmin() throws ParseException, IOException {
        // Hiển thị menu cho chức vụ Admin
    	loop:
	        while (true) {
	            System.out.println("----- MENU ADMIN -----");
	            System.out.println("1. Quan ly San Pham");
	            System.out.println("2. Quan ly Nhan Vien");
	            System.out.println("3. Quan ly Khach Hang");
	            System.out.println("4. Quan ly Nha Cung Cap");
	            System.out.println("5. Quan ly Hoa Don");
	            System.out.println("6. Quan ly Phieu Nhap");
	            System.out.println("0. Dang xuat");
	            System.out.print("Nhap lua chon cua ban: ");
	            int choice = sc.nextInt();
	            switch (choice) {
	            case 1:
	                quanLySanPham();
	                break;
	            case 2:
	                quanLyNhanVien();
	                break;
	            case 3:
	                quanLyKhachHang();
	                break;
	            case 4:
	                quanLyNhaCungCap();
	                break;
	            case 5:
	                quanLyHoaDon();
	                break;
	            case 6:
	                quanLyPhieuNhap();
	                break;
	            case 0:
                        ghiFileTongHop();
	                System.out.println("Chuong trinh ket thuc. Hen gap lai!!");
	                break loop;
	            default:
	                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
	        }
        }
    }

    private void hienThiMenuNhanVien() throws FileNotFoundException, ParseException {
        // Hiển thị menu cho chức vụ Nhân Viên
    	loop: 
	        while (true) {
	            System.out.println("----- MENU NHAN VIEN -----");
	            System.out.println("1. Quan ly Hoa Don");
	            System.out.println("2. Quan ly Khach Hang");
	            System.out.println("0. Dang xuat");
	            System.out.print("Nhap lua chon cua ban: ");
	            int choice = sc.nextInt();
	
	            // Xử lý lựa chọn
	            switch (choice) {
	            case 1:
	                quanLyHoaDon();
	                break;
	            case 2:
	                quanLyKhachHang();
	                break;
	                case 0:
                            ghiFileTongHop();
	                    System.out.println("Dang xuat thanh cong.");
	                    break loop;
	                default:
	                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
	            }
	        }        
    }
}
