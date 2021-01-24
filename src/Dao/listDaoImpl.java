/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.list_order;

/**
 *
 * @author hung
 */
public class listDaoImpl implements listDao{

    @Override
    public List<list_order> getList() {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `list_order`";
            List<list_order> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list_order li = new list_order();
                li.setId_list_order(list.size());
                li.setDonGia(rs.getInt("dongia"));
                li.setSoLuong(rs.getInt("soluong"));
                li.setMaMonAn(rs.getInt("monan_idmonan"));
                li.setMaHoaDon(rs.getInt("hoadon_idhoadon"));
                list.add(li);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public int createOrUpdate(list_order list_Order) {
       try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO list_order(idlist_order,soluong,dongia,monan_idmonan,hoadon_idhoadon) VALUES(?, ?, ?, ? , ?) ON DUPLICATE KEY UPDATE idlist_order = VALUES(idlist_order), soluong = VALUES(soluong),dongia = VALUES(dongia),monan_idmonan = VALUES(monan_idmonan),hoadon_idhoadon = VALUES(hoadon_idhoadon)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, list_Order.getId_list_order());
            ps.setInt(2, list_Order.getSoLuong());
            ps.setInt(3, list_Order.getDonGia());
            ps.setInt(4, list_Order.getMaMonAn());
            ps.setInt(5, list_Order.getMaHoaDon());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
}
