/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe de data simulando seus campos.
 */

package consultorio;

public class Data
{
	private int dia;
	private int mes;
	private int ano;
	
	/*
	 * Método para adquirir o dia da data.
	 * @return int
	 */
	
	public int getDia()
	{
		return this.dia;
	}
	
	/*
	 * Método para adquirir o mês da data.
	 * @return int
	 */
	
	public int getMes()
	{
		return this.mes;
	}
	
	/*
	 * Método para adquirir o ano da data.
	 * @return int
	 */
	
	public int getAno()
	{
		return this.ano;
	}
	
	/*
	 * Método para compilar os dados do objeto tipo Data em uma String.
	 * @return String
	 */
	
	public String toString()
	{
		return "Data: " + this.dia + "/" + this.mes + "/" + this.ano;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param dia
	 * @param mes
	 * @param ano
	 */
	
	public Data(int dia, int mes, int ano)
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	/*
	 * Método para comparar um obejto do tipo Data com o objeto local. Retorna true se os objetos forem iguais e false se forem diferentes.
	 * @return boolean
	 */
	
	public boolean equals(Data data)
	{
		if(this.dia != data.getDia())
		{
			return false;
		}
		else
		{
			if(this.mes != data.getMes())
			{
				return false;
			}
			else
			{
				if(this.ano != data.getAno())
				{
					return false;
				}
			}
		}
		return true;
	}
}
