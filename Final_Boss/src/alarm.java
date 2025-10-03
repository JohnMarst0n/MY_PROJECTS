import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class alarm{
    public static void main(String[] args) {
        String auname ="Final_Boss//EBA.wav";
        
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter DT = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime = null;

        while(alarmtime == null){

            try{

        System.out.print("Set your alarm (HH:MM:SS): ");
        String alarm = scan.nextLine();
        alarmtime = LocalTime.parse(alarm,DT);
        System.out.println("Your alarm set for "+alarmtime);

        }catch(DateTimeParseException e){
            System.out.println("Please enter the time in the right formate");
        }

        }
        alarm_clock aclock = new alarm_clock(alarmtime ,auname,scan);
        Thread thread = new Thread(aclock);
        thread.start();
    }
}