// HUIDS: 21130176 and 31238714
// This object is the DisjointSet data structure
// used in Kruskal's algorithm, as described in
// lecture.
import java.util.*;

public class DisjointSet {
	private ArrayList<Node> nodes;

	// A disjoint set is created with
	// zero nodes; it is empty. Nodes
	// here correspond to vertices.
	public DisjointSet() {
		nodes = new ArrayList<Node>(0);
	}

	// Make a node for a given vertex
	// pointing to itself. (A 1-element
	// set.)
	public void makeset(int v) {
		this.nodes.add(new Node(v));
	}

	// Given a vertex, find the node
	// coresponding to that vertex.
	public Node getnode(int v) {
		for (Node n : nodes) {
			if (n.getvertex() == v) {
				return n;
			}
		}
		return null;
	}

	// Given a vertex, find the initial
	// node of that vertex's tree, while
	// updating all nodes along the way to
	// point directly to that initial node.
	public Node find(int v) {
		Node n = this.getnode(v);
		if (n != n.getp()) {
			n.setp(find(n.getp().getvertex()));
		}
		return n.getp();
	}

	// Link two trees based on the ranks of
	// the initial nodes by setting the higher
	// rank tree as the parent of the lower one.
	public void link(Node x, Node y) {
		if (x.getrank() > y.getrank()) {
			link(y, x);
		}
		else {
			if (x.getrank() == y.getrank()) {
				y.incrank();
			}
			x.setp(y);
		}
	}

	// Take the union of two vertices' sets
	// by linking their initial nodes.
	public void union(int u, int v) {
		this.link(this.find(u), this.find(v));
	}
}