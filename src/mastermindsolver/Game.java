/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermindsolver;

import java.util.Random;

/**
 *
 * @author kerem
 */
public class Game {

    private byte guessCount;
    private Result[] result;
    private boolean allowDuplicateColors;
    private boolean allowEmptyColor;
    
    public Game(boolean AllowDuplicateColors, boolean AllowEmptyColor) {
        result = new Result[12];
        guessCount = 0;
        allowDuplicateColors = AllowDuplicateColors;
        allowEmptyColor = AllowEmptyColor;
    }
    
    public void addResult(Result R) {
        result[guessCount] = R;
        guessCount++;
    }
    
    public boolean isGameOver() {
        return guessCount >= result.length;
    }
    
    public Guess produceGuess() {
        Guess ret = new Guess();
        
        if (guessCount == 0) {
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            boolean niceStart = false;
            while (!niceStart) {
                Random rnd = new Random();
                r1 = rnd.nextInt(Stone.COLOR_COUNT);
                r2 = rnd.nextInt(Stone.COLOR_COUNT);
                r3 = rnd.nextInt(Stone.COLOR_COUNT);
                r4 = rnd.nextInt(Stone.COLOR_COUNT);
                
                niceStart = true;
                if (r1 == r2 || r1 == r3 || r1 == r4 || r2 == r3 || r2 == r4 || r3 == r4) niceStart = false;
            }
            
            ret = new Guess(r1, r2, r3, r4);
            return ret;
        }
        
        for (byte x1 = 0; x1 < Stone.COLOR_COUNT; x1++){
            for (byte x2 = 0; x2 < Stone.COLOR_COUNT; x2++) {
                for (byte x3 = 0; x3 < Stone.COLOR_COUNT; x3++) {
                    for (byte x4 = 0; x4 < Stone.COLOR_COUNT; x4++) {
                        
                        if (
                               allowDuplicateColors ||
                               (
                                   !allowDuplicateColors &&                          
                                   x1 != x2 && x1 != x3 && x1 != x4 &&
                                   x2 != x3 && x2 != x4 &&
                                   x3 != x4
                               )
                           ) {
                            Guess g = new Guess(x1, x2, x3, x4);
                            
                            if (g.areAllStonesUsableColors(allowEmptyColor))
                            {
                                if (guessCount == 0) return g;

                                boolean canReturn = true;
                                for (int y = 0; y < guessCount; y++) {
                                    if (!result[y].isGuessConsistent(g, allowDuplicateColors)) canReturn = false;
                                }

                                if (canReturn) return g;
                            }
                        
                        }
                        
                        
                    }
                }
            }
        }
        
        return null;
    }
    
}
