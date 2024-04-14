package cuahangbanpizza.DTO;

public class SanPham {
     private String maSP, tenSP, maLoaiSP, hinhAnh;
     private int soLuong;
     private double gia;
     private static int stt = 1;
     public SanPham(){
         maSP="";
         tenSP="";
         maLoaiSP="";
         hinhAnh= "";
         soLuong =0;
         gia =0;
     }
    public SanPham(String masp, String tensp, String loaisp, String hinhanh, int sl, double gia) {
        this.maSP = masp;
        this.tenSP = tensp;
        this.maLoaiSP = loaisp;
        this.hinhAnh = hinhanh;
        this.soLuong = sl;
        this.gia = gia;
    }
    public SanPham(SanPham a){
        maSP = a.maSP;
        tenSP = a.tenSP;
        maLoaiSP = a.maLoaiSP;
        hinhAnh = a.hinhAnh;
        soLuong = a.soLuong;
        gia = a.gia;
    } 
    //SETTER

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String MaSP) {
        this.maSP = MaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String TenSP) {
        this.tenSP = TenSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.soLuong = SoLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public static int getStt() {
        return stt;
    }

    public static void setStt(int stt) {
        SanPham.stt = stt;
    }
    
    //KHỞI TẠO MÃ TỰ ĐỘNG
        public int change(String maHoaDon){
            String id = maHoaDon.substring(2, 5);
            return Integer.parseInt(id);
        }
    
        public static void init(int id){
            stt = id+1;
        }
        public void taoMaTuDong(){
            maSP = String.format("SP%03d", (stt++));        
            System.out.println("Mã sản phẩm là: " + maSP);
        }
}
