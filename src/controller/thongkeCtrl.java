/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.hoadon;
import model.nhanvien;
import service.hoadonService;
import service.hoadonServiceImpl;
import service.nhanvienService;
import service.nhanvienServiceImpl;

/**
 *
 * @author hung
 */
public class thongkeCtrl {

    public thongkeCtrl() {
    }
    public void setView(JComboBox jcb1){
        nhanvienService nvs= new nhanvienServiceImpl();
        jcb1.removeAllItems();
        for(nhanvien nv : nvs.getList()){
            jcb1.addItem(nv.getTenNhanVien());
        }
    }
    public void XemtienBanCuaNhanVienTheoNgay(JComboBox jcb1 ,JDateChooser jdc ,JButton jbt ,JLabel jlb){
        jbt.addMouseListener(new MouseAdapter() {
            hoadonService hds = new hoadonServiceImpl();
            nhanvienService nvs = new nhanvienServiceImpl();
            public void mouseClicked(MouseEvent e){
                Date date = jdc.getDate();
                String ten = jcb1.getItemAt(jcb1.getSelectedIndex()).toString();
                int tong = 0;
                int manv = 0;
                for(nhanvien nv :nvs.getList()){
                    if(nv.getTenNhanVien().equals(ten)){
                        manv = nv.getId_nhanvien();
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                for(hoadon hd : hds.getList()){
                    if(hd.getMaNhanVien() == manv && sdf.format(date).equals(sdf.format(hd.getDate()))){
                        tong += hd.getDongia();
                    }
                }
                jlb.setText(String.valueOf(tong));
                
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
    public void doanhthutheoNgay(JButton jbt ,JLabel jlb , JCalendar jcd ){
        jbt.addMouseListener(new MouseAdapter() {
            hoadonService hds = new hoadonServiceImpl();
            public void mouseClicked(MouseEvent e){
                Date date = new JCalendar().getDate();
                
                int tong = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for(hoadon hd : hds.getList()){
                    
                    if(sdf.format(date).equals(sdf.format(hd.getDate()))){
                        tong += hd.getDongia();
                    }
                }
                
                jlb.setText(String.valueOf(tong));
                
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
