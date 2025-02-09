public class MemorySimulation {
    public static void main(String[] args) {
        MemoryManager manager = new MemoryManager();
        manager.allocateProcess(1);
        manager.allocateProcess(2);
        manager.allocateProcess(3);
        manager.allocateProcess(4);
    }
}
