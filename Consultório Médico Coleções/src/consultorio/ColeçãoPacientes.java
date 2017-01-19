/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe para coleçãode objetos do tipo Paciente.
 */

package consultorio;

import java.util.ArrayList;

public class ColeçãoPacientes
{
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente> ();
	
	/*
	 * Método para adidionar objeto do tipo Paciente à coleção. Retorna true se a operação for concluída com sucesso e false se ocorrer algum erro.
	 * @param paciente
	 * @return boolean
	 */
	
	public boolean adicionarPaciente(Paciente paciente)
	{
		for(int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).equals(paciente))
			{					
				return false;
			}
		}
		pacientes.add(paciente);
		return true;
	}
	
	/*
	 * Método para pesquisar um paciente pelo número do documento. Retorna o Paciente encontrado.
	 * @param documento
	 * @return Paciente
	 */
	
	public Paciente pesquisaPeloDocumento(String documento)
	{
		int i, flag = -1;
		for(i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).getDocumento().equals(documento))
			{
				flag = i;
				break;
			}
		}
		if(flag != -1)
		{
			return pacientes.get(flag);
		}
		else
		{
			return null;
		}
	}
	
	/*
	 * Método para remover um paciente pelo número do documento. Retorna true se a operação for concluída com sucesso e false se ocorrer algum erro.
	 */
	
	public boolean removePeloDocumento(String documento)
	{
		for(int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).getDocumento().equals(documento))
			{
				pacientes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Método para calcular a quantidade de pacientes por sexo determinado. Retorna a quantidade.
	 * @param sexo
	 * @return int
	 */
	
	public int qtdPacientesPorSexo(String sexo)
	{
		int cont = 0;
		for(int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).getSexo().equals(sexo))
			{
				cont++;
			}
		}
		return cont;
	}
	
	/*
	 * Método para listar os pacientes com endereço cadastrado. Retorna a quantidade desses pacientes.
	 * @return int
	 */
	
	public int listagemPacientesComEndereço()
	{
		int cont = 0;
		for(int i = 0; i < pacientes.size(); i++)
		{
			if(!pacientes.get(i).getEndereco().getBairro().equals(null))
			{
				System.out.println(pacientes.get(i).toString());
				cont++;
			}
		}
		return cont;
	}
	
	/*
	 * Método para listar pacientes maiores de 60 anos. Retorna a quantidade desses pacientes.
	 * @return int
	 */
	
	public int listagemDePacientesMaioresDe60anos()
	{
		int cont = 0;
		for(int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).calcIdade() > 60)
			{
				System.out.println(pacientes.get(i).toString());
				cont++;
			}
		}
		return cont;
	}
}
