import java.awt.event.*;

/**
 *  |-----------------------------------------------------------|
 *  |                          ExitMenuListener                 |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |                               |                           |
 *  |     Closes game               |                           |
 *  |                               |        GameView           |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class ExitMenuListener implements ActionListener
{   // actionPerformed method
    public void actionPerformed(ActionEvent e)
    {   // exits the program
        System.exit(0);
    }
}
