/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.swing.border.LineBorder;
import java.lang.Object;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author 20210031
 */
public class Normalv4 extends javax.swing.JFrame{

    public static int rows,columns,total;
    public static ArrayList<Integer> bombsIndexes;
    public static JFrame frame;
    public boolean isFirst = true, isActive = true;
    public static StopWatchPanel myTimer;
    public static int flagCount =  Minesweeper.totalBombs; 
    public static JLabel txtFlagCount;

    
    public Normalv4() {
        initComponents();
        //this.getContentPane().removeAll();
        
        

        frame = this;
        makeMainPanel();
        //putImages();
        panelGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192), 5));
        this.setContentPane(panelMain);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        validate();
        revalidate();
    }
    
    public  void makeMainPanel(){
        JPanel pane = panelMain;
        makeToolsPanel();
        makeGamePanel();
        Test();
    }
    public void Test(){
        for(Component c: panelGame.getComponents()){
            if(c instanceof CustomButton){
                CustomButton b = (CustomButton) c;
                if(b.isBomb == true)
                   b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/detonatedBomb.png"))); 
                else{
                    switch(b.bombsAdjacent){
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
    
    
   

    public  void makeToolsPanel(){
            JPanel pane = panelTool;
            txtFlagCount = new JLabel(Integer.toString(Minesweeper.totalBombs));
            JButton btnBackToMenu = new JButton("Back to Menu");
            JButton btnReset = new JButton("Reset");
            myTimer = new StopWatchPanel();
            btnBackToMenu.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    
                    int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit? All progress will be lost", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        Homepage s = new Homepage();
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
                    if (!myTimer.timer.isRunning()) {
                        myTimer.lastTickTime = System.currentTimeMillis();
                    }
                    panelGame.removeAll();
                    panelGame.revalidate();
                    panelGame.repaint();
                    makeGamePanel();
                    isActive = true;
                    flagCount =  Minesweeper.totalBombs;
                    txtFlagCount.setText(Integer.toString(flagCount));
                }
                });
                
            
            
            
            pane.add(txtFlagCount);
            pane.add(btnBackToMenu);
            pane.add(btnReset);
            pane.add(myTimer);
    }
    
    public boolean checkWin(){
        int temp = 0;
        int nonBombs = Minesweeper.rows*Minesweeper.columns - Minesweeper.totalBombs;
        for(Component c: panelGame.getComponents()){
            if (c instanceof CustomButton){
                CustomButton b = (CustomButton) c;
                if(!b.isBomb && b.isReveal){
                    temp++;
                }
            }
        }
        
        if (temp == nonBombs)
            return true;
        return false;
    }
    
    public void makeGamePanel(){
        rows = Minesweeper.rows;
        columns = Minesweeper.columns;
        total = rows*columns;
        bombsIndexes = new ArrayList<Integer>(Minesweeper.totalBombs);
        JPanel panel = panelGame;
        panel.setBackground(new java.awt.Color(192, 192, 192));
        panelGame.setLayout(new java.awt.GridLayout(rows,columns)); //Creating a new grid layout and putting it inside the old layout
        createBombsIndexes();
        createButtons(panel);
        createAdjacent();
        
    }
    public void createBombsIndexes(){
        Random ran = new Random();
        int low=1;
        int high=rows*columns;
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
    
    //TO FIX PROBLEM OF INSTADEATH TAKE CREATE BUTTONS FROM FUNCTION ABOVE AND TAKE IF BOMBINDEX.CONTAINS FROM BELOW OF BELOW
    //IMPLEMENT DIFFERENT DIALOG SO THAT IF NO BUTTONS WERE PRESSED NO DIALOG NEEDS TO BE SHOWN
    
    public void won (CustomButton b){
        myTimer.timer.stop();
        revealAll(b);
        JOptionPane.showMessageDialog(frame, "you still suck !:D");
    }
   
    
    public void createButtons(JPanel panel){
        for (int i = 1; i <= total ; i++){
            CustomButton b = new CustomButton(i);
            b.isReveal=false;
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/unshown.png"))); 
            b.addActionListener(new ActionListener() {
            
                public void actionPerformed(ActionEvent e)
                {
                
                    if(isActive && !b.isFlag){
                        if (!myTimer.timer.isRunning()) {
                            myTimer.lastTickTime = System.currentTimeMillis();
                            myTimer.timer.start();
                        }
                        reveal(b);
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
                if (me.getButton()== java.awt.event.MouseEvent.BUTTON3 && !b.isReveal ){ 
                    
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
                    else{
                  
                        if(flagCount < Minesweeper.totalBombs && flagCount >= 0 && b.isFlag){
                          b.isFlag = false;
                          b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/unshown.png")));
                          flagCount++;
                          txtFlagCount.setText(Integer.toString(flagCount));
                        }

                        return;
                    }
                }
                else{
                    return;
                }
            }
        });
        
            if(bombsIndexes.contains(i)){  
                b.isBomb = true;
            } 
            b.setPreferredSize(new Dimension(25,25));
            
            panel.add(b);
        }
    }
    
    public void createAdjacent(){
        ArrayList<Integer> neighbors;
        int count = 0;
        for(Component c: panelGame.getComponents()){
            count = 0;
            if(c instanceof CustomButton){
                CustomButton b = (CustomButton) c;
                count = 0;
                if(!b.isBomb){
                    neighbors = b.setAdjacent(b.ID);
                    
                    for(Component c2: panelGame.getComponents()){
                        if (c2 instanceof CustomButton){
                            CustomButton b2 = (CustomButton) c2;
                            if(neighbors.contains(b2.ID)){
                                if(b2.isBomb == true){
                                    count++;
                                }
                            }
                        }
                    }
                    
                    b.bombsAdjacent = count;
                }
                
            }
        }
    }
    
    public void reveal(CustomButton b){
        b.setBackground(new java.awt.Color(192,192,192));
        if(b.isBomb){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/detonatedBomb.png"))); 
           revealAll(b);
           isActive = false;
           myTimer.timer.stop();
           JOptionPane.showMessageDialog(frame, "you suck !:D");
        }
        else if(b.bombsAdjacent == 0){
            b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/revealed.png")));
        }
        else if(b.bombsAdjacent == 1){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/1.png")));
        }  
        else if(b.bombsAdjacent == 2){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/2.png")));
        }  
        else if(b.bombsAdjacent == 3){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/3.png")));
        }  
        else if(b.bombsAdjacent == 4){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/4.png")));
        }  
        else if(b.bombsAdjacent == 5){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/5.png")));
        }  
        else if(b.bombsAdjacent == 6){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/6.png")));
        }  
        else if(b.bombsAdjacent == 7){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/7.png")));
        }  
        else if(b.bombsAdjacent == 8){
           b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/8.png")));
        } 
    }
    public void revealAll(CustomButton x){
        for (Component c: panelGame.getComponents()){
            if(c instanceof CustomButton){
                CustomButton b = (CustomButton) c;
            
            if(b.isBomb && b!=x){
                b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/newBomb.png")));
                isActive=false;
            }
            else if(!b.isBomb){
                
                if(b.bombsAdjacent == 1){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/1.png")));
                                             } 
                else if(b.bombsAdjacent == 0){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/revealed.png")));
                }
                else if(b.bombsAdjacent == 2){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/2.png")));
                                            }  
                else if(b.bombsAdjacent == 3){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/3.png")));
                                             }        
                else if(b.bombsAdjacent == 4){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/4.png")));
                                             }  
                else if(b.bombsAdjacent == 5){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/5.png")));
                                             }  
                else if(b.bombsAdjacent == 6){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/6.png")));
                                             }  
                else if(b.bombsAdjacent == 7){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/7.png")));
                                             }  
                else if(b.bombsAdjacent == 8){
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/8.png")));
                                            }  
                }
            }
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelTool = new javax.swing.JPanel();
        panelGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.BorderLayout());

        panelTool.setBackground(new java.awt.Color(204, 255, 255));
        panelTool.setMinimumSize(new java.awt.Dimension(40, 40));
        panelMain.add(panelTool, java.awt.BorderLayout.NORTH);

        panelGame.setLayout(new java.awt.GridLayout(1, 0));
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Normalv4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Normalv4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Normalv4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Normalv4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Normalv4 frame = new Normalv4();
               
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
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelTool;
    // End of variables declaration//GEN-END:variables
}
