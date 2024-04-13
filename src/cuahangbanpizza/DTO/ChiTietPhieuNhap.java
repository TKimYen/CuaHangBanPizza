package cuahangbanpizza.DTO;
/**
 *
 * @author HP
 */
public class ChiTietPhieuNhap {
    private String maPN;
    private String maSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    
    public ChiTietPhieuNhap() {}
    
    public ChiTietPhieuNhap(String mapn, String masp, int soluong, double dongia, double thanhtien) {
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
    
     public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String mapn) {
        this.maPN = mapn;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String masp) {
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

    public void setDonGia(double dongia) {
        this.donGia = dongia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhtien) {
        this.thanhTien = thanhtien;
    }
}