/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.nhanvienDao;
import Dao.nhanvienDaoImpl;
import java.util.List;
import model.nhanvien;

/**
 *
 * @author hung
 */
public class nhanvienServiceImpl implements nhanvienService{
    private nhanvienDao nvDao= null;
    public nhanvienServiceImpl(){
        nvDao = new nhanvienDaoImpl();
    }
    @Override
    public List<nhanvien> getList() {
        return nvDao.getList();
    }

    @Override
    public int createOrUpdate(nhanvien nv) {
        return nvDao.createOrUpdate(nv);
    }
    
}
