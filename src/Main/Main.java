/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import cuahangbanpizza.DAO.MyConnect;
import cuahangbanpizza.GUI.Sign_in;
//import cuahangbanpizza.GUI.DangNhapGUI;

public class Main {

    public Main(){
//       new MyConnect();

//        changLNF("Nimbus");
        new Sign_in();
        
    }
    public static void main(String[] args) {
        new Main();
    }

    public void changLNF(String nameLNF) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (nameLNF.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }
}
