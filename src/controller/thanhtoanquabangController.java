/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DbConnect;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.hoadon;
import model.list_order;
import model.monan;
import model.nhanvien;
import service.hoadonService;
import service.hoadonServiceImpl;
import service.listService;
import service.listServiceImpl;
import service.monanService;
import service.monanServiceImpl;

/**
 *
 * @author hung
 */
public class thanhtoanquabangController {
    private JTable jtb;
    private JComboBox jcb;
    private JComboBox jcb1;
    private JButton jbtAdd;
    private JTextField jtx;
    ArrayList<list_order> list = new ArrayList<>();
    hoadon hd = new hoadon();
    int tong = 0;
    public thanhtoanquabangController(JTable jtb, JComboBox jcb, JComboBox jcb1, JButton jbtAdd, JTextField jtx ) {
        this.jtb = jtb;
        this.jcb = jcb;
        this.jcb1 = jcb1;
        this.jbtAdd = jbtAdd;
        this.jtx = jtx;
        
    }
    
    public void setView(){
        monanService ma = new monanServiceImpl();
        hoadonService hds = new hoadonServiceImpl();
        hd.setId_hoadon(hds.getList().size());
        System.out.println("ma hoa don moi la :" + hd.getId_hoadon());
        System.out.println(hd.getId_hoadon());
        jcb.removeAllItems();
        jcb1.removeAllItems();
        for(monan a : ma.getList()){
            jcb.addItem(a.getTenMonAn()); 
        }
    }
    public void setEvent(){
        hoadonService hds = new hoadonServiceImpl();
        monanService ma = new monanServiceImpl();
        listService ls = new listServiceImpl();
        System.out.println(hd.getId_hoadon());
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        jbtAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                list_order li = new list_order();
                int i = jcb.getSelectedIndex();
                String tenMon = (String)jcb.getItemAt(i);
                monan a = null;
                for(monan m : ma.getList()){
                    if(m.getTenMonAn().equals(tenMon)){
                        a = m;
                    }
                }
                try {
                    int so = ls.getList().size()+1;
                    boolean kiemtra = false;
                    li.setId_list_order(so);
                    for(list_order so1 : ls.getList()){
                        if(so1.getId_list_order()== li.getId_list_order()){
                            li.setId_list_order(i+1);
                            System.out.println("Da doi" + li.getId_list_order());
                            break;
                        }
                    }
                    li.setSoLuong(Integer.valueOf(jtx.getText()));
                    li.setHoadon(hd);
                    li.setMon(a);
                    li.setDonGia(li.getSoLuong()*a.getDonGia());
                    li.setMaMonAn(a.getId_monan());
                    li.setMaHoaDon(hd.getId_hoadon());
                    tong += li.getDonGia();
                    System.out.println(tong);
                    list.add(li);
                    ls.createOrUpdate(li);
                    model.addRow(li.toObjects());
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
    
    public void setThanhToan(JButton jbtThanhToan){
            hoadonService hds = new hoadonServiceImpl();
            jbtThanhToan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                hd.setDate(new java.util.Date());
                hd.setDongia(tong);
                nhanvien nv = (nhanvien) FileType.ReadFile("nhanviendangnhap.txt").get(0);
                hd.setMaNhanVien(nv.getId_nhanvien());
                System.out.println(hd.toString());
                
                hds.createOrUpdate(hd);
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
    public void Xoa(JTable jtb,JButton jbtDelete){
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        jbtDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                
                try {
                    int row = jtb.getSelectedRow();
                    String t = jtb.getValueAt(row, 4).toString();
                    Connection cons = DbConnect.getConnection();
                    String sql = "DELETE FROM list_order where idlist_order = " + t;
                    PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
                    ps.execute();
                    model.removeRow(row);

                } catch (SQLException ex) {

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


