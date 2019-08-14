package Menu;

import empregado.Comissionado;
import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class TaxaServico extends Operacao implements Comando {
    public TaxaServico() {
        super();
    }

    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        int id = procura(empregado);
        
        if(id != -1){
            if(empregado.get(id) instanceof Comissionado){
                ((Comissionado) empregado.get(id)).setPorcentagem();
                salvaEstado(empregado,stack);
                stack_index = 0;
            }else{
                System.out.println("Empregado Nao Comissionado");
            }
        }
    }
}
