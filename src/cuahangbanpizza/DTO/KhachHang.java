/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangbanpizza.DTO;

/**
 *
 * @author HP
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class KhachHang{
    Scanner sc = new Scanner(System.in);
    private int maKH;
    private String ho, ten;
    private String gioitinh;
    private String sdt, diachi;
//    private static int stt = 1;
    
    public KhachHang() {
        
    }
        
    public KhachHang(int maKH,String ho, String ten, String gioitinh, String sdt, String diachi) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
    }
    public KhachHang(KhachHang a) {
	maKH = a.maKH;
        ho = a.ho;
        ten = a.ten;
        gioitinh = a.gioitinh;
        sdt = a.sdt;
	diachi = a.diachi;
    }

	
    //SETTER
    public void setMakh(int maKH) {
	this.maKH = maKH;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setDiachi(String diachi) {
	this.diachi = diachi;
    }
	
    //GETTER
    public int getMakh() {
        return maKH;
    }
    public String getHo() {
        return ho;
    }
    public String getTen() {
        return ten;
    }
    public String getGioitinh() {
        return gioitinh;
    }
    public String getSdt() {
	return sdt;
    }
    public String getDiachi() {
	return diachi;
    }
}
