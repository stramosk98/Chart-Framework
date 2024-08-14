package chart;

public interface ChartStrategy {
	String generateChart(Chart chart);
	String getChartType();
	String getElement();
}
