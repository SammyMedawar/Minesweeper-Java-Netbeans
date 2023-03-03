
package minesweeper;


public class Minesweeper extends Homepage{
public static int columns = 9, rows = 9, totalBombs = 14;
public static String difficulty = "easy", wallpaper = "Default";
public static boolean isDarkMode = false;
    
    public static void main(String[] args) {
        StartScreen.main(args);
        
    }
    public static void setSettings(int x, int y){
        rows = x;
        columns = y;
    }
    public static int getRows(){
        return rows;
    }
    public static int getColumns(){
        return columns;
    }
    
}
