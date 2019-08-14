package Menu;

import empregado.Empregado;
import memento.Memento;

import java.util.List;

public class RodaFolhaPagamento implements Comando {
    @Override
    public void execute(List<Empregado> empregado, Calendario calendario, List<Memento> stack) {
        
    	for (Empregado empregados : empregado) {
            if (calendario.calendario.compareTo(empregados.getPagamentoDia()) == 0) {
                System.out.println("Id: " + empregados.id);
                System.out.println("Nome: " + empregados.name);
                empregados.pagamento(calendario.dia);
                System.out.println();
            }
        }
    }
}
