/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

/**
 *
 * @author THANH THAO
 */
import cuahangbanpizza.DAO.SanPhamDAO;
import cuahangbanpizza.DTO.SanPham;
import MyCustom.MyDialog;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SanPhamBUS {

    private SanPhamDAO spDAO = new SanPhamDAO();
    private ArrayList<SanPham> listSanPham = null;

    public SanPhamBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listSanPham = spDAO.getListSanPham();
    }

    public ArrayList<SanPham> getDanhSachSanPham() {
        if (this.listSanPham == null)
            docDanhSach();
        return this.listSanPham;
    }
    
//    public ArrayList<SanPham> timSanPham(String tuKhoa) {
//        tuKhoa = tuKhoa.toLowerCase();
//        ArrayList<SanPham> dssp = new ArrayList<>();
//        for (SanPham sp : listSanPham) {
//            if (sp.getTenSP().toLowerCase().contains(tuKhoa) || 
//                sp.getMaLoaiSP().toLowerCase().contains(tuKhoa)) {
//                dssp.add(sp);
//            }
//        }
//        return dssp;
//    }

    public boolean themSanPham(SanPham sp) {
        boolean flag = spDAO.addSanPham(sp);
        if (flag) {
            new MyDialog("Thêm mới thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm mới thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean suaSanPham(SanPham sp) {
        boolean flag = spDAO.updateSanPham(sp);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    

    public boolean xoaSanPham(String maSP) {
        boolean flag = spDAO.deleteSanPham(maSP);
        if (flag) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
}

