package com.xworkz.runner;

import com.xworkz.dao.RowDataDao;
import com.xworkz.dao.impl.RowDataDaoImpl;
import com.xworkz.dto.RowDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

public class Main {
    public static ArrayList<RowDto> getDataFromExcel(String filePath) throws IOException {
        ArrayList<RowDto> data=new ArrayList<>();
        //reading raw bytes from file it can be anytype
        FileInputStream fis=new FileInputStream(filePath);
        //Apache poi library converts bytes to excel form
        //it creates a workbook book that we can process
        Workbook workbook = new XSSFWorkbook(fis);
        //getting first sheet from workbook
        Sheet sheet = workbook.getSheetAt(0);
        //formatter to convert any value to string
        DataFormatter formatter = new DataFormatter();
        for(Row row:sheet){
            //skipping first row which is heading
            if (row.getRowNum() == 0) {
                continue;
            }
            String softwareName=formatter.formatCellValue(row.getCell(0));
            String version=formatter.formatCellValue(row.getCell(1));
            String developedBy=formatter.formatCellValue(row.getCell(2));
            int yearint = (int) row.getCell(3).getNumericCellValue();
            Year year=Year.of(yearint);
            String openSourceStr=formatter.formatCellValue(row.getCell(4));
            openSourceStr=openSourceStr.toLowerCase().substring(0,1);
            Boolean openSource=false;
            if("y".equals(openSourceStr)){
                openSource=true;

            }
            RowDto rowDto=new RowDto(softwareName,version,developedBy,year,openSource);
            data.add(rowDto);

        }


        return data;
    }


    public static void main(String[] args) throws IOException, SQLException {
        ArrayList<RowDto> data=getDataFromExcel("src/main/resources/Data.xlsx");

        RowDataDao rowDataDao=new RowDataDaoImpl();

       int rowsSaved= rowDataDao.savedData(data);
        System.out.println("rows saved :"+rowsSaved);

    }
}
