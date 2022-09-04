/**
 *  |-----------------------------------------------------------|
 *  |                          TreasureButton                   |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |                               |     TreasureButtonListener|
 *  |                               |       EmptyButton         |
 *  |   class for the TreasureButton|        GameView           |
 *  |   object                      |                           |
 *  |-------------------------------+---------------------------|

 */
public class TreasureButton extends EmptyButton
{
    public TreasureButton()
    {
    
    }// method to show the user what the button is 
    public void showButton()
    {   // reveals the button to be a treasure
        this.setText("$");
    }// checks to see if the current button is a treasure or not
    public boolean isTreasure()
    {   // returns true
        return true;
    }// method to see if the current button is a troll
    public boolean isTroll()
    {   // returns false
        return false;
    }
}

