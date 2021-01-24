/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hung
 */
import java.io.Serializable;

/**
 *
 * @author hung
 */
public class monan implements Serializable{
    private int id_monan;
    private String tenMonAn;
    private int donGia;
    private String danhmuc;

    public int getId_monan() {
        return id_monan;
    }

    public void setId_monan(int id_monan) {
        this.id_monan = id_monan;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }
    

    public monan() {
        
    }

    public monan(int id_monan, String tenMonAn, int donGia, String danhmuc) {
        this.id_monan = id_monan;
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.danhmuc = danhmuc;
    }
    public Object[] toObjects(){
        return new Object[]{id_monan,tenMonAn,donGia,danhmuc};
    }
    
    
    
    
}
