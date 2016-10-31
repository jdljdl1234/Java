// Stuart Reges
// 8/31/99
// grader: self
//
// Class LunarInfoPanel displays a text version of the lunar lander's state:
// fuel level, velocity and altitude

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LunarInfoPanel extends JPanel
{
        public LunarInfoPanel(LunarLander lander)
        {
                myLander = lander;
                setLayout(new GridLayout(3, 1));
                JPanel p;

                // create fuel subpanel
                p = new JPanel();
                myFuel = new JTextField(5);
                myFuel.setEditable(false);
                p.add(new JLabel("Fuel"));
                p.add(myFuel);
                add(p);

                // create velocity subpanel
                p = new JPanel();
                myVelocity = new JTextField(10);
                myVelocity.setEditable(false);
                p.add(new JLabel("Velocity"));
                p.add(myVelocity);
                add(p);

                // create altitude subpanel
                p = new JPanel();
                myAltitude = new JTextField(7);
                myAltitude.setEditable(false);
                p.add(new JLabel("Altitude"));
                p.add(myAltitude);
                add(p);

                update();
        }

        public void update()
        // post: updates text fields
        {
                myFuel.setText(myLander.getFuel() + " units");
                myVelocity.setText(myLander.getVelocity() + " meters/second");
                myAltitude.setText(myLander.getAltitude() + " meters");
        }

        private LunarLander myLander;   // lander to query
        private JTextField myFuel;      // text field for fuel
        private JTextField myVelocity;  // text field for velocity
        private JTextField myAltitude;  // text field for altitude
}
