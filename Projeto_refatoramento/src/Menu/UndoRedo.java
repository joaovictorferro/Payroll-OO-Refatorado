package Menu;

import empregado.Empregado;
import exceptions.Exceptions;
import memento.Memento;

import java.util.List;

public class UndoRedo extends Operacao implements Comando {
	
	static Exceptions exceptions = new Exceptions();

	public UndoRedo() {
        super();
    }

    @Override
    public void execute(List<Empregado> payroll, Calendario calendar, List<Memento> stack){

        System.out.println("O que deseja fazer:");
        System.out.println("1- Undo 2- Redo");
        int aux = exceptions.integerInput();
        
        while(aux < 1 || aux > 2) {
			System.out.println("Digite um numero entre 1 - 2");
			aux = exceptions.integerInput();
		}

        if(aux == 1){
            stack_index++;
        }else if(aux == 2){
            stack_index--;
        }
        
        stack.get(stack_index).undo_redo(payroll);
    }
}
