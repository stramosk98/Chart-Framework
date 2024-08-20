package chart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import strategy.AreaChartStrategy;
import strategy.ColumnChartStrategy;
import strategy.GeoChartStrategy;
import strategy.LineChartStrategy;
import strategy.PieChartStrategy;

/**
 * Classe que representa um gr�fico, configur�vel atrav�s de diferentes
 * estrat�gias de renderiza��o. Gerencia o t�tulo, os dados e a estrat�gia de
 * visualiza��o do gr�fico.
 * 
 * @autor Antonio S. Stramosk
 */
public class Chart {

	private String title;
	private String[][] columns;
	private ChartStrategy strategy;

	/**
	 * Construtor padr�o da classe `Chart`.
	 */
	public Chart() {
	};

	/**
	 * Constr�i um gr�fico com o t�tulo, dados e tipo de gr�fico especificado.
	 * 
	 * @param title T�tulo do gr�fico.
	 * @param list  Dados do gr�fico em formato de matriz bidimensional.
	 * @param type  Tipo de gr�fico a ser gerado, representado por um enum.
	 */
	public Chart(String title, String[][] list, IChartEnum type) {
		this.title = title;
		this.columns = list;
		getTypeChart(type);
	};

	/**
	 * Retorna o t�tulo do gr�fico.
	 * 
	 * @return T�tulo do gr�fico.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Define o t�tulo do gr�fico.
	 * 
	 * @param title Novo t�tulo do gr�fico.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retorna os dados do gr�fico.
	 * 
	 * @return Matriz bidimensional contendo os dados do gr�fico.
	 */
	public String[][] getColumns() {
		return columns;
	}

	/**
	 * Define os dados do gr�fico.
	 * 
	 * @param columns Nova matriz de dados para o gr�fico.
	 */
	public void setColumns(String[][] columns) {
		this.columns = columns;
	}

	/**
	 * Retorna a estrat�gia de renderiza��o do gr�fico.
	 * 
	 * @return Objeto `ChartStrategy` respons�vel pela renderiza��o do gr�fico.
	 */
	public ChartStrategy getStrategy() {
		return strategy;
	}

	/**
	 * Define a estrat�gia de renderiza��o do gr�fico.
	 * 
	 * @param strategy Nova estrat�gia de renderiza��o.
	 */
	public void setStrategy(ChartStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Determina a estrat�gia de renderiza��o com base no tipo de gr�fico.
	 * 
	 * @param type Enum que define o tipo de gr�fico.
	 */
	private void getTypeChart(IChartEnum type) {
		if (type == ChartEnum2.GeoChart || type == ChartEnum3.GeoChart) {
			setStrategy(new GeoChartStrategy());
		} else if (type == ChartEnum2.ColumnChart || type == ChartEnum3.ColumnChart || type == ChartEnum.ColumnChart) {
			setStrategy(new ColumnChartStrategy());
		} else if (type == ChartEnum2.PieChart) {
			setStrategy(new PieChartStrategy());
		} else if (type == ChartEnum3.AreaChart || type == ChartEnum.AreaChart) {
			setStrategy(new AreaChartStrategy());
		} else if (type == ChartEnum3.LineChart || type == ChartEnum.LineChart) {
			setStrategy(new LineChartStrategy());
		}
	}

	/**
	 * Gera o c�digo HTML necess�rio para visualizar o gr�fico.
	 * 
	 * @return String contendo o c�digo HTML gerado.
	 * @throws IOException Se ocorrer um erro ao escrever o arquivo HTML.
	 */
	public String generateHTML() throws IOException {
		this.verifyValueList();
		String data = strategy.generateChart(this);
		String element = strategy.getElement(this);
		String name = title + ".html";
		FileWriter arq = new FileWriter(name);
		PrintWriter writerArq = new PrintWriter(arq);
		String result = "<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart', 'geochart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable("
				+ data + ");var options = {title: '" + title + "'};var chart = new google.visualization."
				+ strategy.getChartType() + "(document.getElementById('" + element
				+ "'));chart.draw(data, options);}</script></head><body><div id=\"" + element
				+ "\" style=\"width: 900px; height: 500px;\"></div></body></html>";
		writerArq.println(result);
		arq.close();
		return result;
	}

	/**
	 * Verifica a consist�ncia dos dados do gr�fico, assegurando que todas as linhas
	 * t�m o mesmo n�mero de colunas.
	 */
	private void verifyValueList() {
		int columnLength = columns[0].length;
		for (String[] value : columns) {
			if (value.length != columnLength) {
				throw new IllegalArgumentException("spected " + columnLength + " params, " + value.length + " given");
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chart [title=");
		builder.append(title);
		builder.append(", columns=");
		builder.append(Arrays.toString(columns));
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append("]");
		return builder.toString();
	}
}