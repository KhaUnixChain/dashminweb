package com.fpt.assignment.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileUtils {
    public static byte[] read(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            int n = fis.available();  // lay do dai cua fis (dung luong file)
            byte[] data = new byte[n];
            fis.read(data);
            fis.close();
            return data;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void writer(String path, byte [] data){
        try {
            // nếu muốn ghi thêm thông tin thay gì bị ghi đè --> path, true 
            FileOutputStream fos = new FileOutputStream(path, true);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
