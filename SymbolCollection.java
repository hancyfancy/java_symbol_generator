import java.util.Arrays;

public class SymbolCollection extends AbstractSymbols {
    /* Precondition symbols is sorted */
    private Symbol[] usedSymbols = null;
    private Symbol[] unusedSymbols = null;
    public SymbolCollection(Symbol[] unusedSymbols) {
        this.setUnusedSymbols(unusedSymbols);
        this.setUsedSymbols(new Symbol[this.getMaximumNumberOfBits()]);
    }
    public Symbol[] getUsedSymbols() {
        return this.usedSymbols;
    }
    private void setUsedSymbols(Symbol[] newUsedSymbols) {
        if ((newUsedSymbols != null) && (newUsedSymbols.length == this.getMaximumNumberOfBits())) {
            this.usedSymbols = newUsedSymbols;
        }
    }
    public Symbol[] getUnusedSymbols() {
        return this.unusedSymbols;
    }
    private void setUnusedSymbols(Symbol[] newUnusedSymbols){
        if ((newUnusedSymbols != null) && (newUnusedSymbols.length == this.getMaximumNumberOfBits())) {
            this.unusedSymbols = newUnusedSymbols;
        }
    }
    public Symbol getUsedSymbol(String symbolHex) {
        Symbol symbol = null;
        if ((symbolHex != null) && (symbolHex != "")) {
            Symbol[] usedSymbols = getUsedSymbols();
            for (int i = 0; i < usedSymbols.length; i++) {
                Symbol currentSymbol = usedSymbols[i];
                if (currentSymbol.getHex().equals(symbolHex)) {
                    symbol = currentSymbol;
                    deleteUsedSymbol(symbol);
                    setUnusedSymbol(symbol);
                }
            }
        }
        return symbol;
    }
    public void setUsedSymbol(Symbol newUsedSymbol) {
        if (newUsedSymbol != null) {
            Symbol[] usedSymbols = getUsedSymbols();
            if (getUnusedSymbol(newUsedSymbol.getHex()) == null) {
                int ceiling = super.decimal(newUsedSymbol.getDecimal());
                int floor = this.getHexLowerBound();
                usedSymbols[ceiling-floor] = newUsedSymbol;
            }
        }
    }
    public void deleteUsedSymbol(Symbol existingUsedSymbol) {
        if (existingUsedSymbol != null) {
            Symbol[] usedSymbols = getUsedSymbols();
            for (int i = 0; i < usedSymbols.length; i++) {
                Symbol currentSymbol = usedSymbols[i];
                if (currentSymbol.getHex() == existingUsedSymbol.getHex()) {
                    currentSymbol = null;
                }
            }
        }
    }
    public Symbol getUnusedSymbol(String symbolHex) {
        Symbol symbol = null;
        if ((symbolHex != null) && (symbolHex != "")) {
            Symbol[] unusedSymbols = getUnusedSymbols();
            for (int i = 0; i < unusedSymbols.length; i++) {
                Symbol currentSymbol = unusedSymbols[i];
                if (currentSymbol.getHex().equals(symbolHex)) {
                    symbol = currentSymbol;
                    deleteUnusedSymbol(symbol);
                    //setUsedSymbol(symbol);
                    break;       
                }
            }
        }
        return symbol;
    }
    public void setUnusedSymbol(Symbol newUnusedSymbol) {
        if (newUnusedSymbol != null) {
            Symbol[] unusedSymbols = getUnusedSymbols();
            if (getUsedSymbol(newUnusedSymbol.getHex()) == null) {
                int ceiling = super.decimal(newUnusedSymbol.getDecimal());
                int floor = this.getHexLowerBound();
                unusedSymbols[ceiling-floor] = newUnusedSymbol;
            }
        }
    }
    public void deleteUnusedSymbol(Symbol existingUnusedSymbol) {
        if (existingUnusedSymbol != null) {
            Symbol[] unusedSymbols = getUnusedSymbols();
            for (int i = 0; i < unusedSymbols.length; i++) {
                Symbol currentSymbol = unusedSymbols[i];
                if (currentSymbol.getHex() == existingUnusedSymbol.getHex()) {
                    currentSymbol = null;
                }
            }
        }
    }
    public String toString() {
        return Arrays.toString(getUnusedSymbols()).replace("]","").replace("[","");
    }
}
