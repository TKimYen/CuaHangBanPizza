//package quanlybanthuoc;
//
//import java.util.Scanner;
//
////import CHITIETHD.menuHD;
////import CHITIETHD.menuPN;
////import KHACHHANG.menuKH;
////import NHANVIEN.Menu;
////import SANPHAM.menu;
//
//public class DangNhap {
////	private Ch
//    private static final String ADMIN_USERNAME = "admin";
//    private static final String ADMIN_PASSWORD = "admin123";
//    private static final String EMPLOYEE_USERNAME = "employee";
//    private static final String EMPLOYEE_PASSWORD = "employee123";
//    static Scanner sc = new Scanner(System.in);
//
//    public DangNhap() {
//        
//    }
//
//    public void hienThiMenuChonChucVu() {
//        System.out.println("----- MENU CHON CHUC VU -----");
//        System.out.println("1. Admin");
//        System.out.println("2. Nhan Vien");
//        System.out.print("Nhap lua chon cua ban: ");
//    }
//
//    public boolean dangNhap() {
//        hienThiMenuChonChucVu();
//
//        int choice = sc.nextInt();
//        sc.nextLine(); // Đọc bỏ dòng newline
//
//        System.out.println("Nhap ten dang nhap: ");
//        String username = sc.nextLine();
//        System.out.println("Nhap mat khau: ");
//        String password = sc.nextLine();
//
//        boolean isAuthenticated = false;
//
//        switch (choice) {
//            case 1:
//                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
//                    System.out.println("Dang nhap thanh cong!");
//                    isAuthenticated = true;
//                    hienThiMenuAdmin();
//                }
//                break;
//            case 2:
//                if (username.equals(EMPLOYEE_USERNAME) && password.equals(EMPLOYEE_PASSWORD)) {
//                    System.out.println("Dang nhap thanh cong!");
//                    isAuthenticated = true;
//                    hienThiMenuNhanVien();
//                }
//                break;
//            default:
//                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
//                return false;
//        }
//
//        if (!isAuthenticated) {
//            System.out.println("Dang nhap that bai. Vui long kiem tra lai thong tin dang nhap.");
//            return false;
//        }
//
//        return true;
//    }
//    
//    public static void quanLySanPham() {
//        System.out.println("Chuc nang quan ly San Pham");
//        menu menu = new menu();
//        menu.run();
//    }
//
//    public static void quanLyNhanVien() {
//        System.out.println("Chuc nang quan ly Nhan Vien");
//        Menu menu = new Menu();
//	    menu.run();
//    }
//
//    public static void quanLyKhachHang() {
//        System.out.println("Chuc nang quan ly Khach Hang");
//        menuKH menu = new menuKH();
//	    menu.run();
//    }
//
//    public static void quanLyHoaDon() {
//        System.out.println("Chuc nang quan ly Hoa Don");
//        menuHD menu = new menuHD();
//        menu.run();
//    }
//
//    public static void quanLyPhieuNhap() {
//        System.out.println("Chuc nang quan ly Phieu Nhap");
//        menuPN menu = new menuPN();
//        menu.run();
//    }
//
//    public static void main(String[] args) {
//        DangNhap dn = new DangNhap();
//        if (dn.dangNhap()) {
//            hienThiMenuAdmin();
//        } else {
//            System.out.println("Dang nhap that bai. Vui long dang nhap truoc khi truy cap chuc nang.");
//        }
//    }
//
//    public static void hienThiMenuAdmin() {
//        // Hiển thị menu cho chức vụ Admin
//        while (true) {
//            System.out.println("----- MENU ADMIN -----");
//            System.out.println("1. Quan ly San Pham");
//            System.out.println("2. Quan ly Nhan Vien");
//            System.out.println("3. Quan ly Khach Hang");
//            System.out.println("4. Quan ly Hoa Don");
//            System.out.println("5. Quan ly Phieu Nhap");
//            System.out.println("0. Dang xuat");
//            System.out.print("Nhap lua chon cua ban: ");
//            int choice = sc.nextInt();
//            switch (choice) {
//            case 1:
//                quanLySanPham();
//                break;
//            case 2:
//                quanLyNhanVien();
//                break;
//            case 3:
//                quanLyKhachHang();
//                break;
//            case 4:
//                quanLyHoaDon();
//                break;
//            case 5:
//                quanLyPhieuNhap();
//                break;
//            case 0:
//                System.out.println("Chuong trinh ket thuc. Hen gap lai!!");
//                System.exit(0);
//            default:
//                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
//        }
//        }
//    }
//
//    private void hienThiMenuNhanVien() {
//        // Hiển thị menu cho chức vụ Nhân Viên
//        while (true) {
//            System.out.println("----- MENU NHAN VIEN -----");
//            System.out.println("1. Quan ly Hoa Don");
//            System.out.println("2. Quan ly Khach Hang");
//            System.out.println("0. Dang xuat");
//            System.out.print("Nhap lua chon cua ban: ");
//            int choice = sc.nextInt();
//
//            // Xử lý lựa chọn
//            switch (choice) {
//            case 1:
//                quanLyHoaDon();
//                break;
//            case 2:
//                quanLyKhachHang();
//                break;
//                case 0:
//                    System.out.println("Dang xuat thanh cong.");
//                    return;
//                default:
//                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
//            }
//        }
//    }
//}
