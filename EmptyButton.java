
// imports the swing package
import javax.swing.*;
/**
 *  |-----------------------------------------------------------|
 *  |                          EmptyButton                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     of the buttons            |     EmptyButtonListener   |
 *  |                               |       TreasureButton      |
 *  |     Shows empty when clicked  |        GameView           |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class EmptyButton extends JButton
{   // constructor for the button
    public EmptyButton()
    {   // text is initially sent to nothing
        this.setText("");
    }// method to reveal to the user what the button is 
    public void showButton()
    {   // sets the button to 0 for nothing there 
        this.setText("0");
    }// checks to see if the current button is a treasure or not
    public boolean isTreasure()
    {   // returns false
        return false;
    }// method to see if the current button is a troll
    public boolean isTroll()
    {   // returns false
        return false;
    }
}
