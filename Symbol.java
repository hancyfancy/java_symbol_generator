public class Symbol extends AbstractSymbols {
    private String ascii = null;
    private String hex = null;
    private Integer decimal = null;
    public Symbol(Integer newDecimal) {
        this.setDecimal(newDecimal);
        this.setHex(newDecimal);
        this.setAscii(getHex());
    }
    public String getAscii() {
        return this.ascii;
    }
    private void setAscii(String newHex) {
        this.ascii = super.ascii(newHex);
    }
    public String getHex() {
        return this.hex;
    }
    private void setHex(Integer newDecimal) {
        this.hex = super.hex(newDecimal);
    }
    public Integer getDecimal() {
        return this.decimal;
    }
    private void setDecimal(Integer newDecimal) {
        this.decimal = super.decimal(newDecimal);
    }
    public String toString() {
        //return getHex();
        return getAscii();
    }
}
