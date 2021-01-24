/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import model.monan;

/**
 *
 * @author hung
 */
public interface monanDao {
    public List<monan> getList();
    public int createOrUpdate(monan mon);
}
