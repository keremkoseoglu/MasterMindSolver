/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermindsolver;

/**
 *
 * @author kerem
 */
public class Guess {
    
    
    public Stone[] stones;
    
    public Guess() {
        stones = new Stone[4];
    }
    
    public Guess(int ColorIndex1, int ColorIndex2, int ColorIndex3, int ColorIndex4) {
        stones = new Stone[4];
        stones[0] = new Stone(ColorIndex1);
        stones[1] = new Stone(ColorIndex2);
        stones[2] = new Stone(ColorIndex3);
        stones[3] = new Stone(ColorIndex4);
    }
    
    public @Override String toString() {
        return stones[0].getColorString() + " ; " + stones[1].getColorString() + " ; " + stones[2].getColorString() + " ; " + stones[3].getColorString();
    }
    
    public boolean areAllStonesUsableColors(boolean AllowEmptyColor) {
        return  stones[0].isUsable(AllowEmptyColor) &&
                stones[1].isUsable(AllowEmptyColor) &&
                stones[2].isUsable(AllowEmptyColor) &&
                stones[3].isUsable(AllowEmptyColor);
    }
    
    
}
