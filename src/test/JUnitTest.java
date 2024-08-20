package test;

import java.io.IOException;

import chart.Chart;
import chart.ChartEnum;
import chart.ChartEnum2;
import chart.ChartEnum3;
import chart.ChartFactory;
import junit.framework.TestCase;

/**
 * Classe de teste unitário utilizando JUnit para verificar a geração de gráficos.
 * Testa a criação de diversos tipos de gráficos utilizando diferentes conjuntos de dados.
 * 
 * @autor Antonio S. Stramosk
 */
public class JUnitTest extends TestCase {

	String[][] matriz4 = { { "Year", "Sales", "Expenses", "Profit" }, 
							{ "2004", "1000", "400", "600" },
							{ "2005", "1170", "460", "500" },
							{ "2006", "660", "1120", "800" }, 
							{ "2007", "1030", "540", "700" }};
	
	String[][] matriz3 = { { "Year", "Sales", "Expenses" }, 
							{ "2004", "1000", "400" },
							{ "2005", "1170", "460" },
							{ "2006", "660", "1120" }, 
							{ "2007", "1030", "540" }};

	String[][] matriz2 = { { "Year", "Sales" }, 
							{ "2004", "1000" },
							{ "2005", "1170" },
							{ "2006", "660"  }, 
							{ "2007", "1030" }};
	
	String[][] geo2 = { { "Country", "Popularity" },
				        { "Germany", "200" },
				        { "United States", "300" },
				        { "Brazil", "400" },
				        { "Canada", "500" },
				        { "France", "600" },
				        { "RU", "700" }};
	
	String[][] geo3 = { { "City",   "Population", "Area"},
				        { "Rome",      "2761477",    "1285.31" },
				        { "Milan",     "1324110",    "181.76" },
				        { "Naples",    "959574",    "117.27" },
				        { "Turin",     "907563",    "130.17" },
				        { "Palermo",   "655875",    "158.9" },
				        { "Genoa",     "607906",    "243.60" },
				        { "Bologna",   "380181",    "140.7" },
				        { "Florence",  "371282",    "102.41" },
				        { "Fiumicino", "67370",     "213.44" },
				        { "Anzio",     "52192",     "43.43" },
				        { "Ciampino",  "38262",      "11" }};
	
	Chart chart = new Chart();

	/**
     * Testa a geração de um gráfico de área com quatro colunas.
     * 
     * @throws IOException
     */
	public void testChart4Area() throws IOException {
		chart = ChartFactory.createChart("Area4", matriz4, ChartEnum.AreaChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', 'Profit', ], ['2004', 1000, 400, 600], ['2005', 1170, 460, 500], ['2006', 660, 1120, 800], ['2007', 1030, 540, 700],]);var options = {title: 'Area4'};var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));chart.draw(data, options);}</script></head><body><div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de coluna com quatro colunas.
     * 
     * @throws IOException
     */
	public void testChart4Column() throws IOException {
		chart = ChartFactory.createChart("Column4", matriz4, ChartEnum.ColumnChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', 'Profit', ], ['2004', 1000, 400, 600], ['2005', 1170, 460, 500], ['2006', 660, 1120, 800], ['2007', 1030, 540, 700],]);var options = {title: 'Column4'};var chart = new google.visualization.ColumnChart(document.getElementById('columnchart_material'));chart.draw(data, options);}</script></head><body><div id=\"columnchart_material\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de linha com quatro colunas.
     * 
     * @throws IOException
     */
	public void testChart4Line() throws IOException {
		chart = ChartFactory.createChart("Line4", matriz4, ChartEnum.LineChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', 'Profit', ], ['2004', 1000, 400, 600], ['2005', 1170, 460, 500], ['2006', 660, 1120, 800], ['2007', 1030, 540, 700],]);var options = {title: 'Line4'};var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));chart.draw(data, options);}</script></head><body><div id=\"curve_chart\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de área com três colunas.
     * 
     * @throws IOException
     */
	public void testChart3Area() throws IOException {
		chart = ChartFactory.createChart("Area3", matriz3, ChartEnum3.AreaChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', ], ['2004', 1000, 400], ['2005', 1170, 460], ['2006', 660, 1120], ['2007', 1030, 540],]);var options = {title: 'Area3'};var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));chart.draw(data, options);}</script></head><body><div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de coluna com três colunas.
     * 
     * @throws IOException
     */
	public void testChart3Column() throws IOException {
		chart = ChartFactory.createChart("Column3", matriz3, ChartEnum3.ColumnChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', ], ['2004', 1000, 400], ['2005', 1170, 460], ['2006', 660, 1120], ['2007', 1030, 540],]);var options = {title: 'Column3'};var chart = new google.visualization.ColumnChart(document.getElementById('columnchart_material'));chart.draw(data, options);}</script></head><body><div id=\"columnchart_material\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de linha com três colunas.
     * 
     * @throws IOException
     */
	public void testChart3Line() throws IOException {
		chart = ChartFactory.createChart("Line3", matriz3, ChartEnum3.LineChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', 'Expenses', ], ['2004', 1000, 400], ['2005', 1170, 460], ['2006', 660, 1120], ['2007', 1030, 540],]);var options = {title: 'Line3'};var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));chart.draw(data, options);}</script></head><body><div id=\"curve_chart\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de pizza com duas colunas.
     * 
     * @throws IOException
     */
	public void testChart2Pie() throws IOException {
		chart = ChartFactory.createChart("Pizza2", matriz2, ChartEnum2.PieChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', ], ['2004', 1000], ['2005', 1170], ['2006', 660], ['2007', 1030],]);var options = {title: 'Pizza2'};var chart = new google.visualization.PieChart(document.getElementById('piechart'));chart.draw(data, options);}</script></head><body><div id=\"piechart\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de coluna com duas colunas.
     * 
     * @throws IOException
     */
	public void testChart2Column() throws IOException {
		chart = ChartFactory.createChart("Column2", matriz2, ChartEnum2.ColumnChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Year', 'Sales', ], ['2004', 1000], ['2005', 1170], ['2006', 660], ['2007', 1030],]);var options = {title: 'Column2'};var chart = new google.visualization.ColumnChart(document.getElementById('columnchart_material'));chart.draw(data, options);}</script></head><body><div id=\"columnchart_material\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
	/**
     * Testa a geração de um gráfico de geográfico com duas colunas.
     * 
     * @throws IOException
     */
	public void testChart3Geo() throws IOException {
		chart = ChartFactory.createChart("Geo3", geo3, ChartEnum3.GeoChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['City', 'Population', 'Area', ], ['Rome', 2761477, 1285.31], ['Milan', 1324110, 181.76], ['Naples', 959574, 117.27], ['Turin', 907563, 130.17], ['Palermo', 655875, 158.9], ['Genoa', 607906, 243.60], ['Bologna', 380181, 140.7], ['Florence', 371282, 102.41], ['Fiumicino', 67370, 213.44], ['Anzio', 52192, 43.43], ['Ciampino', 38262, 11],]);var options = {title: 'Geo3'};var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));chart.draw(data, options);}</script></head><body><div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}

	/**
     * Testa a geração de um gráfico de geográfico com três colunas.
     * 
     * @throws IOException
     */
	public void testChart2Geo() throws IOException {
		chart = ChartFactory.createChart("Geo2", geo2, ChartEnum2.GeoChart);
		assertEquals(
			"<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Country', 'Popularity', ], ['Germany', 200], ['United States', 300], ['Brazil', 400], ['Canada', 500], ['France', 600], ['RU', 700],]);var options = {title: 'Geo2'};var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));chart.draw(data, options);}</script></head><body><div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div></body></html>",
			chart.generateHTML()
		);
	}
	
}
