package teste.marte.sonda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.comando.MoverComando;
import teste.marte.sonda.comando.VirarDireitaComando;
import teste.marte.sonda.comando.VirarEsquerdaComando;
import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.helper.SondaHelper;

@SpringBootTest
public class SondaHelperTest {

	@Autowired
	private SondaHelper helper;

	@Test
	public void deveGerarPlanalto() {
		EntradaDTO entrada = new EntradaDTO("4 4", new ArrayList<>());

		Planalto planalto = helper.getPlanalto(entrada);

		assertEquals(4, planalto.getEixoX());
		assertEquals(4, planalto.getEixoY());
	}

	@Test
	public void deveGerarSonda() {
		Sonda sonda = helper.getSonda(new SondaDTO("2 1 L"), new Planalto(3, 3));

		assertEquals(3, sonda.getPlanalto().getEixoX());
		assertEquals(3, sonda.getPlanalto().getEixoY());
		assertEquals(2, sonda.getPosicao().getEixoX());
		assertEquals(1, sonda.getPosicao().getEixoY());
		assertEquals(Direcao.LESTE, sonda.getDirecao());
	}

	@Test
	public void deveGerarComandos() {
		List<IComando> comandos = helper.getComandos(new SondaDTO("1 1 N", "MDMEMEMMEM"));

		assertEquals(10, comandos.size());
		assertEquals(MoverComando.class, comandos.get(0).getClass());
		assertEquals(VirarDireitaComando.class, comandos.get(1).getClass());
		assertEquals(MoverComando.class, comandos.get(2).getClass());
		assertEquals(VirarEsquerdaComando.class, comandos.get(3).getClass());
		assertEquals(MoverComando.class, comandos.get(4).getClass());
		assertEquals(VirarEsquerdaComando.class, comandos.get(5).getClass());
		assertEquals(MoverComando.class, comandos.get(6).getClass());
		assertEquals(MoverComando.class, comandos.get(7).getClass());
		assertEquals(VirarEsquerdaComando.class, comandos.get(8).getClass());
		assertEquals(MoverComando.class, comandos.get(9).getClass());
	}
}
