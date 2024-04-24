package cuahangbanpizza.DTO;

import java.util.Scanner;

public class NhaCungCap {
    Scanner sc = new Scanner(System.in);
    private int maNCC;
    private String tenNCC, sdt, diachi;
    private static int stt = 1;
	
    public NhaCungCap() {
        
    }
        
    public NhaCungCap(int maNCC, String tenNCC, String sdt, String diachi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.diachi = diachi;
    }
        
    public NhaCungCap(NhaCungCap a) {
        maNCC = a.maNCC;
        tenNCC = a.tenNCC;
	sdt = a.sdt;
        diachi = a.diachi;
    }

    //SETTER
    public void setMancc(int maNCC) {
        this.maNCC = maNCC;
    }
    public void setTenncc(String tenncc) {
        this.tenNCC = tenncc;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    //GETTER
    public int getMancc() {
        return maNCC;
    }
     public String getTenncc() {
        return tenNCC;
     }
     public String getSdt() {
        return sdt;
    }
    public String getDiachi() {
        return diachi;
    }
}