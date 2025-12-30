import java.util.LinkedList;
import java.util.Queue;


public class BFS {

    static class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjList;

        public Graph(int v) {
            vertices = v;
            adjList = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        // BFS Transversal from a given source
        void bfs(int start) {
            //Array to track visited vertices
            boolean[] visited = new boolean[vertices];

            //Queue for bfs
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);

            System.out.println("BFS Starting from " + start + ";");

            while (!queue.isEmpty()) {

                //Dequeue the vertex and print it
                int current = queue.poll();
                System.out.println(current + " ");

                //Get all the adjacent vertices
                for (Integer neighbor : adjList[current]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }

                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println("==BFS IMPLEMENTATION ");
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        g.bfs(0);

    }

}
