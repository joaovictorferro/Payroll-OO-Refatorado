package empregado;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Horista extends Empregado {
    private double valor_hora;
    private int hora;
    Scanner sc = new Scanner(System.in);

    public Horista(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa,Date dia) {
        tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        padraoPagamento(dia);
    }
    public Horista(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa,double valor_hora, int hora){
        super.tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        this.valor_hora = valor_hora;
        this.hora = hora;

    }

    public Horista(Date dia) {
        adicionarEmpregado();
        padraoPagamento(dia);
    }

    @Override
    public void tipo(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax){
        super.tipo(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
        novoTipo();
    }

    @Override
    public void adicionarEmpregado(){
        super.adicionarEmpregado();
        novoTipo();
    }

    public void novoTipo(){
        hora = 0;
        System.out.println("Valor da hora trabalhada:");
        valor_hora = exceptions.doubleInput();
    }
    
    public void ponto(){
        System.out.println("Quantas horas trabalhou no dia:");
        int hora_trabalhada = exceptions.integerInput();
        while(hora_trabalhada < 0 || hora_trabalhada > 24) {
        	System.out.println("Digite um valor entre 0 - 24 ");
        	hora_trabalhada = exceptions.integerInput();
        }
        hora += hora_trabalhada;
    }
    
    @Override
    public void padraoPagamento(Date dia){
        pagamentoEscolha = PagamentoEscolha.Padrao;
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dia);
        int semana = 6 - calendario.get(Calendar.DAY_OF_WEEK);
        pagamentoDia.setTime(dia);
        if(semana > 0){
            pagamentoDia.add(Calendar.DAY_OF_MONTH,semana);
        }else{
        	pagamentoDia.add(Calendar.DAY_OF_MONTH,7 + semana);
        }
    }

    @Override
    public void pagamento(Date dia){
        double salario = hora * valor_hora;
        System.out.println("Pagamento: " +(salario - (salario*getSindicato_taxa()/100) ));
        checarDia(dia);
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public int getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return super.toString() +"Horista{" +"valor da hora trabalhada:" + valor_hora +", houra:" + hora +'}';
    }
}