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
import teste.marte.sonda.exception.ComandoInvalidoException;
import teste.marte.sonda.exception.PlanaltoInvalidoException;
import teste.marte.sonda.exception.SondaInvalidaException;

@Service
public class SondaHelper {

	public Planalto getPlanalto(EntradaDTO entrada) {
		if (Objects.isNull(entrada) || Objects.isNull(entrada.getLimitePlanalto())
				|| entrada.getLimitePlanalto().trim().length() < 3) {
			throw new PlanaltoInvalidoException("Os valores de Limite superior do Planalto não podem ser nulos.");
		}

		String[] planalto = entrada.getLimitePlanalto().split(" ");
		Integer posicaoX = null;
		Integer posicaoY = null;

		try {
			posicaoX = Integer.parseInt(planalto[0]);
			posicaoY = Integer.parseInt(planalto[1]);
		} catch (NumberFormatException e) {
			throw new PlanaltoInvalidoException("Os valores de Limite superior X ou Y do Planalto são inválidos.");
		}

		return new Planalto(posicaoX, posicaoY);
	}

	public Sonda getSonda(SondaDTO sondaDTO, Planalto planalto) {
		if (Objects.isNull(sondaDTO) || Objects.isNull(sondaDTO.getSonda())
				|| sondaDTO.getSonda().trim().length() < 5) {
			throw new SondaInvalidaException("Os valores de posição X, Y e Direção da Sonda não podem ser nulos.");
		}

		String[] sonda = sondaDTO.getSonda().split(" ");
		Integer posicaoX = null;
		Integer posicaoY = null;
		Direcao direcao = null;

		try {
			posicaoX = Integer.parseInt(sonda[0]);
			posicaoY = Integer.parseInt(sonda[1]);
			direcao = Direcao.getDirecao(sonda[2]).get();
		} catch (NumberFormatException e) {
			throw new SondaInvalidaException("Os valores de posição X ou Y da Sonda são inválidos.");
		} catch (IllegalArgumentException e) {
			throw new SondaInvalidaException("O valor de Direção da Sonda é inválido.");
		}

		return new Sonda(posicaoX, posicaoY, direcao, planalto);
	}

	public List<IComando> getComandos(SondaDTO sondaDTO) {
		String comando = sondaDTO.getComando();

		if (Objects.isNull(comando) || comando.length() < 1) {
			throw new ComandoInvalidoException("O valor de Comando da Sonda não pode ser nulo ou vazio.");
		}

		List<IComando> comandos = new ArrayList<>();
		for (int i = 0, j = comando.length(); i < j; i++) {
			char c = comando.charAt(i);
			if (c == 'E') {
				comandos.add(new VirarEsquerdaComando());
			} else if (c == 'D') {
				comandos.add(new VirarDireitaComando());
			} else if (c == 'M') {
				comandos.add(new MoverComando());
			} else {
				throw new ComandoInvalidoException("O valor de Comando da Sonda é inválido.");
			}
		}

		return comandos;
	}
}
