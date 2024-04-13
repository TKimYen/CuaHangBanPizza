package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.LoaiDAO;
import cuahangbanpizza.DTO.Loai;
import MyCustom.MyDialog;
import java.util.ArrayList;

public class LoaiBUS {

    private LoaiDAO loaiDAO = new LoaiDAO();
    private ArrayList<Loai> listLoai = null;
    
    public LoaiBUS() {
        docDanhSachLoai();
    }

    public void docDanhSachLoai() {
        this.listLoai = loaiDAO.getDanhSachLoai();
    }

    public ArrayList<Loai> getDanhSachLoai() {
        if (listLoai == null) {
            docDanhSachLoai();
        }
        return this.listLoai;
    }

    public String getTenLoai(int ma) {
        for (Loai loai : listLoai) {
            if (loai.getMaLoai() == ma) {
                return loai.getMaLoai() + " - " + loai.getTenLoai();
            }
        }
        return "";
    }

    public boolean themLoai(int maLoai, String tenLoai) {
        if (tenLoai.trim().equals("")) {
            new MyDialog("Không được để trống tên loại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        maLoai += 1;
        Loai loai = new Loai(maLoai, tenLoai);
        if (loaiDAO.themLoai(loai)) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

    public boolean xoaLoai(String ma) {
        if (ma.trim().equals("")) {
            new MyDialog("Chưa chọn loại để xoá!", MyDialog.SUCCESS_DIALOG);
            return false;
        }
        int maLoai = Integer.parseInt(ma);
        if (loaiDAO.xoaLoai(maLoai)) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Xoá thất bại! Loại có sản phẩm con", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

    public boolean suaLoai(String ma, String ten) {
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên loại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int maLoai = Integer.parseInt(ma);
        if (loaiDAO.suaLoai(maLoai, ten)) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

}
