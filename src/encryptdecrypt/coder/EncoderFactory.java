package encryptdecrypt.coder;

public class EncoderFactory {
    public static Encoder createEncoder(String type, int shift) {
        if (type.toLowerCase().equals("unicode"))
            return new UnicodeShiftEncoder(shift);
        else if (type.toLowerCase().equals("shift"))
            return new AlphabetShiftEncoder(shift);
        return null;
    }
}
