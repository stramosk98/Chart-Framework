package chart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import strategy.AreaChartStrategy;
import strategy.ColumnChartStrategy;
import strategy.GeoChartStrategy;
import strategy.LineChartStrategy;
import strategy.PieChartStrategy;

public class Chart {

	private String title;
	private String[][] columns;
	private ChartStrategy strategy;
	
	public Chart() {};

	public Chart(String title, String[][] list, IChartEnum type) {
		this.title = title;
		this.columns = list;
		getTypeChart(type);
	};	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[][] getColumns() {
		return columns;
	}

	public void setColumns(String[][] columns) {
		this.columns = columns;
	}
	
	public ChartStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ChartStrategy strategy) {
		this.strategy = strategy;
	}
	
	private void getTypeChart(IChartEnum type) {
		if (type == ChartEnum2.GeoChart) {
			setStrategy(new GeoChartStrategy());
		} else if (type == ChartEnum2.ColumnChart) {
			setStrategy(new ColumnChartStrategy());
		} else if (type == ChartEnum2.PieChart) {
			setStrategy(new PieChartStrategy());
		} else if (type == ChartEnum3.AreaChart || type == ChartEnum.AreaChart) {
			setStrategy(new AreaChartStrategy());
		} else if (type == ChartEnum3.LineChart || type == ChartEnum.LineChart) {
			setStrategy(new LineChartStrategy());
		}
	}
	
	public String generateHTML() throws IOException {
		this.verifyValueList();
        String data = strategy.generateChart(this);
        String element = strategy.getElement(this);
        String name = title + ".html";
        FileWriter arq = new FileWriter(name);
		PrintWriter writerArq = new PrintWriter(arq);
		writerArq.println("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable(" + data + ");var options = {title: '" + title + "'};var chart = new google.visualization." + strategy.getChartType() + "(document.getElementById('" +  element + "'));chart.draw(data, options);}</script></head><body><div id=\"" +  element + "\" style=\"width: 900px; height: 500px;\"></div></body></html>");
		arq.close();
		return "Success to create " + title + " Chart!";
    }
	
	private void verifyValueList() {
		int columnLength = columns[0].length;
		for (String[] value : columns) {
			if (value.length != columnLength) {
				throw new IllegalArgumentException("spected " + columnLength + " params, " + value.length + " given");
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chart [title=");
		builder.append(title);
		builder.append(", columns=");
		builder.append(Arrays.toString(columns));
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append("]");
		return builder.toString();
	}
}