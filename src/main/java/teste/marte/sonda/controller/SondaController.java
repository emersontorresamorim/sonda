package teste.marte.sonda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;
import teste.marte.sonda.service.SondaService;

@RestController
@RequestMapping("/sonda")
public class SondaController {

	@Autowired
	private SondaService service;

	@PostMapping("/executar")
	public List<SondaDTO> executar(@RequestBody EntradaDTO entrada) {
		return service.executar(entrada);
	}
}
