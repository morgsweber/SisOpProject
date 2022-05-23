package software;
import hardware.VM;
import hardware.Opcode;

public class MemoryManager {
    public int memorySize;
    public static int pageSize;
    public int memoryFrames;
    public static boolean[] frames;

    public MemoryManager(int memorySize, int pageSize) {
        this.memorySize = memorySize;
        this.pageSize = pageSize;
        this.memoryFrames = memorySize/pageSize;
        this.frames = new boolean[memoryFrames];
        frames[2] = true;
        frames[3] = true;
        frames[4] = true;
        frames[10] = true; 
        frames[11] = true;
    }

    public int[] allocate(int wordNum){
        int pageNum = 0;
        int count = 0;

        if(wordNum < pageSize){ pageNum = 1; }
        else if(wordNum%pageSize == 0){ pageNum = wordNum/pageSize; }
        else { pageNum = wordNum/pageSize + 1; }

        int[] pagesTable = new int [pageNum];
        for (int i = 0; i < frames.length; i++) {
            if(count == pageNum){
                break;
            }
            else if(!frames[i]){
                pagesTable[count] = i;
                count++;
                frames[i] = true;
            }
        }

        if(count < pageNum){
            return null;
        }
        return pagesTable;
    }

    public static int translate(int logicAddress, int[] pageTable) {
        int pageIndex = logicAddress/pageSize;
        int offset = logicAddress % pageSize;
        int physicalAddress = (pageTable[pageIndex] * pageSize) + offset;

        return physicalAddress;
    }

    public void deallocates(int[] tablePages){
        for (int i = 0; i < tablePages.length; i++) {
            frames[tablePages[i]] = false;
            for (int j = pageSize * tablePages[i]; j < pageSize * (tablePages[i] + 1); j++) {
                VM.m[j].opc = Opcode.___;
                VM.m[j].r1 = -1;
                VM.m[j].r2 = -1;
                VM.m[j].p = -1;
            }
        }
    }
}
