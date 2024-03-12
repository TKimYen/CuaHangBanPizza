package cuahangbanpizza.DTO;

import cuahangbanpizza.DTO.SanPham;
import cuahangbanpizza.DanhSachSanPham;

public class Pizza extends SanPham {
        DanhSachSanPham dssp = new DanhSachSanPham();
	private String de;
        private String size;
	//CONSTRUCTOR
	public Pizza() {}
        public Pizza(String masp, String tensp, String loaisp, int sl, double gia, String de, String size) {
           super(masp, tensp, loaisp, sl, gia);
           this.de = de;
           this.size = size;
        }
        public Pizza(Pizza a) {
           super((SanPham) a);
           de = a.de;
           size = a.size;
        }
    //SETTER
        public void setDe(String de) {
            this.de = de;
        }

    public void setSize(String size) {
        this.size = size;
    }
        
    //GETTER
        public String getDe() {
             return de;
        }

    public String getSize() {
        return size;
    }
        
    @Override
    public void nhap() {
        super.nhap();
        super.setLoaisp("Pizza");
        System.out.print("Loại đế: ");
        de = sc.nextLine();     
        System.out.print("Cỡ: ");
        size = sc.nextLine();
    }
    
    @Override
    public void xuat() {
	System.out.format("|| %8s | %12s | %23s | %20s | %8s | %12s | %12s | %15s ||\n", super.getMasp(), super.getTensp(), super.getLoaisp(), super.getSl(), super.getGia(),null, de,size);
    }
	
}

