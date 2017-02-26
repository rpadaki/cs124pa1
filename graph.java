import java.util.*;

public class Graph {
	private int vertices;
	private ArrayList<Edge> edges;

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

	private ArrayList<Edge> merge(ArrayList<Edge> s, ArrayList<Edge> t) {
		Edge u;
		if (s.isEmpty()) {
			return t;
		}
		if (t.isEmpty()) {
			return s;
		}
		if (s.get(0)<=t.get(0)) {
			u = s.remove(0);
		}
		else {
			u = t.remove(0);
		}
		return merge(s,t).add(0,u);
	}

	private void mergesort() {
		ArrayList<ArrayList<Edge>> q = new ArrayList<ArrayList<Edge>>(0);
		ArrayList<Edge> u, v;
		for (Edge x : this.edges) {
			ArrayList<Edge> r = new ArrayList<Edge>(1);
			r.add(x);
			q.add(r);
		}
		while (q.size() >= 2) {
			u = q.remove(0);
			v = q.remove(0);
			q.add(this.merge(u,v));
		}
		if (q.isEmpty()) {
			edges = ArrayList<Edge>(0);
		}
		else {
			edges = q.get(0);
		}
	}

	public ArrayList<Edge> getmst() {
		ArrayList<Edge> x = new ArrayList<Edge>();
		this.mergesort();
		DisjointSet ds = new DisjointSet();
		for (int u = 0; u < this.vertices; u++) {
			ds.makeset(u);
		}
		for (Edge e : edges) {
			if (ds.find(e.getv1()) != ds.find(e.getv2())) {
				x.add(e);
				ds.union(e.getv1(), e.getv2());
			}
		}
		return x;
	}

}