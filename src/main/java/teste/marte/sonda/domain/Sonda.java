package teste.marte.sonda.domain;

import java.io.Serializable;
import java.util.Objects;

import teste.marte.sonda.comando.IComando;
import teste.marte.sonda.enumeration.Direcao;
import teste.marte.sonda.enumeration.Lado;
import teste.marte.sonda.exception.MovimentoSondaInvalidoExpcetion;

public class Sonda implements Serializable {

	private static final long serialVersionUID = -1796176332015688028L;
	private static final Integer POSICAO_MINIMA_XY = 0;

	private Posicao posicao;
	private Direcao direcao;
	private Planalto planalto;

	public Sonda(Integer posicaoX, Integer posicaoY, Direcao direcao, Planalto planalto) {
		if (Objects.isNull(posicaoX) || Objects.isNull(posicaoY) || Objects.isNull(direcao)) {
			throw new IllegalArgumentException("Os valores de posição X, Y e Direção não podem ser nulos.");
		}
		this.posicao = new Posicao(posicaoX, posicaoY);
		this.direcao = direcao;
		this.planalto = planalto;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public void executar(IComando comando) {
		comando.executar(this);
	}

	public void virar(Lado lado) {
		direcao = direcao.virar(lado);
	}

	public void mover() {
		if (isMovimentoValido(planalto)) {
			posicao = direcao.mover(posicao);
		} else {
			throw new MovimentoSondaInvalidoExpcetion(
					String.format("Movimento de Sonda inválido. (Localização: %s)", toString()));
		}
	}

	private boolean isMovimentoValido(Planalto planalto) {
		boolean isValido = true;

		if (posicao.getEixoX() == POSICAO_MINIMA_XY && Direcao.OESTE.equals(direcao)) {
			isValido = false;
		}
		if (posicao.getEixoX() == planalto.getEixoX() && Direcao.LESTE.equals(direcao)) {
			isValido = false;
		}
		if (posicao.getEixoY() == POSICAO_MINIMA_XY && Direcao.SUL.equals(direcao)) {
			isValido = false;
		}
		if (posicao.getEixoY() == planalto.getEixoY() && Direcao.NORTE.equals(direcao)) {
			isValido = false;
		}

		return isValido;
	}

	@Override
	public String toString() {
		return String.format("%d %d %s", posicao.getEixoX(), posicao.getEixoY(), direcao.getSigla());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
		result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sonda other = (Sonda) obj;
		if (direcao != other.direcao)
			return false;
		if (posicao == null) {
			if (other.posicao != null)
				return false;
		} else if (!posicao.equals(other.posicao))
			return false;
		return true;
	}
}
