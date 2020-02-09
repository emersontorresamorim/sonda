package teste.marte.sonda.comando;

import teste.marte.sonda.domain.Sonda;
import teste.marte.sonda.enumeration.Lado;

public class VirarDireitaComando implements IComando {

	@Override
	public void executar(Sonda sonda) {
		sonda.virar(Lado.DIREITO);
	}
}
