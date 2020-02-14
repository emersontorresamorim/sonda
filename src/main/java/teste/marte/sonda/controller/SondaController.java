package teste.marte.sonda.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.helper.SondaHelper;
import teste.marte.sonda.service.SondaService;

@RestController
@RequestMapping("/sonda")
public class SondaController {

	@Autowired
	private SondaHelper helper;

	@Autowired
	private SondaService service;

	@PostMapping("/executar")
	public List<String> executar(@RequestBody EntradaDTO entrada) {
		Map<Sonda, List<IComando>> sondasParaProcessar = new LinkedHashMap<>();

		Planalto planalto = helper.getPlanalto(entrada);

		entrada.getSondas().forEach(sondaDTO -> {
			Sonda sonda = helper.getSonda(sondaDTO, planalto);
			List<IComando> comandos = helper.getComandos(sondaDTO);
			sondasParaProcessar.put(sonda, comandos);
		});

		return service.executar(sondasParaProcessar);
	}
}
