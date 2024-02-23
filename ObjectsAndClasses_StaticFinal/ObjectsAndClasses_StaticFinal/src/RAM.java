public class RAM {
    public RAMType ramType;
    public int ramCapacity;
    public int ramWeight;

    public RAM(RAMType ramType, int ramCapacity, int ramWeight) {
        this.ramType = ramType;
        this.ramCapacity = ramCapacity;
        this.ramWeight = ramWeight;
    }

    public RAMType getRAMType() {
        return ramType;
    }

    public int getRAMCapacity() {
        return ramCapacity;
    }

    public int getRAMWeight() {
        return ramWeight;
    }
}
