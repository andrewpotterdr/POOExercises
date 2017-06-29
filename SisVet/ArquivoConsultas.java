package SisVet;

/** Classe que mostra o comportamento de uma consulta
 *  @author Francisco Petrônio Alencar de Medeiros
 *  @version 1.0
 */

import java.util.*;

public class ArquivoConsultas{

	Vector consultas;

	public ArquivoConsultas(){

		consultas = new Vector();

	}

	public void nova(Consulta consulta){

		consultas.add(consulta);

	}

	public Vector pesquisar(String data) throws ExcecaoDeAnimal{

		Iterator it = consultas.iterator();
		Vector consultasPesquisadas = new Vector();

		if (!it.hasNext())
			throw new ExcecaoDeAnimal("Não existem consultas agendadas");

		while (it.hasNext()){
			
			Consulta c = (Consulta)it.next();
			if (c.getData() == data)
				consultasPesquisadas.add(c);

		}

		return consultasPesquisadas;
	}

}
