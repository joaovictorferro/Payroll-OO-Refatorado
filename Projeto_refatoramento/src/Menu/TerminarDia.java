package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class TerminarDia implements Comando {
    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        calendario.terminarDia();
    }
}
