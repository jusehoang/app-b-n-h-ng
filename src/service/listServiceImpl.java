/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.listDao;
import Dao.listDaoImpl;
import java.util.List;
import model.list_order;

/**
 *
 * @author hung
 */
public class listServiceImpl implements listService{
    private listDao listdao = null;
    public listServiceImpl(){
        listdao = new listDaoImpl();
    }
    @Override
    public List<list_order> getList() {
        return listdao.getList();
    }

    @Override
    public int createOrUpdate(list_order li) {
        return listdao.createOrUpdate(li);
    }
    
}
