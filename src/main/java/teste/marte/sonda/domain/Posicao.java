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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eixoX == null) ? 0 : eixoX.hashCode());
		result = prime * result + ((eixoY == null) ? 0 : eixoY.hashCode());
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
		Posicao other = (Posicao) obj;
		if (eixoX == null) {
			if (other.eixoX != null)
				return false;
		} else if (!eixoX.equals(other.eixoX))
			return false;
		if (eixoY == null) {
			if (other.eixoY != null)
				return false;
		} else if (!eixoY.equals(other.eixoY))
			return false;
		return true;
	}
}
