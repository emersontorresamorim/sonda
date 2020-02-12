package teste.marte.sonda.dto;

import java.io.Serializable;
import java.util.List;

public class EntradaDTO implements Serializable {

	private static final long serialVersionUID = 2447245497110673177L;

	private String limitePlanalto;
	private List<SondaDTO> sondas;

	public EntradaDTO() {
	}

	public EntradaDTO(String limitePlanalto, List<SondaDTO> sondas) {
		this.limitePlanalto = limitePlanalto;
		this.sondas = sondas;
	}

	public String getLimitePlanalto() {
		return limitePlanalto;
	}

	public void setLimitePlanalto(String limitePlanalto) {
		this.limitePlanalto = limitePlanalto;
	}

	public List<SondaDTO> getSondas() {
		return sondas;
	}

	public void setSondas(List<SondaDTO> sondas) {
		this.sondas = sondas;
	}
}
