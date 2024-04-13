/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

import MyCustom.MyDialog;
import cuahangbanpizza.DAO.TaiKhoanDAO;

/**
 *
 * @author DELL
 */
public class TaiKhoanBUS {
    private TaiKhoanDAO tkDAO;
    
    public TaiKhoanBUS(){
        tkDAO = new TaiKhoanDAO();
    }
    
    public String getTenDangNhapTheoMa(String ma) {
        return tkDAO.getTenDangNhapTheoMa(ma);
    }
    
    public void datLaiMatKhau(String maNV, String tenDangNhap) {
        boolean flag = tkDAO.datLaiMatKhau(maNV, tenDangNhap);
        if (flag) {
            new MyDialog("Đặt lại thành công! Mật khẩu mới là: " + tenDangNhap, MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Đặt lại thất bại!", MyDialog.ERROR_DIALOG);
        }
    }
    
    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return tkDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }
    
    public boolean themTaiKhoan(String maNV, String tenDangNhap, String quyen) {
        if (tenDangNhap.trim().equals("")) {
            new MyDialog("Không được để trống Tên đăng nhập!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (kiemTraTrungTenDangNhap(tenDangNhap)) {
            MyDialog dlg = new MyDialog("Tên đăng nhập bị trùng! Có thể tài khoản bị khoá, thực hiện mở khoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                moKhoaTaiKhoan(maNV);
                return true;
            }
            return false;
        }
        boolean flag = tkDAO.themTaiKhoan(maNV, tenDangNhap, quyen);
        if (flag) {
            new MyDialog("Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap, MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Cấp tài khoản thất bại! Tài khoản đã tồn tại", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    public void khoaTaiKhoan(String maNV) {
        boolean flag = tkDAO.khoaTaiKhoan(maNV);
        if (flag) {
            new MyDialog("Khoá tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Khoá tài khoản thất bại!", MyDialog.ERROR_DIALOG);
        }
    }

    public void moKhoaTaiKhoan(String maNV) {
        boolean flag = tkDAO.moKhoaTaiKhoan(maNV);
        if (flag) {
            new MyDialog("Mở khoá tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Mở khoá tài khoản thất bại!", MyDialog.ERROR_DIALOG);
        }
    }

    public boolean doiMatKhau(String maNV, String matKhauCu, String matKhauMoi, String nhapLaiMatKhau) {
        if(!matKhauMoi.equals(nhapLaiMatKhau)) {
            new MyDialog("Mật khẩu mới không khớp!", MyDialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = tkDAO.doiMatKhau(maNV, matKhauCu, matKhauMoi);
        if (flag) {
            new MyDialog("Đổi thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Mật khẩu cũ nhập sai!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
}
