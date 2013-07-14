/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermindsolver;

/**
 *
 * @author kerem
 */
public class Stone {

    public enum COLOR {RED, ORANGE, YELLOW, GREEN, BLUE, PINK, TEAL, WHITE, PURPLE, EMPTY};
    public static final int COLOR_COUNT = 10;
    
    private COLOR color;
    
    public Stone() {
        initialize(null);
    }
    
    public Stone (COLOR C) {
        initialize(C);
    }
    
    public Stone(int ColorIndex) {
        initialize(getColorByIndex(ColorIndex));
    }
    
    private void initialize(COLOR C) {
        color = C;
    }
    
    public COLOR getColor() {
        return color;
    }
    
    public void setColor(COLOR C) {
        color = C;
    } 
    
    public String getColorString() {
        return getColorString(color);
    }
    
    public boolean isUsable(boolean AllowEmptyColor) {
        return isColorUsable(AllowEmptyColor, getColor());
    }
    
    public boolean isIdenticalTo(Stone OtherStone) {
        return areStonesIdentical(this, OtherStone);
    }
    
    public static COLOR getColorByIndex(int Index) {
        if (Index == 0) return COLOR.BLUE;
        if (Index == 1) return COLOR.GREEN;
        if (Index == 2) return COLOR.ORANGE;
        if (Index == 3) return COLOR.PINK;
        if (Index == 4) return COLOR.PURPLE;
        if (Index == 5) return COLOR.RED;
        if (Index == 6) return COLOR.TEAL;
        if (Index == 7) return COLOR.WHITE;
        if (Index == 8) return COLOR.YELLOW;
        if (Index == 9) return COLOR.EMPTY;
        
        return null;
    }
    
    public static String getColorString(COLOR C) {
        
        if (C == COLOR.BLUE) return "Blue";
        if (C == COLOR.GREEN) return "Green";
        if (C == COLOR.ORANGE) return "Orange";
        if (C == COLOR.PINK) return "Pink";
        if (C == COLOR.PURPLE) return "Purple";
        if (C == COLOR.RED) return "Red";
        if (C == COLOR.TEAL) return "Teal";
        if (C == COLOR.WHITE) return "White";
        if (C == COLOR.YELLOW) return "Yellow";
        if (C == COLOR.EMPTY) return "Empty";
        
        return null;
    }
    
    public static String getColorString(int ColorIndex) {
        return getColorString(getColorByIndex(ColorIndex));
    }
    
    public static boolean isColorUsable(boolean allowEmptyColor, COLOR C) {
        return (allowEmptyColor || (!allowEmptyColor && !C.equals(COLOR.EMPTY)));
    }
    
    public static boolean areStonesIdentical(Stone S1, Stone S2) {
        return S1.getColor().equals(S2.getColor());
    }
    
}
