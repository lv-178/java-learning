import java.security.Key;

public class Main {
    public static void main(String[] args) {
        Processor processor1 = new Processor(8000000, 3, ProcessorManufacturer.AMD, 120);
        RAM ram1 = new RAM(RAMType.DRAM, 8, 26);
        ROM rom1 = new ROM(ROMType.SSD, 500, 480);
        Screen screen1 = new Screen("1920x1080", ScreenType.IPS, 800);
        Keyboard keyboard1 = new Keyboard(KeyboardType.BLACK, KeyboardLight.NO, 350);

        Computer computer1 = new Computer("Lenovo", "Work computer", processor1, ram1, rom1, screen1, keyboard1);

        Processor processor2 = new Processor(6000000, 4, ProcessorManufacturer.AMD, 140);
        RAM ram2 = new RAM(RAMType.SRAM, 16, 42);
        ROM rom2 = new ROM(ROMType.SSD, 1000, 480);
        Screen screen2 = new Screen("1920x1080", ScreenType.TN, 850);
        Keyboard keyboard2 = new Keyboard(KeyboardType.BLACK, KeyboardLight.YES, 430);

        Computer computer2 = new Computer("HP", "For games", processor2, ram2, rom2, screen2, keyboard2);

        System.out.println(computer1.printInformation());
        System.out.println(computer2.printInformation());
    }
}