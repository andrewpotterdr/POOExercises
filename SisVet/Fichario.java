package SisVet;

/** Esta classe mostra o comportamento de um fich�rio de animais. Opera��es
 *  como incluir, remover, pesquisar e exibir fichario estar�o presentes
 *  @author Francisco Petr�nio Alencar de Medeiros
 *  @version 1.0
 */

 import java.util.*;
 import java.lang.*;

 public class Fichario{

 /** Atributos da classe Fichario  */

 	private Vector animais;

	public Fichario(){

		animais = new Vector();

	}

	public void incluir(Animal a){

		animais.add(a);

	}

	public void remover(String nome) throws ExcecaoDeAnimal{

		Iterator it = animais.iterator();
		int i = 0;

		if (!it.hasNext()){
			throw new ExcecaoDeAnimal("O fich�rio est� vazio");
		}

		while (it.hasNext()){

			if (((Animal)it.next()).getNome() == nome){
				animais.remove(i);
				break;
			}

			i++;
		}

		if (i == animais.size())
			throw new ExcecaoDeAnimal("O nome requerido n�o est� no fich�rio");

	}

	public Animal pesquisar(String nome) throws ExcecaoDeAnimal{

		Iterator it = animais.iterator();

		if (!it.hasNext())
			throw new ExcecaoDeAnimal("Fich�rio vazio");


		while (it.hasNext()){

			Animal a = (Animal)it.next();
				
			if (a.getNome() == nome)
				return a; 

		}

		throw new ExcecaoDeAnimal("O fich�rio est� vazio");
	}
	
	public void exibir() throws ExcecaoDeAnimal{

		Iterator it = animais.iterator();

		if (!it.hasNext())
			throw new ExcecaoDeAnimal("O fich�rio est� vazio");

		while (it.hasNext()){

			((Animal)it.next()).exibir();

			}

		}

 }
