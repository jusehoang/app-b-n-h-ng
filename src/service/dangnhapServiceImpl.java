/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.taikhoanDao;
import Dao.taikhoanDaoImpl;
import model.nhanvien;

/**
 *
 * @author hung
 */
public class dangnhapServiceImpl implements dangnhapService{
    private taikhoanDao tkd = null;

    public dangnhapServiceImpl() {
        tkd = new taikhoanDaoImpl();
    }
    
    @Override
    public nhanvien login(String tenDangNhap, String matKhau) {
        return tkd.login(tenDangNhap, matKhau);
    }
    
}
