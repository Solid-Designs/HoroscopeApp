import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame(){
        super("Horoscope App");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        formPanel = new FormPanel();

        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        formPanel.setListener(new FormListener() {
            @Override
            public void formEventOccurred(FormEvent e) {
                textPanel.clearText();
                textPanel.appendText(e.getSign() + "\n");
            }
        });

        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
