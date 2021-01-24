/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author hung
 */
public class FileType {
    public static <T> void WriteFile(ArrayList<T> arr , String f){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(arr);
            oos.close();
        } catch (Exception e) {
        }
    }
    public static <T> ArrayList<T> ReadFile(String f){
        ArrayList<T> arr = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            arr = (ArrayList<T>)ois.readObject();
            ois.close();
        } catch (Exception e) {
        }
        return arr;
    }
}
