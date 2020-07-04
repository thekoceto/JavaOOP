package P01_CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        int index = 0;
        for (CardSuit value : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", index++, value.name());
        }
    }
}
