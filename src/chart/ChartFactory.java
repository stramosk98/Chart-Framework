package chart;

/**
 * Classe responsável por criar instâncias de Chart com base nos parâmetros fornecidos.
 * 
 * @author Antonio S. Stramosk
 */
public class ChartFactory {

    /**
     * Cria um gráfico com base no nome, nos valores e no tipo de enum fornecido.
     * 
     * @param name Nome do gráfico.
     * @param values Matriz de valores do gráfico.
     * @param chartEnum Enum que define o tipo de gráfico.
     * @return Uma instância de Chart configurada conforme os parâmetros.
     * @throws IllegalArgumentException Se o enum não for compatível com os valores.
     */
    public static Chart createChart(String name, String[][] values, IChartEnum chartEnum) {
        if (values[0].length == 2 && chartEnum instanceof ChartEnum2) {
            return new Chart(name, values, chartEnum);
        } else if (values[0].length == 3 && chartEnum instanceof ChartEnum3)  {
            return new Chart(name, values, chartEnum);
        } else if (values[0].length > 3 && chartEnum instanceof ChartEnum)  {
            return new Chart(name, values, chartEnum);
        } else {
            throw new IllegalArgumentException("Invalid enum given");
        }
    }
}

