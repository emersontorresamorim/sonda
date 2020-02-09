package teste.marte.sonda.dto;

import java.io.Serializable;

public class SondaDTO implements Serializable {

	private static final long serialVersionUID = -8936624761405909295L;
	
	private String sonda;
	private String comando;
	
	public SondaDTO() {
	}
	
	public SondaDTO(String sonda) {
		this.sonda = sonda;
	}
	
	public SondaDTO(String sonda, String comando) {
		this.sonda = sonda;
		this.comando = comando;
	}
	
	public String getSonda() {
		return sonda;
	}
	
	public void setSonda(String sonda) {
		this.sonda = sonda;
	}
	
	public String getComando() {
		return comando;
	}
	
	public void setComando(String comando) {
		this.comando = comando;
	}
}
