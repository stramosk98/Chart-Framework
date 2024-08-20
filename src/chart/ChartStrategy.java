package chart;

/**
 * Interface que define a estrat�gia de renderiza��o de gr�ficos.
 * Fornece m�todos para gera��o de gr�ficos, obten��o de elementos HTML e tipo de gr�fico.
 * 
 * @autor Antonio S. Stramosk
 */
public interface ChartStrategy {
	
	/**
     * Gera a representa��o dos dados do gr�fico em formato compat�vel para renderiza��o.
     * 
     * @param chart Objeto `Chart` que cont�m os dados e configura��es.
     * @return String representando os dados formatados do gr�fico.
     */
    String generateChart(Chart chart);

    /**
     * Obt�m o identificador do elemento HTML onde o gr�fico ser� renderizado.
     * 
     * @param chart Objeto `Chart` associado ao gr�fico.
     * @return String com o ID do elemento HTML.
     */
    String getElement(Chart chart);

    /**
     * Retorna o tipo de gr�fico que ser� renderizado (e.g., `PieChart`, `LineChart`).
     * 
     * @return String representando o tipo de gr�fico.
     */
    String getChartType();
}
