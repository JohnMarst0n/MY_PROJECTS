import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class alarm_clock implements Runnable{

    private final LocalTime time;
    private final String file;
    private final Scanner scan;

    alarm_clock(LocalTime time, String file, Scanner scan){
        this.time = time;
        this.file = file;
        this.scan = scan;

    }

    @Override
    public void run(){
        
        while(LocalTime.now().isBefore(time)){

            try{
                Thread.sleep(1000);
                int hours = LocalTime.now().getHour();
                int min = LocalTime.now().getMinute();
                int sec = LocalTime.now().getSecond();
                System.out.printf("\r%02d:%02d:%02d",hours,min,sec);
            }catch(InterruptedException e){
                System.out.println("Thread was interrupted");
            }

        }
        System.out.println("\nWAKE UP!!");
        music(file);
    }

    private void music(String file){

        File aufile = new File(file);

        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(aufile);
                //above and bellow lines are important
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.loop(clip.LOOP_CONTINUOUSLY);
            clip.start();

            System.out.println("Press *Enter* to stop");
            scan.nextLine();
            clip.stop();

                    scan.close();

        }
    
        catch(LineUnavailableException e){
            System.out.println("audio not here");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("this file is not supported");
        }
        catch(IOException e){
            System.out.println("ERROR");
        } 

    }

}
