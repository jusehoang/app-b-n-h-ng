/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.hoadon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hung
 */
public class hoadonDaoImpl implements hoadonDao{

    @Override
    public List<hoadon> getList() {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `hoadon`";
            List<hoadon> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hoa = new hoadon();
                hoa.setId_hoadon(list.size());
                hoa.setDongia(rs.getInt("tongdon"));
                hoa.setDate(rs.getDate("date"));
                hoa.setMaNhanVien(rs.getInt("nhanvien_idnhanvien"));
                list.add(hoa);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int createOrUpdate(hoadon hoadon1) {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO hoadon(idhoadon, tongdon, date ,nhanvien_idnhanvien) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE idhoadon = VALUES(idhoadon), tongdon = VALUES(tongdon),date = VALUES(date) ,nhanvien_idnhanvien=VALUES(nhanvien_idnhanvien)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hoadon1.getId_hoadon());
            ps.setInt(2, hoadon1.getDongia());
            ps.setDate(3, new Date(hoadon1.getDate().getTime()));
            ps.setInt(4, hoadon1.getMaNhanVien());
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
        }
        return 0;
    }
    
}
