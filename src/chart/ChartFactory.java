package chart;

public class ChartFactory {
	 public static Chart createChart(String name, String[] values, IChartEnum chartEnum) {
        if (values.length == 3 && chartEnum instanceof ChartEnum3) {
            return new Chart(name, values, chartEnum);
        } else if (values.length == 4 && chartEnum instanceof ChartEnum4) {
            return new Chart(name, values, chartEnum);
        } else if (values.length == 2 && chartEnum instanceof ChartEnum2)  {
        	return new Chart(name, values, chartEnum);
        } else {
            throw new IllegalArgumentException("Invalid enum");
        }
    }
}
