package empregado;

import java.util.Calendar;
import java.util.Date;

public class Salariado extends Empregado {
    private double salario;
    
    public Salariado(Date dia){
        adicionarEmpregado();
        padraoPagamento(dia);
    }
    
    public Salariado(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa, Date dia) {
        tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        padraoPagamento(dia);
    }
    
    public Salariado(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa,double salario){
        super.tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        this.salario = salario;
    }

    @Override
    public void tipo(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax){
        super.tipo(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
        novoTipo();
    }
    
    private void novoTipo(){
        System.out.println("Digite o salario do Empregado:");
        salario = exceptions.doubleInput();
    }

    @Override
    public void adicionarEmpregado(){
        super.adicionarEmpregado();
        novoTipo();
    }

    @Override
    public void padraoPagamento(Date dia){
        pagamentoEscolha = PagamentoEscolha.Padrao;
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dia);
        calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));

        int semana = checarDia(calendario);
        pagamentoDia = calendario;
        pagamentoDia.add(Calendar.DAY_OF_MONTH,semana);
    }


    private int checarDia(Calendar calendario){
        int semana = calendario.get(Calendar.DAY_OF_WEEK);
        if(semana == 7){
            return -1;
        }else if(semana == 1){
            return -2;
        }
        return 0;
    }

    @Override
    public void pagamento(Date dia){
        System.out.println("Pagamento: " +(salario - (salario*getSindicato_taxa()/100) ));
        checarDia(dia);
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return  super.toString() +"Salariado{" +"salario=" + salario +'}';
    }
}