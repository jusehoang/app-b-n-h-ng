/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.hoadon;
import model.list_order;
import model.monan;
import service.hoadonService;
import service.hoadonServiceImpl;
import service.listService;
import service.listServiceImpl;

/**
 *
 * @author hung
 */
public class thanhtoanController {
    private hoadon hoaDon;
    private JButton jbtThanhToan;
    private JButton jbtAdd;
    private JTextField jtfSoLuong;
    private monan mon;
    private listService lis = new listServiceImpl();
    private hoadonService hds = new hoadonServiceImpl();
    private ArrayList<list_order> list = new ArrayList<>();
    private JTable jtb;
    public thanhtoanController(hoadon hoaDon,  JButton jbtThanhToan) {
        this.hoaDon = hoaDon;
        this.jbtThanhToan = jbtThanhToan;
    }
    
    public void setEventList_OrDer(JButton jbtAdd , JTextField jtfSoLuong , monan mon ,JTable jtb ,JButton delete){
        jbtAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(jtfSoLuong.getText().length()==0){
                    
                }
                else{
                    try {
                        list_order li = new list_order();
                        li.setId_list_order(lis.getList().size()+1);
                        li.setSoLuong(Integer.valueOf(jtfSoLuong.getText()));
                        li.setHoadon(hoaDon);
                        li.setMon(mon);
                        li.setDonGia(Integer.valueOf(jtfSoLuong.getText())*mon.getDonGia());
                        li.setMaMonAn(mon.getId_monan());
                        li.setMaHoaDon(hoaDon.getId_hoadon()); 
                        list.add(li);
                        System.out.println(li.getId_list_order());
                        DefaultTableModel model1 = (DefaultTableModel) jtb.getModel();
                        model1.addRow(li.toObjects());
                        
                    } catch (Exception ei) {
                        System.out.println(ei);
                    }
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
        delete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(jtfSoLuong.getText().length()==0){
                    
                }
                else{
                    try {
                        DefaultTableModel model1 = (DefaultTableModel) jtb.getModel();
                        int row = jtb.getSelectedRow();
                        model1.removeRow(row);
                        list.remove(row);
                        System.out.println(row);
                        
                    } catch (Exception ei) {
                        System.out.println(ei);
                    }
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
    public void setEventThanhToan(hoadon hd){
        jbtThanhToan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(list.size()!=0){
                    int tong = 0;
                    System.out.println(list);
                    for(int i = 0 ; i < list.size() ; i ++){
                        list.get(i).setId_list_order(list.get(i).getId_list_order()+i);
                        tong += (list.get(i).getDonGia());
                        lis.createOrUpdate(list.get(i));
                        
                    }
                    hd.setDongia(tong);
                    hds.createOrUpdate(hd);
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
