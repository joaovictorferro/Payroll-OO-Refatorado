package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class ListaProximoPagamento extends Operacao implements Comando  {
    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        int id = procura(empregado);
        
        if(id != -1){
        	empregado.get(id).listaPagamento(calendario.data);
        }
    }
}
