package aisd.lab1.heapsort;

public class TEST {
    
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        
        double[] unsorted = null;
        if(unsorted == null)
            System.out.println("NULL");
        double[] sorted = sorter.sort(unsorted);
        
        /*for(int i = 0; i < sorted.length; i++)
            System.out.println(sorted[i]);*/
    }
}
