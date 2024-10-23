public class FindHeight {
    public static void main(String[] args) {
        int[] arr = {10,6,8,5,11,9};
        int[] height = findHeight(arr);
        for (Integer count:height) {
            System.out.print(count+" ");
        }

    }
    public static int[] findHeight(int arr[]){

        int[] height = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int counter = 0, max = -1,temp= -1;
            for (int j = i+1; j <arr.length; j++) {
                temp = arr[j];
                if(temp > max){
                    max = temp;
                    counter++;
                    if(max >= arr[i])
                        break;
                }
            }
            height[i] = counter;
        }
        return height;
    }
}
