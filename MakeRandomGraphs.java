import java.util.*;

public class MakeRandomGraphs {
	public static void main(String args[]) {
		// Graph g = makeRandomEdges(65536);
		// System.out.println("Graph weight: " + g.gettotalweight());
		// System.out.println(g.getedges().size());
		for (int d = 2; d < 5; d++) {
			System.out.println("\nDIMENISION " + d);
			for (int i = 2; i < 150; i++) {
				double totalMax = 0;
				for (int j = 0; j < 5; j++) {
					Graph g = makeRandomCube(i,d);
					totalMax += maxweight(g.getmst());
				}
				System.out.println(i + "\t" + totalMax/5.0);
			}
		}

		// for (int i = 128; i < 131073; i = i * 2) {
		// //	double totalMax = 0;
		// 	double totweight = 0;
		// 	for (int j = 0; j < 5; j++) {
		// 		Graph g = makeRandomCube(i,4);
		// 		totweight += weight(g.getmst()) / (i);
		// 		//totalMax += maxweight(g.getmst());
		// 	}
		// 	System.out.println(i + "\tAverage MST Weight:\t" + totweight / 5.0);
		// 	//System.out.println((1000*i)+ " " + totalMax/5.0 + " k = " + (0.7072/Math.pow(1000*i, 0.693)));
		// }
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

		//double maxweight = 2.0*(0.007*Math.pow(n,2) + 1.9861*n - 5)/(Math.pow(n,2)+n);
		double maxweight = 0.7072/Math.pow(n, 0.693);
		for (int i = 0; i < n; i++) {
		//	if (i/1000 > (i-1)/1000) System.out.println(i);
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

	public static Graph makeRandomCube(int n, int d) {
		Vertex[] vlist = new Vertex[n];
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			vlist[i] = new Vertex(d);
		}
		double maxweight = Math.sqrt(d);//*0.7072/Math.pow(n, 0.693);
		double weight;
		double totalweight = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				weight = vlist[i].distance(vlist[j]);
				totalweight += weight;
				if (weight < maxweight) {
					a.add(new Edge(i,j,weight));
				}
			}
		}
		return new Graph(n, a, totalweight);
	}
}