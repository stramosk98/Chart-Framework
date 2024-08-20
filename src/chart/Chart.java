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
 * Classe que representa um gráfico, configurável através de diferentes
 * estratégias de renderização. Gerencia o título, os dados e a estratégia de
 * visualização do gráfico.
 * 
 * @autor Antonio S. Stramosk
 */
public class Chart {

	private String title;
	private String[][] columns;
	private ChartStrategy strategy;

	/**
	 * Construtor padrão da classe `Chart`.
	 */
	public Chart() {
	};

	/**
	 * Constrói um gráfico com o título, dados e tipo de gráfico especificado.
	 * 
	 * @param title Título do gráfico.
	 * @param list  Dados do gráfico em formato de matriz bidimensional.
	 * @param type  Tipo de gráfico a ser gerado, representado por um enum.
	 */
	public Chart(String title, String[][] list, IChartEnum type) {
		this.title = title;
		this.columns = list;
		getTypeChart(type);
	};

	/**
	 * Retorna o título do gráfico.
	 * 
	 * @return Título do gráfico.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Define o título do gráfico.
	 * 
	 * @param title Novo título do gráfico.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retorna os dados do gráfico.
	 * 
	 * @return Matriz bidimensional contendo os dados do gráfico.
	 */
	public String[][] getColumns() {
		return columns;
	}

	/**
	 * Define os dados do gráfico.
	 * 
	 * @param columns Nova matriz de dados para o gráfico.
	 */
	public void setColumns(String[][] columns) {
		this.columns = columns;
	}

	/**
	 * Retorna a estratégia de renderização do gráfico.
	 * 
	 * @return Objeto `ChartStrategy` responsável pela renderização do gráfico.
	 */
	public ChartStrategy getStrategy() {
		return strategy;
	}

	/**
	 * Define a estratégia de renderização do gráfico.
	 * 
	 * @param strategy Nova estratégia de renderização.
	 */
	public void setStrategy(ChartStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Determina a estratégia de renderização com base no tipo de gráfico.
	 * 
	 * @param type Enum que define o tipo de gráfico.
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
	 * Gera o código HTML necessário para visualizar o gráfico.
	 * 
	 * @return String contendo o código HTML gerado.
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
	 * Verifica a consistência dos dados do gráfico, assegurando que todas as linhas
	 * têm o mesmo número de colunas.
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