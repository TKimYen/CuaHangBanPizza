package cuahangbanpizza.DTO;
/**
 *
 * @author HP
 */
public class ChiTietPhieuNhap {
    private int maPN;
    private int maSP;
    private int soLuong;
    private int donGia;
    private double thanhTien;
    
    public ChiTietPhieuNhap() {
    
    }
    
    public ChiTietPhieuNhap(int mapn, int masp, int soluong, int dongia, double thanhtien) {
        this.maPN = mapn;
        this.maSP = masp;
        this.soLuong = soluong;
        this.donGia = dongia;
        this.thanhTien = thanhtien;
    }
    
    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn){
        this.maPN = ctpn.maPN;
        this.maSP = ctpn.maSP;
        this.soLuong = ctpn.soLuong;
        this.donGia = ctpn.donGia;
        this.thanhTien = ctpn.thanhTien;
    }
    
     public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int mapn) {
        this.maPN = mapn;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int masp) {
        this.maSP = masp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soluong) {
        this.soLuong = soluong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(int dongia) {
        this.donGia = dongia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhtien) {
        this.thanhTien = thanhtien;
    }
}