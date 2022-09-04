import java.awt.event.*;
/**
 *  |-----------------------------------------------------------|
 *  |                       TrollButtonListener                 |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  | listen for button press       |                           |
 *  |                               |     TrollButton           |
 *  |                               |                           |
 *  | change values of button       |       GameView            |
 *  | and text fields               |                           |
 *  |-------------------------------+---------------------------|
*/
public class TrollButtonListener implements ActionListener
{   // EmptyButtonListener has-a EmptyButton
    private TrollButton button;
    // EmptyButtonListener has-a GameView
    private GameView game;
    // constructor to get the game and the button pressed
    public TrollButtonListener(GameView game, TrollButton button)
    {   // sets button pressed
        this.button = button;
        // sets the game in play
        this.game = game;
    }// action performed method for the event
    public void actionPerformed(ActionEvent e)
    {   // sets the button pressed to "Troll"
        button.showButton();
        // disables the button 
        button.setEnabled(false);
        // calls the foundNothing method
        game.foundTroll();
        // sets the last move to landing on a troll
        game.trollMove();
        // if statement to see if the game is over
        if (game.isGameOver())
        {   // if game is over then it will end game
            game.endGame();
        }
    }
}
