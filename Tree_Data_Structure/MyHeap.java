package Tree_Data_Structure;

class MyHeap {
    int heapSize;
    int []heap;
    int capacity;

    public MyHeap(int []arr) {
        this.heap = arr;
        this.heapSize = arr.length;
        this.capacity = arr.length;
    }

    public void buildTree(){
        //N/2 to N-1
        // 0 to (N/2-1)
        for (int index = heapSize/2-1; index >= 0; index--) {
            heapify(index);
        }
    }

    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapify(int index) {
        int largest = index;
        int leftChildIndex = 2*index+1;
        int rightChildIndex = 2*index+2;
        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largest]){
            largest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largest]){
            largest = rightChildIndex;
        }

        if (largest != index){
            swap(index, largest);
            heapify(largest);
        }
    }

    public int extractMax(){
        if (heapSize == 0){
            System.out.println("Heap is empty");
            return -1;
        }
        int max = heap[0];      //store the root
        heap[0] = heap[heapSize-1];
        heapSize--;     //delete the last node
        heapify(0);
        return max;
    }

    public void increaseKey(int index, int newValue){
        if (index < 0 || index >= heapSize || heap[index] >= newValue){
            System.out.println("Wrong operation");
            return;
        }

        heap[index] = newValue;

        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index/2.0)-1)]){
            swap(index, (int) (Math.ceil(index/2.0)-1));
            index = (int) (Math.ceil(index/2.0)-1);
        }
    }

    public void decreaseKey(int index, int newValue){
        if (index < 0 || index >= heapSize || heap[index] <= newValue){
            System.out.println("Wrong operation");
            return;
        }
        heap[index] = newValue;
        heapify(index);
    }

    public void insert(int newValue){
        if (heapSize+1 >= capacity){
            increaseCapacity();
        }
        heapSize+=1;
        heap[heapSize-1] = newValue;
        int index = heapSize-1;
        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index/2.0)-1)]){
            swap(index, (int) (Math.ceil(index/2.0)-1));
            index = (int) (Math.ceil(index/2.0)-1);
        }
    }

    private void increaseCapacity() {
        capacity*=2;
        int []newHeap = new int[capacity];
        for (int i = 0; i < heapSize; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public int[] heapSort(){
        buildTree();
        int size = heapSize;
        for (int i = 0; i < size; i++) {
            extractMaxAndStore();
        }
        return heap;
    }

    public void extractMaxAndStore(){
        if (heapSize == 0){
            System.out.println("Heap is empty");
            return;
        }
        int max = heap[0];      //store the root
        heap[0] = heap[heapSize-1];
        heap[heapSize-1] = max;     //store in the last node
        heapSize--;     //delete the last node
        heapify(0);
        return;
    }

    public void printTree(){
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr = new int[]{10, 5, 20, 6, 11};
        MyHeap heap1 = new MyHeap(arr);
        heap1.printTree();
        int[] res = heap1.heapSort();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+", ");
        }
        System.out.println();

        MyHeap heap2 = new MyHeap(res);
        heap2.printTree();

//        heap1.printTree();
//        heap1.buildTree();
//        heap1.printTree();
//        heap1.increaseKey(4, 15);
//        heap1.printTree();
//        heap1.decreaseKey(0, 4);
//        heap1.printTree();
////        System.out.println("remove max element is -> "+heap1.extractMax());
////        heap1.printTree();
//        heap1.insert(18);
//        heap1.printTree();
    }
}
