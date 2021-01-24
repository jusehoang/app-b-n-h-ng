/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author hung
 */
import java.util.List;
import model.hoadon;
public interface hoadonDao {
    public List<hoadon> getList();
    public int createOrUpdate(hoadon hoadon1);
}
