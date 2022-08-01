package com.fpt.assignment.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class FakerUtils {
    String[] ho = {"Nguyễn", "Huỳnh", "Phạm", "Phan", "Trần", "Lê", "Mai", "Trương", "Trịnh", "Phùng", "Lại", "Hà", "Lương", "Lý", "Hà", "Thôi", "Triệu", "Tào", "Đoàn", "Nhâm", "Khương", "Viên", "Tăng", "Đồng", "Diệp", "Tô", "Thái", "Từ", "Đàm", "Quách", "Đào", "Đinh", "Tạ", "Ông", "Cao"};
    String[] lot = {"Thị", "", "Văn", "Minh", "Tấn", "Lộc", "Kim", "Đình", "Ngọc", "Bá", "Bích", "Thu", "Thanh", "Quang", "Tú", "Lan", "Khởi", "Trùng", "Vân", "Tiên", "Bích", "Thanh", "Thiên", "Trọng", "Mỹ"};
    String[] ten =      {"Nhi", "Khang", "Tâm", "Sương", "Thảo", "Linh", "Tài", "Khải", "Hương", "Lan", "Nam", "Bình", "Lam", "Cường", "Phú", "Tân", "Lĩnh", "Trinh", "Ngân", "Thành", "Thanh", "Trọng", "Tuấn", "Sơn", "Đức", "An", "Mỹ", "Vân", "My"};
    String[] nameMaNV = {"nhi", "khang", "tam", "suong", "thao", "linh", "tai", "khai", "huong", "lan", "nam", "binh", "lam", "cuong", "phu", "tan", "minhlinh", "trinh", "ngan", "thanh", "trong", "tuan", "son", "duc", "an", "my", "van"};
    String[] manv = {"NC", "AP", "123", "IT", "HA", "CI", "EXO", "KA", "HM", "542", "875", "GU", "QG", "HV", "XX", "TX", "789", "521", "963"};
    String[] street = {"Tôn Đức Thắng", "Phạm Như Xương", "Đống Đa", "Lý Thái Tông", "Phạm Thị Minh Khai", "Trần Quốc Toản", "Nguyễn Thị Minh Khai", "Đa Bác", "Hòa Mỹ", "Đặng Dung", "Quang Nam", "Huỳnh Thúc Kháng", "Ngã Ba Huế", "Tô Hiệu", "Tôn Đản", "Võ Nguyên Giáp", "Gia Bắc", "Hồ Chí Minh", "Số 7", "Số 5", "Số 3", "Số 10", "Hà Huy Tập", "Võ Thị Sáu"};
    String[] city = {"Đà Nẵng", "TP.HCM", "Cần Thơ", "Nha Trang", "Hà Nội", "Quãng Nam", "Quãng Ngãi", "Bình Thuận", "Quy Nhơn", "Cà Mau", "Ninh Thuận", "Nghệ An", "Huế", "Quãng Trị", "Hà Nam", "Đồng Nai"};
    int[] nam_nhanvien = {1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003};
    int[] nam_banve = {2015, 2016, 2017, 2018, 2019, 2020, 2021};
    int[] thang = {1,2,3,4,5,6,7,8,9,10,11,12};
    int[] ngay = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    int[] gioitinh = {0, 1};
    int[] vaitro = {0,1};
    int[] digit = {0,1,2,3,4,5,6,7,8,9};
    String[] headerphone = {"031", "032", "033", "035", "037", "039", "071", "072", "073", "075", "077", "090", "096", "095", "091", "099", "062", "063", "064", "067"};
    String[] detailemail = {"@yahoo.com", "@gmail.com", "@fpt.edu.vn", "@io.com", "@outlook.com", "@zoho.com", "@edu.com.vn"};
    final String user = "sa";
    final String password = "0907718993";
    final String url = "jdbc:sqlserver://localhost:1433;databaseName=WebsellManager";
    
    // -----------------------------------------------------------------------------
    static int number = 500;

    public String getPhoneRandom(String headphone) {
        for (int j = 0; j < 7; j++) {
            headphone += "" + digit[  (int) Math.floor(Math.random()*digit.length + 0)  ];
        }
        return headphone;
    }
    
    public void create_customer() {
        for (int i = 0; i < number; i++) {

            /** random for full name  */
            int randomHo = (int) Math.floor(Math.random()*ho.length + 0);
            int randomLot = (int) Math.floor(Math.random()*lot.length + 0);
            int randomTen = (int) Math.floor(Math.random()*ten.length + 0);


            /** random for email */
            int randomNameMaNV = (int) Math.floor(Math.random()*nameMaNV.length + 0);
            int randomheaderphone = (int) Math.floor(Math.random() * headerphone.length + 0);
            int randomMaNV = (int) Math.floor(Math.random() * manv.length + 0);
            int randomDetailMail = (int) Math.floor(Math.random() * detailemail.length + 0);


            String hoten = ho[randomHo] + " " + lot[randomLot] + " " + ten[randomTen];
            String phone = getPhoneRandom(headerphone[randomheaderphone]);
            String email = nameMaNV[randomNameMaNV] + manv[randomMaNV] + headerphone[randomheaderphone] + detailemail[randomDetailMail];

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES (?,?,?)");
                ps.setString(1, email);
                ps.setString(2, hoten);
                ps.setString(3, phone);
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }

    public void create_employee() {
        for (int i = 0; i < 10; i++) {
            /** random for full name  */
            int randomHo = (int) Math.floor(Math.random()*ho.length + 0);
            int randomLot = (int) Math.floor(Math.random()*lot.length + 0);
            int randomTen = (int) Math.floor(Math.random()*ten.length + 0);


            /** random for email */
            int randomNameMaNV = (int) Math.floor(Math.random()*nameMaNV.length + 0);
            int randomheaderphone = (int) Math.floor(Math.random() * headerphone.length + 0);
            int randomMaNV = (int) Math.floor(Math.random() * manv.length + 0);
            int randomDetailMail = (int) Math.floor(Math.random() * detailemail.length + 0);

            /** random for gender */
            int randomGioiTinh = (int) Math.floor(Math.random() * gioitinh.length + 0);

            /** random for address */
            int randomStreet = (int) Math.floor(Math.random() * street.length + 0);
            int randomCity = (int) Math.floor(Math.random() * city.length + 0);

            /** random for birth */
            int randomNgay = (int) Math.floor(Math.random() * ngay.length + 0);
            int randomThang = (int) Math.floor(Math.random() * thang.length + 0);
            int randomNam = (int) Math.floor(Math.random() * nam_nhanvien.length + 0);            




            // --------------------------------------------------------------------------------------------------------------------
            String id = "PD0" + Math.round(Math.random() * (9999 - 5000 + 1) + 5000);  
            String hoten = ho[randomHo] + " " + lot[randomLot] + " " + ten[randomTen];
            int gender = gioitinh[randomGioiTinh];
            String diachi = "K" + Math.round(Math.random() * (999 - 100 + 1) + 100) + "/" + ngay[randomNgay] + " " + street[randomStreet] + ", " + city[randomCity];
            String ngaysinh = nam_nhanvien[randomNam] + "-" + thang[randomThang] + "-" + ngay[randomNgay];
            String email = nameMaNV[randomNameMaNV] + manv[randomMaNV] + headerphone[randomheaderphone] + detailemail[randomDetailMail];
            String avartar = "abc.jpg";
            String pw = manv[randomMaNV] + headerphone[randomheaderphone] + nameMaNV[randomNameMaNV];
            int chucvu = gioitinh[randomGioiTinh];

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, id);
                ps.setString(2, diachi);
                ps.setString(3, avartar);
                ps.setDate(4, Date.valueOf(ngaysinh));
                ps.setString(5, email);
                ps.setInt(6, gender);
                ps.setString(7, hoten);
                ps.setString(8, pw);
                ps.setInt(9, chucvu);
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }

    // public static void main(String[] args) {
    //     new FakerUtils().create_employee();
    // }
}
