package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementa��o da estrat�gia para renderiza��o de gr�ficos do tipo Pizza.
 * Gera o gr�fico, define o elemento HTML e especifica o tipo de gr�fico como `PieChart`.
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
