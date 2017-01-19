/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe para coleção de objetos do tipo Médico.
 */

package consultorio;

import java.util.ArrayList;

public class ColeçãoMédicos
{
	private ArrayList<Médico> medicos = new ArrayList<Médico> ();
	
	/*
	 * Método para adicionar um médico à coleção. Retorna true se conseguir concluir a operação com sucesso e false se ocorrer algum erro.
	 * @param medico
	 * @return boolean
	 */
	
	public boolean adicionarMédico(Médico medico)
	{
		for(int i = 0; i < medicos.size(); i++)
		{
			if(medicos.get(i).equals(medico))
			{
				return false;
			}
		}
		medicos.add(medico);
		return true;
	}
	
	/*
	 * Método para pesquisar um médico pelo seu CRM. Retorna o objeto do tipo Médico.
	 * @param CRM
	 * @return Médico
	 */
	
	public Médico pesquisaPeloCRM(String CRM)
	{
		int i, flag = -1;
		for(i = 0; i < medicos.size(); i++)
		{
			if(medicos.get(i).getCRM().equals(CRM))
			{
				flag = i;
				break;
			}
		}
		if(flag != -1)
		{
			return medicos.get(flag);
		}
		else
		{
			return null;
		}
	}
	
	/*
	 * Método para pesquisar médicos por partes do nome. Retorna uma coleção de médicos que tem a parte do nome pesquisado.
	 * @param nome
	 * @return ArrayList<Médico>
	 */
	
	public ArrayList<Médico> pesquisaMédicoPorParteDoNome(String nome)
	{
		ArrayList<Médico> medicosPesquisa = new ArrayList<Médico> ();
		for(int i = 0; i < medicos.size(); i++)
		{
			if(medicos.get(i).getNome().contains(nome))
			{
				medicosPesquisa.add(medicos.get(i));
			}
		}
		return medicosPesquisa;
	}
}
