public class ROM {
    public ROMType romType;
    public int romCapacity;
    public int romWeight;

    public ROM(ROMType romType, int romCapacity, int romWeight) {
        this.romType = romType;
        this.romCapacity = romCapacity;
        this.romWeight = romWeight;
    }

    public ROMType getROMType() {
        return romType;
    }

    public int getROMCapacity() {
        return romCapacity;
    }

    public int getROMWeight() {
        return romWeight;
    }
}
