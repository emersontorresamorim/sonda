package teste.marte.sonda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;
import teste.marte.sonda.service.SondaService;

@SpringBootTest
public class SondaServiceTest {

	@Autowired
	private SondaService service;
	
	@Test
	public void deveExecutarComandosDasSondasComSucesso() {
		List<SondaDTO> sondasDTO = new ArrayList<>();
		sondasDTO.add(new SondaDTO("0 0 N", "MMMDMMMDMM"));
		sondasDTO.add(new SondaDTO("3 0 O", "MDMMEMEMM"));
		EntradaDTO entrada = new EntradaDTO("4 4", sondasDTO);
		
		List<SondaDTO> sondasAposMovimentacao = service.executar(entrada);
		
		assertEquals("3 1 S", sondasAposMovimentacao.get(0).getSonda());
		assertEquals("1 0 S", sondasAposMovimentacao.get(1).getSonda());
	}
}
