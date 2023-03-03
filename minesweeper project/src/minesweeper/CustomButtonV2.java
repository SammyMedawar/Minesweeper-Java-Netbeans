
package minesweeper;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;

public class CustomButtonV2 extends JButton{
    public boolean isBomb = false, isFlag, isReveal, isAnimated = false;
    public int nbrBombsAdjacent, ID, x, y;
    public ArrayList<CustomButtonV2> neighbors;
    private int rows, columns;
    
    CustomButtonV2(int i, int x, int y){
        //setPreferedSize(new Dimension(0,0));
        
        super.getPreferredSize();
        isBomb = false;
        ID = i;
        this.x = x;
        this.y = y;
        rows = Minesweeper.rows;
        columns = Minesweeper.columns;
    }
    
    @Override
    public Dimension getPreferredSize(){
        Dimension d = super.getPreferredSize();
        int s = (int) (d.getWidth() < d.getHeight() ? d.getHeight() : d.getWidth());
        return new Dimension(s,s);
    }
    
    
    
    
}
