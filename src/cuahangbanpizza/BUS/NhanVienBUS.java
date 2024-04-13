package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.NhanVienDAO;
import cuahangbanpizza.DTO.NhanVien;
import MyCustom.MyDialog;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NhanVienBUS {

    private NhanVienDAO nvDAO = new NhanVienDAO();
    private ArrayList<NhanVien> listNhanVien = null;

    public NhanVienBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listNhanVien = nvDAO.getListNhanVien();
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        if (this.listNhanVien == null)
            docDanhSach();
        return this.listNhanVien;
    }
    
    public ArrayList<NhanVien> timNhanVien(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (NhanVien nv : listNhanVien) {
            if (nv.getHo().toLowerCase().contains(tuKhoa) || nv.getTen().toLowerCase().contains(tuKhoa) ||
                    nv.getGioitinh().toLowerCase().contains(tuKhoa) || nv.getCV().toLowerCase().contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public boolean themNhanVien(String ma, String ho, String ten, String gioiTinh, String ngaySinh, String dienThoai, String chucVu, Double luong) {
        try {
            int maNV = Integer.parseInt(ma);
        
            if (ten.trim().equals("")) {
                new MyDialog("Hãy nhập tên Nhân viên này!", MyDialog.ERROR_DIALOG);
                return false;
            }
        
            Pattern pattern = Pattern.compile("^\\d{10}$");
            if (!pattern.matcher(dienThoai).matches()) {
               new MyDialog("Hãy nhập số điện thoại hợp lệ!", MyDialog.ERROR_DIALOG);
               return false;
            }
        
            NhanVien nv = new NhanVien();
            nv.setManv(ma);
            nv.setHo(ho);
            nv.setTen(ten);
            nv.setGioitinh(gioiTinh);
            nv.setNgaysinh(ngaySinh);
            nv.setSdt(dienThoai);
            nv.setCV(chucVu);
            nv.setLuong(luong);
            
           
           boolean flag = nvDAO.addNhanVien(nv);
        
            if (flag) {
                new MyDialog("Thêm mới thành công!", MyDialog.SUCCESS_DIALOG);
           } else {
               new MyDialog("Thêm mới thất bại!", MyDialog.ERROR_DIALOG);
           }
        
           return flag;
       } catch (NumberFormatException e) {
            new MyDialog("Mã nhà cung cấp không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
       }
    }

public boolean suaNhanVien(String ma, String ho, String ten, String gioiTinh, String ngaySinh, String soDienThoai, String chucVu, Double luong) {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setGioitinh(gioiTinh);
        nv.setNgaysinh(ngaySinh);
        nv.setSdt(soDienThoai);
        nv.setCV(chucVu);
        nv.setLuong(luong);
        boolean flag = nvDAO.updateNhanVien(Integer.parseInt(ma), nv);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    

    public boolean xoaNhanVien(String ma) {
        try {
            int maNV = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                boolean flag = nvDAO.deleteNhanVien(maNV);
                if (flag) {
                    new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
                    return true;
                } else {
                    new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
                    return false;
                }
            } else {
            // Người dùng chọn hủy bỏ, không thực hiện hành động xoá
                return false;
            }
        } catch (Exception e) {
        // Xử lý ngoại lệ
            new MyDialog("Đã xảy ra lỗi khi xoá nhân viên!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

//    public boolean nhapExcel(String ho, String ten, String gioiTinh, String chucVu) {
//        NhanVien nv = new NhanVien();
//        nv.setHo(ho);
//        nv.setTen(ten);
//        nv.setGioiTinh(gioiTinh);
//        nv.setChucVu(chucVu);
//        boolean flag = nvDAO.nhapExcel(nv);
//        return flag;
//    }
}
