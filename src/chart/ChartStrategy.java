package chart;

/**
 * Interface que define a estratégia de renderização de gráficos.
 * Fornece métodos para geração de gráficos, obtenção de elementos HTML e tipo de gráfico.
 * 
 * @autor Antonio S. Stramosk
 */
public interface ChartStrategy {
	
	/**
     * Gera a representação dos dados do gráfico em formato compatível para renderização.
     * 
     * @param chart Objeto `Chart` que contém os dados e configurações.
     * @return String representando os dados formatados do gráfico.
     */
    String generateChart(Chart chart);

    /**
     * Obtém o identificador do elemento HTML onde o gráfico será renderizado.
     * 
     * @param chart Objeto `Chart` associado ao gráfico.
     * @return String com o ID do elemento HTML.
     */
    String getElement(Chart chart);

    /**
     * Retorna o tipo de gráfico que será renderizado (e.g., `PieChart`, `LineChart`).
     * 
     * @return String representando o tipo de gráfico.
     */
    String getChartType();
}
