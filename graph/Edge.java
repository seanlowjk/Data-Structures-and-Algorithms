/**
 * Represents a Simple Edge which contains a start and end point.
 * While at the same time, contains a weight, representing an integer.
 * 
 * @author seanlowjk
 */
public class Edge implements Comparable<Edge> {

    /**
     * The starting vertex of the edge.
     */
    private int start;

    /**
     * The end vertex of the edge.
     */
    private int end;

    /**
     * The weight of the edge.
     */
    private int weight;

    /**
     * Constructs an Edge based on the given start vertex, the end vertex
     * and the weight of the edge, all as integers.
     * @param start the start vertex.
     * @param end the end vertex.
     * @param weight the weight of the edge.
     */
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**
     * Gets the start vertex of this edge.
     * @return the start vertex as an integer.
     */
    public int getStart() {
        return this.start;
    }

    /**
     * Gets the end vertex of this edge.
     * @return the end vertex as an integer.
     */
    public int getEnd() {
        return this.end;
    }

    /**
     * Gets the weight of this edge.
     * @return the weight as an integer.
     */
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.getWeight() - other.getWeight();
    }
}
