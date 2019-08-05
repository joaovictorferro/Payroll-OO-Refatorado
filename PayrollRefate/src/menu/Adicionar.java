package menu;

import java.util.Scanner;
import empregado.Empregado;
import empregado.Horista;

public class Adicionar implements Menu{
	Scanner sc = new Scanner(System.in);
	Empregado empregado = new Empregado();
	
	public void menu(){
		System.out.println("Entrei aqui");
		addEmpregado();
		return ;
	}
	
	public void addEmpregado(){
		System.out.println("Digite o tipo de funcionario:");
		System.out.println("1-Horista 2-Assalariado 3-Comissionado");
		int type = sc.nextInt();
		while(type < 1 || type > 3){
			System.out.println("Digite um numero valido");
			System.out.println("1-Horista 2-Assalariado 3-Comissionado");
			type = sc.nextInt();
		}
		if(type == 1) {
			addHorista();
		}else if(type == 2) {
			//addSalaried();
		}else if(type == 3) {
			//addCommissioned();
		}
	}

	public void addHorista(){
		Empregado employeeHourly = new Horista();
		empregado.add(employeeHourly);
	}
	/*
	    public void addSalaried(){
	    	String id = Integer.toString(cont);
	        Employee employeeWageEarner = new WageEarner();
	        employeeWageEarner.setId(id);
	        employee.add(employeeWageEarner);
	    }

	    public void addCommissioned(){
	    	String id = Integer.toString(cont);
	        Employee employeeComissioned = new Comissioned();
	        employeeComissioned.setId(id);
	        employee.add(employeeComissioned);
	    }
	    */

	@Override
	public void menu(int opc) {
		// TODO Auto-generated method stub
		
	}
}
