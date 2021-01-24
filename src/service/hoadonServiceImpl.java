/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.hoadonDao;
import Dao.hoadonDaoImpl;
import java.util.List;
import model.hoadon;

/**
 *
 * @author hung
 */
public class hoadonServiceImpl implements hoadonService{
    
    private hoadonDao HoaDonDao = null;
    public hoadonServiceImpl(){
        HoaDonDao = new hoadonDaoImpl();
    }
    @Override
    public List<hoadon> getList() {
        return HoaDonDao.getList();
    }

    @Override
    public int createOrUpdate(hoadon hoa) {
        return HoaDonDao.createOrUpdate(hoa);
    }
    
}
