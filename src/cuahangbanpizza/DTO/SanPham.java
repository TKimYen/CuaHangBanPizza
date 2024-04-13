package cuahangbanpizza.DTO;
import java.util.Scanner;

public class SanPham {
     public transient Scanner sc = new Scanner(System.in);
     private String masp, tensp, loaisp;
     private int sl;
     private double gia;
     private static int stt = 1;
     public SanPham(){
         masp="";
         tensp="";
         loaisp="";
         sl =0;
         gia =0;
     }
    public SanPham(String masp, String tensp, String loaisp, int sl, double gia) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.sl = sl;
        this.gia = gia;
    }
    public SanPham(SanPham a){
        masp = a.masp;
        tensp = a.tensp;
        loaisp = a.loaisp;
        sl = a.sl;
        gia = a.gia;
    } 
    //SETTER
    public void setMasp(String masp) {
        this.masp = masp;
    }
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }
    public void setSl(int sl) {
        this.sl = sl;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    //GETTER
    public String getMasp() {
        return masp;
    }
    public String getTensp() {
        return tensp;
    }
    public String getLoaisp() {
        return loaisp;
    }
    public int getSl() {
        return sl;
    }
    public double getGia() {
        return gia;
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
            masp = String.format("SP%03d", (stt++));        
        }
}
