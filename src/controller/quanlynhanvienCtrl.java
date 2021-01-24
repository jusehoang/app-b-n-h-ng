/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Views.SuaThongTinNhanVien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.list_order;
import model.monan;
import model.nhanvien;
import service.nhanvienService;
import service.nhanvienServiceImpl;

/**
 *
 * @author hung
 */
public class quanlynhanvienCtrl {

    public quanlynhanvienCtrl() {
    }
    public void hienthiBangNhanVien(JTable jtb){
        nhanvienService nvS = new nhanvienServiceImpl();
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        for(nhanvien nv : nvS.getList()){
            model.addRow(nv.toObjects());
        }
    }
    public void hienthiBangNhanVienTimKiem(JTable jtb , JTextField jtx , JButton add){
        nhanvienService nvS = new nhanvienServiceImpl();
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        add.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                try {
                    String s = jtx.getText();
                    model.getDataVector().removeAllElements();
                    for(nhanvien nv : nvS.getList()){
                        if(nv.getTenNhanVien().equals(s)){
                            model.addRow(nv.toObjects());
                        }
                    }
                } catch (Exception t) {
                    System.out.println(t);
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    public void themMoiNhanVien(JButton add ,JTextField jtx1,JTextField jtx2,JTextField jtx3,JTextField jtx4,JPasswordField jpf1,JPasswordField jpf2){
        nhanvienService nvs = new nhanvienServiceImpl();
        add.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                
                try {
                    String f ="";
                    for(nhanvien nv1 : nvs.getList()){
                        if(nv1.getTaiKhoan().equals(jtx4.getText())){
                            f+=nv1.getTaiKhoan();
                        }
                    }
                    nhanvien nv = new nhanvien();
                    if(!"".equals(f)){
                        JOptionPane.showMessageDialog(null,"Đã trùng tài khoản ");
                    }
                    else if(jtx1.getText().equals("")||jtx2.getText().equals("")|| jtx3.getText().equals("") || jtx4.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Đã có trường nhập thiếu ");
                    }
                    else{
                        nv.setId_nhanvien(nvs.getList().size()+1);
                        nv.setTenNhanVien(jtx1.getText());
                        nv.setDiaChi(jtx2.getText());
                        nv.setSoDienThoai(jtx3.getText());
                        nv.setTaiKhoan(jtx4.getText());
                        nv.setMatKhau(jpf1.getText());
                        nv.setTrangThai("no");
                        nvs.createOrUpdate(nv);
                    }
                } catch (Exception t) {
                    System.out.println(t);
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    public void SuaThongTinNhanVien(JTable jtb){
        jtb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                try {
                    DefaultTableModel model = (DefaultTableModel)jtb.getModel();
                    model = (DefaultTableModel)jtb.getModel();
                    int index = jtb.getSelectedRow();
                    
                    ArrayList<Integer> list = FileType.ReadFile("data.txt");
                    int i = (Integer)model.getValueAt(index, 0);
                    list.add(i);
                    FileType.WriteFile(list, "data.txt");
                    new SuaThongTinNhanVien().show();
                } catch (Exception t) {
                    System.out.println(t);
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    public void setView1(JTextField jtx1,JTextField jtx2,JTextField jtx3,JTextField jtx4,JTextField jtx5){
        ArrayList<Integer> list = FileType.ReadFile("data.txt");
        int i = list.get(list.size()-1);
        nhanvienService nvs = new nhanvienServiceImpl();
        nhanvien nv = null ;
        for(nhanvien nv1 : nvs.getList()){
            if(nv1.getId_nhanvien()==i){
                nv= nv1;
            }
        }
        jtx1.setText(nv.getTenNhanVien());
        jtx2.setText(nv.getDiaChi());
        jtx3.setText(nv.getSoDienThoai());
        jtx4.setText(nv.getTaiKhoan());
        jtx5.setText(nv.getMatKhau());
        
    }
    public void setEventSuaThongtin(JTextField jtx1,JTextField jtx2,JTextField jtx3,JTextField jtx4,JTextField jtx5 , JButton sua){
        sua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                try {
                    ArrayList<Integer> list = FileType.ReadFile("data.txt");
                    int i = list.get(list.size()-1);
                    nhanvienService nvs = new nhanvienServiceImpl();
                    nhanvien nv = null ;
                    for(nhanvien nv1 : nvs.getList()){
                        if(nv1.getId_nhanvien()==i){
                            nv= nv1;
                        }
                    }
                    nv.setTenNhanVien(jtx1.getText());
                    nv.setDiaChi(jtx2.getText());
                    nv.setSoDienThoai(jtx3.getText());
                    nv.setTaiKhoan(jtx4.getText());
                    nv.setMatKhau(jtx5.getText());
                    nvs.createOrUpdate(nv);
                    JOptionPane.showMessageDialog(null, "Sửa Thành Công");
                } catch (Exception t) {
                    System.out.println(t);
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
}
