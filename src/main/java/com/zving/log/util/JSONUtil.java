package com.zving.log.util;

import com.zving.framework.data.DataColumn;
import com.zving.framework.data.DataTable;
import com.zving.framework.json.JSONArray;

public class JSONUtil {
	public static JSONArray toJSONArray(DataTable dt) {
		JSONArray jsonArray = new JSONArray();
		DataColumn[] columns = dt.getDataColumns();
		for (int i = 0; i < columns.length; i++) {
			dt.getDataColumn(i).setColumnName(dt.getDataColumn(i).getColumnName().toLowerCase());
			for (int j = 0; j < dt.getRowCount(); j++) {
				dt.get(j).set(columns[i].getColumnName(), dt.get(j).getString(columns[i].getColumnName()));
			}
		}
		for (int i = 0; i < dt.getRowCount(); i++) {
			jsonArray.add(dt.getDataRow(i).toMapx());
		}
		return jsonArray;
	}
}
