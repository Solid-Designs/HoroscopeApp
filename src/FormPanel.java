import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FormPanel extends JPanel {
    private JComboBox signComboBox;
    private JButton submitButton;
    private FormListener listener;

    public FormPanel(){
        setLayout(new GridBagLayout());

        signComboBox = new JComboBox();
        submitButton = new JButton("Submit");

        // Add all of the horoscope signs to the combo box
        DefaultComboBoxModel signComboBoxModel = new DefaultComboBoxModel();
        signComboBoxModel.addElement("ARIES");
        signComboBoxModel.addElement("TAURUS");
        signComboBoxModel.addElement("GEMINI");
        signComboBoxModel.addElement("CANCER");
        signComboBoxModel.addElement("LEO");
        signComboBoxModel.addElement("VIRGO");
        signComboBoxModel.addElement("LIBRA");
        signComboBoxModel.addElement("SCORPIO");
        signComboBoxModel.addElement("SAGITTARIUS");
        signComboBoxModel.addElement("CAPRICORN");
        signComboBoxModel.addElement("AQUARIUS");
        signComboBoxModel.addElement("PISCES");
        signComboBox.setModel(signComboBoxModel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sign = (String)signComboBox.getSelectedItem();
                // Do the website scraping here:
                try{
                    Document document = Jsoup.connect(getUrl(sign)).get();

                    Element horoscope = document.select("p").first();
                    FormEvent ev = new FormEvent(this, horoscope.text());

                    if(listener != null){
                        listener.formEventOccurred(ev);
                    }

                } catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        layoutSettings();
    }

    public String getUrl(String sign){
        String url = "https://www.astrology.com";

        switch(sign){
            case "ARIES":
                url = url + "/horoscope/daily/aries.html";
                break;
            case "TAURUS":
                url = url + "/horoscope/daily/taurus.html";
                break;
            case "GEMINI":
                url = url + "/horoscope/daily/gemini.html";
                break;
            case "CANCER":
                url = url + "/horoscope/daily/cancer.html";
                break;
            case "LEO":
                url = url + "/horoscope/daily/leo.html";
                break;
            case "VIRGO":
                url = url + "/horoscope/daily/virgo.html";
                break;
            case "LIBRA":
                url = url + "/horoscope/daily/libra.html";
                break;
            case "SCORPIO":
                url = url + "/horoscope/daily/scorpio.html";
                break;
            case "SAGITTARIUS":
                url = url + "/horoscope/daily/sagittarius.html";
                break;
            case "CAPRICORN":
                url = url + "/horoscope/daily/capricorn.html";
                break;
            case "AQUARIUS":
                url = url + "/horoscope/daily/aquarius.html";
                break;
            case "PISCES":
                url = url + "/horoscope/daily/pisces.html";
                break;
        }

        return url;
    }

    public void setListener(FormListener listener){
        this.listener = listener;
    }

    public void layoutSettings(){
        GridBagConstraints gc = new GridBagConstraints();

        // First Row ----------
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0;

        add(signComboBox, gc);

        // Second Row ----------
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 0;

        add(submitButton, gc);
    }
}
