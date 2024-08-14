package chart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import strategy.AreaChartStrategy;
import strategy.ColumnChartStrategy;
import strategy.GeoChartStrategy;
import strategy.LineChartStrategy;
import strategy.PieChartStrategy;

public class Chart {

	private String title;
	private String[] columnsNames;
	private List<Value> valueList = new ArrayList<>();
	private ChartStrategy strategy;
	
	public Chart() {};

	public Chart(String title, String[] list, IChartEnum type) {
		this.title = title;
		this.columnsNames = list;
		getTypeChart(type);
	};	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getColumnsNames() {
		return columnsNames;
	}

	public void setColumnsNames(String[] columnsNames) {
		this.columnsNames = columnsNames;
	}
	
	public List<Value> getValueList() {
		return valueList;
	}

	public void setValueList(List<Value> valueList) {
		this.valueList = valueList;
	}
	
	public ChartStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ChartStrategy strategy) {
		this.strategy = strategy;
	}
	
	public String generateHTML() throws IOException {
		this.verifyValueList();
        String data = strategy.generateChart(this);
        String name = title + ".html";
        FileWriter arq = new FileWriter(name);
		PrintWriter writerArq = new PrintWriter(arq);
		writerArq.println("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable(" + data + ");var options = {title: '" + title + "'};var chart = new google.visualization." + strategy.getChartType() + "(document.getElementById('" +  strategy.getElement() + "'));chart.draw(data, options);}</script></head><body><div id=\"" +  strategy.getElement() + "\" style=\"width: 900px; height: 500px;\"></div></body></html>");
		arq.close();
		return "Success to create " + title + " Chart!";
    }
	
	private void verifyValueList() {
		for (Value value : valueList) {
			if (value.getChartList().length != columnsNames.length) {
				throw new IllegalArgumentException("spected " + columnsNames.length + " params, " + value.getChartList().length + " given");
			}
		}
	}
	
	private void getTypeChart(IChartEnum type) {
		if (type == ChartEnum2.GeoChart) {
			setStrategy(new GeoChartStrategy());
		} else if (type == ChartEnum3.LineChart) {
			setStrategy(new LineChartStrategy());
		} else if (type == ChartEnum2.ColumnChart) {
			setStrategy(new ColumnChartStrategy());
		} else if (type == ChartEnum2.PieChart) {
			setStrategy(new PieChartStrategy());
		} else if (type == ChartEnum3.AreaChart) {
			setStrategy(new AreaChartStrategy());
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chart [title=");
		builder.append(title);
		builder.append(", columnsNames=");
		builder.append(Arrays.toString(columnsNames));
		builder.append(", valueList=");
		builder.append(valueList);
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append("]");
		return builder.toString();
	}

}