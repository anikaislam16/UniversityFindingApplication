package combo_suggestion;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class scrllbar extends JScrollBar {

    public scrllbar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(180, 180, 180));
        setBackground(Color.WHITE);
        setUnitIncrement(20);
    }
}
