public class Keyboard {
    public KeyboardType keyboardType;
    public KeyboardLight keyboardLight;
    public int keyboardWeight;

    public Keyboard(KeyboardType keyboardType, KeyboardLight keyboardLight, int keyboardWeight) {
        this.keyboardType = keyboardType;
        this.keyboardLight = keyboardLight;
        this.keyboardWeight = keyboardWeight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public KeyboardLight getKeyboardLight() {
        return keyboardLight;
    }

    public int getKeyboardWeight() {
        return keyboardWeight;
    }
}
