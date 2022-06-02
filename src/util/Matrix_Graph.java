package util;

import java.util.HashMap;

public class Matrix_Graph<T> {
	
	//Basado en el codigo presentado en este video: https://www.youtube.com/watch?v=kAP8qlzZbeY

	private final int MAX_VERTEX = 100;
	private HashMap<T, Vertex<T>> vertices;
	private int edges;
	private int adjMatrix[][];
	
	public Matrix_Graph() {
		vertices = new HashMap<>();
		edges = 0;
		adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
		
		for(int i = 0; i < MAX_VERTEX; i++) {
			for(int j = 0; j < MAX_VERTEX; j++) {
				adjMatrix[i][j] = 0;
			}
		}
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
	
	// se le manda por parametro el id de las dos personas que se van a relasionar
	public void addEdge(int v1, int v2, int weight) {
		adjMatrix[v1][v2] = weight;
		edges++;
	}
	
	public Vertex<T> getVertex(T e){
		return vertices.get(e);
	}
	
}
