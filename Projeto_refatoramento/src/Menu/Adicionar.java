package Menu;

import empregado.Comissionado;
import empregado.Horista;
import empregado.Salariado;
import exceptions.Exceptions;
import memento.Memento;
import empregado.Empregado;

import java.util.List;
import java.util.Scanner;

public class Adicionar extends Operacao implements Comando {
	static Exceptions exceptions = new Exceptions();
	private Scanner sc;

	public Adicionar() {
        super();
    }

    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
    	sc = new Scanner(System.in);
        int i;
        System.out.println("Digiteo tipo de Empregado:");
        System.out.println("1- Horista; 2- Salariado; 3- Comissionado");
        i = exceptions.integerInput();
        
        while(i < 1 || i > 3) {
			System.out.println("Digite um numero entre 1 - 3");
			i = exceptions.integerInput();
		}
        sc.nextLine();

        if (i == 1){
            empregado.add(new Horista(calendario.dia));
        }else if(i == 2){
            empregado.add(new Salariado(calendario.dia));
        }else{
        	empregado.add(new Comissionado(calendario.dia));
        }
        salvaEstado(empregado,stack);
        stack_index = 0;
    }

}