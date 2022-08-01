package com.fpt.assignment.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class DateFormatUtils {
    DateFormat formatter;

    /**
    * Chuyển chuỗi thành Date theo định dạng pattern
    * @param str là ngày dạng chuỗi
    * @param pattern là định dạng ngày theo tiêu chuẩn như dd/MM/yyyy
    * @return dạng Date đã được định dạng
    * @throws ParseException lỗi parse string
    **/
    public Date stringOfDate(String str, String pattern) throws ParseException{
        Date date = java.sql.Date.valueOf(LocalDate.now());
        if (!pattern.isEmpty()) {
            formatter = new SimpleDateFormat(pattern);
            date = (Date) formatter.parse(str);
        }
        return date;
    }

    /**
     * Chuyển Date thành dạng String
     * @param date là biến date đưa vào
     * @return trả về dạng String của date đó
     **/
    public String dateOfString(Date date) {
        return date.toString();
    }
}
