public class Computer {
    private final String vendor;
    private final String name;
    private final Processor processor;
    private final RAM ram;
    private final ROM rom;
    private final Screen screen;
    private final Keyboard keyboard;

    public Computer(String vendor, String name, Processor processor, RAM ram, ROM rom, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public int getTotalWeight() {
        return processor.getProcessorWeight() + ram.getRAMWeight() + rom.getROMWeight() + screen.getScreenWeight() + keyboard.getKeyboardWeight();
    }

    public String printInformation() {
        return "Производитель " + vendor + "\nНазвание " + name +
                "\nЧастота процессора " + processor.getProcessorFrequency() +
                "\nКоличество ядер " + processor.getProcessorCore() +
                "\nПроизводитель процессора " +  processor.getProcessorManufactorer() +
                "\nВес процессора " + processor.getProcessorWeight() + " г" +
                "\nТип оперативной памяти " + ram.getRAMType() +
                "\nОбъём оперативной памяти " + ram.getRAMCapacity() + " Гб" +
                "\nВес оперативной памяти " + ram.getRAMWeight() + " г" +
                "\nТип накопителя информации " + rom.getROMType() +
                "\nОбъём накопителя информации " + rom.getROMCapacity() + " Гб" +
                "\nВес накопителя информации " + rom.getROMWeight() + " г" +
                "\nРазмер экрана " + screen.getScreenDiagonal() +
                "\nТип экрана "+ screen.getScreenType() +
                "\nВес экрана " + screen.getScreenWeight() + " г" +
                "\nТип клавиатуры " + keyboard.getKeyboardType() +
                "\nНаличие подсветки " + keyboard.getKeyboardLight() +
                "\nВес клавиатуры " + keyboard.getKeyboardWeight() + " г" +
                "\nОбщий вес компьютера " + getTotalWeight() + " г\n";
    }
}
