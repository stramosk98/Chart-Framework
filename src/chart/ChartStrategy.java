package chart;

public interface ChartStrategy {
	String generateChart(Chart chart);
	String getElement(Chart chart);
	String getChartType();
}
