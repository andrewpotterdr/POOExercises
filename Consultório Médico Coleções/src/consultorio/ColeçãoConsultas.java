/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe para coleção de objetos do tipo Consulta.
 */

package consultorio;

import java.util.ArrayList;

public class ColeçãoConsultas
{	
	public ArrayList<Consulta> consultas = new ArrayList<Consulta> ();
	
	/*
	 * Método para adicionar uma consulta à coleção. Retorna true se a operação der certo e false se houver falha.
	 * @param consulta
	 * @return booelan
	 */
	
	public boolean adicionaConsulta(Consulta consulta)
	{
		for(int i = 0; i < consultas.size(); i++)
		{
			if(!consultas.get(i).equals(consulta))
			{
				return false;
			}
		}
		consultas.add(consulta);
		return true;
	}
	
	/*
	 * Método para calcular a quantidade de consultas marcadas em determinada data. Retorna a quantidade de consultas.
	 * @param data
	 * @return int 
	 */
	
	public int qtdConsultasData(Data data)
	{
		int cont = 0;
		for(int i = 0; i < consultas.size(); i++)
		{
			if(consultas.get(i).getData().equals(data))
			{
				cont++;
			}
		}
		return cont;
	}
	
	/*
	 * Método para listar todas as consultas marcadas. Retorna a quantidade de consultas.
	 * @return int
	 */
	
	public int listagemConsultas()
	{
		int i;
		for(i = 0; i < consultas.size(); i++)
		{
			System.out.println(consultas.get(i).toString());
		}
		return i;
	}
	
	/*
	 * Método para calcular as consultas marcadas com um médico específico. Retorna a quantidade de consultas.
	 * @param medico
	 * @return int
	 */
	
	public int qtdConsultasPorMédico(Médico medico)
	{
		int cont = 0;
		for(int i = 0; i < consultas.size(); i++)
		{
			if(consultas.get(i).getMedico().equals(medico))
			{
				cont++;
			}
		}
		return cont;
	}
	
	/*
	 * Método para listar consultas marcadas para um paciente específico. Retorna a quantidade de consultas.
	 * @param paciente
	 * @return int
	 */
	
	public int listaConsultasPorPaciente(Paciente paciente)
	{
		int cont = 0;
		for(int i = 0; i < consultas.size(); i++)
		{
			if(consultas.get(i).getPaciente().equals(paciente))
			{
				System.out.println(consultas.get(i).toString());
				cont++;
			}
		}
		return cont;
	}
}
