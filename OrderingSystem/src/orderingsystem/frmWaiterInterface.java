/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderingsystem;
import java.io.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class frmWaiterInterface extends javax.swing.JFrame {

    /**
     * Creates new form frmWaiterInterface
     */
    public frmWaiterInterface() {
        initComponents();
        this.setSize(600, 300); //Sets size dimensions of the forms
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jpPanel.setOpaque(true);
        jpPanel.setBackground(new Color(125, 176, 255));
        mReadOrderFile(mFilePath());
        mGetOrderData();
        mSetValuesToGUI();
    }

    
    //Creating an object of class StringBuilder used for 
    //holding contents of a read file.
    StringBuilder sb = new StringBuilder();
    
    String[] arrOrderData; //A string array to store oder data
    
        
    //A method that returns a file object of the path of a text file
    public File mFilePath() {
        return new File("Order_by_Sanele_for_2_guests.txt");
    }
    
    //A method that reads a file passed as an argument to it
    //and stores the read details to a StringBuilder object
    public void mReadOrderFile(File flOrder) {
        FileReader reader;
        int intChar;
        
        try{
            reader = new FileReader(flOrder);
            while((intChar = reader.read()) != -1){
                sb.append((char)intChar);
            }
            reader.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
    }
    
    //A method used to get order data
    public void mGetOrderData() {
        arrOrderData = new String[mGetOrderLength()];
        for(int i = 0; i < arrOrderData.length; i++) {
            arrOrderData[i] = mStringCutter();
        }
    }
    
    //A method that returns an integer value of the count of order details
    private int mGetOrderLength() {
        int intLength = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '.') {
                intLength++ ;
            }
        }
        return intLength;
    }
    
    //A method that returns a String value of a substring deleted from a stringbuilder value
    private String mStringCutter() {
        String strCut = sb.substring(0, sb.indexOf(".")).trim();
        sb.delete(0, sb.indexOf(".")).deleteCharAt(sb.indexOf(".")).trimToSize();
        return strCut;
    }
        
    //A method to set values to Graphical User Interface
    private void mSetValuesToGUI() {
        String[] arrValues = mFilterForWaiterInterface(arrOrderData);
        txtFirstName.setText(arrValues[0]);
        txtFirstName.setEditable(false);
        
        txtNumberOfGuests.setText(arrValues[1]);
        txtNumberOfGuests.setEditable(false);
        
        txtDate.setText(arrValues[2]);
        txtDate.setEditable(false);
        
        txtTime.setText(arrValues[3]);
        txtTime.setEditable(false);
    }
    
    //A method that returns a filtered array of type string containing values
    //to be displayed in this interface
    private String[] mFilterForWaiterInterface(String[] arrRowData) {
        String[] arrFiltered = new String[4];
        String[] arrGuestNumberRange = new String[] {
          "1", "2", "3", "4", "5", "6", "7",
            "8"
        };
        for(int index = 0; index < arrRowData.length; index++){
            for(int i = 0; i < arrGuestNumberRange.length; i++){
                if(arrRowData[index].equals(arrGuestNumberRange[i])){
                    arrFiltered[1] = arrRowData[index];
                }
            }
        }
        
        for(int i = 0; i < arrRowData.length; i++){
            if(!(arrRowData[i].contains("Burger") || arrRowData[i].contains("Twista")
                    || arrRowData[i].contains("Wrap") || arrRowData[i].contains("Stoney")
                    || arrRowData[i].equals("Coca Cola") || arrRowData[i].contains("Sprite")
                    || arrRowData[i].contains("Fanta") || arrRowData[i].contains("Blue")
                    || arrRowData[i].contains("String") || arrRowData[i].contains("Black"))) {
                if(arrRowData[i].contains("/")) {
                    arrFiltered[2] = arrRowData[i];
                } else if(arrRowData[i].contains(":")) {
                    arrFiltered[3] = arrRowData[i];
                } else if(arrRowData[i].length() > 2){
                    arrFiltered[0] = arrRowData[i];
                }
            }
        }
        return arrFiltered;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPanel = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumberOfGuests = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFirstName.setText("Firstname");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Number Of Guests");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTime.setText("Time");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDate.setText("Date");

        javax.swing.GroupLayout jpPanelLayout = new javax.swing.GroupLayout(jpPanel);
        jpPanel.setLayout(jpPanelLayout);
        jpPanelLayout.setHorizontalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(jLabel2)
                    .addComponent(lblTime)
                    .addComponent(lblDate))
                .addGap(69, 69, 69)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFirstName)
                    .addComponent(txtNumberOfGuests)
                    .addComponent(txtTime)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jpPanelLayout.setVerticalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumberOfGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(frmWaiterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmWaiterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmWaiterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmWaiterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmWaiterInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpPanel;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtNumberOfGuests;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
