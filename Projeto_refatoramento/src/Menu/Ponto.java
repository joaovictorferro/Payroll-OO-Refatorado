package Menu;

import empregado.Horista;
import memento.Memento;
import empregado.Empregado;

import java.util.List;

public class Ponto extends Operacao implements Comando {
    public Ponto() {
        super();
    }

    @Override
    public void execute(List<Empregado> empregado, Calendario calendar, List<Memento> stack) {
        int id = procura(empregado);
        
        if(id != -1){
        	if(empregado.get(id) instanceof Horista){
                ((Horista) empregado.get(id)).ponto();
                salvaEstado(empregado,stack);
                stack_index = 0;
            }else{
                System.out.println("Empregado Nao e Horista!!");
            }
        }
    }
}
