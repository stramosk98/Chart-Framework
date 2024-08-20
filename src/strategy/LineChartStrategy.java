package strategy;

import chart.Builder;
import chart.Chart;
import chart.ChartStrategy;

/**
 * Implementação da estratégia para renderização de gráficos do tipo Linha.
 * Gera o gráfico, define o elemento HTML e especifica o tipo de gráfico como `LineChart`.
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
