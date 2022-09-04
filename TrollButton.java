/**
 *  |-----------------------------------------------------------|
 *  |                          TrollButton                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |                               |     TrollButtonListener   |
 *  |                               |       EmptyButton         |
 *  |   class for the TrollButton   |        GameView           |
 *  |   object                      |                           |
 *  |-------------------------------+---------------------------|

 */
public class TrollButton extends EmptyButton
{   // constructor
    public TrollButton()
    {
    
    }// method to show the user what the button is 
    public void showButton()
    {   // reveals the button to be a troll
        this.setText("Troll");
    }// checks to see if the current button is a treasure or not
    public boolean isTreasure()
    {   // returns fasle
        return false;
    }// method to see if the current button is a troll
    public boolean isTroll()
    {   // returns true
        return true;
    }
}