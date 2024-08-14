package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

public class GeoChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement() {
		return "regions_div";
	}

	@Override
	public String getChartType() {
		return "GeoChart";
	}


}
