package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.NhaCungCapDAO;
import cuahangbanpizza.DTO.NhaCungCap;
import MyCustom.MyDialog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhaCungCapBUS {

    private NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    private ArrayList<NhaCungCap> listNhaCungCap = null;

    public NhaCungCapBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listNhaCungCap = nccDAO.getListNhaCungCap();
    }

    public ArrayList<NhaCungCap> getListNhaCungCap() {
        if (this.listNhaCungCap == null) {
            docDanhSach();
        }
        return this.listNhaCungCap;
    }

    
    public ArrayList<NhaCungCap> timNhacungCap(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCap> dskh = new ArrayList<>();
        for (NhaCungCap kh : listNhaCungCap) {
            String ten = kh.getTenncc().toLowerCase();
            String diaChi = kh.getDiachi().toLowerCase();
            if ( ten.contains(tuKhoa) || diaChi.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }
    public boolean themNhaCungCap(int ma, String ten, String dienThoai, String diaChi) {
        try {
        
            if (ten.trim().equals("")) {
                new MyDialog("Hãy nhập tên Nhà cung cấp này!", MyDialog.ERROR_DIALOG);
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
        
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMancc(ma);
            ncc.setTenncc(ten);
            ncc.setSdt(dienThoai);
            ncc.setDiachi(diaChi);
           
           boolean flag = nccDAO.addNhaCungCap(ncc);
        
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

    public boolean suaNhaCungCap(String ma, String ten,  String soDienThoai, String diaChi) {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (diaChi.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTenncc(ten);
        ncc.setSdt(soDienThoai);
        ncc.setDiachi(diaChi);
        boolean flag = nccDAO.updateNhaCungCap(Integer.parseInt(ma), ncc);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    
    public boolean xoaNhaCungCap(String ma) {
        try {
            int maNCC = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                boolean flag = nccDAO.deleteNhaCungCap(maNCC);
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


}
