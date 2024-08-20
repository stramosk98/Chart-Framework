package chart;

/**
 * Classe responsável por montar o título das colunas e seus valores
 * 
 * @author Antonio S. Stramosk
 */
public class Builder {
	
	/**
	 * Retorna uma string com os valores das colunas para ser adicionado ao HTML posteriormente
	 * 
	 * @param chart Classe com atributos para criação do Gráfico
	 * @return String
	 */
	public static String buildChart(Chart chart) {
		StringBuilder data = new StringBuilder();
		data.append("[");
		for (int i = 0; i < chart.getColumns().length; i++) {
			data.append("[");
			for (int j = 0; j < chart.getColumns()[i].length; j++) {
				if (i == 0 || j == 0) {
					data.append("'");
				}
				data.append(chart.getColumns()[i][j]);
				if (i == 0 && j + 1 < chart.getColumns()[i].length) {
					data.append("', ");
				} else if (i == 0 || j == 0) {
					data.append("', ");
				} else if (j + 1 < chart.getColumns()[i].length){
					data.append(", ");
				}
			}
			data.append("], ");
		}
		data.deleteCharAt(data.length() - 1);
		data.append("]");
		return data.toString();
	}

}
