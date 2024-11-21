/*
 * Name: Richard Elliott
 * Title: CMSC401_A3
 * Last Date Modified: 11/8/24
 */
import java.util.*;

public class CMSC401_A3 {
    static final int INF = Integer.MAX_VALUE;

    // BFS to find augmenting path
    private static boolean bfs(int[][] capacity, int[][] flow, int source, int sink, int[] parent) {
        Arrays.fill(parent, -1);
        parent[source] = source;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < capacity.length; v++) {
                if (parent[v] == -1 && capacity[u][v] > flow[u][v]) { // valid edge
                    parent[v] = u;
                    if (v == sink) return true; // found path to sink
                    queue.add(v);
                }
            }
        }
        return false; // no augmenting path
    }

    // Edmonds-Karp implementation of Max-Flow algorithm
    private static int edmondsKarp(int[][] capacity, int source, int sink) {
        int[][] flow = new int[capacity.length][capacity.length];
        int[] parent = new int[capacity.length];
        int maxFlow = 0;

        // While there's an augmenting path, increase the flow
        while (bfs(capacity, flow, source, sink, parent)) {
            int pathFlow = INF;

            // Find the maximum flow through the path found
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, capacity[u][v] - flow[u][v]);
            }

            // Update residual capacities of the edges and reverse edges
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object for input
    
        int N = sc.nextInt(); // Number of courses
        int M = sc.nextInt(); // Number of lecture halls
    
        int source = 0;
        int sink = N + M + 1;
        int totalVertices = N + M + 2;
    
        // Capacity matrix
        int[][] capacity = new int[totalVertices][totalVertices];
    
        // Read each course and its possible lecture halls
        sc.nextLine(); // Consume the rest of the line after reading N and M
        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine(); // Read the entire line for this course
            String[] tokens = line.split(" "); // Split by spaces
    
            // Start from the second element, because the first is the course id
            for (int j = 1; j < tokens.length; j++) {
                int hall = Integer.parseInt(tokens[j]); // Lecture hall number
                capacity[i][N + hall] = 1; // Course i can be assigned to Hall hall
            }
            capacity[source][i] = 1; // Source to each course
        }
    
        // Connect lecture halls to the sink
        for (int i = 1; i <= M; i++) {
            capacity[N + i][sink] = 1;
        }
    
        // Find the maximum matching using Max-Flow
        System.out.println(edmondsKarp(capacity, source, sink));
    
        sc.close(); // Close the Scanner object after use
    }           
}
