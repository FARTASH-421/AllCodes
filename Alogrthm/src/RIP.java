import java.util.*;
class MyHeap{

    private long [] listMax;
    private long [] listMin;
    private int indexMax;
    private int indexMin;
    private int MAX_VALUE = 10000000;

    public MyHeap(){
        this.indexMax = 1;
        this.indexMin = 1;
        this.listMax = new long[MAX_VALUE];
        this.listMin = new long[MAX_VALUE];
    }
    public void addToMaxHeap(long add){

        int index = indexMax;
        listMax[index-1] = add;
        if (index > 1) {
            long data = add;
            while (data > listMax[index / 2 - 1]) {
                long temp = listMax[index / 2 - 1];
                listMax[index / 2 - 1] = data;
                listMax[index - 1] = temp;
                index /= 2;
                if (index == 1)
                    break;
            }
        }
        indexMax++;
    }

    public void addToMinHeap(long add) {
        int index = indexMin;
        listMin[index-1] = add;
        if (index > 1) {
            long data = listMin[index - 1];
            while (data < listMin[index / 2 - 1]) {
                long tempData = listMin[index / 2 - 1];
                listMin[index / 2 - 1]= data;
                listMin[index - 1] = tempData;
                index /= 2;
                if (index == 1)
                    break;
            }
        }
        indexMin++;
    }

    public boolean MaxLargeThenMin(){
        if(listMax[0]>listMin[0])
            return true;
        else
            return false;
    }

    public long deletedMaxHeap(){
        if(indexMax <1)
            return 0;

        indexMax--;
        long temp = listMax[0];
        long large = 0;
        int index = 1;
        int indexBefore = 0;
        while (true){
            indexBefore = index-1;
            if(listMax[2*index-1]>listMax[2*index]){
                large = listMax[2*index-1];
                index = 2*index;
            }else{
                large = listMax[2*index];
                index = 2*index+1;
            }
            listMax[indexBefore] = large;
            if(large == 0){
                listMax[indexBefore] = listMax[indexMax-1];
                listMax[indexMax-1] = 0;
                break;
            }
        }

        return temp;
    }
    public long deletedMinHeap(){
        if (indexMin<1)
            return 0;
        indexMin--;
        long temp = listMin[0];
        int index = 1;
        int indexBefore = 0;
        while (2*index < indexMin){
            indexBefore = index-1;
            long LC = listMin[2*index-1];
            long RC = listMin[2*index];
            if(LC < RC){
                listMin[indexBefore] =LC;
                index = 2*index;
            }else{
                listMin[indexBefore] = RC;
                index = 2*index+1;
            }
        }

            listMin[index - 1] = listMin[indexMin-1];
            listMin[indexMin-1] = 0;

        return temp;
    }
    public boolean indexMaxLargeIndexMin(){
        if(indexMax > indexMin)
            return true;
        else
            return false;
    }
    public boolean sizeMaxLargeThenMin(){
        if(indexMax - indexMin >1)
            return true;
        else
            return false;
    }

    public boolean sizeMinLargeThenMax(){
        if(indexMin-indexMax>1)
            return true;
        else
            return false;
    }

    public boolean indexMinLargeIndexMax(){
        if(indexMin > indexMax)
            return true;
        else
            return false;
    }
    public long getFirstListMax(){
        return listMax[0];
    }
    public long getFirstListMin(){
        return listMin[0];
    }
}


public class RIP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyHeap heap = new MyHeap();
        long input = in.nextLong();

        while (input != -1) {

            heap.addToMaxHeap(input);
            if (heap.MaxLargeThenMin()) {
                heap.addToMinHeap(heap.deletedMaxHeap());
            }

            if (heap.sizeMaxLargeThenMin()) {
                heap.addToMinHeap(heap.deletedMaxHeap());

            } else if (heap.sizeMinLargeThenMax()) {
                heap.addToMaxHeap(heap.deletedMinHeap());
            }

            double result = 0d;
            if (heap.indexMaxLargeIndexMin()){
                result = heap.getFirstListMax();
            }else if(heap.indexMinLargeIndexMax()){
                   result = heap.getFirstListMin();
            }else {
                double max = heap.getFirstListMax();
                double min = heap.getFirstListMin();
                result = (max + min) / 2;
            }
            System.out.printf("%.1f\n", result);
            input = in.nextLong();
        }
    }

}

