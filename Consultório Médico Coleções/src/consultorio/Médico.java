/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe para simular os dados de um médico.
 */

package consultorio;

public class Médico
{
	private String CRM;
	private String nome;
	private String especialidade;
	
	/*
	 * Método para adquirir o CRM do médico.
	 * @return String
	 */
	
	public String getCRM()
	{
		return this.CRM;
	}
	
	/*
	 * Método para adquirir o nome do médico.
	 * @return String
	 */
	
	public String getNome()
	{
		return this.nome;
	}
	
	/*
	 * Método para adquirir a especialidade do médico.
	 * @return String
	 */
	
	public String getEspecialidade()
	{
		return this.especialidade;
	}
	
	/*
	 * Método para compilar os dados do médico em uma String.
	 * @return String
	 */
	
	public String toString()
	{
		if(this.especialidade == null)
		{
			return "Médico\nCRM: " + this.CRM + "\nNome: " + this.nome + "\nEspecialidade: Nenhuma";
		}
		return "Médico\nCRM: " + this.CRM + "\nNome: " + this.nome + "\nEspecialidade: " + this.especialidade;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param CRM
	 * @param nome
	 * @param especialidade
	 */
	
	public Médico(String CRM, String nome, String especialidade)
	{
		this.CRM = CRM;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param CRM
	 * @param nome
	 */
	
	public Médico(String CRM, String nome)
	{
		this.CRM = CRM;
		this.nome = nome;
	}
	
	/*
	 * Método para comparar um objeto do tipo Médico com o objeto local. Retorna true se os objetos forem iguais e false se forem diferentes.
	 */
	
	public boolean equals(Médico medico)
	{
		if(!this.CRM.equals(medico.getCRM()))
		{
			return false;
		}
		return true;
	}
}

