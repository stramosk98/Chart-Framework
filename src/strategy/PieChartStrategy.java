package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementação da estratégia para renderização de gráficos do tipo Pizza.
 * Gera o gráfico, define o elemento HTML e especifica o tipo de gráfico como `PieChart`.
 * 
 * @autor Antonio S. Stramosk
 */
public class PieChartStrategy implements ChartStrategy {

	@Override
	public String generateChart(Chart chart) {
		return Builder.buildChart(chart);
	}
	
	@Override
	public String getElement(Chart chart) {
		return "piechart";
	}

	@Override
	public String getChartType() {
		return "PieChart";
	}


}
