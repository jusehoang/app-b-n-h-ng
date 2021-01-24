/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Views.NewJFrame;
import Views.NewJFrame1;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.nhanvien;
import service.dangnhapService;
import service.dangnhapServiceImpl;

/**
 *
 * @author hung
 */
public class dangnhapCtrl {
    private Dialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMsg;
    
    dangnhapService dns =null;

    public dangnhapCtrl(Dialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;
        
        dns = new dangnhapServiceImpl();
    }
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String t ="";
                    ArrayList<nhanvien> nv = new ArrayList<>();
                    nhanvien nvm = new  nhanvien();
                    nhanvien taiKhoan = null;
                    FileType.WriteFile(null, "nhanviendangnhap.txt");
                    if (jtfTenDangNhap.getText().length() == 0
                            || jtfMatKhau.getText().length() == 0) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        taiKhoan = dns.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
                        if (taiKhoan == null) {
                            jlbMsg.setText("Tên đăng nhập và mật khẩu không đúng!");
                        }else if(taiKhoan.getTrangThai().equals("no")){
                            dialog.dispose();
                            t="no";                          
                        }
                        else {
                                dialog.dispose();
                                t="admin";
                                
                        }
                    }
                    
                    if(t.equals("no") && taiKhoan != null){
                        try {
                            nv.add(taiKhoan);
                            FileType.WriteFile(nv, "nhanviendangnhap.txt");
                        } catch (Exception exp) {
                            System.out.println(exp);
                        }
                        
                        new NewJFrame1().show();
                    }
                    else if(t.equals("admin")){
                        try {
                            nv.add(taiKhoan);
                            FileType.WriteFile(nv, "nhanviendangnhap.txt");
                        } catch (Exception exp) {
                            System.out.println(exp);
                        }
                        new NewJFrame().show();
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
 
    }
}
