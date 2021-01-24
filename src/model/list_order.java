/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import service.monanService;
import service.monanServiceImpl;

/**
 *
 * @author hung
 */
public class list_order {
    private int id_list_order;
    private monan mon;
    private hoadon hoadon;
    private int soLuong;
    private int donGia;
    private int maMonAn;
    private int maHoaDon;
    private String tenMon;
    private String tenMon1;
    public int getId_list_order() {
        return id_list_order;
    }

    public void setId_list_order(int id_list_order) {
        this.id_list_order = id_list_order;
    }

    public monan getMon() {
        return mon;
    }

    public void setMon(monan mon) {
        this.mon = mon;
    }

    public hoadon getHoadon() {
        return hoadon;
    }

    public void setHoadon(hoadon hoadon) {
        this.hoadon = hoadon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = mon.getTenMonAn();
    }
    
    public Object[] toObjects(){
        return new Object[]{mon.getId_monan(),mon.getTenMonAn(),soLuong,mon.getDonGia()*soLuong ,id_list_order};
    } 
    
    
}
