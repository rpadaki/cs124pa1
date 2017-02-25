import edge;
import graph;
import Java.util.*;

public static class MakeRandomGraphs {
	public static void main(String args[]) {
		ArrayList<Edge> a = makeRandomEdges(5);
		for (edge e: a) {
			System.out.println(e.getweight());
		}
	}

	public static ArrayList<Edge> makeRandomEdges(int n) {
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				a.add(new Edge(i,j,Random.nextFloat()))
			}
		}
	}

	public static ArrayList<Edge> makeRandomSquare(int n) {

	}
}