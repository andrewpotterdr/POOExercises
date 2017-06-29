package SisVet;

/** Esta classe representa um cachorro, suas características e comportamentos
 *  @author Francisco Petronio Alencar de Medeiros
 *  @version 1.0
 */

 import java.util.*;


 public class Cachorro implements Animal{

 /** Declaração dos atributos da classe */

 	private String nome;
 	private String dono;
 	private int idade;
 	private int sexo;
	private static final String[] sexos = {"","Feminino","Masculino"};

 /** Construtor */

 	public Cachorro(String nome,String dono,int idade,int sexo){

		this.nome = nome;
		this.dono = dono;
		this.idade = idade;
		this.sexo = sexo;

	}
	
	public String getNome(){

		return nome;

	}

	public String getDono(){

		return dono;

	}

	public int getIdade(){

		return idade;

	}

	public int getSexo(){

		return sexo;

	}

	public void setDono(String dono){

		this.dono = dono;

	}

	public void setSexo(int sexo){

		this.sexo = sexo;

	}

	public void exibir(){

		System.out.println("Informações sobre o CACHORRO");
		System.out.println("Nome:  " + nome);
		System.out.println("Dono:  " + dono);
		System.out.println("Sexo:  " + sexos[sexo]);
		System.out.println("Idade: " + idade);

	}


 }
