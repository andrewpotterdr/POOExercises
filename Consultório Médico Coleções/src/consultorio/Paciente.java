/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Classe para simular os campos de um paciente.
 */

package consultorio;

import java.util.GregorianCalendar;
import java.lang.Character;

public class Paciente
{
	private String documento;
	private String nome;
	private String sexo;
	private Endereço endereco;
	private Data dataNasc;
	
	/*
	 * Método para adquirir o número do documento do paciente.
	 * @return String
	 */
	
	public String getDocumento()
	{
		return this.documento;
	}
	
	/*
	 * Método para adquirir o nome do paciente.
	 * @return String
	 */
	
	public String getNome()
	{
		return this.nome;
	}
	
	/*
	 * Método para adquirir o sexo do paciente.
	 * @return String
	 */
	
	public String getSexo()
	{
		return this.sexo;
	}
	
	/*
	 * Método para adquirir o endereço do paciente.
	 * @return Endereço
	 */
	
	public Endereço getEndereco()
	{
		return this.endereco;
	}
	
	/*
	 * Método para adquirir a data de nascimento do paciente.
	 * @return Data
	 */
	
	public Data getDataNasc()
	{
		return this.dataNasc;
	}
	
	/*
	 * Método para formatar o nome do paciente.
	 * @return String
	 */
	
	public String nomeFormatado()
	{
		String nomeFormatado = "";
		int espaco = -1;
		for(int i = this.nome.length() - 1; i >= 0; i--)
		{
			if(Character.isLetter(this.nome.charAt(i)))
			{
				while(this.nome.charAt(i) != ' ')
				{
					nomeFormatado = this.nome.charAt(i) + nomeFormatado;
					i--;
				}
				espaco = i;
				nomeFormatado = nomeFormatado + ",";
			}
			break;
		}
		for(int i = 0; i < espaco; i++)
		{
			if(i == 0)
			{
				if(this.nome.charAt(i) != ' ')
				{
					nomeFormatado = nomeFormatado + " " + this.nome.charAt(i) + ".";
				}
			}
			else
			{
				if(this.nome.charAt(i-1) == ' ' && Character.isLetter(this.nome.charAt(i)))
				{
					nomeFormatado = nomeFormatado + " " + this.nome.charAt(i) + ".";
				}
			}
		}
		return nomeFormatado;
	}
	
	/*
	 * Método para calcular a idade do paciente. Retorna a idade do paciente.
	 * @return int
	 */
	
	public int calcIdade()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		int idade;
		int diaAtual = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mesAtual = calendar.get(GregorianCalendar.MONTH);
		int anoAtual = calendar.get(GregorianCalendar.YEAR);
		int diaNasc = dataNasc.getDia();
		int mesNasc = dataNasc.getMes();
		int anoNasc = dataNasc.getAno();
		idade = anoAtual - anoNasc;
		if(mesAtual < mesNasc)
		{
			idade--;
		}
		else
		{
			if(mesAtual == mesNasc)
			{
				if(diaAtual < diaNasc)
				{
					idade--;
				}
			}
		}
		return idade;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param documento
	 * @param nome
	 * @param sexo
	 * @param endereço
	 * @param dataNasc
	 */
	
	public Paciente(String documento, String nome, String sexo, Endereço endereco, Data dataNasc)
	{
		this.documento = documento;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
	}
	
	/*
	 * Construtor que atribui os valores passados por parâmetros aos atributos locais.
	 * @param documento
	 * @param nome
	 * @param sexo
	 * @param dataNasc
	 */
	
	public Paciente(String documento, String nome, String sexo, Data dataNasc)
	{
		this.documento = documento;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
	}
	
	/*
	 * Método para comparar um objeto do tipo Paciente com o objeto local. Retorna true se os objetos forem iguais e false se forem diferentes.
	 * @return boolean
	 */
	
	public boolean equals(Paciente paciente)
	{
		if(!this.documento.equals(paciente.getDocumento()))
		{
			return false;
		}
		return true;
	}
	
	/*
	 * Método para compilar os dados de um paciente em String.
	 * @return String
	 */
	
	public String toString()
	{
		if(this.endereco == null)
		{
			return "Paciente\nDocumento: " + this.documento + "\nNome: " + nomeFormatado() + "\nSexo: " + this.sexo + "\nData de Nascimento: " + this.dataNasc + "\nEndereço: Não registrado";
		}
		return "Paciente\nDocumento: " + this.documento + "\nNome: " + nomeFormatado() + "\nSexo: " + this.sexo + "\nData de Nascimento: " + this.dataNasc + "\nEndereço:\n" + this.endereco.toString();
	}
}
