package stayawake;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author darwinnacionales
 */
public class StayAwake
{
    public static void main(String[] args)
    {
        Thread unliThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Robot robot = new Robot();
                    
                    while(true)
                    {
                        System.out.println("Moves the mouse");
                        robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX() + 1, (int)MouseInfo.getPointerInfo().getLocation().getY());
                        robot.delay(5);
                        robot.mouseMove((int)MouseInfo.getPointerInfo().getLocation().getX() - 1, (int)MouseInfo.getPointerInfo().getLocation().getY());
                        robot.delay(60000); // Delays the code from running again for 1 minute
                    }//end while
                } catch (AWTException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }//end catch
            }//end run
        });
        
        unliThread.start();
    }//end method main
}//end class StayAwake
