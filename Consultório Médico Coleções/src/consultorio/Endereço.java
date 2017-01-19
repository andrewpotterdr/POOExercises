/**
 * 
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * 
 * Classe para Endereço contendo os campos: CEP, Rua, Bairro e Complemento.
 *
 */
package consultorio;

public class Endereço
{
	private String CEP;
	private String rua;
	private String bairro;
	private String complemento;
	
	/** 
	 * O método getCEP retorna o valor da String CEP
	 * @return String
	 */
	
	public String getCEP()
	{
		return this.CEP;
	}
	
	/**
	 * O método getRua retorna o valor da String rua
	 * @return String
	 */
	
	public String getRua()
	{
		return this.rua;
	}
	
	/**
	 * O método getBairro retorna o valor da String bairro
	 * @return String
	 */
	
	public String getBairro()
	{
		return this.bairro;
	}
	
	/**
	 * O método getComplemento retorna o valor da String complemento
	 * @return String
	 */
	
	public String getComplemento()
	{
		return this.complemento;
	}
	
	/**
	 * O método setCEP seta o valor da variável CEP.
	 * @param CEP
	 */
	
	public void setCEP(String CEP)
	{
		this.CEP = CEP;
	}
	
	/**
	 * O método setRua seta o valor da variável rua
	 * @param rua
	 */
	
	public void setRua(String rua)
	{
		this.rua = rua;
	}
	
	/**
	 * O método setBairro seta o valor da variável bairro
	 * @param bairro
	 */
	
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}
	
	/**
	 * O método setComplemento seta o valor da variável complemento
	 * @param complemento
	 */
	
	public void setComplemento(String complemento)
	{
		this.complemento = complemento;
	}
	
	/**
	 * O método toString concatena em uma String os valores das variáveis 
	 */
	
	public String toString()
	{
		return "CEP: " + this.CEP + "\nRua: " + this.rua + "\nBairro: " + this.bairro + "\nComplemento: " + this.complemento;
	}
	
	/**
	 * Esse método construtor cria um objeto setando todos os campos com valores.
	 * @param CEP
	 * @param rua
	 * @param bairro
	 * @param complemento
	 */
	
	public Endereço(String CEP, String rua, String bairro, String complemento)
	{
		this.CEP = CEP;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
	}
	
	/**
	 * Esse método construtor cria um objeto sem setar nenhum campo.
	 */
	
	public Endereço()
	{
		
	}
	
	/*
	 * Esse método compara os campos da classe com outro objeto do tipo Endereço e retorna true se os endereços forem iguais, e false se forem diferentes.
	 * @return boolean
	 *
	 */
	
	public boolean equals(Endereço endereco)
	{
		if(!this.bairro.equals(endereco.getBairro()))
		{
			return false;
		}
		else
		{
			if(!this.rua.equals(endereco.getRua()))
			{
				return false;
			}
			else
			{
				if(!this.CEP.equals(endereco.getCEP()))
				{
					return false;
				}
				else
				{
					if(!this.complemento.equals(endereco.getComplemento()))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
}
