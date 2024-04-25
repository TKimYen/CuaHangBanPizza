package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.KhachHangDAO;
import cuahangbanpizza.DTO.KhachHang;
import MyCustom.MyDialog;
import java.util.ArrayList;
import java.util.regex.Pattern;
//import java.util.Locale;

public class KhachHangBUS {

    private ArrayList<KhachHang> listKhachHang = null;
    private KhachHangDAO khDAO = new KhachHangDAO();

    public void docDanhSach() {
        this.listKhachHang = khDAO.getListKhachHang();
    }

    public ArrayList<KhachHang> getListKhachHang() {
        if (listKhachHang == null)
            docDanhSach();
        return listKhachHang;
    }

    public ArrayList<KhachHang> getListNhaCungCap() {
        if (this.listKhachHang == null) {
            docDanhSach();
        }
        return this.listKhachHang;
    }

    
    //Phương thức tìm kiếm khách hàng , nhận đầu vào là một từ khó 
    public ArrayList<KhachHang> timKiemKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (KhachHang kh : listKhachHang) {
            String ho = kh.getHo().toLowerCase();
            String ten = kh.getTen().toLowerCase();
            String gioiTinh = kh.getGioitinh().toLowerCase();
            if (ho.contains(tuKhoa) || ten.contains(tuKhoa) || gioiTinh.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public boolean themKhachHang(int ma, String ho, String ten, String gioiTinh, String dienThoai, String diaChi) {
        try {        
            if (ten.trim().equals("")) {
                new MyDialog("Hãy nhập tên Khách hàng này!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (diaChi.trim().equals("")) {
                new MyDialog("Hãy nhập địa chỉ!", MyDialog.ERROR_DIALOG);
                return false;
            }
        
            Pattern pattern = Pattern.compile("^\\d{10}$");
            if (!pattern.matcher(dienThoai).matches()) {
               new MyDialog("Hãy nhập số điện thoại hợp lệ!", MyDialog.ERROR_DIALOG);
               return false;
            }       
            KhachHang kh = new KhachHang();
            kh.setMakh(ma);
            kh.setHo(ho);
            kh.setTen(ten);
            kh.setGioitinh(gioiTinh);
            kh.setSdt(dienThoai);
            kh.setDiachi(diaChi);
           
           boolean flag = khDAO.addKhachHang(kh);
        
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

    public boolean suaKhachHang(String ma, String ho, String ten, String Gioitinh, String Ngaysinh, String Sodienthoai, String Diachi) {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (Gioitinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        KhachHang kh = new KhachHang();
        kh.setHo(ho);
        kh.setTen(ten);
        kh.setGioitinh(Gioitinh);
        boolean flag = khDAO.updateKhachHang(Integer.parseInt(ma), kh);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean xoaKhachHang(String ma) {
        try {
            int maKH = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            if(dlg.getAction() == MyDialog.OK_OPTION) {
                boolean flag = khDAO.deleteKhachHang(maKH);
                if (flag) {
                   new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
                   return true;
                } else {
                    new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
                }
                return flag;
            } else {
                return false; // Người dùng chọn hủy bỏ, không thực hiện hành động xoá
            }
        } catch (Exception e) {
            new MyDialog("Đã xảy ra lỗi khi xóa khách hàng!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
}
