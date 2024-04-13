/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.GUI;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class MainQuanLyGUI extends JFrame {
    
    public MainQuanLyGUI(){
        this.setTitle("Phần mền quản lý cửa hàng bán pizza");
        this.setSize(1280, 900);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/pizza-iconapp.png");
        this.setIconImage(icon);
        
    }
    
    public void addControls(){
        
    }
    
    public void addEvents(){
        
    }

    public void showWindow(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
