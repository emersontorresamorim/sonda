package teste.marte.sonda.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.comando.MoverComando;
import teste.marte.sonda.comando.VirarDireitaComando;
import teste.marte.sonda.comando.VirarEsquerdaComando;
import teste.marte.sonda.domain.Planalto;
import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.exception.LimitePlanaltoInvalidoException;

@Service
public class SondaHelper {

	public Planalto getPlanalto(EntradaDTO entrada) {
		if (Objects.isNull(entrada) || Objects.isNull(entrada.getLimitePlanalto())
				|| entrada.getLimitePlanalto().trim().length() < 2) {
			throw new LimitePlanaltoInvalidoException("Limite superior do Planalto inválido.");
		}

		String[] limite = entrada.getLimitePlanalto().split(" ");
		return new Planalto(Integer.parseInt(limite[0]), Integer.parseInt(limite[0]));
	}

	public Sonda getSonda(SondaDTO sondaDTO, Planalto planalto) {
		String[] sonda = sondaDTO.getSonda().split(" ");
		return new Sonda(Integer.parseInt(sonda[0]), Integer.parseInt(sonda[1]), Direcao.getDirecao(sonda[2]).get(),
				planalto);
	}

	public List<IComando> getComandos(SondaDTO sondaDTO) {
		String comando = sondaDTO.getComando();
		List<IComando> comandos = new ArrayList<>();

		for (int i = 0, j = comando.length(); i < j; i++) {
			char c = comando.charAt(i);
			if (c == 'E') {
				comandos.add(new VirarEsquerdaComando());
			} else if (c == 'D') {
				comandos.add(new VirarDireitaComando());
			} else if (c == 'M') {
				comandos.add(new MoverComando());
			}
		}

		return comandos;
	}
}
