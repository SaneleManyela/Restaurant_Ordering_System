/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class OrderingSystem extends JFrame{
    public OrderingSystem() {
        this.setTitle("McDonald Ordering System"); //Sets the title of the frame
        this.setExtendedState(MAXIMIZED_BOTH); //Display the form in full screen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //On an event of closing this form, the whole application will exit
        mMainWindow(); //A method call to create graphical user interface of this form
        this.setVisible(true); //this displays the form
    }
    
    //A method that creates the main window by positioning the menu on a JPanel container
    private void mMainWindow() {
        JPanel jpPanel = new JPanel(new BorderLayout()); //Creates a JPanel object and set its layout to BorderLayout
        jpPanel.setOpaque(true); //prepares the JPanel to be set background colour
        jpPanel.setBackground(new Color(125, 176, 255)); //The JPanel object is set the colour
        jpPanel.add(mMenu(), BorderLayout.NORTH); //The JPanel object adds a JMenuBar in the north border of the window
        this.add(jpPanel); //The JPanel object is added to this form
    }
    
    /**
     * A method that defines a JMenuBar, the menu bar's menus,
     * and the menus' menu items.
     */
    private JMenuBar mMenu() {
        JMenuBar mbMenuBar = new JMenuBar(); //Instantiation of a JMenuBar object
        JMenu mnuFile = new JMenu("File"); //Instantiation of a JMenu object File
        JMenuItem mnuItemExit = new JMenuItem("Exit"); //Instantiation of a JMenuItem object Exit
        mnuItemExit.addActionListener(new ActionListener() { //an action listener is added to the menu item mnuItemExit so that when clicked, the application stops
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0); //Stops the application
           }
        });
    
        JMenu mnuOrder = new JMenu("Order"); //Instantiation of a JMenu object Order
        JMenuItem mnuItemOrder = new JMenuItem("Place Your Order"); //Instantiation of a JMenuItem object Order
        mnuItemOrder.addActionListener(new ActionListener() { //an action listener is added to the menu item mnuItemOrder so that when clicked, the order form is displayed
            @Override
            public void actionPerformed(ActionEvent e) {
                frmOrderWindow frmOrder = new frmOrderWindow();
                frmOrder.show();
            }
        });
        
        JMenu mnuWaiterInterface = new JMenu("Waiter"); //Instantiation of a JMenu object Waiter
        JMenuItem mnuItemWaiterInterface = new JMenuItem("Waiter Interface"); //Instantiation of a JMenuItem object Order
        mnuItemWaiterInterface.addActionListener(new ActionListener() { //an action listener is added to the menu item mnuItemWaiterInterface so that when clicked, the waiter interface is displayed
            @Override
            public void actionPerformed(ActionEvent e) {
                frmWaiterInterface frmWaiter = new frmWaiterInterface();
                frmWaiter.setVisible(true);
            }
        });
        
        JMenu mnuKitchenInterface = new JMenu("Kitchen");
        JMenuItem mnuItemKitchenInterface = new JMenuItem("Kitchen Interface");
        mnuItemKitchenInterface.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmKitchenInterface frmKitchen = new frmKitchenInterface();
                frmKitchen.setVisible(true);
            }
        });
        mnuFile.add(mnuItemExit); //Adds menu item exit to the JMenu File
        mbMenuBar.add(mnuFile); //Adds JMenu File to the menu bar
        mnuOrder.add(mnuItemOrder);
        mbMenuBar.add(mnuOrder);
        mnuWaiterInterface.add(mnuItemWaiterInterface);
        mbMenuBar.add(mnuWaiterInterface);
        mnuKitchenInterface.add(mnuItemKitchenInterface);
        mbMenuBar.add(mnuKitchenInterface);
        return mbMenuBar; //returns the JMenuBar
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderingSystem order = new OrderingSystem(); //Instantiation of an object of class OrderingSystem
    }
}
