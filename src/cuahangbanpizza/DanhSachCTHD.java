/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DanhSachCTHD {
    Scanner sc = new Scanner(System.in);
    private ChiTietHoaDon [] ct;
    private int sizeCT;
    
    public DanhSachCTHD(){
        ct = new ChiTietHoaDon[1];
        sizeCT = 1;
    }

    public ChiTietHoaDon[] getCt() {
        return ct;
    }

    public void setCt(ChiTietHoaDon[] ct) {
        this.ct = ct;
    }

    public int getSizeCT() {
        return sizeCT;
    }

    public void setSizeCT(int sizeCT) {
        this.sizeCT = sizeCT;
    }
    
    public void nhapDanhSach(DanhSachSanPham dssp, String maHD) throws FileNotFoundException {
        do{
            System.out.print("Nhập vào số lượng chi tiết hóa đơn: ");
            sizeCT = sc.nextInt();
            sc.nextLine();
            if(sizeCT <= 0)
                System.out.println("Số lượng chi tiết hóa đơn phải lớn hơn 0.");
            else{
                ct = new ChiTietHoaDon[sizeCT];
                for(int i = 0; i < sizeCT; i++){
                    ct[i] = new ChiTietHoaDon();
                    ct[i].nhap(dssp, maHD);
                }
            }  
        }while(sizeCT <= 0);
    }
    
    public void xuat(String mahd){
        for(int i = 0; i < sizeCT; i++){
            if(ct[i].getMaHoaDon().contains(mahd))
                ct[i].xuat();
        }
    }
    
    public void them(DanhSachSanPham dssp, String maHD){
        do{
            System.out.print("Nhập vào số lượng chi tiết hóa đơn: ");
            int slctMoi = sc.nextInt();
            sc.nextLine();
            if(slctMoi <= 0)
                System.out.println("Số lượng chi tiết hóa đơn phải lớn hơn 0.");
            else{
                sizeCT += slctMoi;
                ct = new ChiTietHoaDon[sizeCT];
                for(int i = 0; i < slctMoi; i++){
                    ct[i] = new ChiTietHoaDon();
                    ct[i].nhap(dssp, maHD);
                }
            }
        }while(sizeCT <= 0);
    }
    
    public void xoaTheoMaSP(){
        //Nhập mã hóa đơn và mã sp muốn xóa
    }
    
    public void xoaTheoMaHD(DanhSachSanPham dssp, String ma){
        for (int i = 0; i < ct.length; i++) {
            if(ct[i].getMaHoaDon().equals(ma)){
                dssp.tangSL_SP(ct[i].getMaSanPham(), ct[i].getSoLuong());
                if (i == ct.length - 1) {
                    ct[i] = null;
                    sizeCT--;
                } 
                else {
                    for (int k = i; k < ct.length - 1; k++) {
                        ct[k] = ct[k + 1];
                    }
                sizeCT--;
                }
            }
//            break;
        }
    }
    
    public void docFile(String fileName){
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            sizeCT = Integer.parseInt(input.readLine());
            ct = new ChiTietHoaDon[sizeCT];
            for(int i=0; i < sizeCT; i++) 
            {
                String line = input.readLine();
                String ar[] = line.split(";");
                String maHoaDon = ar[0];
                String maSanPham = ar[1]; 
                int soLuong = Integer.parseInt(ar[2]);
                double donGia = Double.parseDouble(ar[3]);
                double thanhTien = Double.parseDouble(ar[4]);
                ct[i] = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia, thanhTien);
                }            
            input.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void ghiFile(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
//            BufferedWriter bw = new BufferedWriter(fw);
            String s;
            s=sizeCT+"\n";
            fw.write(s);
            for(ChiTietHoaDon c : ct){
                s = c.getMaHoaDon() + ";" + c.getMaSanPham() + ";" + c.getSoLuong() + ";" + c.getDonGia() + ";" + c.getThanhTien() + "\n";
                    fw.write(s);
            }
            fw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
