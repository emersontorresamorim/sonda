package teste.marte.sonda.domain;

import java.io.Serializable;

public class Planalto implements Serializable {

	private static final long serialVersionUID = -7203070131207333177L;
	
	private Posicao posicao;

	public Planalto(int eixoX, int eixoY) {
		this.posicao = new Posicao(eixoX, eixoY);
	}

	public int getEixoX() {
		return posicao.getEixoX();
	}

	public int getEixoY() {
		return posicao.getEixoY();
	}
	
	@Override
	public String toString() {
		return String.format("%d %d", posicao.getEixoX(), posicao.getEixoY());
	}
}
