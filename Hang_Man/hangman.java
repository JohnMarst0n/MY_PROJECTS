import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        String words = "hangword.txt";
        ArrayList<String> word = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(words))){
            String line;
            while ((line = reader.readLine()) != null) {
                word.add(line.trim());
                
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        catch(IOException e){
            System.out.println("ERROR");

    }
    Random ran = new Random();
    String gword = word.get(ran.nextInt(word.size()));

    Scanner scan = new Scanner(System.in);
    ArrayList<Character> guesser = new ArrayList<>();
    int wrong = 0;

    System.out.println("Welcome to HangMan");
        System.out.println();
    for(int i=0;i<gword.length();i++){
        guesser.add('_');
    }
        while (wrong <6) {
            System.out.println("placeholder");
            System.out.print("Word: ");
            for(char c:guesser){
                System.out.print(c+" ");
            }
            System.out.println();
            System.out.print("Enter your guess: ");
            char letter = scan.next().toLowerCase().charAt(0);

            if(gword.indexOf(letter)>=0){
                System.out.println("CORRECT!\n");
                System.out.println("Number of wrong guesses: "+wrong);
                
                for(int i=0;i<gword.length();i++){
                    if(gword.charAt(i)==letter){
                        guesser.set(i, letter);
                    }
                }
                if(!guesser.contains('_')){
                System.out.println("YOU WIN!!!");
                System.out.println("The word was: "+gword);
                break;
            }
            }
            else{
                System.out.println("WRONG!\n");
                wrong++;
                System.out.println("Number of wrong guesses: "+wrong);
            }
            if(wrong==6){
                
                System.out.println("GAME OVER");
                System.out.println("The word was: "+gword);
            }
            
        }
        scan.close();
}
}