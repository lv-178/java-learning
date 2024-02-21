public class Load {
    private final double mass;
    private final String address;
    private final String registrationNumber;
    private final boolean canBeTurnedOver;
    private final boolean isFragile;
    private final Dimensions dimensions;

    public Load(Dimensions dimensions, double mass, String address, String registrationNumber,
                boolean canBeTurnedOver, boolean isFragile) {
        this.mass = mass;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.canBeTurnedOver = canBeTurnedOver;
        this.isFragile = isFragile;
        this.dimensions = dimensions;
    }

    public double getMass() {
        return mass;
    }

    public String getAddress() {
        return address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean getIsFragile() {
        return isFragile;
    }

    public boolean getCanBeTurnedOver() {
        return canBeTurnedOver;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Load setMass(double mass) {
        return new Load(dimensions, mass, address, registrationNumber, canBeTurnedOver, isFragile);
    }

    public Load setAddress(String address) {
        return new Load(dimensions, mass, address, registrationNumber, canBeTurnedOver, isFragile);
    }

    public Load setRegistrationNumber(String registrationNumber) {
        return new Load(dimensions, mass, address, registrationNumber, canBeTurnedOver, isFragile);
    }

    public String toString() {
        return "dimensions: " + dimensions + "\nmass: " + mass + " kg\naddress: " + address
                + "\nregistration number: " + registrationNumber + "\nfragile: " + isFragile
                + "\ncan be turned over: " + canBeTurnedOver;
    }
}
