package empregado;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.Exceptions;

import java.util.Calendar;

public abstract class Empregado {
	
    public String id;
    public String name;
    private String endereco;
    private String metodo_pagamento;
    private boolean sindicato;
    private String sindicato_id;
    private double sindicato_taxa;
    protected PagamentoEscolha pagamentoEscolha;
    protected Calendar pagamentoDia = Calendar.getInstance();
    static Exceptions exceptions = new Exceptions();
    Scanner sc = new Scanner(System.in);

    public void adicionarEmpregado(){
        
    	System.out.println("Digite o Id do empregado:");
        id = sc.nextLine();
        
        while(id.equals("")) {
        	System.out.println("Digite uma entrada valida!!");
        }
        
        pagamentoEscolha = PagamentoEscolha.Padrao;
        nome();
        endereco();
        metodoPagamento();
        
        System.out.println("Pertence ao sindicato?");
        System.out.println("1 - Sim / 2 - Nao");
        int aux = exceptions.integerInput();
        
        while(aux < 1 || aux > 2) {
			System.out.println("Digite um numero entre 1 - 2");
			aux = exceptions.integerInput();
		}
        
        if(aux == 2) {
        	naoPertenceSindicato();
        }else{
            pertenceSindicato();
        }
    }

    public void tipo(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa) {
        this.id = id;
        this.name = name;
        this.endereco = endereco;
        this.metodo_pagamento = metodo_pagamento;
        this.sindicato = sindicato;
        this.sindicato_id = sindicato_id;
        this.sindicato_taxa = sindicato_taxa;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public boolean isSindicato() {
        return sindicato;
    }

    public String getSindicato_id() {
        return sindicato_id;
    }

    public double getSindicato_taxa() {
        return sindicato_taxa;
    }

    public void nome(){

        System.out.println("Digite o nome do Empregado:");
        name = sc.nextLine();
        while(name.equals("")) {
        	System.out.println("Digite uma entrada valida");
        	name = sc.nextLine();
        }
    }
    
    public void endereco() {
        System.out.println("Digite o endereco do Empregado:");
        endereco = sc.nextLine();
        while(endereco.equals("")) {
        	System.out.println("Digite uma entrada valida");
        	endereco = sc.nextLine();
        }
    }
    
    public void metodoPagamento(){
        System.out.println("Digite o Metodo de pagamento do Empregado:");
        System.out.println("1 - cheque pelos correios 2 - cheque em mãos 3 -depósito em conta bancária");
        
        int i = exceptions.integerInput();
        while(i < 1 || i > 3) {
        	System.out.println("Digite uma entrada valida");
        	i = exceptions.integerInput();
        }
        
        if(i == 1) {
        	metodo_pagamento = "cheque pelos correios";
        }else if(i==2) {
        	metodo_pagamento = "cheque em mãos";
        }else {
        	metodo_pagamento = "depósito em conta bancária";
        }
    }
    
    public void sindicatoId(){
        System.out.println("Digite o Id do Empregado no Sindicato");
        sindicato_id = sc.nextLine();
        while(sindicato_id.equals("")) {
        	System.out.println("Digite uma entrada valida");
        	sindicato_id = sc.nextLine();
        }
    }
    
    public void sindicatoTaxa() {
        System.out.println("Digite a taxa do sindicato");
        sindicato_taxa = exceptions.doubleInput();
    }

    public void pertenceSindicato(){
        sindicato = true;
        sindicatoId();
        sindicatoTaxa();
        sc.nextLine();
    }
    
    public void naoPertenceSindicato(){
        sindicato = false;
        sindicato_id = null;
        sindicato_taxa = 0;
    }

    public void sindicato(){
      if(sindicato == true){
          naoPertenceSindicato();
      }else {
          pertenceSindicato();
      }
    }

    public Calendar getPagamentoDia() {
        return pagamentoDia;
    }

    public abstract void padraoPagamento(Date dia);

    public abstract void pagamento(Date dia);

    public void checarDia(Date dia){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dia);
        if(pagamentoEscolha.equals(PagamentoEscolha.Padrao)){
            padraoPagamento(dia);
        }else if(pagamentoEscolha.equals(PagamentoEscolha.Mes_Primeiro_Dia)){
            padraoPagamentoPrimeiroDia(calendario);
        }else if(pagamentoEscolha.equals(PagamentoEscolha.Mes_Ultimo_dia)){
            padraoPagamentoUltimoDia(calendario);
        }else if(pagamentoEscolha.equals(PagamentoEscolha.Semana_Segunda)){
            padraoPagamentoSemanaSegunda(calendario);
        } else if(pagamentoEscolha.equals(PagamentoEscolha.Semana_Sexta)){
            padraoPagamentoSemanaSexta(calendario);
        }else{
            padraoPagamentoBissemanal(calendario);
        }
    }
    
    public void padraoPagamentoPrimeiroDia(Calendar cal){
        pagamentoEscolha = PagamentoEscolha.Mes_Primeiro_Dia;

        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.add(Calendar.DAY_OF_MONTH,1);
        
        if(cal.get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY)
        {
            cal.add(Calendar.DAY_OF_MONTH,2);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY)
        {
            cal.add(Calendar.DAY_OF_MONTH,1);
        }
        pagamentoDia.setTime(cal.getTime());
    }

    public void padraoPagamentoUltimoDia(Calendar calendario){
        pagamentoEscolha = PagamentoEscolha.Mes_Ultimo_dia;
        calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        if(calendario.get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY)
        {
            calendario.add(Calendar.DAY_OF_MONTH,-1);
        }
        else if(calendario.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY)
        {
            calendario.add(Calendar.DAY_OF_MONTH,-2);
        }
        pagamentoDia.setTime(calendario.getTime());
    }
    
    public void padraoPagamentoSemanaSegunda(Calendar calendario){
        pagamentoEscolha = PagamentoEscolha.Semana_Segunda;
        int semana = 7 +(2 - calendario.get(Calendar.DAY_OF_WEEK));
        calendario.add(Calendar.DAY_OF_MONTH,semana);
        pagamentoDia.setTime(calendario.getTime());
    }
    
    public void padraoPagamentoSemanaSexta(Calendar calendario){
        pagamentoEscolha = PagamentoEscolha.Semana_Sexta;
        int semana = 7+(5 - calendario.get(Calendar.DAY_OF_WEEK));
        calendario.add(Calendar.DAY_OF_MONTH,semana);
        pagamentoDia.setTime(calendario.getTime());
    }
    
    public void padraoPagamentoBissemanal(Calendar calendario) {
        pagamentoEscolha = PagamentoEscolha.Bissemanal;
        int semana= 2 - calendario.get(Calendar.DAY_OF_WEEK);
        calendario.add(Calendar.DAY_OF_MONTH,(14 + semana));
        pagamentoDia.setTime(calendario.getTime());
    }

    public void listaPagamento(SimpleDateFormat calendar){
        Date calendario = pagamentoDia.getTime();
        System.out.println(pagamentoEscolha);
        System.out.println("Proximo pagamento:" + calendar.format(calendario));
    }

    public String toString() {
        return "Empregado{" +"id:" + id + '\'' +", name:" + name + '\'' +", endereco:" + endereco + '\'' +", metodo de pagamento:'" + metodo_pagamento + '\'' +", sindicato: " + sindicato +", sindicato_id='" + sindicato_id + '\'' +", sindicato_taxa=" + sindicato_taxa +'}';
    }
}