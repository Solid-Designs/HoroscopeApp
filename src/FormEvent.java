import java.util.EventObject;

public class FormEvent extends EventObject {
    private String horoscope;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String horoscope) {
        super(source);
        this.horoscope = horoscope;
    }

    public String getSign() {
        return horoscope;
    }

    public void setSign(String sign) {
        this.horoscope = sign;
    }
}
