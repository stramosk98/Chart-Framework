package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementa��o da estrat�gia para renderiza��o de gr�ficos do tipo Linha.
 * Gera o gr�fico, define o elemento HTML e especifica o tipo de gr�fico como `LineChart`.
 * 
 * @autor Antonio S. Stramosk
 */
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
