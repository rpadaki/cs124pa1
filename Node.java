import java.util.*;

public class Node {
	private int rank;
	private int v;
	private Node p;

	public Node(int vertex) {
		this.p = this;
		this.v = vertex;
		this.rank = 0;
	}

	public edge getvertex() {
		return this.v;
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