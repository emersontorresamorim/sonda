package teste.marte.sonda.domain;

import java.io.Serializable;

public class Posicao implements Serializable {

	private static final long serialVersionUID = 3348321840674454182L;
	
	private Integer eixoX;
	private Integer eixoY;

	public Posicao(Integer eixoX, Integer eixoY) {
		this.eixoX = eixoX;
		this.eixoY = eixoY;
	}

	public Integer getEixoX() {
		return eixoX;
	}
	
	public void setEixoX(Integer eixoX) {
		this.eixoX = eixoX;
	}
	
	public Integer getEixoY() {
		return eixoY;
	}
	
	public void setEixoY(Integer eixoY) {
		this.eixoY = eixoY;
	}
}
