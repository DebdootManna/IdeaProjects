import java.util.*;

public class BombDetonation {
    
    // Method to calculate the distance between two bombs
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find the maximum number of bombs that can be detonated
    public static int maxDetonatedBombs(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        // Step 1: Build a graph where each bomb is a node
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: For each pair of bombs, check if they can detonate each other
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // Bomb i can detonate bomb j if the distance is less than or equal to its range
                    int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                    int x2 = bombs[j][0], y2 = bombs[j][1];
                    if (distance(x1, y1, x2, y2) <= r1) {
                        graph.get(i).add(j);
                    }
                }
            }
        }

        // Step 3: Perform DFS to find the size of the largest connected component
        boolean[] visited = new boolean[n];
        int maxDetonated = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Perform DFS from bomb i
                int detonated = dfs(graph, visited, i);
                maxDetonated = Math.max(maxDetonated, detonated);
            }
        }

        return maxDetonated;
    }

    // DFS to visit all reachable bombs from the current bomb
    private static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int count = 1;  // Count this bomb itself
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(graph, visited, neighbor);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example input: each bomb is represented by [x, y, range]
        int[][] bombs = {
            {2, 3, 3},
            {6, 2, 4},
            {8, 8, 2},
            {3, 6, 2}
        };

        System.out.println("Maximum number of bombs that can be detonated: " + maxDetonatedBombs(bombs));
    }
}
