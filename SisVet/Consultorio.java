package SisVet;

/** Classe que contém um menu que possibilita manipular as outras classes do projeto
 *  @author Francisco Petrônio Alencar de Medeiros
 *  @version 1.0
 */
 public class Consultorio{

 	private Fichario fichario;
	private ArquivoConsultas consultas;
 
 	public Consultorio(){

		System.out.println("SISTEMA DO CONSULTÓRIO VETERINÁRIO - SCV");
		fichario = new Fichario();
		consultas = new ArquivoConsultas();

	}

	public void interfaceComUsuario(){

		String cmd;

		// Incluir um gato no fichário de animais

		Animal a = new Gato("Chanin","Gabriela",3,1);
		fichario.incluir(a);
		Animal a1 = new Cachorro("Rix","Gabriela",1,2);
		fichario.incluir(a1);
		Animal a2 = new Cachorro("Lua","Matheus",1,1);
		fichario.incluir(a2);

		/*
		try{
			fichario.remover("Chanin");
			fichario.exibir();
		}catch(ExcecaoDeAnimal e){System.err.println(e.getMessage());}

		*/
	
		/*
		try{
			Animal a6 = fichario.pesquisar("Lua");
			a6.exibir();
		}catch(ExcecaoDeAnimal e){System.err.println(e.getMessage());}
		*/

		Consulta c = new Consulta(a1,"18/10/2001");
		consultas.nova(c);
		c.exibir();

	} 

	public static void main(String[] args){

		Consultorio consultorio = new Consultorio();
		consultorio.interfaceComUsuario();

	}

 }
