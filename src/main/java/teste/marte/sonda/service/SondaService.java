package teste.marte.sonda.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.domain.Sonda;

@Service
public class SondaService {

	public List<String> executar(Map<Sonda, List<IComando>> sondasParaProcessar) {
		sondasParaProcessar.entrySet().stream().forEach(entry -> {
			entry.getValue().forEach(comando -> entry.getKey().executar(comando));
		});

		return sondasParaProcessar.keySet().stream().map(Sonda::toString).collect(Collectors.toList());
	}
}
