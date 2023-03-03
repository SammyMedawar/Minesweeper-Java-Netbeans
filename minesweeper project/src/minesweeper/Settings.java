
package minesweeper;
import java.awt.Color;
import java.lang.Math;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Settings extends javax.swing.JFrame {
 

    public Settings() {
        initComponents();
        updateUI();
    }
    
    Color grey192 = new Color(192,192,192);
    Color black92 = new Color(92,92,92);
    ImageIcon GenericBackground180x60 = new ImageIcon("src/minesweeper/resources/Generic-Background-180x60.png");
    ImageIcon GenericBackgroundDark180x60 = new ImageIcon("src/minesweeper/resources/Generic-Background-DM-180x60.png");
    ImageIcon GenericBackground440x300 = new ImageIcon("src/minesweeper/resources/Generic-Background-440x300.png");
    ImageIcon GenericBackgroundDark440x300 = new ImageIcon("src/minesweeper/resources/Generic-Background-DM-440x300.png");
    ImageIcon GenericBackground500x500 = new ImageIcon("src/minesweeper/resources/Generic-Background-500x500.png");
    ImageIcon GenericBackgroundDark500x500 = new ImageIcon("src/minesweeper/resources/Generic-Background-DM-500x500.png");
    ImageIcon Bliss = new ImageIcon("src/minesweeper/resources/bliss.jpg");
    ImageIcon msWallpaper = new ImageIcon("src/minesweeper/resources/msWallpaper.jpg");
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsLabel = new javax.swing.JLabel();
        difficultyLabel = new javax.swing.JLabel();
        rowsLabel = new javax.swing.JLabel();
        hardBtn = new java.awt.Checkbox();
        columnsLabel = new javax.swing.JLabel();
        bombsLabel = new javax.swing.JLabel();
        rowsTextBox = new javax.swing.JTextField();
        columnsTextBox = new javax.swing.JTextField();
        bombsTextBox = new javax.swing.JTextField();
        themeLabel = new javax.swing.JLabel();
        wallpaperLabel = new javax.swing.JLabel();
        wallpaperSelector = new javax.swing.JComboBox<>();
        meduimLabel = new javax.swing.JLabel();
        darkModeBtn = new java.awt.Checkbox();
        meduimBtn = new java.awt.Checkbox();
        easyBtn = new java.awt.Checkbox();
        customLabel = new javax.swing.JLabel();
        hardLabel = new javax.swing.JLabel();
        lightLabel = new javax.swing.JLabel();
        customBtn = new java.awt.Checkbox();
        easyLabel = new javax.swing.JLabel();
        lightModeBtn = new java.awt.Checkbox();
        darkLabel = new javax.swing.JLabel();
        confirmBtn = new java.awt.Button();
        backBtn = new java.awt.Button();
        settingsBody = new javax.swing.JLabel();
        settingsLabelBackground = new javax.swing.JLabel();
        settingsBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        settingsLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 37)); // NOI18N
        settingsLabel.setForeground(new java.awt.Color(92, 92, 92));
        settingsLabel.setText("Settings");
        getContentPane().add(settingsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 25, -1, -1));

        difficultyLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        difficultyLabel.setForeground(new java.awt.Color(92, 92, 92));
        difficultyLabel.setText("Difficulty:");
        getContentPane().add(difficultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 112, -1));

        rowsLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        rowsLabel.setForeground(new java.awt.Color(92, 92, 92));
        rowsLabel.setText("Rows:");
        getContentPane().add(rowsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 112, -1));

        hardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hardBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        hardBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hardBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(hardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 15, 15));

        columnsLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        columnsLabel.setForeground(new java.awt.Color(92, 92, 92));
        columnsLabel.setText("Columns:");
        getContentPane().add(columnsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 180, 112, -1));

        bombsLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        bombsLabel.setForeground(new java.awt.Color(92, 92, 92));
        bombsLabel.setText("Bombs:");
        getContentPane().add(bombsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 112, -1));

        rowsTextBox.setEditable(false);
        rowsTextBox.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(rowsTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 218, 110, 32));

        columnsTextBox.setEditable(false);
        columnsTextBox.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(columnsTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 218, 110, 32));

        bombsTextBox.setEditable(false);
        bombsTextBox.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(bombsTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 218, 110, 32));

        themeLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        themeLabel.setForeground(new java.awt.Color(92, 92, 92));
        themeLabel.setText("Theme:");
        getContentPane().add(themeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 112, -1));

        wallpaperLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        wallpaperLabel.setForeground(new java.awt.Color(92, 92, 92));
        wallpaperLabel.setText("Wallpaper:");
        getContentPane().add(wallpaperLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 342, -1, -1));

        wallpaperSelector.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        wallpaperSelector.setForeground(new java.awt.Color(92, 92, 92));
        wallpaperSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Bliss", "Minesweeper Art" }));
        wallpaperSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallpaperSelectorActionPerformed(evt);
            }
        });
        getContentPane().add(wallpaperSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 349, 254, -1));

        meduimLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        meduimLabel.setForeground(new java.awt.Color(92, 92, 92));
        meduimLabel.setText("Meduim");
        getContentPane().add(meduimLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 70, 30));

        darkModeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        darkModeBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        darkModeBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                darkModeBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(darkModeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 15, 15));

        meduimBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        meduimBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        meduimBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                meduimBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(meduimBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 15, 15));

        easyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        easyBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        easyBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                easyBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(easyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 15, 15));

        customLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        customLabel.setForeground(new java.awt.Color(92, 92, 92));
        customLabel.setText("Custom");
        customLabel.setToolTipText("");
        getContentPane().add(customLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 30));

        hardLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        hardLabel.setForeground(new java.awt.Color(92, 92, 92));
        hardLabel.setText("Hard");
        getContentPane().add(hardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 60, 30));

        lightLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        lightLabel.setForeground(new java.awt.Color(92, 92, 92));
        lightLabel.setText("Light");
        lightLabel.setToolTipText("");
        getContentPane().add(lightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 60, 30));

        customBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        customBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        customBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(customBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 15, 15));

        easyLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        easyLabel.setForeground(new java.awt.Color(92, 92, 92));
        easyLabel.setText("Easy");
        getContentPane().add(easyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 30));

        lightModeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lightModeBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lightModeBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lightModeBtnItemStateChanged(evt);
            }
        });
        getContentPane().add(lightModeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 15, 15));

        darkLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        darkLabel.setForeground(new java.awt.Color(92, 92, 92));
        darkLabel.setText("Dark");
        darkLabel.setToolTipText("");
        getContentPane().add(darkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 60, 30));

        confirmBtn.setActionCommand("Confirm");
        confirmBtn.setBackground(new java.awt.Color(192, 192, 192));
        confirmBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(92, 92, 92));
        confirmBtn.setLabel("Confirm");
        confirmBtn.setMaximumSize(new java.awt.Dimension(120, 50));
        confirmBtn.setMinimumSize(new java.awt.Dimension(120, 50));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 265, 110, 30));

        backBtn.setBackground(new java.awt.Color(192, 192, 192));
        backBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(92, 92, 92));
        backBtn.setLabel("Back");
        backBtn.setMaximumSize(new java.awt.Dimension(120, 50));
        backBtn.setMinimumSize(new java.awt.Dimension(120, 50));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 120, 50));

        settingsBody.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/Generic-Background-440x300.png"))); // NOI18N
        getContentPane().add(settingsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 440, 300));

        settingsLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/Generic-Background-180x60.png"))); // NOI18N
        settingsLabelBackground.setToolTipText("");
        getContentPane().add(settingsLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 23, 180, 60));

        settingsBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minesweeper/resources/Generic-Background-500x500.png"))); // NOI18N
        getContentPane().add(settingsBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hardBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hardBtnItemStateChanged
        if(hardBtn.getState()){
            easyBtn.setState(false);
            meduimBtn.setState(false);
            customBtn.setState(false);
        }
        else
            hardBtn.setState(true);
        Minesweeper.difficulty = "hard";
        rowsTextBox.setEditable(false);
        columnsTextBox.setEditable(false);
        bombsTextBox.setEditable(false);
        rowsTextBox.setText("16");
        columnsTextBox.setText("30");
        bombsTextBox.setText("99");
        Minesweeper.rows = 16;
        Minesweeper.columns = 30;
        Minesweeper.totalBombs = 99;
    }//GEN-LAST:event_hardBtnItemStateChanged

    private void wallpaperSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallpaperSelectorActionPerformed
        Minesweeper.wallpaper = wallpaperSelector.getSelectedItem().toString();
        updateUI();
    }//GEN-LAST:event_wallpaperSelectorActionPerformed

    private void darkModeBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_darkModeBtnItemStateChanged
        if (darkModeBtn.getState())
        lightModeBtn.setState(false);
        else
            darkModeBtn.setState(true);
        Minesweeper.isDarkMode = true;
        updateUI();
    }//GEN-LAST:event_darkModeBtnItemStateChanged

    private void meduimBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_meduimBtnItemStateChanged
        if(meduimBtn.getState()){
            easyBtn.setState(false);
            hardBtn.setState(false);
            customBtn.setState(false);
        }
        else
            meduimBtn.setState(true);
        Minesweeper.difficulty = "meduim";
        rowsTextBox.setEditable(false);
        columnsTextBox.setEditable(false);
        bombsTextBox.setEditable(false);
        rowsTextBox.setText("13");
        columnsTextBox.setText("15");
        bombsTextBox.setText("40");
        Minesweeper.rows = 13;
        Minesweeper.columns = 15;
        Minesweeper.totalBombs = 40;

    }//GEN-LAST:event_meduimBtnItemStateChanged

    private void easyBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_easyBtnItemStateChanged
        if(easyBtn.getState()){
            meduimBtn.setState(false);
            hardBtn.setState(false);
            customBtn.setState(false);
        }
        else
            easyBtn.setState(true);
        Minesweeper.difficulty = "easy";
        rowsTextBox.setEditable(false);
        columnsTextBox.setEditable(false);
        bombsTextBox.setEditable(false);
        rowsTextBox.setText("9");
        columnsTextBox.setText("9");
        bombsTextBox.setText("10");
        Minesweeper.rows = 9;
        Minesweeper.columns = 9;
        Minesweeper.totalBombs = 10;
    }//GEN-LAST:event_easyBtnItemStateChanged

    private void customBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customBtnItemStateChanged
        if(customBtn.getState()){
            easyBtn.setState(false);
            meduimBtn.setState(false);
            hardBtn.setState(false);
        }
        else
            customBtn.setState(false);
        Minesweeper.difficulty = "custom";
        rowsTextBox.setEditable(true);
        columnsTextBox.setEditable(true);
        bombsTextBox.setEditable(true);
    }//GEN-LAST:event_customBtnItemStateChanged

    private void lightModeBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lightModeBtnItemStateChanged
        if (lightModeBtn.getState())
            darkModeBtn.setState(false);
        else
            lightModeBtn.setState(true);
        Minesweeper.isDarkMode = false;
        updateUI();
    }//GEN-LAST:event_lightModeBtnItemStateChanged

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        Minesweeper.rows = Integer.parseInt(rowsTextBox.getText());
        Minesweeper.columns = Integer.parseInt(columnsTextBox.getText());
        Minesweeper.totalBombs = Integer.parseInt(bombsTextBox.getText());
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        MainMenu n = new MainMenu();
        this.dispose();
        n.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed
    private void updateUI(){
        if(Minesweeper.isDarkMode) {
            darkModeBtn.setState(true);
            confirmBtn.setBackground(black92);
            backBtn.setBackground(black92);
            settingsLabelBackground.setIcon(GenericBackgroundDark180x60);
            settingsBody.setIcon(GenericBackgroundDark440x300);
            confirmBtn.setForeground(grey192);
            backBtn.setForeground(grey192);
            settingsLabel.setForeground(grey192);
            difficultyLabel.setForeground(grey192);
            easyLabel.setForeground(grey192);
            meduimLabel.setForeground(grey192);
            hardLabel.setForeground(grey192);
            customLabel.setForeground(grey192);
            rowsLabel.setForeground(grey192);
            columnsLabel.setForeground(grey192);
            bombsLabel.setForeground(grey192);
            themeLabel.setForeground(grey192);
            lightLabel.setForeground(grey192);
            darkLabel.setForeground(grey192);
            wallpaperLabel.setForeground(grey192);
            
        }
        else {
            lightModeBtn.setState(true);
            confirmBtn.setBackground(grey192);
            backBtn.setBackground(grey192);
            settingsLabelBackground.setIcon(GenericBackground180x60);
            settingsBody.setIcon(GenericBackground440x300);
            confirmBtn.setForeground(black92);
            backBtn.setForeground(black92);
            settingsLabel.setForeground(black92);
            difficultyLabel.setForeground(black92);
            easyLabel.setForeground(black92);
            meduimLabel.setForeground(black92);
            hardLabel.setForeground(black92);
            customLabel.setForeground(black92);
            rowsLabel.setForeground(black92);
            columnsLabel.setForeground(black92);
            bombsLabel.setForeground(black92);
            themeLabel.setForeground(black92);
            lightLabel.setForeground(black92);
            darkLabel.setForeground(black92);
            wallpaperLabel.setForeground(black92);
        }

        if (Minesweeper.difficulty.equals("easy"))
            easyBtn.setState(true);
        else if (Minesweeper.difficulty.equals("meduim"))
            meduimBtn.setState(true);
        else if (Minesweeper.difficulty.equals("hard"))
            hardBtn.setState(true);
        else if (Minesweeper.difficulty.equals("custom"))
            customBtn.setState(true);
        if (Minesweeper.difficulty.equals("custom")){
            rowsTextBox.setEditable(true);
            columnsTextBox.setEditable(true);
            bombsTextBox.setEditable(true);
        }
        else {
            rowsTextBox.setEditable(false);
            columnsTextBox.setEditable(false);
            bombsTextBox.setEditable(false);
        }
        
        rowsTextBox.setText(String.valueOf(Minesweeper.rows));
        columnsTextBox.setText(String.valueOf(Minesweeper.columns));
        bombsTextBox.setText(String.valueOf(Minesweeper.totalBombs));
        
        wallpaperSelector.setSelectedItem(Minesweeper.wallpaper);
        if(Minesweeper.isDarkMode && Minesweeper.wallpaper.equals("Default"))
            settingsBackground.setIcon(GenericBackgroundDark500x500);
        else if (Minesweeper.isDarkMode == false && Minesweeper.wallpaper.equals("Default"))
            settingsBackground.setIcon(GenericBackground500x500);
        else if (Minesweeper.wallpaper.equals("Bliss"))
            settingsBackground.setIcon(Bliss);
        else if (Minesweeper.wallpaper.equals("Minesweeper Art"))
            settingsBackground.setIcon(msWallpaper);
    }
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button backBtn;
    private javax.swing.JLabel bombsLabel;
    private javax.swing.JTextField bombsTextBox;
    private javax.swing.JLabel columnsLabel;
    private javax.swing.JTextField columnsTextBox;
    private java.awt.Button confirmBtn;
    private java.awt.Checkbox customBtn;
    private javax.swing.JLabel customLabel;
    private javax.swing.JLabel darkLabel;
    private java.awt.Checkbox darkModeBtn;
    private javax.swing.JLabel difficultyLabel;
    private java.awt.Checkbox easyBtn;
    private javax.swing.JLabel easyLabel;
    private java.awt.Checkbox hardBtn;
    private javax.swing.JLabel hardLabel;
    private javax.swing.JLabel lightLabel;
    private java.awt.Checkbox lightModeBtn;
    private java.awt.Checkbox meduimBtn;
    private javax.swing.JLabel meduimLabel;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JTextField rowsTextBox;
    private javax.swing.JLabel settingsBackground;
    private javax.swing.JLabel settingsBody;
    private javax.swing.JLabel settingsLabel;
    private javax.swing.JLabel settingsLabelBackground;
    private javax.swing.JLabel themeLabel;
    private javax.swing.JLabel wallpaperLabel;
    private javax.swing.JComboBox<String> wallpaperSelector;
    // End of variables declaration//GEN-END:variables
}
