
package model;


import java.io.Serializable;
import java.util.Date;
public class hoadon implements Serializable{
    private int id_hoadon;
    private int dongia;
    private Date date;
    private nhanvien nhanVien;
    private int maNhanVien;

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public nhanvien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(nhanvien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    public hoadon(int id_hoadon, int dongia, Date date) {
        this.id_hoadon = id_hoadon;
        this.dongia = dongia;
        this.date = date;
    }

    public hoadon() {
        
    }

    
    public Object[] toObjects(){
        return new Object[]{id_hoadon,dongia,date};
    }
    
    public String toString(){
        return id_hoadon+" "+dongia+" "+date;
    }
}
