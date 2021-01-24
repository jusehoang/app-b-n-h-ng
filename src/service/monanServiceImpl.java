/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.monanDao;
import Dao.monanDaoImpl;
import java.util.List;
import model.monan;

/**
 *
 * @author hung
 */
public class monanServiceImpl implements monanService{
    private monanDao monandao = null;
    public monanServiceImpl(){
        monandao = new monanDaoImpl();
    }
    @Override
    public List<monan> getList() {
       return monandao.getList();
    }

    @Override
    public int createOrUpdate(monan mon) {
       return monandao.createOrUpdate(mon);
    }
    
}
