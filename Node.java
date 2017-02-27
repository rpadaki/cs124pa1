// HUIDS: 21130176 and 31238714
// This object is the Node used
// in the tree implementation of
// the DisjointSet type.
import java.util.*;

public class Node {
	private int rank;
	private int v;
	private Node p;

	// Nodes correspond to graph
	// vertices, and start out
	// pointing to themselves.
	public Node(int vertex) {
		v = vertex;
		rank = 0;
		p = this;
	}

	// Return the vertex corresponding
	// to this node.
	public int getvertex() {
		return this.v;
	}

	// Get the parent of this node.
	public Node getp() {
		return this.p;
	}

	// Set the parent of this node.
	public void setp(Node n) {
		p = n;
	}

	// Get the rank of this node.
	public int getrank() {
		return this.rank;
	}

	// Increment the rank of this node.
	public void incrank() {
		rank++;
	}
}