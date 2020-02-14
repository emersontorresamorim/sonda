package teste.marte.sonda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.comando.MoverComando;
import teste.marte.sonda.comando.VirarDireitaComando;
import teste.marte.sonda.comando.VirarEsquerdaComando;
import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.service.SondaService;

@SpringBootTest
public class SondaServiceTest {

	@Autowired
	private SondaService service;

	@Test
	public void deveExecutarComandosDasSondasComSucesso() {
		Map<Sonda, List<IComando>> sondasParaProcessar = criarSondasParaProcessar();

		List<String> sondasAposMovimentacao = service.executar(sondasParaProcessar);

		assertEquals("3 1 S", sondasAposMovimentacao.get(0));
		assertEquals("1 0 S", sondasAposMovimentacao.get(1));
	}

	private Map<Sonda, List<IComando>> criarSondasParaProcessar() {
		Map<Sonda, List<IComando>> sondasParaProcessar = new LinkedHashMap<>();

		Planalto planalto = new Planalto(4, 4);

		Sonda sonda1 = new Sonda(0, 0, Direcao.NORTE, planalto);
		List<IComando> comandosSonda1 = new ArrayList<>();
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new VirarDireitaComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new VirarDireitaComando());
		comandosSonda1.add(new MoverComando());
		comandosSonda1.add(new MoverComando());

		Sonda sonda2 = new Sonda(3, 0, Direcao.OESTE, planalto);
		List<IComando> comandosSonda2 = new ArrayList<>();
		comandosSonda2.add(new MoverComando());
		comandosSonda2.add(new VirarDireitaComando());
		comandosSonda2.add(new MoverComando());
		comandosSonda2.add(new MoverComando());
		comandosSonda2.add(new VirarEsquerdaComando());
		comandosSonda2.add(new MoverComando());
		comandosSonda2.add(new VirarEsquerdaComando());
		comandosSonda2.add(new MoverComando());
		comandosSonda2.add(new MoverComando());

		sondasParaProcessar.put(sonda1, comandosSonda1);
		sondasParaProcessar.put(sonda2, comandosSonda2);

		return sondasParaProcessar;
	}
}
