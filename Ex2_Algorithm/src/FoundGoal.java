import java.util.*;
public class FoundGoal{

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<Edge>[] graph;

    static int dijkstra(int[] dist,int bingin) {
        int n = dist.length;
        boolean[] visited = new boolean[n+1];
        dist[0] = 0;
        dist[bingin] = 0;

        for (int i = 1; i <= n ; i++) {
            int u = -1;
            for (int j = 1; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            if(u!=-1) {
                visited[u] = true;
                for (Edge e : graph[u])
                    dist[e.to] = Math.min(dist[u] + e.weight, dist[e.to]);
            }
        }
        boolean vis = true;
        for(int i=1; i<=n; i++){
            if(!visited[i]) {
                vis = false;
                break;
            }
        }

        int result = -1;
        if(vis)
            for(int x: dist)
               result = Math.max(x, result);

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int target = input.nextInt();

        graph = new List[n+1];
        int [] dist = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        int u, v, w;
        for (int i = 0; i < m; i++) {
            u = input.nextInt() ;
            v = input.nextInt();
            w =input.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        System.out.println(dijkstra(dist,target));


    }
}
