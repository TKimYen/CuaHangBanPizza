/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

//import cuahangbanpizza.DAO.MyConnect;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class Test extends JFrame{
    public Test(){
        this.setTitle("Test");
        this.setSize(200,200);
        this.setLocation(200,200);
        ImageIcon icon = new ImageIcon("./image/ManagerUI/pizza-iconapp.png");
        this.setIconImage(icon.getImage());
    }
    public static void main(String[] args) {
//        new MyConnect();
        Test f = new Test();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
