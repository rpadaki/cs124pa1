import java.util.*;

public class Edge {
	private int vertex1;
	private int vertex2;
	private double weight;

	public Edge(int v1, int v2, double w) {
		if (v2<v1) {
			this.vertex1 = v2;
			this.vertex2 = v1;
		}
		else {
			this.vertex1 = v1;
			this.vertex2 = v2;	
		}
		this.weight = w;
	}

	public int getv1() {
		return this.vertex1;
	}

	public int getv2() {
		return this.vertex2;
	}

	public double getweight() {
		return this.weight;
	}
}