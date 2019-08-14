package exceptions;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Exceptions {
    	Scanner sc = new Scanner(System.in);

        public int integerInput(){
            while (true){
                try{
                    return sc.nextInt();
                }
                catch (InputMismatchException ime){
                    sc.next();
                    System.out.println("Incompatibilidade de entrada.");
                    System.out.println("Por favor, digite um n�mero inteiro.");
                }
            }
        }

        public double doubleInput(){
            while (true){
                try{
                    return sc.nextDouble();
                }
                catch (InputMismatchException ime){
                    sc.next();
                    System.out.println("Incompatibilidade de entrada.");
                    System.out.println("Por favor, digite um numero do tipo double.");
                }
            }
        }

        public int toInteger(String info){
            while(true){
                try{
                    return Integer.parseInt(info);
                }
                catch (NumberFormatException nfe){
                    System.out.println("Exce��o de formato num�rico.");
                    System.out.println("A string n�o p�de ser convertida em um inteiro.");
                    System.out.println("Agenda Invalida.");
                    return -1;
                }
            }
        }
    }