import java.awt.event.*;
/**
 *  |-----------------------------------------------------------|
 *  |                    TreasureButtonListener                 |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  | listen for button press       |                           |
 *  |                               |     TreasureButton        |
 *  | show "$" when clicked.        |                           |
 *  | change values of button       |       GameView            |
 *  | and text fields               |                           |
 *  |-------------------------------+---------------------------|
 */
public class TreasureButtonListener implements ActionListener
{   // TreasureButtonListener has-a button
    private TreasureButton button;
    // TreasureButtonListener has-a GameView
    private GameView game;
    // constructor to set the game in play and the button pressed
    public TreasureButtonListener(GameView game, TreasureButton button)
    {   // the button pressed is set to the instance variable
        this.button = button;
        // the game in play is set to the instance variable
        this.game = game;
    }// action performed method for when the button is pressed
    public void actionPerformed(ActionEvent e)
    {   
        // calls to the givePoints method to get a random point 
        game.givePoints();
        // sets the text of the button to "$"
        button.showButton();
        // sets the button enabled to false 
        button.setEnabled(false);
        // calls the foundTreasure method
        game.foundTreasure();
        // sets the last move to treasure
        game.treasureMove();
        // checks to see if the game is over
        if (game.isGameOver())
        {   // ends the game if the criteria is met
            game.endGame();
        }
    }
}