/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import model.list_order;

/**
 *
 * @author hung
 */
public interface listDao {
    public List<list_order> getList();
    public int createOrUpdate(list_order list_Order);
}
