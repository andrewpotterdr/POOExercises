/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe de hora para simular seus campos.
 */

package consultorio;

public class Hora
{
	int hora;
	int minuto;
	
	/*
	 * Método para adquirir a hora.
	 * @return int
	 */
	
	public int getHora()
	{
		return this.hora;
	}
	
	/*
	 * Método para adquirir o minuto.
	 * @return int
	 */
	
	public int getMinuto()
	{
		return this.minuto;
	}
	
	/*
	 * Método para compilar os dados do objeto em uma String.
	 * @return String
	 */

	public String toString()
	{
		return "Hora: " + this.hora + ":" + this.minuto;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param hora
	 * @param minuto
	 */
	
	public Hora(int hora, int minuto)
	{
		this.hora = hora;
		this.minuto = minuto;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param hora
	 */
	
	public Hora(int hora)
	{
		this.hora = hora;
		this.minuto = 0;
	}
	
	/*
	 * Método para comparar um objeto do tipo Hora com o objeto local. Retorna true se os objetos forem iguais e false se forem diferentes.
	 * @return boolean
	 */
	
	public boolean equals(Hora hora)
	{
		if(this.minuto != hora.getMinuto())
		{
			return false;
		}
		else
		{
			if(this.hora != hora.getHora())
			{
				return false;
			}
		}
		return true;
	}
}