package SeaBattle;

public enum GameSymbol {
    SMALL(1, "🛳️", "ТОРПЕДНЫЙ КАТЕР"),
    MEDIUM(2, "🛳️", "ЭСМИНЕЦ"),
    LARGE(3, "🛳️", "КРЕЙСЕР"),
    HUGE(4, "🛳️", "ЛИНКОР"),

    ATTACK("💥", "ПОПАДАНИЕ"),
    MISS("⭕","ПРОМАХ"),
    EMPTY("⬜","ПУСТАЯ КЛЕТКА"),
    KILL("❌","УБИЙСТВО"),
    OREOL("\uD83D\uDD39","ОРЕОЛ");

    private String description;
    private String symbol;
    private int size;


    GameSymbol(int size, String symbol, String description) {
        this.size = size;
        this.symbol = symbol;
        this.description = description;
    }

    GameSymbol(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
        this.size = 0;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
