/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import Views.NewJDialog;
import Views.NewJFrame;
import java.util.ArrayList;
import java.util.List;
import model.hoadon;
import service.hoadonService;
import service.hoadonServiceImpl;

/**
 *
 * @author hung
 */

public class Ts {

    /**
     * @param args the command line arguments
     * 
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        NewJDialog dialog =  new NewJDialog(null, true);
        dialog.setTitle("Đăng nhập hệ thống .");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
