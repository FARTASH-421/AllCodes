import java.util.Scanner;

public class DeNode {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] parents = new int[size];

        for (int i = 0; i <size; i++)
            parents[i] = in.nextInt();

        int nodeF = in.nextInt();
        int nodeS = in.nextInt();
        System.out.println(sameParents(parents,nodeS,nodeF));

    }
    public static int sameParents(int[] parents, int nodeF, int nodeS){
        if(nodeF >= parents.length|| nodeS >= parents.length)
            return -1;

        int temp = nodeF;
        while (nodeS != -1){
            nodeS = parents[nodeS];
            while (nodeF != -1){
                nodeF = parents[nodeF];
                if(nodeF == nodeS){
                    return nodeF;
                }
            }
            nodeF = temp;
        }
        return -1;
    }
}

