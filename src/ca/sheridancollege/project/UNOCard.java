package ca.sheridancollege.project;

/**
 *
 * @author Shubarna Kc
 */
public class UNOCard {
    private Color color;
    private Value value;

    public UNOCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }
}
