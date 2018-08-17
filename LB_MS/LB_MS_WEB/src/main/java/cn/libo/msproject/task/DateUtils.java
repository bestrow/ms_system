package cn.libo.msproject.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(Date date) {
        return dateToString(date,"yyyy-MM-dd HH:mm:ss:SSS");
    }

    public static String dateToString(Date date, String formatstring) {
        DateFormat dateFormat = new SimpleDateFormat(formatstring);
        return dateFormat.format(date);
    }


}
