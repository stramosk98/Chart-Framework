package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

public class PieChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement() {
		return "piechart";
	}

	@Override
	public String getChartType() {
		return "PieChart";
	}


}
