public class Processor {
    public int processorFrequency;
    public int processorCore;
    public ProcessorManufacturer processorManufactorer;
    public int processorWeight;

    public Processor(int processorFrequency, int processorCore, ProcessorManufacturer processorManufactorer, int processorWeight) {
        this.processorFrequency = processorFrequency;
        this.processorCore = processorCore;
        this.processorManufactorer = processorManufactorer;
        this.processorWeight = processorWeight;
    }

    public int getProcessorFrequency() {
        return processorFrequency;
    }

    public int getProcessorCore() {
        return processorCore;
    }

    public ProcessorManufacturer getProcessorManufactorer() {
        return processorManufactorer;
    }

    public int getProcessorWeight() {
        return processorWeight;
    }
}
