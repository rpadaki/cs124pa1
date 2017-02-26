import java.util.*;

public class MakeRandomGraphs {
	public static void main(String args[]) {
		ArrayList<Edge> a = makeRandomCube(5, 2);
		for (Edge e: a) {
			System.out.println(e.getweight());
		}
	}

	public static ArrayList<Edge> makeRandomEdges(int n) {
		Random rng = new Random();
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				a.add(new Edge(i,j,rng.nextFloat()));
			}
		}
		return a;
	}

	public static ArrayList<Edge> makeRandomCube(int n, int d) {
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
		return a;
	}
}