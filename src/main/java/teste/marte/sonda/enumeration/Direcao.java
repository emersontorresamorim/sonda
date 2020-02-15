package teste.marte.sonda.enumeration;

import java.util.Optional;

import teste.marte.sonda.domain.Posicao;

public enum Direcao {

	NORTE("N") {
		@Override
		public Direcao virar(Lado lado) {
			return Lado.ESQUERDO.equals(lado) ? Direcao.OESTE : Direcao.LESTE;
		}

		@Override
		public Posicao mover(Posicao posicao) {
			posicao.setEixoY(posicao.getEixoY() + 1);
			return posicao;
		}
	},
	SUL("S") {
		@Override
		public Direcao virar(Lado lado) {
			return Lado.ESQUERDO.equals(lado) ? Direcao.LESTE : Direcao.OESTE;
		}

		@Override
		public Posicao mover(Posicao posicao) {
			posicao.setEixoY(posicao.getEixoY() - 1);
			return posicao;
		}
	},
	LESTE("L") {
		@Override
		public Direcao virar(Lado lado) {
			return Lado.ESQUERDO.equals(lado) ? Direcao.NORTE : Direcao.SUL;
		}

		@Override
		public Posicao mover(Posicao posicao) {
			posicao.setEixoX(posicao.getEixoX() + 1);
			return posicao;
		}
	},
	OESTE("O") {
		@Override
		public Direcao virar(Lado lado) {
			return Lado.ESQUERDO.equals(lado) ? Direcao.SUL : Direcao.NORTE;
		}

		@Override
		public Posicao mover(Posicao posicao) {
			posicao.setEixoX(posicao.getEixoX() - 1);
			return posicao;
		}
	};

	private String sigla;

	private Direcao(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public static Optional<Direcao> getDirecao(String sigla) {
		Direcao direcao = null;

		if ("N".equals(sigla)) {
			direcao = Direcao.NORTE;
		} else if ("S".equals(sigla)) {
			direcao = Direcao.SUL;
		} else if ("L".equals(sigla)) {
			direcao = Direcao.LESTE;
		} else if ("O".equals(sigla)) {
			direcao = Direcao.OESTE;
		} else {
			throw new IllegalArgumentException("Direção inválida.");
		}

		return Optional.ofNullable(direcao);
	}

	public abstract Direcao virar(Lado lado);

	public abstract Posicao mover(Posicao posicao);
}
