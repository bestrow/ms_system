package cn.libo.msproject.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String transferdate(Date date, String dateFormateparam) {
        DateFormat dateFormat = new SimpleDateFormat(dateFormateparam);
        return dateFormat.format(date);
    }

    public static Date transferdate(String dateString, String dateFormateparam) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(dateFormateparam);
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
