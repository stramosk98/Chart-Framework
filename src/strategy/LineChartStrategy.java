package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

public class LineChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement(Chart chart) {
		return "curve_chart";
	}

	@Override
	public String getChartType() {
		return "LineChart";
	}


}
