/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.hoadon;
import model.list_order;
import service.hoadonService;
import service.hoadonServiceImpl;
import service.listService;
import service.listServiceImpl;

/**
 *
 * @author hung
 */
public class quanLyHoaDon {
    private JCalendar jcl;
    private JButton jbtDay;
    private JButton jbtAll;
    private JTable jtb;
    private hoadonService hds = new hoadonServiceImpl();
    private listService ls = new listServiceImpl();

    public quanLyHoaDon() {
    }
    
    
    
    public void All(JTable jtb){
        List<hoadon> hd = hds.getList();
        List<list_order> listOrder = ls.getList();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)jtb.getModel();
        model.getDataVector().removeAllElements();
        for(hoadon hd1 : hd){
            if(hd1.getDongia()!=0){
                model.addRow(hd1.toObjects());
            }
        }
    }
    public void setEventTimKiem(JTable jtb , JButton jbtDay , JCalendar jCalendar){
        jbtDay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                DefaultTableModel model = new DefaultTableModel();
                model = (DefaultTableModel)jtb.getModel();
                model.getDataVector().removeAllElements();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formatDate = sdf.format(jCalendar.getDate());
                System.out.println(formatDate);
                List<hoadon> hd = hds.getList();
                for(hoadon hd1 : hd){
                    if(sdf.format(hd1.getDate()).equals(formatDate) && hd1.getDongia()!=0){
                        System.out.println(1);
                        model.addRow(hd1.toObjects());
                    }
                    else{
                        
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
    public void setEventXemChiTietHoaDon(JTable jtb){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)jtb.getModel();
        jtb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                DefaultTableModel model = new DefaultTableModel();
                model = (DefaultTableModel)jtb.getModel();
                int index = jtb.getSelectedRow();
                
                ArrayList<Integer> list = FileType.ReadFile("data.txt");
                int i = (Integer)model.getValueAt(index, 0);
                list.add(i);
                FileType.WriteFile(list, "data.txt");
                new Views.ChiTietHoaDon().show();
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
