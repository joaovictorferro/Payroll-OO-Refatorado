package memento;

import java.util.ArrayList;
import java.util.List;

import empregado.Comissionado;
import empregado.Horista;
import empregado.Salariado;
import empregado.Empregado;


public class Memento {
    private List<Empregado> anterior ;

    public Memento(List <Empregado> empregado){	
        anterior = new ArrayList<>();
        copy(empregado,anterior);
    }

    public void undo_redo(List <Empregado> empregado){	
    	empregado.clear();
        copy(anterior,empregado);
    }
    
    private void copy(List <Empregado> empregado1, List <Empregado> empregado2 ){
        for(int i=0; i<empregado1.size();i++){
            if (empregado1.get(i) instanceof Horista){
            	empregado2.add(i,new Horista(empregado1.get(i).id,empregado1.get(i).name,empregado1.get(i).getEndereco(),empregado1.get(i).getMetodo_pagamento(),empregado1.get(i).isSindicato(),empregado1.get(i).getSindicato_id(),empregado1.get(i).getSindicato_taxa(),((Horista) empregado1.get(i)).getValor_hora(),((Horista) empregado1.get(i)).getHora()));
            }
            else if(empregado1.get(i) instanceof Salariado)
            {
            	empregado2.add(i,new Salariado(empregado1.get(i).id,empregado1.get(i).name,empregado1.get(i).getEndereco(),empregado1.get(i).getMetodo_pagamento(),empregado1.get(i).isSindicato(),empregado1.get(i).getSindicato_id(),empregado1.get(i).getSindicato_taxa(),((Salariado) empregado1.get(i)).getSalario()));
            }
            else if(empregado1.get(i) instanceof Comissionado)
            {
            	empregado2.add(i,new Comissionado(empregado1.get(i).id,empregado1.get(i).name,empregado1.get(i).getEndereco(),empregado1.get(i).getMetodo_pagamento(),empregado1.get(i).isSindicato(),empregado1.get(i).getSindicato_id(),empregado1.get(i).getSindicato_taxa(),((Comissionado) empregado1.get(i)).getSalario_fixo(),((Comissionado) empregado1.get(i)).getVenda(),((Comissionado) empregado1.get(i)).getPorcentagem()));
            }
        }
    }
}


