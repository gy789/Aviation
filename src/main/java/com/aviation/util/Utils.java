package com.aviation.util;

import com.aviation.entity.Flight;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
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
    public static List<Flight> ReadExcelData(InputStream is) throws IOException{
        List<Flight> flightList = new ArrayList<>();
        Workbook wb;
        Sheet sheet;
        Row row;
        Flight flight;
        try {
            wb = WorkbookFactory.create(is);
            sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();

            for (int i =1;i <= rowNum;i++){
                String flight_id = UUID.randomUUID().toString().trim().replace("-","");
                flight = new Flight();
                row = sheet.getRow(i);
                flight.setFlight_id(flight_id);
                flight.setFlight_number(row.getCell(0).toString());
                flight.setFlight_start(row.getCell(1).toString());
                flight.setFlight_end(row.getCell(2).toString());
                flight.setFlight_start_time(row.getCell(3).toString());
                flight.setFlight_arrive_time(row.getCell(4).toString());
                flight.setCompany_name(row.getCell(5).toString());
                flight.setFlight_price(row.getCell(6).toString());
                flight.setFlight_time(row.getCell(7).toString());
                flight.setSeat_basic_count(Integer.parseInt(row.getCell(8).toString()));
                flightList.add(flight);
            }
        }catch (InvalidFormatException e){
            e.printStackTrace();
        }
        return flightList;

    }

    public static Workbook create(InputStream inp) throws IOException, InvalidFormatException {
        // If clearly doesn't do mark/reset, wrap up
        if(! inp.markSupported()) {
            inp = new PushbackInputStream(inp, 8);
        }

        if(POIFSFileSystem.hasPOIFSHeader(inp)) {
            return new HSSFWorkbook(inp);
        }
        if(POIXMLDocument.hasOOXMLHeader(inp)) {
            return new XSSFWorkbook(OPCPackage.open(inp));
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }
}
