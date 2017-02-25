package cs124pa1;
import Java.util.*;

public class Graph {
	private int vertices;
	private ArrayList<Edge> edges;
	private float weight;

	public Graph(int n, ArrayList<Edge> e) {
		this.vertices = n;
		this.edges = new ArrayList<Edge>(e);
	}
	
	public int getvertices() {
		return this.vertices;
	}

	public ArrayList<Edge> getedges() {
		return this.edges;
	}

	public ArrayList<Edge> getedges(int v) {
		ArrayList<Edge> out = new ArrayList<Edge>(0);
		for (Edge e : this.edges) {
			if (v == e.getv1() || v == e.getv2()) {
				out.add(e);
			}
		}
		return out;
	}
}