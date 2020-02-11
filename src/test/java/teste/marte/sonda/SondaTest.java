package teste.marte.sonda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.enumeration.Lado;

public class SondaTest {

	@Test
	public void movimentacaoSondaTest() {
		/*
		 * Cenário 1:
		 * 
		 * Entrada: 
		 * 5 5 
		 * 1 2 N 
		 * LMLMLMLMM
		 * 
		 * Saída: 
		 * 1 3 N
		 */

		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(1, 2, Direcao.NORTE, planalto);

		sonda.virar(Lado.ESQUERDO);
		sonda.mover();
		sonda.virar(Lado.ESQUERDO);
		sonda.mover();
		sonda.virar(Lado.ESQUERDO);
		sonda.mover();
		sonda.virar(Lado.ESQUERDO);
		sonda.mover();
		sonda.mover();

		assertEquals(sonda.getPosicao().getEixoX(), 1);
		assertEquals(sonda.getPosicao().getEixoY(), 3);
		assertEquals(sonda.getDirecao(), Direcao.NORTE);
	}
}
