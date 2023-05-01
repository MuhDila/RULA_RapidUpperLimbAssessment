package GUI_Custom;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(13, 13));
        setForeground(new Color(40,167,69));
        setBackground(Color.WHITE);
    }
}