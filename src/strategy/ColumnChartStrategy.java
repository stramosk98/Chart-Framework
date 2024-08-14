package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

public class ColumnChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement(Chart chart) {
		if (chart.getColumns().length > 2) {
			return "columnchart_material";
		}
		return "columnchart_values";
	}

	@Override
	public String getChartType() {
		return "ColumnChart";
	}


}
