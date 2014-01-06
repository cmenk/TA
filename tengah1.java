package TA;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Agus Sumarna
 */
public class tengah1 {
     public tengah1(JFrame form) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - form.getSize().width)/2;
        int y = (dim.height - form.getSize().height)/2;
        form.setLocation(x,y);
    }
}
