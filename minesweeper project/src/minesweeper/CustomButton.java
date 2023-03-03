package minesweeper;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;



public class CustomButton extends JButton{
    public boolean isBomb = false;
    public int nbrAdjacentBombs, bombCount = 0;
    public int ID;
    public int rows, columns;
    public int bombsAdjacent;
    public boolean isFlag;
    public boolean isReveal;
    public ArrayList<Integer> adjacents;
   
    
    CustomButton(int i){
        //setPreferedSize(new Dimension(0,0));
        
        super.getPreferredSize();
        isBomb = false;
        ID = i;
        rows = Minesweeper.rows;
        columns = Minesweeper.columns;
    }
    
    @Override
    public Dimension getPreferredSize(){
        Dimension d = super.getPreferredSize();
        int s = (int) (d.getWidth() < d.getHeight() ? d.getHeight() : d.getWidth());
        return new Dimension(s,s);
    }
    
    public boolean isMultiple(int base, int multiple){
        if(multiple%base == 0)
            return true;
        return false;
    }
    
    public ArrayList<Integer> setAdjacent(int i){
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        
        if(i==1){ //if top left corner
            neighbors.add(2);
            neighbors.add(columns + 1);
            neighbors.add(columns + 2);
        }
        else if(i==columns){ //if top right corner
            
            neighbors.add(columns-1);
            neighbors.add(columns+columns);
            neighbors.add(columns+columns-1);
        }
        else if(i == (rows*columns) - columns + 1){ //bottom left corner
            neighbors.add(i + 1);
            neighbors.add(i - columns);
            neighbors.add(i - columns + 1);
        }
        else if(i == rows*columns){ //bottom right corner
            neighbors.add(i-1);
            neighbors.add(i - columns);
            neighbors.add(i - columns - 1);
        }
        else if(i>1 && i<columns){ //Top edge
            neighbors.add(i-1);
            neighbors.add(i+1);
            neighbors.add(i + columns);
            neighbors.add(i + columns - 1);
            neighbors.add(i + columns + 1);
        }
        else if(isMultiple(columns,i-1)){ //Left edge
            
            neighbors.add(i-columns);
            neighbors.add(i-columns+1);
            neighbors.add(i + 1);
            neighbors.add(i + columns);
            neighbors.add(i + columns + 1);
        }
        else if(isMultiple(columns, i)){ //right edge
            neighbors.add(i-columns);
            neighbors.add(i-columns - 1);
            neighbors.add(i - 1);
            neighbors.add(i + columns - 1);
            neighbors.add(i + columns);
            

        }
        else if(i > ((rows*columns)-columns+1) && i < rows*columns){ //bottom edge
            neighbors.add(i-columns-1);
            neighbors.add(i-columns);
            neighbors.add(i - columns + 1);
            neighbors.add(i -1);
            neighbors.add(i + 1);
        }
        else{
            neighbors.add(i-1);
            neighbors.add(i+1);
            neighbors.add(i-columns-1);
            neighbors.add(i-columns);
            neighbors.add(i-columns+1);
            neighbors.add(i+columns-1);
            neighbors.add(i+columns);
            neighbors.add(i+columns+1);
        }
        adjacents = neighbors;
        return neighbors;
        
    }
    
//    //toggle flag
//    public void toggleflag(){
//        if(isFlag){
//            isFlag=false;
//        }
//        else{
//            isFlag=true;
//        }
//        
//    }
//    public boolean getflag(){
//        return isFlag;
//    }
    
    
  
    
}
