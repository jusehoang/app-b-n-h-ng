/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import model.nhanvien;

/**
 *
 * @author hung
 */
public interface taikhoanDao {
    public nhanvien login(String tenDangNhap, String matKhau);
}
