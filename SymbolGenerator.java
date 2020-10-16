import java.util.concurrent.ThreadLocalRandom;

public class SymbolGenerator extends AbstractSymbols {
    public SymbolGenerator() {}
    public Symbol[] generateSymbols(int multiplier) {
        Symbol[] symbols = new Symbol[super.getMaximumNumberOfBits()];
        for (Integer i = 0; i < super.getMaximumNumberOfBits(); i++) {
            if ((multiplier >= 0) && (multiplier <= Math.ceil(super.getHexUpperBound()/super.getMaximumNumberOfBits()))) {
                Symbol symbol = new Symbol(i + super.getMaximumNumberOfBits()*multiplier);
                if (symbol.toString() != null) {
                    symbols[i] = symbol;
                }
            }
        }
        return symbols;
    }
    public String getRandomHex() {
        Integer randomDecimal = ThreadLocalRandom.current().nextInt(super.getHexLowerBound(), super.getHexUpperBound() + 1);
        String randomHex = super.hex(randomDecimal);
        return randomHex;
    }
}
