package Menu;

import empregado.Empregado;
import exceptions.Exceptions;
import memento.Memento;

import java.util.Calendar;
import java.util.List;

public class NovaAgendaPagamento extends Operacao implements Comando  {
    static Exceptions exceptions = new Exceptions();
    
	@Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        int id = procura(empregado);
        
        if(id != -1){
            System.out.println("Escolha para qual tipo de Agenda o Empregado ira muda:");
            System.out.println("1 - Padrao");
            System.out.println("2 - Primeiro dia do Mes");
            System.out.println("3 - Ultimo dia do Mes");
            System.out.println("4 - Semanal as Segunda");
            System.out.println("5 - Semana as Sextas");
            System.out.println("6 - Bissemanal");
            int aux = exceptions.integerInput();
            
            while(aux < 1 || aux > 6) {
				System.out.println("Digite um numero entre 1 - 6");
				aux = exceptions.integerInput();
			}
            
            Calendar calendario_aux = Calendar.getInstance();
            calendario_aux.setTime(calendario.dia);

            if(aux == 1){
                empregado.get(id).padraoPagamento(calendario.dia);
            }else if(aux == 2){
            	empregado.get(id).padraoPagamentoPrimeiroDia(calendario_aux);
            }else if(aux == 3){
            	empregado.get(id).padraoPagamentoUltimoDia(calendario_aux);
            }else if(aux == 4){
            	empregado.get(id).padraoPagamentoSemanaSegunda(calendario_aux);
            }else if(aux == 5){
                empregado.get(id).padraoPagamentoSemanaSexta(calendario_aux);
            }else if(aux == 6){
            	empregado.get(id).padraoPagamentoBissemanal(calendario_aux);
            }
        }
        salvaEstado(empregado,stack);
        stack_index = 0;
    }
}
