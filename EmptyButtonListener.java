import java.awt.event.*;
/**
 *  |-----------------------------------------------------------|
 *  |                       EmptyButtonListener                 |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  | listen for button press       |                           |
 *  |                               |     EmptyButton           |
 *  |                               |                           |
 *  | change values of button       |       GameView            |
 *  | and text fields               |                           |
 *  |-------------------------------+---------------------------|
*/
public class EmptyButtonListener implements ActionListener
{   // EmptyButtonListener has-a EmptyButton
    private EmptyButton button;
    // EmptyButtonListener has-a GameView
    private GameView game;
    // constructor to get the game and the button pressed
    public EmptyButtonListener(GameView game, EmptyButton button)
    {   // sets button pressed
        this.button = button;
        // sets the game in play
        this.game = game;
    }// action performed method for the event
    public void actionPerformed(ActionEvent e)
    {   // sets the button pressed to "0"
        button.showButton();
        // disables the button 
        button.setEnabled(false);
        // calls the foundNothing method
        game.foundNothing();
        // sets the text to the last move
        game.nothingMove();
        // if statement to see if the game is over
        if (game.isGameOver())
        {   // if game is over then it will end game
            game.endGame();
        }
    }
}
