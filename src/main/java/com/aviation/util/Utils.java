package com.aviation.util;

import com.aviation.entity.Flight;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 读取Excel内容
     * */
    public static List<Flight> ReadExcelData(InputStream is){
        List<Flight> flightList = new ArrayList<>();
        POIFSFileSystem fs;
        HSSFWorkbook wb;
        HSSFSheet sheet;
        HSSFRow row;
        Flight flight;
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();

            for (int i =1;i <= rowNum;i++){
                flight = new Flight();
                row = sheet.getRow(i);
                flight.setFlight_start(row.getCell(0).toString());
                flight.setFlight_end(row.getCell(1).toString());
                flight.setFlight_start_time(row.getCell(2).toString());
                flight.setFlight_arrive_time(row.getCell(3).toString());
                flight.setCompany_name(row.getCell(4).toString());
                flight.setFlight_price(row.getCell(5).toString());
                flight.setSeat_count(Integer.parseInt(row.getCell(6).toString()));
                flightList.add(flight);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return flightList;

    }
}
