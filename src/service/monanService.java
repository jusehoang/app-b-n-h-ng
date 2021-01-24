/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.monan;

/**
 *
 * @author hung
 */
public interface monanService {
    public List<monan> getList();
    public int createOrUpdate(monan mon);
}
