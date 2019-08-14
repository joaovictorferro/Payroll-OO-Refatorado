package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacao {
    List<Comando> slot;
    public int stack_index;
	private Scanner sc;

    public Operacao(){}

    public Operacao(List<Empregado> empregado, List<Memento> stack) {
        this.stack_index = 0;
        salvaEstado(empregado,stack);
        this.slot = new ArrayList<>();
        slot.add(0,new Adicionar());
        slot.add(1,new Remove());
        slot.add(2,new Ponto());
        slot.add(3,new ResultadoVenda());
        slot.add(4,new TaxaServico());
        slot.add(5,new MudaInformacao());
        slot.add(6,new RodaFolhaPagamento());
        slot.add(7,new UndoRedo());
        slot.add(8,new ListaProximoPagamento());
        slot.add(9,new NovaAgendaPagamento());
        slot.add(10,new Lista());
        slot.add(11,new TerminarDia());
        slot.add(12,new Sair());
    }

    public void operate(int index, List<Empregado> empregado, Calendario calendar, List<Memento> stack){
        slot.get(index).execute(empregado,calendar,stack);
    }

    public int procura(List <Empregado> empregado){
        sc = new Scanner(System.in);
        System.out.println("Digite o id do empregado que deseja procurar:");
        String id = sc.nextLine();
        
        while(id.equals("")) {
        	System.out.println("Digite uma entrada valida");
        	id = sc.nextLine();
        }
        
        for(int i = 0; i < empregado.size(); i++){
            if(empregado.get(i).id.equals(id)){
                return i;
            }
        }
        System.out.println("Empregado nao Existe");
        return -1;
    }
    
    public void salvaEstado(List<Empregado> payroll, List<Memento> stack){
        stack_index--;
        
        while (stack_index > 0){
            stack.remove(stack_index);
            stack_index--;
        }
        stack.add(0,new Memento(payroll));
    }
}