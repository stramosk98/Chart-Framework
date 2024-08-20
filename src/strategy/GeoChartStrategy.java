package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementação da estratégia para renderização de gráficos do tipo Geográfico.
 * Gera o gráfico, define o elemento HTML e especifica o tipo de gráfico como `GeoChart`.
 * 
 * @autor Antonio S. Stramosk
 */
public class GeoChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement(Chart chart) {
		if (chart.getColumns().length > 2) {
			return "chart_div";
		}
		return "regions_div";
	}

	@Override
	public String getChartType() {
		return "GeoChart";
	}


}
