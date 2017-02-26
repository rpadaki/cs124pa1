import java.util.*;

public class Graph {
	private int vertices;
	private ArrayList<Edge> edges;
	private double totalweight;

	public Graph(int n, ArrayList<Edge> e, double w) {
		this.vertices = n;
		this.edges = new ArrayList<Edge>(e);
		this.totalweight = w;
	}

	public double gettotalweight() {
		return this.totalweight;
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

	private ArrayList<Edge> sort() {
		Collections.sort(this.edges);
		return this.edges;
	}

	private ArrayList<Edge> merge(ArrayList<Edge> s, ArrayList<Edge> t) {
		Edge u;
		ArrayList<Edge> out = new ArrayList<Edge>(s.size() + t.size());
		while (!s.isEmpty() && !t.isEmpty()) {
			if (s.get(0).getweight() < t.get(0).getweight()) {
				u = s.remove(0);
			}
			else {
				u = t.remove(0);
			}
			out.add(0,u);
		}
		while (!s.isEmpty()) {
			out.add(s.remove(0));
		}
		while (!t.isEmpty()) {
			out.add(t.remove(0));
		}
		return out;
	}

	private void mergesort() {
		// System.out.println('k');
		ArrayList<ArrayList<Edge>> q = new ArrayList<ArrayList<Edge>>(0);
		ArrayList<Edge> u, v;
		for (Edge x : this.edges) {
			ArrayList<Edge> r = new ArrayList<Edge>(1);
			r.add(x);
			q.add(r);
		}
		// System.out.println('j');
		while (q.size() >= 2) {
			u = q.remove(0);
			v = q.remove(0);
			q.add(this.merge(u,v));
			// if (q.size()/10000 != (q.size()-1)/10000) System.out.println(q.size());
		}
		// System.out.println('i');
		if (q.isEmpty()) {
			edges = new ArrayList<Edge>(0);
		}
		else {
			edges = q.get(0);
		}
	}

	public ArrayList<Edge> getmst() {
		ArrayList<Edge> x = new ArrayList<Edge>(0);
		this.sort();
		//this.mergesort();
		DisjointSet ds = new DisjointSet();
		for (int u = 0; u < this.vertices; u++) {
			ds.makeset(u);
		}
		// System.out.println("Kruskal: " + this.edges.size() + " edges");
		int i = 0;
		for (Edge e : edges) {
			i++;
			// if (i/10000 != (i-1)/10000) System.out.println(i);
			if (ds.find(e.getv1()).getvertex() != ds.find(e.getv2()).getvertex()) {
				x.add(e);
				ds.union(e.getv1(), e.getv2());
			}
		}
		return x;
	}

}