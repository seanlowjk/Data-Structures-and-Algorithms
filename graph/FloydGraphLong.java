/**
 * A Simple Algorithm to Execute Floyd Warshall. 
 * 
 * This checks the shortest path from one to another vertex. 
 * Note that the graph is impelmented using an Adjacency Matrix. 
 * 
 * @author seanlowjk
 */
public class FloydGraphLong {

    /**
     * The number of Vertices in the Graph.
     */
    private int numOfVertex;

    /**
     * The Data Structure used for the graph. 
     */
    private int[][] adjMatrix;

    /**
     * Create a Graph with an empty adjacency matrix. 
     * @param numOfVertex the number of vertices in the graph. 
     */
    public FloydGraphLong(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        adjMatrix = new int[numOfVertex][numOfVertex];

        for (int i = 0; i < numOfVertex; i ++) {
            for (int j = 0; j < numOfVertex; j ++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    /**
     * Adds an edge to the graph. 
     * 
     * If a shorter path already exsist, this path is ignored. 
     * @param i the start vertex.
     * @param j the end vertex.
     * @param weight the weight of the edge. 
     */
    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = Math.min(adjMatrix[i][j], weight);
    }

    /**
     * An SSSP Algorithm. 
     * 
     * This is to find the shortest path between each and every vertex. 
     * Time Complexity: O(V * V * V)
     */
    public void floydWarshall() { 
        for (int k = 0; k < numOfVertex; k ++) {
            for (int i = 0; i < numOfVertex; i ++) {
                for (int j = 0; j < numOfVertex; j ++) {
                    int edgeWeight = 0;
                    int traversalWeight = 0;
                    if (adjMatrix[i][j] == Integer.MAX_VALUE) {
                        edgeWeight = Integer.MAX_VALUE;
                    } else {
                        edgeWeight = adjMatrix[i][j];
                    }

                    if (adjMatrix[i][k] == Integer.MAX_VALUE ||
                            adjMatrix[k][j] == Integer.MAX_VALUE) {
                        traversalWeight = Integer.MAX_VALUE;        
                    } else {
                        traversalWeight = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                    adjMatrix[i][j] = Math.min(edgeWeight, traversalWeight);
                }
            }
        }
    }

    /**
     * Simple Algorithm to check for negative cycles. 
     * 
     * This is indiclated by Integer.MIN_VALUE. 
     */
    public void checkCycles() { 
        for (int i = 0; i < numOfVertex; i ++) {
            for (int j = 0; j < numOfVertex; j ++) {
                for (int k = 0; k < numOfVertex; k ++) {
                    if (adjMatrix[k][k] < 0 && adjMatrix[i][j] != Integer.MIN_VALUE) {
                        if (adjMatrix[i][k] < Integer.MAX_VALUE) {
                            if (adjMatrix[k][j] < Integer.MAX_VALUE) {
                                adjMatrix[i][j] = Integer.MIN_VALUE;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the weight of an edge. 
     * @param source the source vertex.
     * @param dest the destination vertex.
     * @return the weight of the edge. 
     */
    public int retrieveEdge(int source, int dest) {
        return adjMatrix[source][dest];
    }
}
