package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

public class AreaChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement() {
		return "chart_div";
	}

	@Override
	public String getChartType() {
		return "AreaChart";
	}


}
