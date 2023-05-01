package GUI_Custom;

import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }

    public boolean getSelectedIndex(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
