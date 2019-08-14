package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class Lista extends Operacao implements Comando  {
    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        int id = procura(empregado);
        
        if(id != -1){   
            System.out.println(empregado.get(id).toString());
        }
    }
}
