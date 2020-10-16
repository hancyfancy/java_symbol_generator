public class Main {
    public static void main(String[] args) {
        String output = "";
        SymbolGenerator symbolGenerator = new SymbolGenerator();
        for (int i = 0; i < 40; i++) {
            SymbolCollection symbolCollection = new SymbolCollection(symbolGenerator.generateSymbols(i));
            output = output + symbolCollection.toString();
        }
        System.out.println(output);
    }
}
