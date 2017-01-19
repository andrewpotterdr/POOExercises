/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe de consulta simulando seus campos.
 */

package consultorio;

public class Consulta
{
	private Paciente paciente;
	private Médico medico;
	private Data data;
	private Hora hora;
	
	/*
	 * Método para adquirir os dados do paciente da consulta.
	 * @return Paciente
	 */
	
	public Paciente getPaciente()
	{
		return this.paciente;
	}
	
	/*
	 * Método para adquirir os dados do médico da consulta
	 * @return Médico
	 */
	
	public Médico getMedico()
	{
		return this.medico;
	}
	
	/*
	 * Método para adquirir os dados da data da consulta.
	 * @return Data
	 */
	
	public Data getData()
	{
		return this.data;
	}
	
	/*
	 * Método para adquirir os dados da hora da consulta.
	 * @return Hora
	 */
	
	public Hora getHora()
	{
		return this.hora;
	}
	
	/*
	 * Método para compilar os dados de uma consulta em String.
	 * @return String
	 */
	
	public String toString()
	{
		if(hora == null)
		{
			return "Consulta\nPaciente: " + this.paciente + "\nMédico: " + this.medico + "\nData: " + this.data;
		}
		else
		{
			return "Consulta\nPaciente: " + this.paciente + "\nMédico: " + this.medico + "\nData: " + this.data + "\nHora: " + this.hora;
		}
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param paciente
	 * @param medico
	 * @param data
	 * @param hora
	 */
	
	public Consulta(Paciente paciente, Médico medico, Data data, Hora hora)
	{
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
		this.hora = hora;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param paciente
	 * @param medico
	 * @param data
	 */
	
	public Consulta(Paciente paciente, Médico medico, Data data)
	{
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}
	
	/*
	 * Método para comparar um objeto do tipo Consulta com o objeto local. Retorna true se os objetos forem iguais e false se forem diferentes.
	 * @param consulta
	 * @return boolean
	 */

	public boolean equals(Consulta consulta)
	{
		if(!this.data.equals(consulta.data))
		{
			return false;
		}
		else
		{
			if(!this.hora.equals(consulta.getHora()))
			{
				return false;
			}
			else
			{
				if(this.medico.equals(consulta.getMedico()) || this.paciente.equals(consulta.getPaciente()))
				{
					return true;
				}
			}
		}
		return true;
	}
}
