package Menu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendario {
	private static Calendario uniqueCalendar = new Calendario();
    public Date dia;
    public Calendar calendario;
    public SimpleDateFormat data;

    public Calendario()
    {
        data = new SimpleDateFormat("dd/MM/yyyy");
        dia = new Date();
        calendario = Calendar.getInstance();
        calendario.setTime(dia);
    }

    public static Calendario getInstance(){
        return uniqueCalendar;
    }
    
    public void terminarDia(){
        calendario.add(Calendar.DAY_OF_MONTH,1);
        dia = calendario.getTime();
    }

    public String semanaDia(){
        int semana = calendario.get(Calendar.DAY_OF_WEEK);
        if(semana == 1){
            return "Domingo";
        }else if(semana == 2){
            return "Segunda";
        }else if(semana == 3){
            return "Terca";
        }else if(semana == 4){
            return "Quarta";
        }else if(semana == 5){
            return "Quinta";
        }else if(semana == 6){
            return "Sexta";
        }else{
            return "Sabado";
        }
    }
}
