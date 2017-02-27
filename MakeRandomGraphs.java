// HUIDS: 21130176 and 31238714
// Our main file, where we take input, construct graphs, and
// return output as per the problem specifications.
import java.util.*;

public class MakeRandomGraphs {
	// Making sure final program format is correct.
	public static void main(String args[]) {
		try {
			int flag = Integer.parseInt(args[0]);
			int numpoints = Integer.parseInt(args[1]);
			int numtrials = Integer.parseInt(args[2]);
			int dimension = Integer.parseInt(args[3]);

			// Standard output.
			// Flag 0 (or anything, really) looks
			// at total MST weight.
			// Flag 1 looks at the maximum edge
			// weight within the mst.
			double totweight = 0;
			for (int i = 0; i < numtrials; i++) {
				Graph g = null;
				if (dimension == 0) g = makeRandomEdges(numpoints);
				else if (dimension > 0) g = makeRandomCube(numpoints, dimension);
				else {
					System.out.println("Error: Invalid Arguments.");
					System.exit(0);
				}
				if (flag != 1) totweight += weight(g.getmst());
				else if (flag == 1) totweight += maxweight(g.getmst());
			}
			System.out.println(totweight/numtrials + " " + numpoints + " " + numtrials + " " + dimension);
		}
		catch (NumberFormatException e) {
			System.out.println("Error: Invalid Arguments.");
			System.exit(0);
		}
	}

	// Given a list of edges, find the maximum weight.
	public static double maxweight(ArrayList<Edge> edges) {
		double out = Integer.MIN_VALUE;
		for (Edge e : edges) {
			if (out < e.getweight()) {
				out = e.getweight();
			}
		}
		return out;
	}

	// Given a list of edges, find the total weight.
	public static double weight(ArrayList<Edge> edges) {
		double total = 0;
		for (Edge e : edges) {
			total += e.getweight();
		}
		return total;
	}

	// We tested our implementation of Kruskal's
	// on a simple example graph.
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


	// This is the first case, in which we
	// generate edge weights uniformly at
	// random in [0,1].
	public static Graph makeRandomEdges(int n) {
		Random rng = new Random();
		ArrayList<Edge> a = new ArrayList<Edge>();
		double weight;
		double totalweight = 0;
		// We did not expect edges of weight
		// greater than this function k(n)
		// to appear in our graph, based
		// on empirical data for smaller n.
		double maxweight = 0.7072/Math.pow(n, 0.693);
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				weight = rng.nextDouble();
				totalweight += weight;
				if (weight <= maxweight) {
					a.add(new Edge(i,j,weight));
				}
			}
		}
		return new Graph(n, a, totalweight);
	}

	// This is the second case, in which we
	// generate edges weights as Euclidean
	// distances between points picked
	// uniformly at random in the unit
	// d-hypercube.
	public static Graph makeRandomCube(int n, int d) {
		Vertex[] vlist = new Vertex[n];
		ArrayList<Edge> a = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			vlist[i] = new Vertex(d);
		}
		// We did not expect edges of weight
		// greater than this function k(n,d)
		// to appear in our graph, based on
		// empirical data for smaller n.
		double maxweight = Math.pow(n, -0.77/d);
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