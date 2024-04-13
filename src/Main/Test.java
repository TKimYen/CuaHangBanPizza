/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

//import cuahangbanpizza.DAO.MyConnect;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author DELL
 */
public class Test extends JFrame{
    public Test(){
        this.setTitle("Test");
        this.setSize(200,200);
        this.setLocation(200,200);
        JLabel lblBanHang = new JLabel(new ImageIcon("image/outline_check_circle_outline_white_24dp.png"));
        this.add(lblBanHang);
    }
    public static void main(String[] args) {
//        new MyConnect();
        Test f = new Test();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
