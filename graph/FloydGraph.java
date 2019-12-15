/**
 * A Simple Algorithm to Execute Floyd Warshall. 
 * 
 * This checks whether edges can be connected from one to another vertex. 
 * Note that the graph is impelmented using an Adjacency Matrix. 
 * 
 * @author seanlowjk
 */
public class FloydGraph {

    /**
     * The number of Vertices in the Graph.
     */
    private int numOfVertex;

    /**
     * The Data Structure used for the graph. 
     */
    private boolean[][] adjMatrix;

    /**
     * Create a Graph with an empty adjacency matrix. 
     * @param numOfVertex the number of vertices in the graph. 
     */
    public FloydGraph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        adjMatrix = new boolean[numOfVertex][numOfVertex];

        for (int i = 0; i < numOfVertex; i ++) {
            for (int j = 0; j < numOfVertex; j ++) {
                adjMatrix[i][j] = false;
            }
        }
    }

    /**
     * Adds an edge to the graph. 
     * 
     * Note that this Edge is uni-directional. 
     * @param i the start vertex.
     * @param j the end vertex. 
     */
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
    }

    /**
     * An SSSP Algorithm. 
     * 
     * Except that this is to check connectivity between vertices. 
     * Time Complexity: O(V * V * V)
     */
    public void floydWarshall() { 
        for (int k = 0; k < numOfVertex; k ++) {
            for (int i = 0; i < numOfVertex; i ++) {
                for (int j = 0; j < numOfVertex; j ++) {
                    adjMatrix[i][j] = adjMatrix[i][j] || 
                        (adjMatrix[i][k] && adjMatrix[k][j]);
                }
            }
        }
    }

    /**
     * Checks if two vertices can be connected from one vertex to another. 
     * @param source the source vertex.
     * @param dest the destination vertex. 
     * @return true if they can be accessed by a certain network. False if otherwise. 
     */
    public boolean areEdgesConnected(int source, int dest) {
        return adjMatrix[source][dest];
    }
}
