import java.util.*;

public class Node {
	private int rank;
	private int v;
	private Node p;

	public Node(int vertex) {
		v = vertex;
		rank = 0;
		p = this;
	}

	public int getvertex() {
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