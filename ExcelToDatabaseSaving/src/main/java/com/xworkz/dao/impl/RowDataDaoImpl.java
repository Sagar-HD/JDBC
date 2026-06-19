package com.xworkz.dao.impl;

import com.xworkz.dao.RowDataDao;
import com.xworkz.dbutil.DbUtil;
import com.xworkz.dto.RowDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RowDataDaoImpl implements RowDataDao {
    @Override
    public int savedData(ArrayList<RowDto> rows) throws SQLException {
       if(rows!=null){

               Connection con = DbUtil.getConnection();
               String insertQuery="insert into sheet (software_name,version,developed_by,year,open_source) values (?,?,?,?,?)";
           PreparedStatement ps=con.prepareStatement(insertQuery);
           for(RowDto row:rows){
               ps.setString(1,row.getSoftwareName());
               ps.setString(2,row.getVersion());
               ps.setString(3,row.getDevelopedBy());
               ps.setString(4,row.getYear().toString());
               ps.setBoolean(5,row.isOpenSource());
               ps.addBatch();

           }
         int[] results=ps.executeBatch();

           DbUtil.closeResources(con,ps,null);

          int numberOfRowsInserted=0;
          for(int i:results){
              numberOfRowsInserted+=i;
          }
          return numberOfRowsInserted;


       }

  return  0;
    }
}
