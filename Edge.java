// HUIDS: 21130176 and 31238714
// This object represents an edge of an undirected graph.
import java.util.*;

public class Edge implements Comparable<Edge> {
	private int vertex1;
	private int vertex2;
	private double weight;

	// We refer to vertices by their index number,
	// and standardize by letting the smaller one
	// come first.
	public Edge(int v1, int v2, double w) {
		if (v2<v1) {
			this.vertex1 = v2;
			this.vertex2 = v1;
		}
		else {
			this.vertex1 = v1;
			this.vertex2 = v2;	
		}
		this.weight = w;
	}

	// In order to sort edges by weight,
	// we tell java how to compare them.
	public int compareTo(Edge e) {
		if (weight == e.weight) {
			return 0;
		}
		else if (weight > e.weight) {
			return 1;
		}
		else {
			return -1;
		}
	}

	// Return the first (smaller) vertex.
	public int getv1() {
		return this.vertex1;
	}

	// Return the seocond (larger) vertex.
	public int getv2() {
		return this.vertex2;
	}

	// Return the weight.
	public double getweight() {
		return this.weight;
	}
}