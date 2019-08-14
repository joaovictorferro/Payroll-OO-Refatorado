package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public interface Comando {
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack);
}
