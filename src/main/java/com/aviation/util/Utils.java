package com.aviation.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

    /**
     * 当月第一天
     * @param timeFlag 是否带时分秒， true是
     * @return
     */
    public static String getFirstDay(boolean timeFlag) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        if(timeFlag){
            str.append(" 00:00:00");
        }
        return str.toString();
    }

    /**
     * 当月最后一天
     * @param timeFlag 是否带时分秒， true是
     * @return
     */
    public static String getLastDay(boolean timeFlag) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, gcLast.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        if(timeFlag){
            str.append(" 23:59:59");
        }
        return str.toString();
    }
}
