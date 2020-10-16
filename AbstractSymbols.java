abstract class AbstractSymbols {
    private final int maximumNumberOfBits = 255;
    private final int hexLowerBound = 0;
    private final int hexUpperBound = 10175;
    public int getMaximumNumberOfBits() {
        return this.maximumNumberOfBits;
    }
    public int getHexLowerBound() {
        return this.hexLowerBound;
    }
    public int getHexUpperBound() {
        return this.hexUpperBound;
    }
    public String ascii(String binary) {
        Utility utility = new Utility();
        return (isValid(binary) ? utility.bytesToString("UTF-16", utility.hexadecimalToBytes(binary)) : null);
    }
    public String hex(Integer decimal) {
        Utility utility = new Utility();
        return (isValid(decimal) ? utility.decimalToHexadecimal(decimal) : null);
    }
    public Integer decimal(Integer decimal) {
        return (isValid(decimal) ? decimal : -1);
    }
    public boolean isValid(Integer decimal) {
        return ((decimal >= getHexLowerBound()) && (decimal <= getHexUpperBound()));
    }
    public boolean isValid(String genericString) {
        return ((genericString != null) && (genericString != ""));
    }
}
