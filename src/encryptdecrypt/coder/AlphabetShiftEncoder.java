package encryptdecrypt.coder;

class AlphabetShiftEncoder implements Encoder {
    final int shift;
    final static int alphabetSize = 'z' - 'a' + 1;

    public AlphabetShiftEncoder(int shift) {
        this.shift = shift % alphabetSize;
    }

    private int shiftChar(int codePoint, boolean encode) {
        final int shiftBase;

        if (codePoint >= 'A' && codePoint <= 'Z') {
            shiftBase = 'A';
        } else if (codePoint >= 'a' && codePoint <= 'z') {
            shiftBase = 'a';
        } else
            shiftBase = -1;
        if (shiftBase != -1) {
            codePoint -= shiftBase;
            codePoint += encode ? shift : -shift;
            codePoint %= alphabetSize;
            if (codePoint < 0)
                codePoint = shiftBase + alphabetSize + codePoint;
            else
                codePoint += shiftBase;
        }
        return codePoint;
    }

    @Override
    public String encode(String input) {
        return input.codePoints().map((int code) -> shiftChar(code, true)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Override
    public String decode(String input) {
        return input.codePoints().map((int code) -> shiftChar(code, false)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
