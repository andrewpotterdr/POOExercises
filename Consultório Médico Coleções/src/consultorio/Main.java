/*
 * @author Michael Almeida da Franca Monteiro
 * @version 1.0
 * Aplicação para administração de um consultório médico.
 */

package consultorio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main
{
	/*
	 * Método principal por onde a aplicação começa, chamando os outros métodos a serem executados.
	 */
	public static void main(String []args)
	{
		ColeçãoConsultas colcon = new ColeçãoConsultas();
		ColeçãoMédicos colmed = new ColeçãoMédicos();
		ColeçãoPacientes colpac = new ColeçãoPacientes();
		GregorianCalendar calendar = new GregorianCalendar();
		Scanner input = new Scanner(System.in);
		System.out.println("Bem-vindo ao sistema de administração de consultórios médicos!");
		while(menu(input,colcon,colmed,colpac,calendar) != 1);
	}
	
	/*
	 * Método menu, pelo qual são chamados os 3 submenus de consultas, médicos e pacientes respectivamente. Retorna 1 se for escolhida a função Encerrar Aplicação e se encerra o programa. Retorna 0 se precisar voltar novamente ao menu.
	 * @param input
	 * @param colcon
	 * @param colmed
	 * @param colpac
	 * @param calendar
	 * @return int
	 */
	
	private static int menu(Scanner input, ColeçãoConsultas colcon, ColeçãoMédicos colmed, ColeçãoPacientes colpac, GregorianCalendar calendar)
	{
		int res;
		System.out.println("Que menu deseja acessar agora?");
		System.out.println("1 - Menu de Consultas\n" +
						   "2 - Menu de Médicos\n" +
						   "3 - Menu de Pacientes\n" + 
						   "4 - Encerrar Aplicação");
		switch(lerOpcao(input,1,4))
		{
			case 1:
				res = menuConsultas(input,colcon,colmed,colpac,calendar);
				while(res != 2)
				{
					res = menuConsultas(input,colcon,colmed,colpac,calendar);
				}
				return 0;
			case 2:
				res = menuMédicos(input,colmed);
				while(res != 2)
				{
					res = menuMédicos(input,colmed);
				}
				return 0;
			case 3:
				res = menuPacientes(input,colpac,calendar);
				while(res != 2)
				{
					res = menuPacientes(input,colpac,calendar);
				}
				return 0;
		}
		return 1;
	}
	
	/*
	 * Método menu de consultas para acessar as opções de consulta. Retorna 1 se tiver sucesso, 0 se ocorrer algum erro e 2 para retornar e reexecutar o mesmo menu.
	 * @param input
	 * @param colcon
	 * @param colmed
	 * @param colpac
	 * @param calendar
	 * @return int
	 */
	
	private static int menuConsultas(Scanner input, ColeçãoConsultas colcon, ColeçãoMédicos colmed, ColeçãoPacientes colpac, GregorianCalendar calendar)
	{
		System.out.println("Que ação deseja executar agora?");
		System.out.println("1 - Marcar consulta\n" + 
						   "2 - Mostrar quantidade de consultas em determinada data\n" + 
						   "3 - Listar todas as consultas\n" + 
						   "4 - Mostrar quantidade de consultas de determinado médico\n" + 
						   "5 - Listar consultas de determinado paciente\n" + 
						   "6 - Retornar ao menu anterior");
		switch(lerOpcao(input,1,6))
		{
			case 1:
				Consulta consulta;
				System.out.println("Digite o número de documento do paciente a ser consultado: ");
				String documentoPaciente = input.nextLine();
				Paciente paciente = colpac.pesquisaPeloDocumento(documentoPaciente);
				if(paciente == null)
				{
					System.out.println("Paciente não cadastrado. Tecle 'ENTER' para continuar.");
					input.nextLine();
					return 0;
				}
				System.out.println("Digite o nome do médico ou seu CRM: ");
				String nomeCRMMédico = input.nextLine();
				Médico medico = colmed.pesquisaPeloCRM(nomeCRMMédico);
				if(medico == null)
				{
					ArrayList<Médico> medicos = colmed.pesquisaMédicoPorParteDoNome(nomeCRMMédico);
					if(medicos.size() > 1)
					{
						int i;
						for(i = 0; i < medicos.size(); i++)
						{
							System.out.println((i + 1) + medicos.get(i).getNome());
						}
						medico = medicos.get(lerOpcao(input,1,i) - 1);
					}
					else
					{
						if(medicos.size() == 1)
						{
							medico = medicos.get(0);
						}
						else
						{
							if(medicos.size() < 1)
							{
								System.out.println("Médico não cadastrado. Tecle 'ENTER' para continuar.");
								input.nextLine();
								return 0;
							}
						}
					}
				}
				System.out.println("Digite o ano em que será realizada a consulta: ");
				int ano = lerOpcao(input,calendar.YEAR,2050);
				System.out.println("Digite o mês em que será realizada a consulta: ");
				int mes = lerOpcao(input,1,12);
				System.out.println("Digite o dia em que será realizada a consulta: ");
				int dia = lerOpcao(input,1,maxDiasDoMes(mes,calendar,ano));
				Data data = new Data(dia,mes,ano);
				System.out.println("Deseja marcar uma hora? ('0' Não/'1' Sim)");
				if(lerOpcao(input,0,1) == 1)
				{
					System.out.println("Digite a hora da consulta: (Exemplo: '16')");
					int hora = lerOpcao(input,0,23);
					System.out.println("Digite o minuto da consulta: (Exemplo: '30')");
					int minuto = lerOpcao(input,0,59);
					Hora horar = new Hora(hora,minuto);
					consulta = new Consulta(paciente,medico,data,horar);
				}
				else
				{
					consulta = new Consulta(paciente,medico,data);
				}
				if(colcon.adicionaConsulta(consulta))
				{
					System.out.println("Consulta marcada com sucesso!");
				}
				else
				{
					System.out.println("Consulta já marcada nessa data, nesse horário com o esse médico e/ou paciente.");
				}
			break;
			case 2:
				calendar = new GregorianCalendar();
				System.out.println("Digite o ano da data que será consultada: ");
				ano = lerOpcao(input,calendar.YEAR,2050);
				System.out.println("Digite o mês da data que será consultada: ");
				mes = lerOpcao(input,1,12);
				System.out.println("Digite o dia da data que será consultada: ");
				dia = lerOpcao(input,1,maxDiasDoMes(mes,calendar,ano));
				data = new Data(dia,mes,ano);
				if(colcon.qtdConsultasData(data) == 0)
				{
					System.out.println("Não há consultas marcadas para esta data.");
				}
				else
				{
					System.out.println("Há " + colcon.qtdConsultasData(data) + " consultas marcadas para esta data.");
				}
			break;
			case 3:
				System.out.println("Lista de todas as consultas marcadas");
				if(colcon.listagemConsultas() == 0)
				{
					System.out.println("Não há consultas marcadas.");
				}
			break;
			case 4:
				System.out.println("Digite o nome do médico ou seu CRM: ");
				nomeCRMMédico = input.nextLine();
				medico = colmed.pesquisaPeloCRM(nomeCRMMédico);
				if(medico == null)
				{
					ArrayList<Médico> medicos = colmed.pesquisaMédicoPorParteDoNome(nomeCRMMédico);
					if(medicos.size() > 1)
					{
						int i;
						for(i = 0; i < medicos.size(); i++)
						{
							System.out.println((i + 1) + medicos.get(i).toString());
						}
						System.out.println("Digite o número do médico a ser selecionado: ");
						medico = medicos.get(lerOpcao(input,1,i) - 1);
					}
					else
					{
						if(medicos.size() == 1)
						{
							medico = medicos.get(0);
						}
						else
						{
							if(medicos.size() < 1)
							{
								System.out.println("Médico não cadastrado. Tecle 'ENTER' para continuar");
								input.nextLine();
								return 0;
							}
						}
					}
				}
				if(colcon.qtdConsultasPorMédico(medico) == 0)
				{
					System.out.println("Não há consultas marcadas com esse médico.");
				}
				else
				{
					System.out.println("Há " + colcon.qtdConsultasPorMédico(medico) + " consultas marcadas com esse médico");
				}
			break;
			case 5:
				System.out.println("Digite o número de documento do paciente a ser consultado: ");
				documentoPaciente = input.nextLine();
				paciente = colpac.pesquisaPeloDocumento(documentoPaciente);
				if(paciente == null)
				{
					System.out.println("Paciente não cadastrado. Tecle 'ENTER' para continuar.");
					input.nextLine();
					return 0;
				}
				System.out.println("Lista de consultas marcadas para o paciente " + paciente.nomeFormatado() + ":");
				if(colcon.listaConsultasPorPaciente(paciente) == 0)
				{
					System.out.println("Não há consultas marcadas para esse paciente.");
				}
			break;
			case 6:
				return 2;
		}
		return 1;
	}
	
	/*
	 * Método menu de médicos, que acessa as opções relacionadas a médicos, Retorna 1 se tiver sucesso, 0 se ocorrer algum erro e 2 para retornar e reexecutar o mesmo menu.
	 * @param input
	 * @param colmed
	 * @return int 
	 */
	
	private static int menuMédicos(Scanner input, ColeçãoMédicos colmed)
	{
		Médico medico = null;
		System.out.println("Que ação deseja executar agora?");
		System.out.println("1 - Cadastrar médico\n" + 
						   "2 - Pesquisar médico pelo CRM\n" + 
						   "3 - Pesquisar médico por parte do nome\n" + 
						   "4 - Retornar ao menu anterior");
		switch(lerOpcao(input,1,4))
		{
			case 1:
				System.out.println("Digite o CRM do médico a ser cadastrado: ");
				String CRM = input.nextLine();
				System.out.println("Digite o nome completo do médico a ser cadastrado: ");
				String nome = input.nextLine();
				System.out.println("O médico tem uma especialidade? ('0' - não/'1' - sim)");
				if(lerOpcao(input,0,1) == 0)
				{
					medico = new Médico(CRM,nome);
				}
				else
				{
					System.out.println("Qual é a principal especialidade desse médico?");
					String especialidade = input.nextLine();
					medico = new Médico(CRM,nome,especialidade);
				}
				if(colmed.adicionarMédico(medico))
				{
					System.out.println("Médico cadastrado com sucesso!");
				}
				else
				{
					System.out.println("Médico já está cadastrado no sistema. Tecle 'ENTER' para continuar:");
					input.nextLine();
				}
			break;
			case 2:
				System.out.println("Digite o CRM do médico a ser pesquisado:");
				CRM = input.nextLine();
				medico = colmed.pesquisaPeloCRM(CRM);
				if(medico == null)
				{
					System.out.println("Médico não cadastrado. Tecle 'ENTER' para continuar.");
					input.nextLine();
				}
				else
				{
					System.out.println(medico.toString());
				}
			break;
			case 3:
				System.out.println("Digite o nome do médico: " );
				nome = input.nextLine();
				ArrayList<Médico> medicos = colmed.pesquisaMédicoPorParteDoNome(nome);
				if(medicos.size() > 1)
				{
					int i;
					for(i = 0; i < medicos.size(); i++)
					{
						System.out.println((i + 1) + "-" + medicos.get(i).toString());
					}
					System.out.println("Digite o número do médico a ser selecionado: ");
					medico = medicos.get(lerOpcao(input,1,i) - 1);
					System.out.println(medico.toString());
				}
				else
				{
					if(medicos.size() == 1)
					{
						medico = medicos.get(0);
						System.out.println(medico.toString());
					}
					else
					{
						if(medicos.size() < 1)
						{
							System.out.println("Médico não cadastrado. Tecle 'ENTER' para continuar.");
							input.nextLine();
							return 0;
						}
					}
				}
			break;
			case 4:
				return 2;
		}
		return 1;
	}
	
	/*
	 * Método menu de pacientes, que acessa as operações relacionadas aos pacientes. Retorna 1 se tiver sucesso, 0 se ocorrer algum erro e 2 para retornar e reexecutar o mesmo menu.
	 * @param input
	 * @param colpac
	 * @param calendar
	 * @return int 
	 */
	
	private static int menuPacientes(Scanner input, ColeçãoPacientes colpac, GregorianCalendar calendar)
	{
		Paciente paciente = null;
		System.out.println("Que ação deseja executar agora?");
		System.out.println("1 - Cadastrar paciente\n" + 
						   "2 - Pesquisar paciente\n" + 
						   "3 - Remover paciente\n" + 
						   "4 - Mostrar quantidade de pacientes por sexo\n" + 
						   "5 - Listar pacientes com endereço\n" + 
						   "6 - Listar pacientes acima de 60 anos\n" + 
						   "7 - Retornar ao menu anterior");
		switch(lerOpcao(input,1,7))
		{
			case 1:
				System.out.println("Digite o número do documento do paciente a ser cadastrado: ");
				String documento = input.nextLine();
				System.out.println("Digite o nome do paciente a ser cadastrado: ");
				String nome = input.nextLine();
				System.out.println("Digite o sexo do paciente a ser cadastrado: ('Masculino'/'Feminino')");
				String sexo = lerSexo(input);
				System.out.println("Digite o ano de nascimento do paciente a ser cadastrado: ");
				Data data = lerData(input,calendar);
				System.out.println("Deseja informar o endereço? ('0' não/'1' sim)");
				if(lerOpcao(input,0,1) == 0)
				{
					paciente = new Paciente(documento,nome,sexo,data);
				}
				else
				{
					Endereço endereco = lerEndereco(input);
					paciente = new Paciente(documento,nome,sexo,endereco,data);
				}
				if(colpac.adicionarPaciente(paciente))
				{
					System.out.println("Paciente cadastrado com sucesso.");
				}
				else
				{
					System.out.println("O paciente já está cadastrado no sistema. Tecle 'ENTER' para continuar.");
					input.nextLine();
					return 0;
				}
			break;
			case 2:
				System.out.println("Digite o número do documento do paciente a ser pesquisado: ");
				documento = input.nextLine();
				paciente = colpac.pesquisaPeloDocumento(documento);
				if(paciente == null)
				{
					System.out.println("Esse paciente não está cadastrado. Tecle 'ENTER' para continuar:");
					input.nextLine();
				}
				else
				{
					System.out.println(paciente.toString());
				}
			break;
			case 3:
				System.out.println("Digite o número do documento do paciente a ser removido: ");
				documento = input.nextLine();
				if(colpac.removePeloDocumento(documento))
				{
					System.out.println("Paciente removido do sistema com sucesso!");
				}
				else
				{
					System.out.println("Paciente não cadastrado no sistema. Tecle 'ENTER' para continuar:");
					input.nextLine();
				}
			break;
			case 4:
				System.out.println("Digite o sexo a ser analisado: ('Masculino'/'Feminino')");
				sexo = lerSexo(input);
				int qtd = colpac.qtdPacientesPorSexo(sexo);
				if(qtd == 0)
				{
					System.out.println("Não há pacientes do sexo " + sexo.toLowerCase() + " cadastrados no sistema.");
				}
				else
				{
					System.out.println("Há " + qtd + " pacientes do sexo " + sexo.toLowerCase() + " cadastrados no sistema.");
				}
			break;
			case 5:
				System.out.println("Lista de pacientes com endereço cadastrados");
				if(colpac.listagemPacientesComEndereço() == 0)
				{
					System.out.println("Não há pacientes com endereço cadastrados.");
				}
			break;
			case 6:
				System.out.println("Lista de pacientes com idade acima de 60 anos");
				if(colpac.listagemDePacientesMaioresDe60anos() == 0)
				{
					System.out.println("Não há pacientes com idade acima de 60 anos.");
				}
			break;
			case 7:
				return 2;
		}
		return 1;
	}
	
	/*
	 * Método para ler uma opção dentro de um intervalo de inteiros passados por parâmetro. Retorna a opção finalmente escolhida, após filtragem de erros.
	 * @param input
	 * @param iniciall
	 * @param finall
	 * @return int 
	 */
	
	private static int lerOpcao(Scanner input, int iniciall, int finall)
	{
		int opcao;
		if(!input.hasNextInt())
		{
			System.out.printf("Digite um número válido: \n");
			input.nextLine();
			return lerOpcao(input,iniciall,finall);
		}
		opcao = input.nextInt();
		input.nextLine();
		if(opcao < iniciall || opcao > finall)
		{
			System.out.printf("Digite um número entre '" + iniciall + "' e '" + finall + "' : \n");
			return lerOpcao(input,iniciall,finall);
		}
		return opcao;
	}
	
	/*
	 * Método para ler o sexo, retorna o sexo escolhido após filtragem de erros.
	 * @param input
	 * @return String
	 */
	
	private static String lerSexo(Scanner input)
	{
		String sexo;
		if(!input.hasNextLine())
		{
			System.out.printf("Digite 'MASCULINO'/'FEMININO': \n");
			return lerSexo(input);
		}
		sexo = input.nextLine();
		sexo = sexo.toUpperCase();
		if(!sexo.equals("MASCULINO") && !sexo.equals("FEMININO"))
		{
			System.out.printf("Digite 'MASCULINO'/'FEMININO': \n");
			return lerSexo(input);
		}
		return sexo;
	}
	
	/*
	 * Método que analisa de acordo com o ano e o mês, o número de dias que o mês possui e retorna esse valor.
	 * @param mes
	 * @param calendar
	 * @param ano
	 * @return int
	 */
	
	private static int maxDiasDoMes(int mes,GregorianCalendar calendar,int ano)
	{
		int res = 0;
		switch(mes)
		{
			case 1:
				res = 31;
			break;
			case 2:
				if(ano % 400 == 0 || ano % 4 == 0 && ano % 100 != 0)
				{
					res = 29;
				}
				else
				{
					res = 28;
				}
			break;
			case 3:
				res = 31;
			break;
			case 4:
				res = 30;
			break;
			case 5:
				res = 31;
			break;
			case 6:
				res = 30;
			break;
			case 7:
				res = 31;
			break;
			case 8:
				res = 31;
			break;
			case 9:
				res = 30;
			break;
			case 10:
				res = 31;
			break;
			case 11:
				res = 30;
			break;
			case 12:
				res = 31;
		}
		return res;
	}
	
	/*
	 * Método para ler a data e a retornar após filtragem de erros.
	 * @param input
	 * @param calendar
	 * @return Data
	 */
	
	private static Data lerData(Scanner input, GregorianCalendar calendar)
	{
		int ano = lerOpcao(input,calendar.YEAR,2050);
		System.out.println("Digite o mês de nascimento do paciente a ser cadastrado: ");
		int mes = lerOpcao(input,1,12);
		System.out.println("Digite o dia de nascimento do paciente a ser cadastrado: ");
		int dia = lerOpcao(input,1,maxDiasDoMes(mes,calendar,ano));
		return new Data(dia,mes,ano);
	}
	
	/*
	 * Método para ler o endereço e o retornar.
	 * @param input
	 * @return Endereço
	 */
	
	private static Endereço lerEndereco(Scanner input)
	{
		System.out.println("Digite o CEP do endereço do paciente a ser cadastrado: ");
		String CEP = input.nextLine();
		System.out.println("Digite o nome da rua do endereço do paciente a ser cadastrado: ");
		String rua = input.nextLine();
		System.out.println("Digite o nome do bairro do endereço do paciente a ser cadastrado: ");
		String bairro = input.nextLine();
		System.out.println("Digite o complemento do endereço do paciente a ser cadastrado: ");
		String complemento = input.nextLine();
		Endereço endereco = new Endereço(CEP,rua,bairro,complemento);
		return endereco;
	}
}
