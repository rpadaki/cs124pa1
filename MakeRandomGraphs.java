import java.util.*;

public class MakeRandomGraphs {
	public static void main(String args[]) {
		// Graph g = makeRandomEdges(65536);
		// System.out.println("Graph weight: " + g.gettotalweight());
		// System.out.println(g.getedges().size());
		// System.out.println("MST weight: " + weight(g.getmst()));

		for (int i = 1; i < 40; i++) {
			double totalMax = 0;
			for (int j = 0; j < 3; j++) {
				Graph g = makeRandomEdges(1000*i);
				totalMax += maxweight(g.getmst());
			}
			System.out.println((1000*i)+ " " + totalMax/3.0 + " k = " + (2*(0.007*Math.pow(1000*i,2) + 1.9861*1000*i - 5)/(Math.pow(1000*i,2)+100*i)));
		}
	}

	public static double maxweight(ArrayList<Edge> edges) {
		double out = Integer.MIN_VALUE;
		for (Edge e : edges) {
			if (out < e.getweight()) {
				out = e.getweight();
			}
		}
		return out;
	}

	public static double weight(ArrayList<Edge> edges) {
		double total = 0;
		for (Edge e : edges) {
			total += e.getweight();
		}
		return total;
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
		return new Graph(9, a, 44);
	}

	// public static void insert(ArrayList<Edge> a, Edge e) {
	// 	int i = 0;
	// 	for (Edge f : a) {
	// 		if (f.getweight()>e.getweight()) {
	// 			break;
	// 		}
	// 		i++;
	// 	}
	// 	a.add(i,e);
	// }

	public static Graph makeRandomEdges(int n) {
		Random rng = new Random();
		ArrayList<Edge> a = new ArrayList<Edge>();
		double weight;
		double totalweight = 0;
		if (n < 8) {
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					weight = rng.nextDouble();
					totalweight += weight;
					a.add(new Edge(i,j,weight));
				}
			}
			return new Graph(n, a, totalweight);
		}
		double maxweight = 2.0*(0.007*Math.pow(n,2) + 1.9861*n - 5)/(Math.pow(n,2)+n);
		for (int i = 0; i < n; i++) {
			if (i/1000 > (i-1)/1000) System.out.println(i);
			for (int j = i+1; j < n; j++) {
				weight = rng.nextDouble();
				totalweight += weight;
				if (weight <= maxweight) {
					// insert(a,new Edge(i,j,weight));
					a.add(new Edge(i,j,weight));
				}
			}
		}
		return new Graph(n, a, totalweight);
	}

	// public static Graph makeRandomCube(int n, int d) {
	// 	Vertex[] vlist = new Vertex[n];
	// 	ArrayList<Edge> a = new ArrayList<Edge>();
	// 	for (int i = 0; i < n; i++) {
	// 		vlist[i] = new Vertex(d);
	// 	}
	// 	double weight;
	// 	double totalweight = 0;
	// 	for (int i = 0; i < n; i++) {
	// 		if (i/1000 > (i-1)/1000) System.out.println(i);
	// 		for (int j = i+1; j < n; j++) {
	// 			weight = vlist[i].distance(vlist[j]);
	// 			totalweight += weight;
	// 			if (weight <= Math.sqrt(d)*Math.pow(2.0, 0.5 - Math.log(n))) {
	// 				insert(a,new Edge(i,j,weight));
	// 			}
	// 		}
	// 	}
	// 	return new Graph(n, a, totalweight);
	// }
}