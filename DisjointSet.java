import java.util.*

public class DisjointSet {
	private ArrayList<Node> nodes;

	public void makeset(Edge e) {
		this.nodes.add(new Node(e));
	}

	public Node getnode(Edge e) {
		for (Node n in nodes) {
			if (n.getedge().getv1() == e.getv1() && n.getEdge().getv2() == e.getv2()) {
				return n;
			}
			return null;
		}
	}
	public Node find(Edge e) {
		Node n = this.getnode(e);
		if (n != n.getp()) {
			n.setp(find(n.getp().getedge()));
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

	public void union(Edge e, Edge f) {
		this.link(this.getnode(e), this.getnode(f));
	}
}