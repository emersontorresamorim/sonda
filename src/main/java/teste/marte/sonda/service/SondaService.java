package teste.marte.sonda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;
import teste.marte.sonda.helper.SondaHelper;

@Service
public class SondaService {

	@Autowired
	private SondaHelper helper;

	public List<SondaDTO> executar(EntradaDTO entrada) {
		Planalto planalto = helper.getPlanalto(entrada);

		entrada.getSondas().forEach(sondaDTO -> {
			Sonda sonda = helper.getSonda(sondaDTO, planalto);
			List<IComando> comandos = helper.getComandos(sondaDTO);
			comandos.forEach(comando -> sonda.executar(comando));

			sondaDTO.setSonda(sonda.toString());
			sondaDTO.setComando(null);
		});

		return entrada.getSondas();
	}
}
