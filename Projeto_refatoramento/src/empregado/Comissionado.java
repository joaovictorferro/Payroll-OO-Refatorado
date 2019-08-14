package empregado;

import java.util.Calendar;
import java.util.Date;

public class Comissionado extends Empregado {
    private double salario_fixo;
    private double venda;
    private double porcentagem;
    
    public Comissionado(Date today){
        adicionarEmpregado();
        padraoPagamento(today);
    }

    public Comissionado(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa,Date dia) {
        tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        padraoPagamento(dia);
    }
    
    public Comissionado(String id, String name, String endereco, String metodo_pagamento, boolean sindicato, String sindicato_id, double sindicato_taxa, double salario_fixo, double venda, double porcentagem){
        super.tipo(id,name,endereco,metodo_pagamento,sindicato, sindicato_id, sindicato_taxa);
        this.salario_fixo = salario_fixo;
        this.venda = venda;
        this.porcentagem = porcentagem;
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
        venda = 0;
        System.out.println("Digite o salario fixo do funcionario?");
        salario_fixo = exceptions.doubleInput();
        setPorcentagem();
    }
    
    public void novaVenda(){
        double nova_venda;
        System.out.println("Digite o preco de venda?");
        nova_venda = exceptions.doubleInput();
        venda += (nova_venda*porcentagem/100);

    }
    
    public void setPorcentagem() {
        System.out.println("Porcentagem de venda (EX: 20)");
        porcentagem = exceptions.doubleInput();
    }

    @Override
    public void padraoPagamento(Date dia){
        pagamentoEscolha = PagamentoEscolha.Padrao;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        int semana = 6 - cal.get(Calendar.DAY_OF_WEEK);
        pagamentoDia.setTime(dia);
        if(semana > 0){
            pagamentoDia.add(Calendar.DAY_OF_MONTH,semana + 7);
        }else{
            pagamentoDia.add(Calendar.DAY_OF_MONTH,14 + semana);
        }
    }

    @Override
    public void pagamento(Date dia){
        double salario = salario_fixo + venda;
        System.out.println("Pagamento: " +(salario - (salario*getSindicato_taxa()/100) ));
        checarDia(dia);
    }

    public double getSalario_fixo() {
        return salario_fixo;
    }

    public double getVenda() {
        return venda;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    @Override
    public String toString() {
        return  super.toString() +"Comissionado{" +"Salario fixo: " + salario_fixo +", venda:" + venda +", porcentagem:" + porcentagem +'}';
    }
}
