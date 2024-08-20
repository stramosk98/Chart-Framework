package chart;

import java.io.IOException;

public class Main {

		public static void main(String[] args) throws IOException {
				
		 	String[][] matriz = {
		 			{"Year", "Sales", "Expenses", "Profit"},
		 			{"2004", "1000", "400", "600"},
		 			{"2005", "1170", "460", "500"},
		 			{"2006", "660", "1120", "800"},
		 			{"2007", "1030", "540", "700"}
		 	};
		 	
			Chart chart2 = ChartFactory.createChart("Area", matriz, ChartEnum.AreaChart);
			System.out.println(chart2.generateHTML());
		}
}
