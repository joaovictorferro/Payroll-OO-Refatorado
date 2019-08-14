package Menu;

import empregado.Comissionado;
import empregado.Horista;
import empregado.Salariado;
import exceptions.Exceptions;
import memento.Memento;
import empregado.Empregado;

import java.util.List;
import java.util.Scanner;

public class MudaInformacao extends Operacao implements Comando {
    private Scanner sc;
    static Exceptions exceptions = new Exceptions();
    
	public MudaInformacao() {
        super();
    }

    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack){
        int id = procura(empregado);
        
        if(id != -1){
            sc = new Scanner(System.in);
            System.out.println("O que deseja muda no Empregado:");
            System.out.println("1- Nome");
            System.out.println("2- Endereco");
            System.out.println("3- Tipo");
            System.out.println("4- Metodo de Pagamento");
            System.out.println("5- Sindicato");
            System.out.println("6- Sindicato Id");
            System.out.println("7- Sindicato Taxa");
            int aux = exceptions.integerInput();
            
            while(aux < 0 || aux > 7) {
				System.out.println("Digite um numero entre 0 - 7");
				aux = exceptions.integerInput();
			}
            
            if(aux == 1){
                empregado.get(id).nome();
            }else if(aux == 2){
            	empregado.get(id).endereco();
            }else if(aux == 3){
                int i;
                System.out.println("Digite o novo tipo do Empregado");
                System.out.println("1- Horista; 2- Salariado; 3- Comissionado");
                i = exceptions.integerInput();
                
                while(i < 1 || aux > 3) {
    				System.out.println("Digite um numero entre 1 - 3");
    				i = exceptions.integerInput();
    			}
                sc.nextLine();

                if (i == 1){
                	empregado.add(new Horista(empregado.get(id).id,empregado.get(id).name,empregado.get(id).getEndereco(),empregado.get(id).getMetodo_pagamento(),empregado.get(id).isSindicato(),empregado.get(id).getSindicato_id(),empregado.get(id).getSindicato_taxa(),calendario.dia));
                }else if(i == 2){
                	empregado.add(new Salariado(empregado.get(id).id,empregado.get(id).name,empregado.get(id).getEndereco(),empregado.get(id).getMetodo_pagamento(),empregado.get(id).isSindicato(),empregado.get(id).getSindicato_id(),empregado.get(id).getSindicato_taxa(),calendario.dia));
                }else{
                	empregado.add(new Comissionado(empregado.get(id).id,empregado.get(id).name,empregado.get(id).getEndereco(),empregado.get(id).getMetodo_pagamento(),empregado.get(id).isSindicato(),empregado.get(id).getSindicato_id(),empregado.get(id).getSindicato_taxa(),calendario.dia));
                }
                empregado.remove(id);
            }else if(aux == 4){
            	empregado.get(id).metodoPagamento();
            }else if(aux == 5){
            	empregado.get(id).sindicato();
            }else if(aux == 6){
            	empregado.get(id).sindicatoId();
            }else if(aux == 7){
            	empregado.get(id).sindicatoTaxa();
            }
        }
    }
}
