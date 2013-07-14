/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermindsolver;

/**
 *
 * @author kerem
 */

public class Result {

    public enum HIT {FULL, HALF}; 
    
    public HIT[] hit;
    public Guess guess;
    
    public Result() {
        init();
    }
    
    public Result(Guess G, String Reply) {
        init();
        guess = G;
        
        for (byte n = 0; n < Reply.length(); n++) {
            hit[n] = Reply.substring(n, n + 1).equals("1") ? HIT.FULL : HIT.HALF;
        }
    }
    
    public boolean completeHit() {
        return (hit[0] == HIT.FULL && hit[1] == HIT.FULL && hit[2] == HIT.FULL && hit[3] == HIT.FULL);
    }
    
    private void init() {
        hit = new HIT[4];
        guess = new Guess(); 
    }
    
    public static Result evaluateGuess(Guess Correct, Guess Guess, boolean AllowDuplicateColors) {
        Result ret = new Result();
        ret.guess = Guess;
        boolean[] evaluated = new boolean[4];
        int hitPos = 0;
        
        if (AllowDuplicateColors) {
            
            for (int n = 0; n < Correct.stones.length; n++) {
                if (Correct.stones[n].isIdenticalTo(Guess.stones[n])) {
                    ret.hit[hitPos] = HIT.FULL;
                    evaluated[n] = true;
                    hitPos++;
                }
            }
            
            for (int n = 0; n < Correct.stones.length; n++) {
                if (!evaluated[n]) {
                    for (int m = 0; m < Guess.stones.length; m++) {
                        if (!evaluated[n] && n != m) {
                            if (Correct.stones[n].isIdenticalTo(Guess.stones[m])) {
                                ret.hit[hitPos] = HIT.HALF;
                                evaluated[n] = true;
                                hitPos++;
                                m = Guess.stones.length + 1;
                            }
                        }
                    }
                }
            }
            
        }
        else {
            for (int n = 0; n < Correct.stones.length; n++) {
                for (int m = 0; m < Guess.stones.length; m++) {
                    if (Correct.stones[n].isIdenticalTo(Guess.stones[m]))  {
                        ret.hit[hitPos] = (n == m) ? HIT.FULL : HIT.HALF;
                        hitPos++;
                    }

                }
            }
        }
        
        return ret;
    }
    
    public boolean isGuessConsistent(Guess G, boolean AllowDuplicateColors) {
        
        Result r = evaluateGuess(G, guess, AllowDuplicateColors);
        return (r.hit[0] == hit[0] &&
                r.hit[1] == hit[1] &&
                r.hit[2] == hit[2] &&
                r.hit[3] == hit[3]);
    }
    
    public static boolean areResultsIdentical(HIT[] h1, HIT[] h2) {
        
        byte fullCount1, fullCount2, halfCount1, halfCount2;
        
        fullCount1 = fullCount2 = halfCount1 = halfCount2 = 0;
        
        for (int n = 0; n < h1.length; n++) {
            if (h1[n] != null && h1[n].equals(HIT.FULL)) fullCount1++;
            if (h1[n] != null && h1[n].equals(HIT.HALF)) halfCount1++;
        }
        
        for (int m = 0; m < h2.length; m++) {
            if (h1[m] != null && 
                    h1[m].equals(HIT.FULL)) fullCount2++;
            if (h1[m] != null && h1[m].equals(HIT.HALF)) halfCount2++;
        }
        
        
        return (fullCount1 == fullCount2 && halfCount1 == halfCount2);
    }
    
}
