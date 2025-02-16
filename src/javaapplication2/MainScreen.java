/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 *
 * @author Chesler John Hamili
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    private String userFile;
    private String finalFile; 
            
    private Font laila_regular_45;
    private Font laila_regular_40;
    private Font laila_regular_20;
    private Font laila_medium;
    private Font laila_bold;
    private Font laila_light;
    
    private final Color LIGHT_BG = new Color(255, 255, 255);
    private final Color DARK_BG = new Color(33, 33, 33);
    private final Color LIGHT_TEXT = new Color(0, 0, 0);
    private final Color DARK_TEXT = new Color(255, 255, 255);
    private final Color LIGHT_PANEL = new Color(204, 204,204);
    private final Color DARK_PANEL = new Color(66, 66, 66);
    private final Color LIGHT_BUTTON = new Color(240, 240, 240);
    private final Color DARK_BUTTON = new Color(75, 75, 75);
    private final Color seven_BG_LIGHT = new Color(204,204,204);
    private final Color seven_BG_DARK = new Color(51,51,51);
    
    public MainScreen() {
        
        loadCustomFont();
        initComponents();
        //full screen
        setExtendedState(MAXIMIZED_BOTH);
        //
        mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            boolean isDarkMode = mode.isSelected();
            updateTheme(isDarkMode);
            //ternary operator -> ?
            mode.setText(isDarkMode ? "Off" : "On");
            }
        });
        press_button.setFocusPainted(false);
        press_button.setBorderPainted(false);
        press_button.setOpaque(true);
    }
    
    private void loadCustomFont() {
        try {
            File fontFileRegular = new File("src/javaapplication2/fonts/Laila-Regular.ttf"); // Adjust path if needed
            File fontFileBold = new File("src/javaapplication2/fonts/Laila-Bold.ttf"); // Adjust path if needed
            File fontFileMedium = new File("src/javaapplication2/fonts/Laila-Medium.ttf"); // Adjust path if needed
            File fontFileLight = new File("src/javaapplication2/fonts/Laila-Light.ttf"); // Adjust path if needed
            laila_regular_45 = Font.createFont(Font.TRUETYPE_FONT, fontFileRegular).deriveFont(45f);
            laila_regular_40 = Font.createFont(Font.TRUETYPE_FONT, fontFileRegular).deriveFont(40f);
            laila_regular_20 = Font.createFont(Font.TRUETYPE_FONT, fontFileRegular).deriveFont(20f);
            laila_bold = Font.createFont(Font.TRUETYPE_FONT, fontFileBold).deriveFont(35f);
            laila_medium = Font.createFont(Font.TRUETYPE_FONT, fontFileMedium).deriveFont(40f);
            laila_light = Font.createFont(Font.TRUETYPE_FONT, fontFileLight).deriveFont(10f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(laila_regular_20);
            ge.registerFont(laila_regular_40);
            ge.registerFont(laila_regular_45);
            ge.registerFont(laila_bold);
            ge.registerFont(laila_light);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            Font Laila_Regular = new Font("Sans-Serif", Font.BOLD, 30); // Fallback font
        }
    }
class RoundedPanel extends JPanel{
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
        public void setBackground(Color bg) {
        super.setBackground(bg);
        this.backgroundColor = bg;
        repaint();
    }
    }
private void updateTheme(boolean isDarkMode) {
    // Main panel background
    jPanel1.setBackground(isDarkMode ? DARK_BG : LIGHT_BG);
    
    // Update all text colors
    jLabel1.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel2.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel3.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel4.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel5.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel6.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel7.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel8.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    exam_score.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel10.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel11.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    jLabel12.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
    
    // Update all rounded panels background
    updateRoundedPanelColors(jPanel2, isDarkMode);
    updateRoundedPanelColors(jPanel4, isDarkMode);
    updateRoundedPanelColors(jPanel5, isDarkMode);
    updateRoundedPanelColors(jPanel6, isDarkMode);
    updateRoundedPanelColors(jPanel9, isDarkMode);
    
    // Update result panel
    jPanel7.setBackground(isDarkMode ? seven_BG_DARK : seven_BG_LIGHT);
   
    
    // Update text fields
    Color textFieldBg = isDarkMode ? DARK_PANEL : LIGHT_PANEL;
    Color textFieldFg = isDarkMode ? DARK_TEXT : LIGHT_TEXT;
    
    text1.setBackground(textFieldBg);
    text3.setBackground(textFieldBg);
    text4.setBackground(textFieldBg);
    text5.setBackground(textFieldBg);
    text6.setBackground(textFieldBg);
    
    text1.setForeground(textFieldFg);
    text3.setForeground(textFieldFg);
    text4.setForeground(textFieldFg);
    text5.setForeground(textFieldFg);
    text6.setForeground(textFieldFg);
    
    // Update button
    press_button.setBackground(isDarkMode ? DARK_BUTTON : LIGHT_BUTTON);
    press_button.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
}
private void updateRoundedPanelColors(JPanel panel, boolean isDarkMode) {
    if (panel instanceof RoundedPanel) {
        RoundedPanel roundedPanel = (RoundedPanel) panel;
        roundedPanel.setBackground(isDarkMode ? DARK_PANEL : LIGHT_PANEL);
        roundedPanel.setForeground(isDarkMode ? DARK_TEXT : LIGHT_TEXT);
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

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        press_button = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exam_score = new javax.swing.JLabel();
        CardHolders = new javax.swing.JPanel();
        jPanel4 = new RoundedPanel(50,Color.WHITE);
        jLabel6 = new javax.swing.JLabel();
        text3 = new javax.swing.JTextField();
        jPanel2 = new RoundedPanel(50,Color.WHITE);
        jLabel4 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        jPanel6 = new RoundedPanel(50,Color.WHITE);
        jLabel8 = new javax.swing.JLabel();
        text5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new RoundedPanel(50,Color.WHITE);
        jLabel7 = new javax.swing.JLabel();
        text4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new RoundedPanel(50,Color.WHITE);
        jLabel10 = new javax.swing.JLabel();
        text6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mode = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        fileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jLabel1.setFont(laila_regular_45);
        jLabel1.setText("Predictive Analytics in Student Performance");

        press_button.setText("Enter");
        press_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                press_buttonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setMaximumSize(new java.awt.Dimension(500, 500));

        jLabel2.setFont(laila_bold);
        jLabel2.setText("Predicted Student's Final Exam Score");

        jLabel3.setFont(laila_regular_20);
        jLabel3.setText("Note: The more data sets there are, the more accurate the prediction results.");

        exam_score.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exam_score.setText("....");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(exam_score, javax.swing.GroupLayout.Alignment.CENTER))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(exam_score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        CardHolders.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(150, 130));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("Study Hours");

        text3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        text3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text3.setOpaque(true);
        text3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 130));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Sleep Hours");

        text1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        text1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text1.setOpaque(true);
        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setMinimumSize(new java.awt.Dimension(150, 60));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(150, 130));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setText("Assignments");

        text5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        text5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text5.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setText("Completed");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(150, 130));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("Class ");

        text4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        text4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text4.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("Attendance");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(150, 130));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setText("Extracurricular");

        text6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        text6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text6.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setText("Hours");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CardHoldersLayout = new javax.swing.GroupLayout(CardHolders);
        CardHolders.setLayout(CardHoldersLayout);
        CardHoldersLayout.setHorizontalGroup(
            CardHoldersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardHoldersLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        CardHoldersLayout.setVerticalGroup(
            CardHoldersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardHoldersLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CardHoldersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
        );

        mode.setText("On");

        jLabel13.setFont(laila_light);
        jLabel13.setText("Have own data?");

        fileButton.setFont(laila_light);
        fileButton.setForeground(new java.awt.Color(0, 153, 255));
        fileButton.setText("Click here");
        fileButton.setBorderPainted(false);
        fileButton.setFocusPainted(false);
        fileButton.setFocusable(false);
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(press_button, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(11, 11, 11)
                        .addComponent(fileButton)))
                .addGap(322, 322, 322))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(164, 164, 164))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(CardHolders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(783, 783, 783))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fileButton))
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CardHolders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(press_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void press_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_press_buttonActionPerformed
        // TODO add your handling code here:
        
        //check if value if user has own set of data
        
        //getter 
        int _study_hours = Integer.parseInt(text3.getText());
        int _sleep_hours = Integer.parseInt(text1.getText());
        int _class_attendance = Integer.parseInt(text4.getText());
        int _assignments_completed = Integer.parseInt(text5.getText());
        int _extracurricular_hours = Integer.parseInt(text6.getText());
        
        String fileName = "C:\\Users\\Chesler John  Hamili\\OneDrive\\Documents\\NetBeansProjects\\HAMILI_LAB_2\\src\\main\\java\\doc\\data.csv";
        if(userFile.isEmpty()){
            finalFile = fileName;
        }else{
            finalFile = userFile;
        }
        File file = new File(finalFile);
        //List and Array is different list can hold any element at a time while array can't
        ArrayList<double[]> x_list = new ArrayList<>();
        ArrayList<Double> y_list = new ArrayList<>();
        try{
            Scanner inputStream = new Scanner(file); 
            System.out.println("Sleep_Hours");
            while(inputStream.hasNext()){
                // hasNext() and next() is not the same
                String data = inputStream.nextLine();
                //System.out.println(data);               
                //use splitter to separate
                String[] values = data.split(","); 
                System.out.print("test");
                
                int val_0 = Integer.parseInt(values[0]);
                System.out.print("test");
                int val_1 = Integer.parseInt(values[1]);
                int val_2 = Integer.parseInt(values[2]);
                int val_3 = Integer.parseInt(values[3]);
                int val_4 = Integer.parseInt(values[4]);
                double val_5 = Double.parseDouble(values[5]);
                x_list.add(new double[]{1,val_0,val_1,val_2,val_3,val_4});
                y_list.add(val_5);
               
            }
            double[][] x_data = x_list.toArray(new double[0][0]);
                //stackoverflow
            double[] y_data = y_list.stream().mapToDouble(Double::doubleValue).toArray();
        // Sir's code
        
        // Create RealMatrix objects for X and y
        RealMatrix X = MatrixUtils.createRealMatrix(x_data);
        RealVector y = MatrixUtils.createRealVector(y_data);

        // Calculate X^T (transpose of X)
        RealMatrix X_transpose = X.transpose();

        // Calculate (X^T * X) and its inverse
        RealMatrix X_transpose_X = X_transpose.multiply(X);
        RealMatrix X_transpose_X_inv = new LUDecomposition(X_transpose_X).getSolver().getInverse();

        // Convert y to a RealMatrix column vector (n x 1 matrix)
        RealMatrix yMatrix = MatrixUtils.createColumnRealMatrix(y.toArray());

        // Calculate beta (coefficients) using the formula: beta = (X^T * X)^(-1) * X^T * y
        RealMatrix beta = X_transpose_X_inv.multiply(X_transpose).multiply(yMatrix);

        // Extract the coefficients as a RealVector (1D array)
        RealVector betaVector = beta.getColumnVector(0);

        // Display the coefficients (beta values)
        System.out.println("Calculated Beta Coefficients:");
        System.out.println("Beta0 (Intercept): " + betaVector.getEntry(0));
        System.out.println("Beta1 (Study Hours): " + betaVector.getEntry(1));
        System.out.println("Beta2 (Sleep Hours): " + betaVector.getEntry(2));
        System.out.println("Beta4 (Class Attendance (%)): " + betaVector.getEntry(3));
        System.out.println("Beta5 (Assignments Completed (%)): " + betaVector.getEntry(4));
        System.out.println("Beta6 (Extracurricular Hours): " + betaVector.getEntry(5));

        // Allow user to input features for prediction
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the student's study hours: ");
        double study_hours = _study_hours;

        System.out.print("Enter the student's sleep hours: ");
        double sleep_hours = _sleep_hours;

        System.out.print("Enter the student's class attendance: ");
        double class_attendance = _class_attendance;

        System.out.print("Enter the student's assignments completed: ");
        double assignments_completed = _assignments_completed;

        System.out.print("Enter the student's extracurricular hours: ");
        double extracurricular_hours = _extracurricular_hours;

        // Create a new feature vector (including the intercept term)
        double[] newTarget = {1, study_hours, sleep_hours, class_attendance, assignments_completed, extracurricular_hours}; // Intercept term + size, bedrooms, location

        // Convert the new house row to a RealVector
        RealVector row = MatrixUtils.createRealVector(newTarget);

        // Calculate the predicted price using the dot product of the feature vector and the beta coefficients
        double predictedFinalExam = row.dotProduct(betaVector);
        
        //answer should be 0-100
        if(predictedFinalExam>100){
            predictedFinalExam = 100;
        }else{
            predictedFinalExam = 0;
        }
        // Output the predicted FinalExam
        System.out.println("\nPredicted Final Exam Score: " + predictedFinalExam);
        exam_score.setText(String.valueOf(predictedFinalExam));
        }catch (FileNotFoundException e){
           e.printStackTrace();
        }   
    }//GEN-LAST:event_press_buttonActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1ActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        // TODO add your handling code here:
        
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // What to do with the file, e.g. display it in a TextArea
        //textarea.read( new FileReader( file.getAbsolutePath() ), null );
        userFile = file.toString();
    } else {
        //System.out.println("File access cancelled by user.");
        javax.swing.JOptionPane.showMessageDialog(this, "Invalid file", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void text3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardHolders;
    private javax.swing.JLabel exam_score;
    private javax.swing.JButton fileButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToggleButton mode;
    private javax.swing.JButton press_button;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    private javax.swing.JTextField text5;
    private javax.swing.JTextField text6;
    // End of variables declaration//GEN-END:variables
}
