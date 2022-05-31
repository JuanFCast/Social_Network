package util;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Graph<T> {
	private HashMap<T, Vertex<T>> vertices;
	private PriorityQueue<Edge> edges;
	
	public Graph() {
		vertices = new HashMap<>();
		edges = new PriorityQueue<>();
	}
	
	public boolean insert(T o) {
		if(vertices.get(o) == null) {
			Vertex<T> v = new Vertex<>(o);
			vertices.put(o, v);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean insertAdj(Vertex<T> v1, Vertex<T> v2, Integer w) {
		Edge e = new Edge(v1, v2, w);
		v1.insertAdj(e);
		v2.insertAdj(e);
		edges.add(e);
		
		return true;
	}
	
	public Vertex<T> getVertex(T e){
		return vertices.get(e);
	}	
}
