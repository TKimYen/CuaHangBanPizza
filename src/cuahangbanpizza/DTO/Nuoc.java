package cuahangbanpizza.DTO;

import cuahangbanpizza.DTO.SanPham;
import cuahangbanpizza.DanhSachSanPham;

public class Nuoc extends SanPham {
        DanhSachSanPham dssp = new DanhSachSanPham();
	private String thuongHieu;
	//CONSTRUCTOR
	public Nuoc() {
            thuongHieu ="";
        }
	public Nuoc(String masp, String tensp, String loaisp, int sl, double gia,String thuongHieu) {
               super(masp, tensp, loaisp, sl, gia);
               this.thuongHieu = thuongHieu;
         }
	public Nuoc(Nuoc a) {
		super((Nuoc) a);
		thuongHieu = a.thuongHieu;
	}
	//SETTER
    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }
	//GETTER
    public String getThuongHieu() {
        return thuongHieu;
    }
	//CAC HAM KHAC
    @Override
    public void nhap() {
        super.nhap();
        super.setLoaisp("Nuoc");
            
        System.out.print("Thương hiệu: ");
        thuongHieu = sc.nextLine();        
    }
	@Override
	public void xuat() {
		System.out.format("|| %8s | %12s | %23s | %20s | %8s | %12s | %12s | %15s ||\n",  super.getMasp(), super.getTensp(), super.getLoaisp(), super.getSl(), super.getGia(), thuongHieu, null, null);
	}          
}
