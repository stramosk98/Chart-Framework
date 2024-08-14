package chart;

public class Builder {
	public static String buildChart(Chart chart) {
		StringBuilder data = new StringBuilder();
		data.append("[['");
		for (int i = 0; i < chart.getColumnsNames().length; i++) {
			data.append(chart.getColumnsNames()[i]);
			if (i + 1 < chart.getColumnsNames().length) {
				data.append("', '");
			}
		}
		data.append("'],");
		for (Value value : chart.getValueList()) {
			String[] valueData = value.getChartList();
			data.append("['");
			for (int j = 0; j < valueData.length; j++) {
				data.append(valueData[j]);
				if (j == 0) {
					data.append("', ");
				} else if (j + 1 < chart.getColumnsNames().length){
					data.append(", ");
				}
			}
			data.append("],");
		}
		data.deleteCharAt(data.length() - 1);
		data.append("]");
		return data.toString();
	}

}
