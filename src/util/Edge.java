package util;

public class Edge {

	private Vertex<?> v1;
	private Vertex<?> v2;
	private Integer weight;
	
	public Edge(Vertex<?> v1, Vertex<?> v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		weight = w;
	}
	
	//Getters & Setters
	public Integer getWeight() {
		return weight;
	}
	
	public Vertex<?> getAdj(Vertex<?> f){
		if(f.equals(v1)) {
			return v2;
		} else {
			return v1;
		}
	}
	
	public void setWeight(int w) {
		weight = w;
	}
	
}
