package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementa��o da estrat�gia para renderiza��o de gr�ficos do tipo �rea.
 * Gera o gr�fico, define o elemento HTML e especifica o tipo de gr�fico como `AreaChart`.
 * 
 * @autor Antonio S. Stramosk
 */
public class AreaChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}

	@Override
	public String getElement(Chart chart) {
		return "chart_div";
	}

	@Override
	public String getChartType() {
		return "AreaChart";
	}

}
