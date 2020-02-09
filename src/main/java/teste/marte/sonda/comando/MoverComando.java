package teste.marte.sonda.comando;

import teste.marte.sonda.domain.Sonda;

public class MoverComando implements IComando {

	@Override
	public void executar(Sonda sonda) {
		sonda.mover();
	}
}
