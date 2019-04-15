import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel(){
        setLayout(new BorderLayout());

        textArea = new JTextArea();

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    public void appendText(String text){
        textArea.append(text);
    }

    public void clearText(){
        textArea.setText("");
    }
}
