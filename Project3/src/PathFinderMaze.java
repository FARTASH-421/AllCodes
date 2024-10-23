import java.util.*;

class sPathFinderMaze {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimX = scanner.nextInt();
        int dimY = scanner.nextInt();
        int[][] table = new int[dimX][dimY];

        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        int endRow = scanner.nextInt();
        int endCol = scanner.nextInt();

        Home[][] parent = new Home[dimX][dimY];
        parent[startRow][startCol] = new Home(-1,-1);
        boolean check = findPath(table,parent, startRow, startCol, endRow, endCol);

        if(check) {

            Stack<Home> path = new Stack<>();
            printPath(parent, endRow, endCol, path);

            while (!path.isEmpty()) {
                Home in = path.pop();
                System.out.print("(" + in.x + ", " + in.y + ") -> ");
            }
        }else{
            System.out.println("No path found.");
        }
    }

    private static void printPath(Home[][] parent, int targRow, int targCol, Stack<Home> path) {
        if(targCol== -1 && targRow == -1)
            return;
        else {
            path.push(new Home(targRow, targCol));
            Home index = parent[targRow][targCol];
            printPath(parent, index.x, index.y, path);
        }
    }

    private static boolean findPath(int[][] table, Home[][] parent, int startX, int startY, int endX, int endY) {

        int dim = table.length;
        Stack<Home> stack = new Stack<>();
        boolean[][] visited = new boolean[dim][dim];
        stack.push(new Home(startX, startY));
        visited[startX][startY] = true;
        int[] dx = {-1, 1, 0, 0};

        while (!stack.isEmpty()) {
            Home current = stack.pop();
            if (current.x == endX && current.y == endY) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dx[3-i];
                if ((newX >= 0 && newX < dim ) && (newY >= 0 && newY < dim)) {
                    if (!visited[newX][newY] && table[newX][newY] == 1) {
                        stack.push(new Home(newX, newY));
                        visited[newX][newY] = true;
                        parent[newX][newY] = new Home(current.x, current.y);
                    }
                }
            }
        }
        return false;
    }
}

class Home {
    int x, y;
    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}