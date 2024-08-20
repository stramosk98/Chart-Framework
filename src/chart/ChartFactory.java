package chart;

/**
 * Classe respons�vel por criar inst�ncias de Chart com base nos par�metros fornecidos.
 * 
 * @author Antonio S. Stramosk
 */
public class ChartFactory {

    /**
     * Cria um gr�fico com base no nome, nos valores e no tipo de enum fornecido.
     * 
     * @param name Nome do gr�fico.
     * @param values Matriz de valores do gr�fico.
     * @param chartEnum Enum que define o tipo de gr�fico.
     * @return Uma inst�ncia de Chart configurada conforme os par�metros.
     * @throws IllegalArgumentException Se o enum n�o for compat�vel com os valores.
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

