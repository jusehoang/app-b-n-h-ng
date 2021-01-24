/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Views.SuaThongTinNhanVien;
import Views.suathongtinmonan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.list_order;
import model.monan;
import model.nhanvien;
import service.monanService;
import service.monanServiceImpl;
import service.nhanvienService;
import service.nhanvienServiceImpl;

/**
 *
 * @author hung
 */
public class themmonController {
    private JTextField jtxTenMon;
    private JTextField jtxGia;
    private JButton jbtAdd;
    private JLabel jLabel;
    private JComboBox jcb;
    
    public themmonController() {
    }
    public ArrayList<String> taoMang(){
        monanService mas = new monanServiceImpl();
        ArrayList<String> list = new ArrayList<>();
        for(monan ma : mas.getList()){
            list.add(ma.getDanhmuc());
        }
        
        for(int i = 0 ; i < list.size()-1 ; i++){
            for(int j = i+1 ; j < list.size() ; j++ ){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }

        return list;
    }
    public void setViewTable(JTable jtb){
        monanService mas = new monanServiceImpl();
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        for(monan mon : mas.getList()){
            model.addRow(mon.toObjects());
        }
    }
    public void setTimKiem(JTable jtb , JButton jbt , JTextField jtx){
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        jbt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                    try {
                       monanService mas = new monanServiceImpl();
                       model.getDataVector().removeAllElements();
                       String t = jtx.getText();
                       for(monan mon : mas.getList()){
                           if(mon.getTenMonAn().equals(t)){
                               model.addRow(mon.toObjects());
                           }
                       }
                        
                    } catch (Exception ei) {
                        System.out.println(ei);
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
    public void setView(JComboBox jcb){
        jcb.removeAllItems();
        monanService mas = new monanServiceImpl();
        for(String t : taoMang()){
            jcb.addItem(t);
        }
        
    }
    public void themMon(JTextField jtxTenMon,JTextField jtxGia,JButton jbtAdd , JLabel jLabel,JComboBox jcb){
        jbtAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                    try {
                        monanService mas = new monanServiceImpl();
                        monan ma = new monan();
                        ma.setId_monan(mas.getList().size()+1);
                        ma.setTenMonAn(jtxTenMon.getText());
                        ma.setDonGia(Integer.valueOf(jtxGia.getText()));
                        ma.setDanhmuc(String.valueOf(jcb.getItemAt(jcb.getSelectedIndex())));
                        mas.createOrUpdate(ma);
                        jLabel.setText("Thêm Mới Món Ăn Thành Công !!!");
                        
                    } catch (Exception ei) {
                        System.out.println(ei);
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
    public void setHienThi(JTable jtb){
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
                    new suathongtinmonan().show();
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
    public void setHienThi1(JTextField jtx1 , JTextField jtx2 ,JTextField jtx3){
        ArrayList<Integer> list = FileType.ReadFile("data.txt");
        int i = list.get(list.size()-1);
        monanService mas = new monanServiceImpl();
                
        monan ma = null ;
        for(monan Ma1 : mas.getList()){
            if(Ma1.getId_monan()==i){
                ma = Ma1;
            }
        }
        jtx1.setText(ma.getTenMonAn());
        jtx2.setText(ma.getDanhmuc());
        jtx3.setText(String.valueOf(ma.getDonGia()));
    }
    public void setEventSuaThongtin(JTextField jtx1,JTextField jtx2,JTextField jtx3 , JButton sua){
        sua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                try {
                    ArrayList<Integer> list = FileType.ReadFile("data.txt");
                    int i = list.get(list.size()-1);
                    monanService mas = new monanServiceImpl();
                    monan ma = null ;
                    for(monan Ma1 : mas.getList()){
                        if(Ma1.getId_monan()==i){
                            ma = Ma1;
                        }
                    }
                    ma.setTenMonAn(jtx1.getText());
                    ma.setDanhmuc(jtx2.getText());
                    ma.setDonGia(Integer.valueOf(jtx3.getText()));
                    mas.createOrUpdate(ma);
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
