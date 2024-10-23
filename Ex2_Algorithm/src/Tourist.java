import java.util.*;
public class Tourist {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<Edge>[] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        graph = new List[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++)
            graph[i] = new ArrayList<>();


        for (int i = 0; i < n-1; i++) {
            int u = input.nextInt() ;
            int v = input.nextInt();
            graph[u].add(new Edge(v, 1));
            graph[v].add(new Edge(u, 1));
        }
       visited[1]= true;
       double result =  find(1,visited);
        System.out.printf("%.7f",result);

    }

    public static double find(int u, boolean [] visited){
        double counter = 0;
        double result = 0;
        for(Edge ex: graph[u]) {
            if(!visited[ex.to]) {
                counter++;
                visited[ex.to]=true;
               result += find(ex.to, visited);
            }
        }
        if(counter == 0)
            return 1;
        if(u == 1)
            return result/counter;
        else
        return result/counter + 1;
    }
}














class Tes{
    public static void main(String[] args) {
        for (int i=0;i<9;i++){
            System.out.println(i);
            if(i == 2){
                break;
            }
        }
    }
}