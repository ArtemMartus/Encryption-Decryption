package encryptdecrypt.coder;

class UnicodeShiftEncoder implements Encoder {
    final int shift;

    public UnicodeShiftEncoder(int shift) {
        this.shift = shift;
    }

    @Override
    public String encode(String input) {
        return input.codePoints().map((int code) -> code + shift).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Override
    public String decode(String input) {
        return input.codePoints().map((int code) -> code - shift).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
