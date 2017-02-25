import java.util.*;

public class Node {
	private int rank;
	private Edge e;
	private Node p;

	public Node(Edge edge) {
		this.p = this;
		this.e = edge;
		this.rank = 0;
	}

	public edge getedge() {
		return this.edge;
	}

	public Node getp() {
		return this.p;
	}

	public void setp(Node n) {
		p = n;
	}

	public int getrank() {
		return this.rank;
	}

	public void incrank() {
		rank++;
	}
}