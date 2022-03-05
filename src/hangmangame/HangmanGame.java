
package hangmangame;

import java.util.Scanner;

public class HangmanGame {

    private final static int VIDAS = 7;
    
    public static void main(String[] args) {
        int v = VIDAS;
        String p = args[0]; // palavra secreta
        String a = ""; // respostas dadas
        boolean gameOver = true; 
        Scanner s = new Scanner(System.in);
        
        while (v > 0){
            // mostra as lacunas
            for (int i = 0; i < p.length(); i++) {
                char x = p.charAt(i);
                if (a.matches(".*"+x+".*"))
                    System.out.print(x);
                else{
                    System.out.print("-");
                    gameOver = false;
                }
            }           
            
            if (gameOver){
                System.out.println("\nYOU WIN!!!");
                break;
            }
            
            System.out.print(" You have "+v+" lifes. Enter a letter: ");
            String l = s.next();
            
            if (!l.matches("[a-z]|[A-Z]")) // não é uma letra
                continue;
            if (a.matches(".*"+l+".*")){ // repetida
                System.out.println("You already said that.");
                continue;
            }
            
            if (p.matches(".*"+l+".*")) // palavra contém a letra
                System.out.println("Yes!");
            else{
                System.out.println("NO!");
                v--;
            }
            a += l;               
            gameOver = true;
        }
        System.out.println("GAME OVER");
    }
    
}
