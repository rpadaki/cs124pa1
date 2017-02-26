import java.util.*;

public class DisjointSet {
	private ArrayList<Node> nodes;

	public DisjointSet() {
		nodes = new ArrayList<Node>(0);
	}

	public void makeset(int v) {
		this.nodes.add(new Node(v));
	}

	public Node getnode(int v) {
		for (Node n : nodes) {
			if (n.getvertex() == v) {
				return n;
			}
		}
		return null;
	}
	public Node find(int v) {
		Node n = this.getnode(v);
		if (n != n.getp()) {
			n.setp(find(n.getp().getvertex()));
		}
		return n.getp();
	}

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

	public void union(int u, int v) {
		this.link(this.find(u), this.find(v));
	}
}