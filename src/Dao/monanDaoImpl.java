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
import model.monan;

/**
 *
 * @author hung
 */
public class monanDaoImpl implements monanDao{

    @Override
    public List<monan> getList() {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `monan`";
            List<monan> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                monan mon = new monan();
                mon.setId_monan(list.size()+1);
                mon.setDonGia(rs.getInt("dongia"));
                mon.setTenMonAn(rs.getString("tenmonan"));
                mon.setDanhmuc(rs.getString("danhmuc"));
                list.add(mon);
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
    public int createOrUpdate(monan mon) {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO monan(idmonan, dongia, tenmonan , danhmuc) VALUES(?, ?, ? , ?) ON DUPLICATE KEY UPDATE idmonan = VALUES(idmonan), dongia = VALUES(dongia),tenmonan = VALUES(tenmonan) ,danhmuc =VALUES(danhmuc)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mon.getId_monan());
            ps.setInt(2, mon.getDonGia());
            ps.setString(3, mon.getTenMonAn());
            ps.setString(4, mon.getDanhmuc());
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
