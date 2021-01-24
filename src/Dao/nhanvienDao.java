/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import model.nhanvien;

/**
 *
 * @author hung
 */
public interface nhanvienDao {
    public List<nhanvien> getList();
    public int createOrUpdate(nhanvien nv);
}
