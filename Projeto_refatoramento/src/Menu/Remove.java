package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class Remove extends Operacao implements Comando {
    public Remove() {
        super();
    }

    @Override
    public void execute(List<Empregado> payroll, Calendario calendar, List<Memento> stack) {
        int id = procura(payroll);
        
        if (id != -1){
            String name = payroll.get(id).name;
            payroll.remove(id);
            System.out.println("Empregado " + name + " Removido");
            salvaEstado(payroll,stack);
            stack_index = 0;
        }
    }
}
