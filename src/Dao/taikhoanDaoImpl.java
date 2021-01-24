/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.nhanvien;

/**
 *
 * @author hung
 */
public class taikhoanDaoImpl implements taikhoanDao{

    @Override
    public nhanvien login(String tenDangNhap, String matKhau) {
        Connection cons = null;
        try {
            cons = DbConnect.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(taikhoanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM nhanvien WHERE taikhoan LIKE ? AND matkhau LIKE ?";
        nhanvien nv = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nv = new nhanvien();
                nv.setId_nhanvien(rs.getInt("idnhanvien"));
                nv.setTenNhanVien(rs.getString("tennhanvien"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setSoDienThoai(rs.getString("sodienthoai"));
                nv.setTaiKhoan(rs.getString("taikhoan"));
                nv.setMatKhau(rs.getString("matkhau"));
                nv.setTrangThai(rs.getString("online"));
            }
            ps.close();
            cons.close();
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
