package SisVet;

/** Classe que mostra o comportamento de uma consulta
 *  @author Francisco Petrônio Alencar de Medeiros
 *  @version 1.0
 */

import java.util.*;

public class Consulta{

	Animal animal;
	String data;

	public Consulta(Animal animal, String data){

		this.animal = animal;
		this.data = data;

	}

	public String getData(){

		return data;

	}

	public void exibir(){

		System.out.println("INFORMAÇÕES SOBRE A CONSULTA");
		animal.exibir();
		System.out.println("Data da consulta: " + data);

	}

}
