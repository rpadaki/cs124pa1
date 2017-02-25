import java.util.*;

public class Vertex {

	private float[] coords;
	private int dim;

	public Vertex(int n) {
		this.coords = new float[n];
		this.dim = n;
		Random rng = new Random();
		for (int i = 0; i < n; i++) {
			this.coords[i] = rng.nextFloat();
		}
	}

	public float distance(Vertex v) {
		float sum = 0;
		float[] vcoords = v.coords;
		for (int i = 0; i < this.dim; i++) {
			sum += Math.pow(this.coords[i] - vcoords[i], 2);
		}
		return (float) Math.sqrt(sum);
	}

	public float[] getcoords() {
		return this.coords;
	}
}