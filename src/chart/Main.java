package chart;

import java.io.IOException;

public class Main {

		public static void main(String[] args) throws IOException {
				
//				Value value1 = new Value(new String[]{"2004", "1000", "400"});
//				Value value2 = new Value(new String[]{"2005", "1170", "460"});
//				Value value3 = new Value(new String[]{"2006", "660", "1120"});
//				Value value4 = new Value(new String[]{"2007", "1030", "540"});
//				Value value5 = new Value(new String[]{"2008", "550", "290"});
//				
//				String[] titleColumns = {"Year", "Sales", "Expenses"};
//				Chart chart1 = ChartFactory.createChart("Lines", titleColumns, ChartEnum.LineChart);
//				chart1.getValueList().add(value1);
//				chart1.getValueList().add(value2);
//				chart1.getValueList().add(value3);
//				chart1.getValueList().add(value4);
//				chart1.getValueList().add(value5);
//				chart1.generateHTML();
				
				Value value1 = new Value(new String[]{"2004", "1000", "400"});
				Value value2 = new Value(new String[]{"2005", "1170", "460"});
				Value value3 = new Value(new String[]{"2006", "660", "1120"});
				Value value4 = new Value(new String[]{"2007", "1030", "540"});
				
				String[] titleColumns1 = {"Year", "Sales", "Expenses"};
				Chart chart2 = ChartFactory.createChart("Area", titleColumns1, ChartEnum3.AreaChart);
				chart2.getValueList().add(value1);
				chart2.getValueList().add(value2);
				chart2.getValueList().add(value3);
				chart2.getValueList().add(value4);
				System.out.println(chart2.generateHTML());
				
				


			}
}
