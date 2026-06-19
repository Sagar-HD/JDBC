package com.xworkz.dao;

import com.xworkz.dto.RowDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RowDataDao {
    int savedData(ArrayList<RowDto> rows) throws SQLException;
}
