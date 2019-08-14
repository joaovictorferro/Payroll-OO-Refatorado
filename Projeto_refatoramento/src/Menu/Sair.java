package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class Sair extends Operacao implements Comando  {
    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
    	
    	System.out.println("Saindo do programa...");
    	System.exit(0);
    }
}