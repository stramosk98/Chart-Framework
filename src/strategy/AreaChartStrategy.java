package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementação da estratégia para renderização de gráficos do tipo Área.
 * Gera o gráfico, define o elemento HTML e especifica o tipo de gráfico como `AreaChart`.
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
