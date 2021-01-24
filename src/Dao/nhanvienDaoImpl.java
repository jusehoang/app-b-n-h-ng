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
import model.hoadon;
import model.nhanvien;

/**
 *
 * @author hung
 */
public class nhanvienDaoImpl implements nhanvienDao{

    @Override
    public List<nhanvien> getList() {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `nhanvien`";
            List<nhanvien> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setId_nhanvien(list.size()+1);
                nv.setTenNhanVien(rs.getString("tennhanvien"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setSoDienThoai(rs.getString("sodienthoai"));
                nv.setTaiKhoan(rs.getString("taikhoan"));
                nv.setMatKhau(rs.getString("matkhau"));
                nv.setTrangThai(rs.getString("online"));
                list.add(nv);
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
    public int createOrUpdate(nhanvien nv) {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO nhanvien(idnhanvien, tennhanvien, diachi ,sodienthoai,taikhoan ,matkhau,online) VALUES(?, ?, ?, ?, ? ,? ,?) ON DUPLICATE KEY UPDATE idnhanvien = VALUES(idnhanvien), tennhanvien = VALUES(tennhanvien),diachi = VALUES(diachi) ,sodienthoai=VALUES(sodienthoai),taikhoan=VALUES(taikhoan),matkhau=VALUES(matkhau),online=VALUES(online)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nv.getId_nhanvien());
            ps.setString(2, nv.getTenNhanVien());
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getTaiKhoan());
            ps.setString(6, nv.getMatKhau());
            ps.setString(7, nv.getTrangThai());
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
