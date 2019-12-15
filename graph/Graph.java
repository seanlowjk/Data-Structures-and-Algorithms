import java.util.*;

/**
 * Represents a Simple Graph, where the underlying implementation behind this
 * graph is of an adjacency list.
 * 
 * @author seanlowjk
 */
class Graph {

    /**
     * The number of vertices in the Graph.
     */
    private int numOfVertex;

    /**
     * The Adjacency List of the Graph, where it is represented by an
     * ArrayList of ArrayLists of Edge.
     */
    private ArrayList<ArrayList<Edge>> adjList;

    /**
     * Constructs a Simple Graph based on the number of vertices given.
     * @param numOfVertex the number of vertices in the graph.
     */
    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        adjList = new ArrayList<ArrayList<Edge>>();
        // For every new vertex, a new ArrayList of Edges is created.
        for (int i = 0; i < numOfVertex; i ++) {
            adjList.add(new ArrayList<Edge>());
        }
    }

    /**
     * Adds an Edge to the Graph, based on the start and end vertex given,
     * plus the weight of the Edge.
     * Time Complexity: O(1)
     * Space Complexity O(1)
     * @param source the start vertex.
     * @param destination the end vertex.
     * @param weight the weight of the Edge.
     */
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Edge(source, destination ,weight));
    }

    /**
     * Conducts a Breath-First Search to traverse through the entire Graph
     * to print all vertices within the Graph from the given start vertex.
     * It will also return the smallest weight from the start vertex to each
     * and every particular vertex.
     * Time Complexity: O(V+E) for Adjavency List.
     * Space Complexity: O(V) due to traversal of all vertices.
     * @param s the vertex to start tranversing from.
     * @return an array of weights from the start vertex to that particular vertex.
     */
    public int[] BFS(int s) {
        boolean[] visited = new boolean[numOfVertex]; // check if all vertices have been visited.
        Queue<Edge> queue = new LinkedList<Edge>(); // Underlying data structure.
        int[] weights = new int[numOfVertex]; // the smallest weight from the start vertex

        visited[s] = true; // if the vertex is visited, mark it as true
        queue.add(new Edge(s, s, 0)); // dummy edge
        weights[s] = 0; // initialize weight as 0 for now, traversing from s to s is 0.
        
        while (queue.size() != 0) {
            Edge edge = queue.poll(); // get the next edge
            System.out.print(edge.getEnd() + " "); // print out the end vertex
            weights[edge.getEnd()] = weights[edge.getStart()] + edge.getWeight(); // calculate weight

            ArrayList<Edge> neighbours = adjList.get(edge.getEnd()); // get all neighbours
            for (Edge e : neighbours) {
                int n = e.getEnd();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(e);
                }
            }
        }

        System.out.println(); // for indentation purposes.
        return weights;
    }

    /**
     * Conducts a Depth-First Search to traverse through the entire Graph
     * to print all vertices within the Graph from the given start vertex.
     * It will also return the smallest weight from the start vertex to each
     * and every particular vertex.
     * Time Complexity: O(V+E) for Adjavency List.
     * Space Complexity: O(V) due to traversal of all vertices.
     * @param s the vertex to start tranversing from.
     * @return an array of weights from the start vertex to that particular vertex.
     */
    public int[] DFS(int s) {
        boolean[] visited = new boolean[numOfVertex]; // check if all vertices have been visited.
        Stack<Edge> stack = new Stack<Edge>(); // Underlying data structure.
        int[] weights = new int[numOfVertex]; // the smallest weight from the start vertex

        visited[s] = true; // if the vertex is visited, mark it as true
        stack.push(new Edge(s, s, 0)); // dummy edge.
        weights[s] = 0; // initialize weight as 0 for now, traversing from s to s is 0.

        while (stack.size() != 0) {
            Edge edge = stack.pop(); // get the next edge
            System.out.print(edge.getEnd() + " "); // print out the end vertex
            weights[edge.getEnd()] = weights[edge.getStart()] + edge.getWeight(); // calculate weight

            ArrayList<Edge> neighbours = adjList.get(edge.getEnd());
            for (Edge e : neighbours) { // get all neighbours
                int n = e.getEnd();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.add(e);
                }
            }
        }
        System.out.println();
        return weights;
    }

    /**
     * Simply checks whether the Graph is Bipartite or not. You will mainly use
     * Depth-First Search for this algorithm. In the event that any neightbouring vertex
     * is of the same "color" as the current vertex, the graph is not bipartite.
     * Time Complexity: O(V+E) for Adjavency List.
     * Space Complexity: O(V) due to traversal of all vertices.
     * @param s the start vertex.
     * @return true if the graph is bipartite. False if otherwise.
     */
    public boolean isBipartite(int s) {
        int[] visited = new int[numOfVertex]; // values will only be -1, 0, or 1.
        Arrays.fill(visited, -1); // vertexes are all not visited
        for (int i = 0; i < numOfVertex; i ++) {
            if (visited[i] == -1) { // if vertex is not visited
                if (!checkColors(i, visited)) { // start coloring
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Colors the start vertex black. If at any point of time, neighbouring vertices are both white
     * or both black, coloring is invalid. Modified Depth-First Search.
     * This is a Helper Function.
     * @param s the start vertex.
     * @param visited the array of colored vertices. -1 for not visited, 0 for white and 1 for black.
     * @return true if the coloring is valid. False if otherwise.
     */
    public boolean checkColors(int s, int[] visited) {
        visited[s] = 1; // the vertex is colored black.
        Stack<Edge> stack = new Stack<Edge>(); // Underlying Data Structure.
        stack.push(new Edge(s, s, 0)); // Dummy Edge.
        while (stack.size() != 0) {
            Edge edge = stack.pop();
            if (visited[edge.getEnd()] == 1) { // if ay any point, start and end vertex are black.
                return false;
            }

            ArrayList<Edge> neighbours = adjList.get(edge.getEnd());
            for (Edge e : neighbours) {
                int t = e.getStart();
                int n = e.getEnd();
                if (visited[n] == -1) { // if vertex is not visited
                    visited[n] = 1 - visited[t]; // color the vertex the opposite color.
                    stack.push(e);
                } else if (visited[t] == visited[n]) { // if start and vertex of same color.
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Simple Algorithm to check if the Graph is Cyclic or not.
     * Time Complexity: O(E log V)
     * @return true if the Graph is Cyclic. False if otherwise.
     */
    public boolean isCyclic() {
        boolean[] visited = new boolean[numOfVertex]; // intialize visited array
        for (int i = 0; i < numOfVertex; i ++) {
            visited[i] = false;
        }

        for (int j = 0; j < numOfVertex; j ++) { // checks for a cycle for all vertices
            if (!visited[j]) {
                if (isCyclicUtil(j, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Recursive Helper Algorithm to check if there exists a cycle in the Graph.
     * @param v starting vertex.
     * @param visited the visited array.
     * @param parent the parent vertex.
     * @return
     */
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true; // vertice v is visited
        int i;
        Iterator<Edge> iter = adjList.get(v).iterator();
        while (iter.hasNext()) {
            Edge e = iter.next();
            i = e.getEnd();
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) { // if there exsits a cycle from i to v
                    return true;
                }
            } else if (i != parent) { // if i is visited and is not the parent vertex, there is a cycle
                return true;
            }
        }
        return false;
    }

    /**
     * Simple Algorithm to get the minimum distance between the starting vertex
     * to any other vertex in the graph.
     * Time Complexity: O(VE)
     * @param s the starting vertex.
     * @return an array of distances from the startving vertex to all vertices.
     */
    public int[] bellmanFord(int s) {
        int[] weights = new int[numOfVertex];
        Arrays.fill(weights, Integer.MAX_VALUE); // Initalize all weights as +Infinity.
        weights[s] = 0; // Distance from s to s is zero.

        // Relax all edges V - 1 times. A simple shortest path from the starting vertex to
        // any other vertex can have only at most V - 1 edges
        for (int i = 0; i < numOfVertex - 1; i ++) {
            for (ArrayList<Edge> edges : adjList) {
                for (Edge edge : edges) {
                    int start = edge.getStart();
                    int end = edge.getEnd();
                    int weight = edge.getWeight();
                    if ((weights[start] + weight) < weights[end]) {
                        weights[end] = weights[start] + weight;
                    }
                }
            } 
        }

        // Check for negative-weight cycles if we get a shorter path again for a
        // particular vertex in the Graph.
        for (int j = 0; j < numOfVertex - 1; j ++) {
            for (ArrayList<Edge> edges : adjList) {
                for (Edge edge : edges) {
                    int start = edge.getStart();
                    int end = edge.getEnd();
                    int weight = edge.getWeight();
                    if ((weights[start] + weight) < weights[end]) {
                        weights[end] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        return weights;
    }

    /**
     * Basic SSSP Algorithm. Basically retrieving and combing all edges until you
     * hit all vertices in the Graph. Nromally, you only need to do so from the
     * starting vertex to one single destination vertex.
     * Time Complexity: O(E log V) to calculate from s to a single destination vertex.
     * @param s the starting vertex.
     * @return an array of distances from the starting vertex to all vertices.
     */
    public int[] dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); // To always retrieve shortest edge
        pq.add(new Edge(s, s, 0)); // Dummy edge.
        int[] weights = new int[numOfVertex];
        Arrays.fill(weights, Integer.MAX_VALUE); // All distances set to +Infinity.
        weights[s] = 0;

        while (pq.size() != 0) {
            Edge edge = pq.poll(); // Get smallest Edge.
            int end = edge.getEnd();
            int weight = edge.getWeight();
            if (weights[end] < weight) { // If Edge is too big, ignore it.
                continue;
            }

            for (Edge e : adjList.get(end)) { // Else, update weight and add the combined Edge.
                int dest = e.getEnd();
                int newWeight = weight + e.getWeight();
                if (newWeight < weights[dest]) {
                    weights[dest] = newWeight;
                    pq.add(new Edge(e.getStart(), dest, newWeight));
                }
            }
        }
        return weights;
    }

    /**
     * Only possible for Directed Acyclic Graphs (DAG). In this case, we would use Kahn's Algorithm.
     * This checks if there is a single unique topological sort, if there is more than one
     * topological sort, or if there is a cycle.
     * Time Complexity: O(V + E)
     */
    public void topologicalSort() { // Kahn's Algorithm has O(V+E) time complexity
        int[] indegree = new int[numOfVertex]; // set all in-degree to zero.
        boolean uniqueTopologicalSort = true;
        
        for (int i = 0; i < numOfVertex; i ++) { // update in-degrees
            ArrayList<Edge> temp = adjList.get(i);
            for (Edge e : temp) {
                indegree[e.getEnd()] ++;
            }
        }

        // if there is more than one vertex with in-degree 0,
        // there is no unique topological sort.
        Queue<Integer> verticeQueue = new LinkedList<Integer>();
        for (int j = 0; j < numOfVertex; j ++) {
            if (indegree[j] == 0) {
                verticeQueue.offer(j);
            }
            if (verticeQueue.size() > 1) {
                uniqueTopologicalSort = false;
            }
        }


        int count = 0; // checks if there is a cycle
        Queue<Integer> topoOrder = new LinkedList<Integer>();
        while (!verticeQueue.isEmpty()) {
            int u = verticeQueue.poll();
            topoOrder.add(u);
            for (Edge n : adjList.get(u)) {
                if (--indegree[n.getEnd()] == 0) {
                    verticeQueue.add(n.getEnd());
                }
                if (verticeQueue.size() > 1) { // if there is more than one vertex with in-degree 0,
                    uniqueTopologicalSort = false;
                }
            }
            count ++;
        }

        if (count != numOfVertex) {
            System.out.println("Cycle exists!");
            return;
        }
        if (!uniqueTopologicalSort) {
            System.out.println("More than one topological sort!");
        }
        for (int x : topoOrder) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
