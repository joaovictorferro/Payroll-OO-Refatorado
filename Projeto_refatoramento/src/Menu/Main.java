package Menu;

import empregado.Empregado;
import exceptions.Exceptions;
import memento.Memento;

import java.util.*;



public class Main {
    
	private static Exceptions exceptions;

	public static void main(String[] args)  {
        Calendario calendario = new Calendario();
        List<Empregado> empregado = new ArrayList<>();
        List<Memento> stack = new ArrayList<>();
        Operacao op = new Operacao(empregado,stack);
        exceptions = new Exceptions();
        start(calendario,empregado,stack,op);
    }

	private static void start(Calendario calendario, List <Empregado> empregado, List<Memento> stack, Operacao op){
		
		System.out.println(calendario.data.format(calendario.dia) + "," + calendario.semanaDia());
		System.out.println();
        	
		System.out.println("Digite [0] se deseja adicionar um empregado:");
		System.out.println("Digite [1] se deseja remover um empregado:");
		System.out.println("Digite [2] se deseja lançar um cartão de ponto:");
		System.out.println("Digite [3] se deseja lançar um resultado de venda:");
		System.out.println("Digite [4] se deseja lançar uma taxa de serviço:");
		System.out.println("Digite [5] se deseja alterar dados de um empregado:");
		System.out.println("Digite [6] se deseja rodar a folha de pagamento:");
		System.out.println("Digite [7] para Undo/Redo:");
		System.out.println("Digite [8] desejar ver os proximos pagamentos dos empregados:");
		System.out.println("Digite [9] para criar uma nova agenda de pagamento:");
		System.out.println("Digite [10] se deseja listar os empregados:");
		System.out.println("Digite [11] Terminar o Dia");
		System.out.println("Digite [12] Caso deseje sair do programa");
		
			int opera;
			opera = exceptions.integerInput();
			
			while(opera < 0 || opera > 12) {
				System.out.println("Digite um numero entre 0 - 12");
				opera = exceptions.integerInput();
			}
			op.operate(opera,empregado,calendario,stack);

			System.out.println();
			start(calendario, empregado,stack, op);
    }





}
