import java.util.*;

public final class MemoryManager {
    private static final int FRAME_COUNT = 16;
    private final Queue<Page> fifoQueue = new LinkedList<>();
    private final Map<Integer, List<Integer>> pageTables = new HashMap<>();
    private final Page[] frames = new Page[FRAME_COUNT];
    
    public MemoryManager() {
        System.out.println("Inicializando memória física com " + FRAME_COUNT + " quadros...");
        displayMemoryState();
    }
    
    public void allocateProcess(int processId) {
        System.out.println("\nAlocando processo " + processId + " na memória...");
        List<Integer> pageTable = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int frameIndex = findFreeFrame();
            Page page = new Page(processId, i);
            
            if (frameIndex == -1) {
                System.out.println("Memória cheia. Aplicando substituição de página...");
                page = replacePage(page);
                frameIndex = Arrays.asList(frames).indexOf(page);
            } else {
                System.out.println("Página " + i + " do processo " + processId + " alocada no quadro " + frameIndex);
                frames[frameIndex] = page;
                fifoQueue.add(page);
            }
            pageTable.add(frameIndex);
        }
        pageTables.put(processId, pageTable);
        displayMemoryState();
    }
    
    private int findFreeFrame() {
        for (int i = 0; i < FRAME_COUNT; i++) {
            if (frames[i] == null) return i;
        }
        return -1;
    }
    
    private Page replacePage(Page newPage) {
        Page oldPage = fifoQueue.poll();
        int index = Arrays.asList(frames).indexOf(oldPage);
        System.out.println("Substituindo página do processo " + oldPage.processId + " (Página " + oldPage.pageNumber + ") pelo processo " + newPage.processId + " (Página " + newPage.pageNumber + ") no quadro " + index);
        frames[index] = newPage;
        fifoQueue.add(newPage);
        return oldPage;
    }
    
    public void displayMemoryState() {
        System.out.println("\nEstado atual da memória:");
        for (int i = 0; i < FRAME_COUNT; i++) {
            if (frames[i] != null) {
                System.out.println("Quadro " + i + ": Processo " + frames[i].processId + " Página " + frames[i].pageNumber);
            } else {
                System.out.println("Quadro " + i + ": Vazio");
            }
        }
    }

    public Map<Integer, List<Integer>> getPageTables() {
        return pageTables;
    }
}