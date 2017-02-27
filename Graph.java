// HUIDS: 21130176 and 31238714
// This object represents an undirected graph.
import java.util.*;

public class Graph {
	private int vertices;
	private ArrayList<Edge> edges;
	private double totalweight;

	// We initialize the graph using the number of
	// vertices and a list of Edge objects. As we
	// were removing edges that we did not expect
	// to be in the MST *before* constructing the
	// graph, we found it useful to keep track of
	// the total graph weight here.
	public Graph(int n, ArrayList<Edge> e, double w) {
		this.vertices = n;
		this.edges = new ArrayList<Edge>(e);
		this.totalweight = w;
	}

	// Return the total weight.
	public double gettotalweight() {
		return this.totalweight;
	}
	
	// Return the number of vertices.
	public int getvertices() {
		return this.vertices;
	}

	// Return the list of edges.
	public ArrayList<Edge> getedges() {
		return this.edges;
	}


	// Return the list of edges containing
	// a specified vertex.
	public ArrayList<Edge> getedges(int v) {
		ArrayList<Edge> out = new ArrayList<Edge>(0);
		for (Edge e : this.edges) {
			if (v == e.getv1() || v == e.getv2()) {
				out.add(e);
			}
		}
		return out;
	}

	// Sort the edges by weight.
	// (This is why Edge is comparable).
	private ArrayList<Edge> sort() {
		Collections.sort(this.edges);
		return this.edges;
	}

	// Our implementation of Kruskal's algorithm,
	// returning the MST as a list of Edge objects.
	public ArrayList<Edge> getmst() {
		ArrayList<Edge> x = new ArrayList<Edge>(0);
		this.sort();
		DisjointSet ds = new DisjointSet();
		for (int u = 0; u < this.vertices; u++) {
			ds.makeset(u);
		}
		int i = 0;
		for (Edge e : edges) {
			i++;
			if (ds.find(e.getv1()).getvertex() != ds.find(e.getv2()).getvertex()) {
				x.add(e);
				ds.union(e.getv1(), e.getv2());
			}
		}
		return x;
	}

}