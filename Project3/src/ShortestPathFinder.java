import java.util.*;

//class Cell {
//    int x, y;
//
//    public Cell(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class ShortestPathFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // دریافت ابعاد آرایه از کاربر
//        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
//        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // ساخت آرایه دو بعدی
        int[][] grid = new int[rows][cols];

        // دریافت محتوای آرایه از کاربر
//        System.out.println("Enter the array elements (0 or 1):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // دریافت مختصات مبدا و مقصد از کاربر
//        System.out.print("Enter the starting row: ");
        int startRow = scanner.nextInt();
//        System.out.print("Enter the starting column: ");
        int startCol = scanner.nextInt();
//        System.out.print("Enter the destination row: ");
        int destRow = scanner.nextInt();
//        System.out.print("Enter the destination column: ");
        int destCol = scanner.nextInt();

        // یافتن و چاپ مسیر کوتاهترین
        findAndPrintShortestPath(grid, startRow, startCol, destRow, destCol);
    }

    private static void findAndPrintShortestPath(int[][] grid, int startX, int startY, int destX, int destY) {
        Stack<Home> stack = new Stack<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        stack.push(new Home(startX, startY));
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            Home current = stack.pop();

            if (current.x == destX && current.y == destY) {
                // اگر به مقصد رسیدیم، مسیر را چاپ کنیم
                printPath(current);
                return;
            }

            // اضافه کردن خلاصه دسترسی‌های مجاور
            addAdjacentCells(grid, current, stack, visited);
        }

        // اگر به اینجا برسیم، مسیری یافت نشده است
        System.out.println("No path found.");
    }

    private static void addAdjacentCells(int[][] grid, Home current, Stack<Home> stack, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0}; // جهت‌های افقی
        int[] dy = {0, 0, -1, 1}; // جهت‌های عمودی

        for (int i = 0; i < 4; i++) {
            int newX = current.x + dx[i];
            int newY = current.y + dy[i];

            // بررسی محدوده
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                // بررسی اینکه خانه توسط گذشته نشده باشد و همچنین خانه فعلی به آن خانه مجاور برسد
                if (!visited[newX][newY] && grid[newX][newY] == 1) {
                    stack.push(new Home(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static void printPath(Home destination) {
        List<Home> path = new ArrayList<>();
        Home current = destination;

        // ساخت مسیر بازگشتی از نقطه مقصد به مبدا
        while (current != null) {
            path.add(current);

        }

        // چاپ مسیر به ترتیب درست
        System.out.println("Shortest Path found:");
        for (int i = path.size() - 1; i >= 0; i--) {
            Home cell = path.get(i);
            System.out.println("(" + cell.x + ", " + cell.y + ")");
        }
    }
}
