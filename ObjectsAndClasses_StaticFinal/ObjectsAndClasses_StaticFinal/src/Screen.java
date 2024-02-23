public class Screen {
    public String screenDiagonal;
    public ScreenType screenType;
    public int screenWeight;

    public Screen(String screenDiagonal, ScreenType screenType, int screenWeight) {
        this.screenDiagonal = screenDiagonal;
        this.screenType = screenType;
        this.screenWeight = screenWeight;
    }

    public String getScreenDiagonal() {
        return screenDiagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public int getScreenWeight() {
        return screenWeight;
    }
}
