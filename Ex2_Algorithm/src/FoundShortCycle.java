import java.util.*;
public class FoundShortCycle {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<Edge>[] graph;

    static int shortest_cycle(int n,int target) {
        int ans = Integer.MAX_VALUE;
        String arr = "";

        int[] dist = new int[n];
        int[] par = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(par, -1);
        Queue<Integer> q = new LinkedList<>();

        dist[target] = 0;
        q.add(target);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (Edge child : graph[x]) {
                if (dist[child.to] == Integer.MAX_VALUE) {
                    dist[child.to] = child.weight + dist[x];
                    par[child.to] = x;
                    q.add(child.to);
                } else if (par[x] != child.to && par[child.to] != x){
                    int temp = dist[x]+dist[child.to]+1;
                    if(ans> temp){
                        ans = temp;
                        if(ans==3){
                            arr = x+" "+child.to+" "+ par[x]+ " "+x;
//                               check = true;
                        }
                        if(ans >3) {
                            String moveChild = "";
                            String movePar = "";
                            int updateChild = child.to;
                            int upDatX = par[x];
                            for (int k = 0; k < ans - 3; k++) {
                                if (upDatX != -1 && updateChild != -1) {
                                    moveChild += updateChild + " ";
                                    movePar = upDatX + " " + movePar;

                                    updateChild = par[updateChild];
                                    upDatX = par[upDatX];
                                }
                            }
                            boolean er = (updateChild + "").equals(movePar.charAt(0) + "");
                            if (!er) {
                                arr = x + " " + moveChild + updateChild + " " + movePar + x;
                            }
                            if (er)
                                arr = x + " " + moveChild + movePar + x;
                            }
                        }
//                        ans = Math.min(ans, dist[x] + dist[child.to] + 1);
                    }
                }
            }


        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return -1;
        }
        else
            System.out.println(ans);
            System.out.println(arr);
            return ans;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int u, v, cost, target = 0;
        boolean check = false;
        for (int i = 0; i < m; i++) {

            u = input.nextInt() ;
            v = input.nextInt();
            cost = Math.abs(input.nextInt());
            graph[u].add(new Edge(v, cost));
            graph[v].add(new Edge(u, cost));
            if(!check) {
                target = u;
                check = true;
            }
        }

        shortest_cycle(n,target);
    }
}
