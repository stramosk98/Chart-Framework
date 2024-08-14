package chart;

import java.util.Arrays;

public class Value {

	private String[] chartList;
	
	public Value() {}
	
	public Value(String[] list) {
		this.chartList = list;
	}

	public String[] getChartList() {
		return chartList;
	}

	public void setChartList(String[] chartList) {
		this.chartList = chartList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Value [chartList=");
		builder.append(Arrays.toString(chartList));
		builder.append("]");
		return builder.toString();
	}
	
}
