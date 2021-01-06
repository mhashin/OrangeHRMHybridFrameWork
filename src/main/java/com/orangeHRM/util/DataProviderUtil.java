package com.orangeHRM.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

public final class DataProviderUtil {

	@DataProvider
	public static Object[] getData(Method m) {

		String testName = m.getName();
		List<Map<String, String>> list = ExcelUtil.getExcel(Constants.getExcelpath(), "Demo");

		List<Map<String, String>> itrationList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("TestName").equalsIgnoreCase(testName)){
				if (list.get(i).get("Execute").equalsIgnoreCase("Y")){
					itrationList.add(list.get(i));
				}
			}
		}
		list.removeAll(itrationList);
		return itrationList.toArray();
	}

}
