package Main;

import QuanLyPizza.DAO.MyConnect;
import QuanLyPizza.GUI.DangNhapGUI;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        new MyConnect();

        changLNF("Nimbus");
        DangNhapGUI login = new DangNhapGUI();
        login.showWindow();
    }
}
