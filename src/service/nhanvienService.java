/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.monan;
import model.nhanvien;

/**
 *
 * @author hung
 */
public interface nhanvienService {
    public List<nhanvien> getList();
    public int createOrUpdate(nhanvien nv);
}
