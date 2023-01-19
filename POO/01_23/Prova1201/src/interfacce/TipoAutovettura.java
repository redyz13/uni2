package interfacce;

import core.Autovettura;

@FunctionalInterface
public interface TipoAutovettura {
    boolean checkTipo(Autovettura a);
}
