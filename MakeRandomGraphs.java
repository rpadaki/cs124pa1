import java.util.*;

public class MakeRandomGraphs {
	public static void main(String args[]) {
		Graph g = makeRandomCube(100,15);
		float totalweight = 0;
		for (Edge e: g.getedges()) {
			totalweight += e.getweight();
		}
		System.out.println("Graph Weight: " + totalweight);
		totalweight = 0;
		for (Edge e: g.getmst()) {
			totalweight += e.getweight();
		}
		System.out.println("MST Weight: " + totalweight);
	}

	public static Graph makeTestGraph() {
		ArrayList<Edge> a = new ArrayList<Edge>(12);
		a.add(new Edge(0,1,1));
		a.add(new Edge(0,3,3));
		a.add(new Edge(1,2,5));
		a.add(new Edge(1,4,5));
		a.add(new Edge(2,5,2));
		a.add(new Edge(3,4,4));
		a.add(new Edge(3,6,2));
		a.add(new Edge(4,5,1));
		a.add(new Edge(4,7,5));
		a.add(new Edge(5,8,7));
		a.add(new Edge(6,7,3));
		a.add(new Edge(7,8,6));
		return new Graph(9, a);
	}

	public static Graph makeRandomEdges(int n) {
		Random rng = new Random();
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				a.add(new Edge(i,j,rng.nextFloat()));
			}
		}
		return new Graph(n, a);
	}

	public static Graph makeRandomCube(int n, int d) {
		Vertex[] vlist = new Vertex[n];
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			vlist[i] = new Vertex(d);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				a.add(new Edge(i,j,vlist[i].distance(vlist[j])));
			}
		}
		return new Graph(n, a);
	}
}