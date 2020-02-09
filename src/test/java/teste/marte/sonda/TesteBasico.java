package teste.marte.sonda;

import org.junit.jupiter.api.Test;

import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.enumeration.Lado;

public class TesteBasico {

	@Test
	public void teste() {
		// Cenário 1: 5 5 - 1 2 N - LMLMLMLMM - 1 3 N

		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(1, 2, Direcao.NORTE, planalto);

		System.out.println(sonda.toString());

		sonda.virar(Lado.ESQUERDO);

		System.out.println(sonda.toString());

		sonda.mover();

		System.out.println(sonda.toString());

		sonda.virar(Lado.ESQUERDO);

		System.out.println(sonda.toString());

		sonda.mover();

		System.out.println(sonda.toString());

		sonda.virar(Lado.ESQUERDO);

		System.out.println(sonda.toString());

		sonda.mover();

		System.out.println(sonda.toString());

		sonda.virar(Lado.ESQUERDO);

		System.out.println(sonda.toString());

		sonda.mover();

		System.out.println(sonda.toString());
		
		sonda.mover();

		System.out.println(sonda.toString());

	}
}
