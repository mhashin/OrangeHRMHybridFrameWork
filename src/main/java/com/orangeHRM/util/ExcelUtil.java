package com.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtil {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;

	private static void loadExcel(String location, String sheetName) {
		try {
			FileInputStream file = new FileInputStream(new File(location));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			file.close();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getExcel(String location, String sheetName) {
		List<Map<String, String>> list = null;
		if (sheet == null) {
			loadExcel(location, sheetName);
		}

		int lastRowNum = sheet.getLastRowNum();
		int lastColVal = sheet.getRow(0).getLastCellNum();

		Map<String, String> map = null;
		list = new ArrayList<>();
		for (int i = 1; i <= lastRowNum; i++) {
			map = new HashMap<>();
			for (int j = 0; j < lastColVal; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}

			list.add(map);
		}

		return list;
	}

}
