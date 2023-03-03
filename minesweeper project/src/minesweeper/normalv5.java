
package minesweeper;


import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class normalv5 extends javax.swing.JFrame {
    public static JFrame frame;
    public boolean isFirst, isTimerActive = true;
    public static StopWatchPanel myTimer;
    public static int flagCount =  Minesweeper.totalBombs; 
    public static JLabel txtFlagCount;
    public static ArrayList<Integer> bombsIndexes;
    public static CustomButtonV2 allButtons[][];
    public static final int rows = Minesweeper.rows, columns = Minesweeper.columns, total = rows*columns;
    public static CustomButtonV2 matrixButtons[][];
    public static javax.swing.ImageIcon[] images;
    
    public normalv5() {
        initComponentsV5();
        images = loadImages();
        frame = this;
        createMainPanel();
        
    }
    
    Color grey192 = new Color(192,192,192);
    Color black92 = new Color(92,92,92);
    Color black128 = new Color(128,128,128);
    
    public void createMainPanel(){
        JPanel pane = panelMain;
        createToolsPanel();
        createGamePanel();
        panelGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192), 5));
        this.setContentPane(panelMain);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        validate();
        revalidate();
    }
    
    public void createToolsPanel(){
        JPanel pane = panelTool;
        txtFlagCount = new JLabel(Integer.toString(Minesweeper.totalBombs));
        Button btnBackToMenu = new Button("Back to Menu");
        Button btnReset = new Button("Reset");
        myTimer = new StopWatchPanel();
        panelTool.setBorder(BorderFactory.createLoweredBevelBorder());
        txtFlagCount.setBorder(BorderFactory.createRaisedBevelBorder());
        
        
        if (Minesweeper.isDarkMode){
            btnReset.setBackground(black92);
            btnBackToMenu.setBackground(black92);
            btnReset.setForeground(grey192);
            btnBackToMenu.setForeground(grey192);
            txtFlagCount.setForeground(grey192);
            panelTool.setBackground(black128);
            myTimer.setBackground(black128);
        }
        else {
            btnReset.setBackground(grey192);
            btnBackToMenu.setBackground(grey192);
            btnReset.setForeground(black92);
            btnBackToMenu.setForeground(black92);
            txtFlagCount.setForeground(black92);
            panelTool.setBackground(grey192);
            myTimer.setBackground(grey192);
        }
        
        btnBackToMenu.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    
                    int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit? All progress will be lost", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        MainMenu s = new MainMenu();
                        frame.dispose();
                        s.setVisible(true);
                    }else if (result == JOptionPane.NO_OPTION){
                        return;
                    }
                }
        });
        
        btnReset.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    JPanel panel = panelGame;
                    pane.remove(myTimer);
                    myTimer = new StopWatchPanel();
                    pane.add(myTimer);
                    if (Minesweeper.isDarkMode)
                        myTimer.setBackground(black128);
                    else 
                        myTimer.setBackground(grey192);
                    if (!myTimer.timer.isRunning()) {
                        myTimer.lastTickTime = System.currentTimeMillis();
                    }
                    panelGame.removeAll();
                    panelGame.revalidate();
                    panelGame.repaint();
                    createGamePanel();
                    isTimerActive = true;
                    flagCount =  Minesweeper.totalBombs;
                    txtFlagCount.setText(Integer.toString(flagCount));
                }
        });      
        
        pane.add(btnBackToMenu);
        pane.add(btnReset);
        pane.add(txtFlagCount);
        pane.add(myTimer);
    }
     
    public void createGamePanel(){
        matrixButtons = new CustomButtonV2 [rows][columns];
        JPanel panel = panelGame;
        bombsIndexes = new ArrayList<>();
        panel.setBackground(new java.awt.Color(192, 192, 192));
        
        panelGame.setLayout(new java.awt.GridLayout(Minesweeper.getRows(),Minesweeper.getColumns())); //Creating a new grid layout and putting it inside the old layout
        createBombsIndexes();
        createButtons(panel);
        createNeighbors();
        createAdjacents();
        //Test();
        panel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    public void Test(){
        for(Component c: panelGame.getComponents()){
            if(c instanceof CustomButtonV2){
                CustomButtonV2 b = (CustomButtonV2) c;
                if(b.isBomb == true)
                   b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/detonatedBomb.png"))); 
                else{
                    switch(b.nbrBombsAdjacent){
                        case 0:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/revealed.png")));
                            break;
                        case 1:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/1.png")));
                            break;
                        case 2:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/2.png")));
                            break;
                        case 3:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/3.png")));
                            break;
                        case 4:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/4.png")));
                            break;
                        case 5:
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/5.png")));
                            break;
                        case 6: 
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/6.png")));
                            break;
                        case 7: 
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/7.png")));
                            break;
                        case 8: 
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/8.png")));
                            break;
                    } 
                }
                    
            }
        }
    }
    
    public void createBombsIndexes(){
        Random ran = new Random();
        int low=1;
        int high=Minesweeper.getRows()*Minesweeper.getColumns();
        int ranValue;
        for (int i = 0 ; i< Minesweeper.totalBombs;i++){
            ranValue = ran.nextInt(high - low)+low;
        
            if(bombsIndexes.contains(ranValue)){
                i--;
                continue;
            }
        
        bombsIndexes.add(ranValue);
        }
    }
    
    public void createButtons(JPanel panel){
        allButtons = new CustomButtonV2[Minesweeper.getRows()][Minesweeper.getColumns()];
        matrixButtons = new CustomButtonV2[Minesweeper.getRows()][Minesweeper.getColumns()];
        int bombs = Minesweeper.totalBombs, counterTest = 0;
        
        int ID = 0;
        for(int i = 0; i< Minesweeper.getRows(); i++){
            for(int j = 0; j< Minesweeper.getColumns(); j++){
                CustomButtonV2 b = new CustomButtonV2(ID, i, j);
                allButtons[i][j] = b;
                matrixButtons[i][j] = b;
                b.isReveal = false;
                b.setPreferredSize(new Dimension(25,25));
                b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/unshown.png"))); 
                b.addActionListener(new ActionListener() {
            
                public void actionPerformed(ActionEvent e)
                {
                
                    if(isTimerActive && !b.isFlag){ //If a button has a flag on it, it should not be opened
                        if (!myTimer.timer.isRunning()) {
                            myTimer.lastTickTime = System.currentTimeMillis();
                            myTimer.timer.start();
                        } //Basically when at a new game and when game is reset, the timer was stopped. 
                          //But when a button is presed while it is stopped, we use this function to restart it
                        reveal(b);
                        
                        if(b.nbrBombsAdjacent == 0 ){
                            dfs(b);
                        }
                        b.isReveal = true;
                        if(flagCount<1 && checkWin()){
                            won(b);
                        }
                    }
                }
                });
                
                b.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me){
                    if (me.getButton()== java.awt.event.MouseEvent.BUTTON3 && !b.isReveal ){ //check if b is revealed or not. 
                                                                                        //If its revealed, shouldnt do anything
                        if(!b.isFlag && flagCount>0 && flagCount <= Minesweeper.totalBombs){
                             b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/flag.png")));
                            b.isFlag = true;
                            flagCount--;
                            txtFlagCount.setText(Integer.toString(flagCount));
                            if(flagCount<1){
                                if(checkWin()){
                                    won(b);
                                }
                            }
                        }
                        else if (flagCount<Minesweeper.totalBombs && flagCount>=0 && b.isFlag){ 
                            b.isFlag = false;             
                            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/unshown.png")));
                            flagCount++;
                            txtFlagCount.setText(Integer.toString(flagCount));
                        }//if number of flags is inbetween the right interval, and flag is true, return it back to its old icon
                        else{
                            return;
                        }
                    }
                else{
                    return;
                }
            }
        });
        
                if(bombsIndexes.contains(ID)){  
                     b.isBomb = true;
                     counterTest++;
                }
                //b.setPreferredSize(new Dimension(25,25));            
                panel.add(b);  
                b.isAnimated = false;
                ID++;
            }
        }
    }
    
    public void createNeighbors(){
        int columns = Minesweeper.getColumns(), rows = Minesweeper.getRows();
        for(Component c: panelGame.getComponents()){
            ArrayList<CustomButtonV2> neighbors = new ArrayList<>();
            if(c instanceof CustomButtonV2){
                CustomButtonV2 b = (CustomButtonV2) c;
                int currentRow = b.x, currentCol = b.y;
                
        
                int iD = b.ID;
                if(iD==0){ //if top left corner
                    neighbors.add(matrixButtons[0][1]);
                    neighbors.add(matrixButtons[1][0]);
                    neighbors.add(matrixButtons[1][1]);
                }
                else if(iD==columns-1){ //if top right corner
                    neighbors.add(matrixButtons[0][columns-2]);
                    neighbors.add(matrixButtons[1][columns-2]);
                    neighbors.add(matrixButtons[1][columns-1]);
                }
                else if(iD == (rows*columns) - columns){ //bottom left corner
                    neighbors.add(matrixButtons[rows-2][0]);
                    neighbors.add(matrixButtons[rows-2][1]);
                    neighbors.add(matrixButtons[rows-1][1]);
                }
                else if(iD == rows*columns - 1){ //bottom right corner
                    neighbors.add(matrixButtons[rows-2][columns-2]);
                    neighbors.add(matrixButtons[rows-2][columns-1]);
                    neighbors.add(matrixButtons[rows-1][columns-2]);
                }
                else if(iD>0 && iD<columns-1){ //Top edge
                    neighbors.add(matrixButtons[0][currentCol-1]);
                    neighbors.add(matrixButtons[1][currentCol-1]);
                    neighbors.add(matrixButtons[1][currentCol]);
                    neighbors.add(matrixButtons[1][currentCol+1]);
                    neighbors.add(matrixButtons[0][currentCol+1]);
                }
                else if(isMultiple(columns, iD)){ //Left edge
                        
                    neighbors.add(matrixButtons[currentRow-1][0]);
                    neighbors.add(matrixButtons[currentRow-1][1]);
                    neighbors.add(matrixButtons[currentRow][1]);
                    neighbors.add(matrixButtons[currentRow+1][1]);
                    neighbors.add(matrixButtons[currentRow+1][0]);
            
                }
                else if(isMultiple(columns, iD+1)){ //right edge
                    neighbors.add(matrixButtons[currentRow-1][currentCol]);
                    neighbors.add(matrixButtons[currentRow-1][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow+1][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow+1][currentCol]);

                }
                else if(iD > ((rows*columns) - columns) && iD < ((rows*columns)-1)){ //bottom edge
                    neighbors.add(matrixButtons[rows-1][currentCol-1]);
                    neighbors.add(matrixButtons[rows-2][currentCol-1]);
                    neighbors.add(matrixButtons[rows-2][currentCol]);
                    neighbors.add(matrixButtons[rows-2][currentCol+1]);
                    neighbors.add(matrixButtons[rows-1][currentCol+1]);
                }
                else{
                    neighbors.add(matrixButtons[currentRow-1][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow-1][currentCol]);
                    neighbors.add(matrixButtons[currentRow-1][currentCol+1]);
                    neighbors.add(matrixButtons[currentRow][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow][currentCol+1]);
                    neighbors.add(matrixButtons[currentRow+1][currentCol-1]);
                    neighbors.add(matrixButtons[currentRow+1][currentCol]);
                    neighbors.add(matrixButtons[currentRow+1][currentCol+1]);
                }
                
                b.neighbors = neighbors;
            }
        }
        
    }
    
    public void createAdjacents(){
        for(Component c: panelGame.getComponents()){
            if(c instanceof CustomButtonV2){
                CustomButtonV2 b = (CustomButtonV2) c;
                if(!b.isBomb){
                    int badj = bfs(b);
                    b.nbrBombsAdjacent = badj;
                }
            }
        }
    }
    
    public int bfs(CustomButtonV2 c){
        Queue<CustomButtonV2> perimeter = new LinkedList<>();
        ArrayList<CustomButtonV2> known = c.neighbors;
        int count =0, i =0, length = known.size();
        perimeter.add(known.get(i));
        while(!perimeter.isEmpty()){
            CustomButtonV2 from = perimeter.remove();
            if(from.isBomb)
                count++;
            if(i<length-1){
                perimeter.add(known.get(i+1));
                i++;
            }
        }
        return count;
    }
    
    public void dfs(CustomButtonV2 c){
        if(c.nbrBombsAdjacent != 0 || c.isReveal)
            return;
        if(c.nbrBombsAdjacent == 0 && !c.isReveal){
            c.isReveal = true;
            if(!c.isBomb)
            c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/revealed.png")));
            for(CustomButtonV2 n: c.neighbors){
                if(!n.isBomb){
                    reveal(n);
                    dfs(n);
                }
            }
        }
    }  
    
    public boolean checkWin(){ //O(n)
        int count = 0;
        int totalFlags = Minesweeper.totalBombs;
        for(Component c: panelGame.getComponents()){
            if (c instanceof CustomButtonV2){
                CustomButtonV2 b = (CustomButtonV2) c;
                if(b.isBomb && b.isFlag){
                    count++;
                }
            }
        }
        if (count == totalFlags)
            return true;
        return false;
    }
    
    public void won (CustomButtonV2 b){
        myTimer.timer.stop();
        
        JOptionPane.showMessageDialog(this, "You Win!:D");
       
    }
    
    
    public void reveal(CustomButtonV2 b){
        b.setBackground(new java.awt.Color(192,192,192));
        if(b.isBomb){
           revealAll(b);
           isTimerActive = false;
           myTimer.timer.stop(); 
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/detonatedBomb.png"))); 
           JOptionPane.showMessageDialog(frame, "you suck !:D");

        }
        if(!b.isBomb){
        switch(b.nbrBombsAdjacent){
            case 0:
                b.setIcon(images[0]);
                break;
            case 1:
                b.setIcon(images[1]);
                break;
            case 2:
                b.setIcon(images[2]);
                break;
            case 3:
                b.setIcon(images[3]);
                break;
            case 4:
                b.setIcon(images[4]);
                break;
            case 5:
                b.setIcon(images[5]);
                break;
            case 6: 
                b.setIcon(images[6]);
                break;
            case 7: 
                b.setIcon(images[7]);
                break;
            case 8: 
                b.setIcon(images[8]);
                break;
        }
        }
        
    } 
    public void revealAll(CustomButtonV2 givenButton){
        for (Component c: panelGame.getComponents()){
            if(c instanceof CustomButtonV2){
                CustomButtonV2 b = (CustomButtonV2) c;
                if(b == givenButton){
                //no
                }
                if(b != givenButton){
                if(b.isBomb){
                    b.setIcon(images[9]);
                    isTimerActive=false;
                }
                else if(!b.isBomb){
                
                    switch(b.nbrBombsAdjacent){
                        case 0:
                            if(b != givenButton)
                            b.setIcon(images[0]);
                            break;
                        case 1:
                            b.setIcon(images[1]);
                            break;
                        case 2:
                            b.setIcon(images[2]);
                            break;
                        case 3:
                            b.setIcon(images[3]);
                            break;
                        case 4:
                            b.setIcon(images[4]);
                            break;
                        case 5:
                            b.setIcon(images[5]);
                            break;
                        case 6: 
                            b.setIcon(images[6]);
                            break;
                        case 7: 
                            b.setIcon(images[7]);
                            break;
                        case 8: 
                            b.setIcon(images[8]);
                            break;
                    } 
                }
                }
            }
        }
        

    }
   
    
    public boolean isMultiple(int base, int multiple){
        if(multiple%base == 0)
            return true;
        return false;
    }
    
   public javax.swing.ImageIcon[] loadImages(){
       javax.swing.ImageIcon[] images = new javax.swing.ImageIcon[10];
       images[0] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/revealed.png")));
       images[1] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/1.png")));
       images[2] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/2.png")));
       images[3] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/3.png")));
       images[4] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/4.png")));
       images[5] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/5.png")));
       images[6] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/6.png")));
       images[7] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/7.png")));
       images[8] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/8.png")));
       images[9] = (new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/newBomb.png")));
       return images;
   }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        panelTool7 = new javax.swing.JPanel();
        panelGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.BorderLayout());

        panelTool7.setBackground(new java.awt.Color(204, 255, 255));
        panelTool7.setMinimumSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout panelTool7Layout = new javax.swing.GroupLayout(panelTool7);
        panelTool7.setLayout(panelTool7Layout);
        panelTool7Layout.setHorizontalGroup(
            panelTool7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTool7Layout.setVerticalGroup(
            panelTool7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelMain.add(panelTool7, java.awt.BorderLayout.NORTH);

        panelGame.setBackground(new java.awt.Color(0, 242, 242));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        panelMain.add(panelGame, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void initComponentsV5(){
        panelMain = new javax.swing.JPanel();
        panelTool = new javax.swing.JPanel();
        panelGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.BorderLayout());

        panelTool.setBackground(new java.awt.Color(204, 255, 255));
        panelTool.setMinimumSize(new java.awt.Dimension(40, 40));
        panelMain.add(panelTool, java.awt.BorderLayout.NORTH);

        panelGame.setLayout(new java.awt.GridLayout());
        panelMain.add(panelGame, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        setLocationRelativeTo(null);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(normalv5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(normalv5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(normalv5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(normalv5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                normalv5 frame = new normalv5();
               
               Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
               int x = dim.width/2 - frame.getSize().width/2;
               int y = dim.height/2 - frame.getSize().height/2;
               
               
               frame.validate();
               frame.setLocation(x,y);
               frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelTool;
    private javax.swing.JPanel panelTool1;
    private javax.swing.JPanel panelTool2;
    private javax.swing.JPanel panelTool3;
    private javax.swing.JPanel panelTool4;
    private javax.swing.JPanel panelTool5;
    private javax.swing.JPanel panelTool6;
    private javax.swing.JPanel panelTool7;
    // End of variables declaration//GEN-END:variables
}
