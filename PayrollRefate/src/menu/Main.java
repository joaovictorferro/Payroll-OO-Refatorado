package menu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a;
		
		System.out.println("Digite [0] se deseja parar o programa:");
		System.out.println("Digite [1] se deseja adicionar um empregado:");
		System.out.println("Digite [2] se deseja remover um empregado:");
		System.out.println("Digite [3] se deseja lançar um cartão de ponto:");
		System.out.println("Digite [4] se deseja lançar um resultado de venda:");
		System.out.println("Digite [5] se deseja lançar uma taxa de serviço:");
		System.out.println("Digite [6] se deseja alterar dados de um empregado:");
		System.out.println("Digite [7] se deseja rodar a folha de pagamento:");
		System.out.println("Digite [8] para Undo/Redo:");
		System.out.println("Digite [9] se deseja alterar sua agenda de pagamentos:");
		System.out.println("Digite [10] para criar uma nova agenda de pagamento:");
		System.out.println("Digite [11] se deseja listar os empregados:");
		
		a = sc.nextInt();
		
		TipoMenu tipoMenu = TipoMenu.values()[a-1];
		Menu menu = tipoMenu.ObterMenu();
		
		sc.close();
	}

}
