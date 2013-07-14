/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermindsolver;

import java.io.*;

/**
 *
 * @author kerem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        boolean keepPlaying;
        boolean allowDuplicateColors;
        boolean allowEmptyColor;
        
        System.out.println("Welcome to Master Mind Solver!");
        System.out.println("Programmed by: Kerem Koseoglu");
        System.out.println("http://kerem.koseoglu.info");
        
        allowDuplicateColors = yesOrNo("Allow duplicate colors");
        allowEmptyColor = yesOrNo("Allow empty colors");
        
        
        keepPlaying = true;
        while (keepPlaying)
        {
            System.out.println("Select 4 of the following colors and hit any key:");
            for (byte n = 0; n < Stone.COLOR_COUNT; n++) {
                if (Stone.isColorUsable(allowEmptyColor, Stone.getColorByIndex(n)))
                    System.out.println(String.valueOf(n) + ". " + Stone.getColorString(n));
            }

            Game game = new Game(allowDuplicateColors, allowEmptyColor);
            boolean cont = true;
            while (cont) {
                Guess g = game.produceGuess();
                if (g == null) {
                    System.out.println("I give up, can't make further consistent guesses");
                    keepPlaying = yesOrNo("Keep playing");
                    cont = false;
                }
                else {
                    System.out.println(g.toString());
                    System.out.println("Result? (1 = Exact hit, 0 = Hit, but wrong place)");

                    InputStreamReader converter = new InputStreamReader(System.in);
                    BufferedReader in = new BufferedReader(converter);
                    String x = in.readLine();

                    Result r = new Result(g, x);
                    if (r.completeHit()) {
                        System.out.println("I won!");
                        keepPlaying = yesOrNo("Keep playing?");
                        cont = false;
                    }
                    else {
                        game.addResult(r);

                        if (game.isGameOver()) {
                        System.out.println("I give up, end of board");
                        keepPlaying = yesOrNo("Keep playing");
                        cont = false;
                        } 
                    } // if CompleteHit
                } // if g is null
            } // while cont
        } // while keepPlaying
    } // main
    
    public static String getUserInput(String Question) throws Exception {
        System.out.print(Question);

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        return in.readLine();
    }
    
    public static boolean yesOrNo(String Question) throws Exception {
        while (1 == 1) {
            String s = getUserInput(Question + "? (Y or N) ");
            if (s.toUpperCase().equals("Y")) return true;
            if (s.toUpperCase().equals("N")) return false;
            System.out.println("Incorrect answer!");
        }
    }
    
    public static void pause() {
      try {
        System.in.read();
        } catch(Exception ex) {}
    }

}
