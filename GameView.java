
// importing swing package
import javax.swing.*;
// importing awt package
import java.awt.*;
// event listener import
import java.awt.event.ActionListener;
// action event import
import java.awt.event.ActionEvent;
// util import
import java.util.*;
// imports random 
import java.util.Random;
/**
 *  |-----------------------------------------------------------|
 *  |                          GameView                         |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Show the game and         |     EmptyButtonListener   |
 *  |     populate the board        |   TreasureButtonListener  |
 *  |                               |       TreasureButton      |
 *  |                               |                           |
 *  |      contain methods for      |        EmptyButton        |
 *  |     listeners                 |                           |
 *  |-------------------------------+---------------------------|
 */
public class GameView extends JFrame 
{   // variable to hold the title
    private String title = "Treasure Hunt"; 
    // jlabel for the title
    private JLabel titleView = new JLabel();
    // jlabel for the try counter
    private JLabel tryCounter = new JLabel();
    // jlabel for the treasure found counter
    private JLabel treasureFoundCounter = new JLabel();
    // jlabel for the treasures left counter
    private JLabel treasuresLeftCounter = new JLabel();
    // jlabel for the points the player has
    private JLabel totalPointsCounter = new JLabel();
    // jlabel for the key
    private JLabel key = new JLabel();
    // jpanel for the gameboard for the buttons
    private JPanel gameBoard;
    // emptybutton variable for the emptybuttons
    private EmptyButton emptyButton;
    // treasurebutton variable for the treasurebuttons
    private TreasureButton treasureButton;
    // trollButton variable for the TrollButtons
    private TrollButton trollButton;
    // random object for randomly placing treasure buttons
    private int numberOfTries = 50;
    // variable for the treasure's found
    private int treasureFoundCount = 0;
    // variable for the treasures that are left counter
    private int treasuresLeft;
    // variable for total points
    private int totalPoints = 0;
    // variable for points given for a treasure button
    private int points;
    // array to store both different buttons 64 times
    private EmptyButton[] buttons = new EmptyButton[64];
    // string for the last move to be displayed
    private JLabel lastMoveField = new JLabel();
    // JPanel for the west side that uses a GridLayout 
    private JPanel westPanel = new JPanel(new GridLayout(2,0));
    // JPanel for the north side which uses a borderlayout
    private JPanel northPanel = new JPanel(new BorderLayout());
    // JPanel for the south side which uses a borderlayout
    private JPanel southPanel = new JPanel(new GridLayout(2,0));
    // JPanel for the east side which uses a borderlayout
    private JPanel eastPanel = new JPanel(new GridLayout(2,0));
    // creates a JMenuBar for the menus
    private JMenuBar menuBar = new JMenuBar();
    // creates a menu for the game to exit and about section
    private JMenu gameMenu = new JMenu("Game");
    // menu item for exiting the game
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    // menu item for about section
    private JMenuItem aboutMenuItem = new JMenuItem("About");
    // the constructor for the class to create the game
    public GameView()
    {  // setting the title for the JFrame
       this.setTitle(title);
       // setting the default close operation for the JFrame
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setting the size for the JFrame
       this.setSize(800, 800);
       // setting the layout as a new borderlayout object
       this.setLayout(new BorderLayout(100, 100));
       
       // sets the JMenuBar
       this.setJMenuBar(menuBar);
       // adds the gameMenu to the menuBar
       menuBar.add(gameMenu);
       // adds the about menu item to the gameMenu
       gameMenu.add(aboutMenuItem);
       // creates a JSeparator 
       JSeparator separator = new JSeparator();
       // adds the separator
       gameMenu.add(separator);
       // adds the exit menu item to the gameMenu
       gameMenu.add(exitMenuItem);
       // adds an action listener for the about menu 
       aboutMenuItem.addActionListener(new AboutMenuListener(this));
       // adds an action listener for the exit menu item
       exitMenuItem.addActionListener(new ExitMenuListener());
       
       // sets the last move
       lastMoveField.setText("Last move: NA");
       // setting the text for the title 
       titleView.setText(title); 
       // centers the title at the top
       titleView.setHorizontalAlignment(JLabel.CENTER);
       // adding the title JPanel and setting it to the north end of the borderlayout
       northPanel.add(titleView);
       // setting text for the amount of tries 
       tryCounter.setText("Tries: " + String.valueOf(numberOfTries));
       // adding the trycounter JPanel and setting it to the west side of the borderlayout
       westPanel.add(tryCounter);
       // adds the lastMoveField to the westPanel
       westPanel.add(lastMoveField);
       // sets the totalPointsCounter 
       totalPointsCounter.setText("Total Points: 0");
       // adds the totalPointsCounter to the southPanel
       southPanel.add(totalPointsCounter);
       // creates the text for the key
       key.setText("Nothing: '0' | Treasure: '$' | Troll: 'Troll'   ");
       // adds the key to the eastPanel
       eastPanel.add(key);
       // sets the totalPointsCounter to the center
       totalPointsCounter.setHorizontalAlignment(JLabel.CENTER);
       // sets the treasureFoundCounter to the center
       treasureFoundCounter.setHorizontalAlignment(JLabel.CENTER);
       
       // setting text for the treasures found counter 
       treasureFoundCounter.setText("Treasures found: " + String.valueOf(treasureFoundCount));
       // adds the JPanel for the treasureFoundCounter to the south of the borderlayout
       southPanel.add(treasureFoundCounter);
       // sets text for the treasures that are left
       treasuresLeftCounter.setText("Treasures left: " + String.valueOf(treasuresLeft));
       // adds the JPanel for the treasures left counter to the east of the borderlayout
       eastPanel.add(treasuresLeftCounter);
       
       // adds the northpanel to the JFrame
       this.add(northPanel, BorderLayout.NORTH);
       // adds the southpanel to the JFrame
       this.add(southPanel, BorderLayout.SOUTH);
       // adds the eastPanel to the JFrame
       this.add(eastPanel, BorderLayout.EAST);
       // adds the westPanel to the JFrame
       this.add(westPanel, BorderLayout.WEST);
       
       // gameBoard variable is a new JPanel with GridLayout to hold the buttons for a 8x8
       gameBoard = new JPanel(new GridLayout(8, 8));
       
       // creates random object
       Random rand = new Random();
       // variable to hold random int from 1-64
       int r = rand.nextInt(64);
       
       // for loop through the buttons array
       for (int i = 0; i < buttons.length; i++)
       {   // if statement for populating the trolls (10 of them)
           if (i < 10)
           {    // while loop for if the current random button is populated
               while (buttons[r] != null)
               {    // new random number 
                   r = rand.nextInt(64);
               }
               // new troll object
               trollButton = new TrollButton();
               // the current random location will have a troll 
               buttons[r] = trollButton;
               // adds action listener for the troll button 
               trollButton.addActionListener(new TrollButtonListener(this, trollButton));
               // while there is something at the current button 
               while (buttons[r] != null)
               {    // new random number 
                   r = rand.nextInt(64);
               }
           }
           // if statement for if the current iteration is less than 20 to populate the treasures
           if (i < 20)
           {    
               // creates new TreasureButton
               treasureButton = new TreasureButton();
               // random index in the array is assigned to the new treasureButton
               buttons[r] = treasureButton;
               // treasuresLeft counter is increased by 1 everytime a new treasureButton is created
               treasuresLeft += 1;
               // sets the new treasuresLeftCounter
               treasuresLeftCounter.setText("Treasures left: " + String.valueOf(treasuresLeft));
               //adds the action listener for each one of the new treasureButtons
               treasureButton.addActionListener(new TreasureButtonListener(this, treasureButton));
               // while loop for if there is something at the current index
               while (buttons[r] != null)
               {    // creates new random number to place object
                   r = rand.nextInt(64); 
               }
           }
           
       }// for loop to add the buttons
       for (int i = 0; i < buttons.length; i++)
       {
           // if there isn't anything at the current location
           if (buttons[i] == null)
           {    // creates a new EmptyButton
               emptyButton = new EmptyButton();
               // the current iteration's location is the new EmptyButton
               buttons[i] = emptyButton;
               // adds action listener for each of the new EmptyButton's
               emptyButton.addActionListener(new EmptyButtonListener(this, emptyButton));
           }
       }
       for (int i = 0; i < buttons.length; i++)
       {
           gameBoard.add(buttons[i]);
       }
       // adds the gameBoard to the JFrame
       this.add(gameBoard);
       // packs the JFrame
       this.pack();
       // sets the JFrame to visible
       this.setVisible(true);
    }// method to reduce each try 
    public void reduceNumberOfTries()
    {   // reduces try by 1
        numberOfTries -= 1;
        // sets the tryCounter to the new value
        tryCounter.setText("Tries: " + String.valueOf(numberOfTries));
    }// method to give a random point for treasure and to add to total points
    public void givePoints()
    {   // random object for random point
        Random rand = new Random();
        // points variable to store random point between 1-3
        points = rand.nextInt(3 - 1 + 1) + 1;
        // adds the points given to the total points
        totalPoints += points;
        // sets the totalPointsCounter 
        totalPointsCounter.setText("Total Points: " + totalPoints);
    }
    // method if treasure is found
    public void foundTreasure()
    {   // adds one to the treasureFoundCounter
        treasureFoundCount += 1;
        // deducts one from the treasuresLeft counter
        treasuresLeft -= 1; 
        // updates the treasures found UI
        treasureFoundCounter.setText("Treasures found: " + String.valueOf(treasureFoundCount));
        // updates the treasures left UI
        treasuresLeftCounter.setText("Treasures left: " + String.valueOf(treasuresLeft));
        // calls the reduceNumberOfTries() method
        reduceNumberOfTries();
    }// method if nothing is found 
    public void foundNothing()
    {   
        // calls the reduceNumberOfTries() 
        reduceNumberOfTries();
    }// method to tell if the game is over
    public boolean isGameOver()
    {   
        // returns true if numberOfTries is 0 or the treasuresLeft is 0 
        return (numberOfTries == 0 || treasuresLeft == 0);
    }// method for if the user found a troll
    public void foundTroll()
    {   // treasures found is 0 
        treasureFoundCount = 0;
        // sets the new amount of treasures found
        treasureFoundCounter.setText("Treasures found: " + String.valueOf(treasureFoundCount));
        // takes away the amount of points the player has 
        totalPoints = 0;
        // sets the totalPoints so the player can see
        totalPointsCounter.setText("Total Points: " + totalPoints);
    }// method to set the lastMove to nothing
    public void nothingMove()
    {   // sets the last move to nothing
        lastMoveField.setText("Last move: nothing");
    }// method to set the lastMove to treasure
    public void treasureMove()
    {   // sets the last move to treasure
        lastMoveField.setText("Last move: treasure!" + " Points = " + points);
    }// method to set the lastMove to troll
    public void trollMove()
    {   // sets the last move to troll
        lastMoveField.setText("Last move: troll");
    }// method to create a new JFrame for about info
    public void aboutFrame()
    {   // creates new about JFrame
        JFrame about = new JFrame();
        // sets title of the JFrame
        about.setTitle("About");
        // sets the layout of the JFrame
        about.setLayout(new BorderLayout(100,100));
        // creates a new JLabel for the info
        JLabel info = new JLabel();
        // adds the information to the info JLabel
        info.setText("email: colinc3@yahoo.com");
        // creates a new JPanel for the info
        JPanel infoView = new JPanel(new BorderLayout());
        // adds the JPanel to the center of the BorderLayout
        infoView.add(info, BorderLayout.CENTER);
        // adds the info JPanel to the JFrame
        about.add(infoView);
        // packs the JFrame
        about.pack();
        // sets JFrame to visible
        about.setVisible(true);
    }
    // method to end the game
    public void endGame()
    {   // number of tries is depleted to 0 
        numberOfTries = 0;
        // sets the tryCounter to the new value
        tryCounter.setText("Tries: " + String.valueOf(numberOfTries));
        // sets the found counter to 0
        treasureFoundCount = 0;
        // if statement for if there is no more treasures left
        if (treasuresLeft == 0)
        {
            // tells the user is game over because the user won
            treasureFoundCounter.setText("Congratulations! You won! Game Over");
        }// else if the number of tries is 0 
        else if (numberOfTries == 0)
        {
            // tells the user is game over 
            treasureFoundCounter.setText("Game is over - Ran out of tries");
        }
        // changes the treasures left to 0
        treasuresLeft = 0;
        // updates the treasures left UI
        treasuresLeftCounter.setText("Treasures left: " + String.valueOf(treasuresLeft));
        // loops through the components in the JPanel 
        for (int i = 0; i < buttons.length; i++)
        {   // disables all of the buttons 
            buttons[i].setEnabled(false);
            // if the current button is a treasure
            if (buttons[i].isTreasure() || buttons[i].isTroll())
            {   // will show the current buttons type
                buttons[i].showButton();
            }
        }
    }
    // method needed for criteria
    public void play()
    {   
    }
    // main method to start the game
    public static void main(String[] args)
    {
        new GameView().play();
    }
}
