import java.awt.event.*;

/**
 *  |-----------------------------------------------------------|
 *  |                          AboutMenuListener                |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |                               |                           |
 *  |  Brings up info on developer  |                           |
 *  |                               |        GameView           |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class AboutMenuListener implements ActionListener
{
    // variable to hold the GameView being used
    private GameView game;
    // constructor 
    public AboutMenuListener(GameView game)
    {   // sets the game instance variable
        this.game = game;
    }// actionPerforemd method for when the menu item is pressed
    public void actionPerformed(ActionEvent e)
    {   // calls teh aboutFrame method
        game.aboutFrame();
    }
}
