package com.keertimaan.excelparser.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser extends FileParser {

  public ExcelParser() {
    super();
  };

  public ExcelParser(File file) {
    super(file);
  }

  @Override
  public Map<Integer, String> getFieldNames() throws Exception {
    Workbook workbook = WorkbookFactory.create(getFile());
    Sheet sheet = workbook.getSheetAt(0);

    Map<Integer, String> columns = new HashMap<>();
    Row firstRow = sheet.getRow(sheet.getFirstRowNum());

    Iterator<Cell> cellIt = firstRow.cellIterator();
    while(cellIt.hasNext()) {
      Cell cell = cellIt.next();
      columns.put(cell.getColumnIndex(), cell.getStringCellValue());
    }

    return columns;
  }

  @Override
  public List<Map<Integer, String>> getFields()
      throws Exception {
    Workbook workbook = WorkbookFactory.create(getFile());
    int numSheets = workbook.getNumberOfSheets();
    List<Map<Integer, String>> rows = new ArrayList<>();

    for(int index = 0; index < numSheets; index++) {
      rows.addAll(getSheetRows(workbook.getSheetAt(index)));
    }

    return rows;
  }

  private List<Map<Integer, String>> getSheetRows(Sheet sheet) {
    List<Map<Integer, String>> rowCollection = new ArrayList<>();

    Iterator<Row> rowIt = sheet.rowIterator();

    /* First row is heading, so
     * skip it over.
     */
    if (rowIt.hasNext()) {
      rowIt.next();
    }

    while (rowIt.hasNext()) {
      Row row = rowIt.next();
      Map<Integer, String> rowValue = new HashMap<>();

      Iterator<Cell> cellIt = row.cellIterator();
      while (cellIt.hasNext()) {
        Cell cell = cellIt.next();
        String value = (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
            ? Double.toString(cell.getNumericCellValue())
            : cell.getStringCellValue();
        rowValue.put(cell.getColumnIndex(), value);
      }

      rowCollection.add(rowValue);
    }

    return rowCollection;
  }
}
