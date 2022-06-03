package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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
	
	public boolean insertV(Vertex<T> o) {
		if(vertices.get(o.getElement()) == null) {
			vertices.put(o.getElement(), o);
			
			if(!o.getAdjE().isEmpty()) {
				for (Edge edge : o.getAdjE()) {
					edges.add(edge);
				}
			}
			
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
	
	@SuppressWarnings("unchecked")
	public void BFS(Vertex<T> v) {
		for (Map.Entry<T, Vertex<T>> vertex : vertices.entrySet()) {
			((Vertex<T>) vertex).setColor("WHITE");
			((Vertex<T>) vertex).setDistance(Double.MAX_VALUE);
		}
		
		v.setColor("GRAY");
		v.setDistance(0);
		v.setParent(null);
		
		Queue<Vertex<T>> q = new LinkedList<>();
		q.add(v);
		
		while(q.isEmpty() != true) {
			Vertex<T> u = q.poll();
			u.BFS(q);
			u.setColor("BLACK");
		}
	}
	
	public void dijkstra(Vertex<T> s) {
		PriorityQueue<Vertex<T>> q = new PriorityQueue<>(new Comparator<Vertex<T>>() {
			@Override
			public int compare(Vertex<T> o1, Vertex<T> o2) {
				if(o1.distance() > o2.distance()) {return 1;} else if(o1.distance() < o2.distance()) {return -1;} else {return 0;}
			}
		});
		
		for (Map.Entry<T, Vertex<T>> v : vertices.entrySet()) {
			if(!v.getValue().equals(s)) {
				v.getValue().setDistance(Double.MAX_VALUE);
			} else {
				v.getValue().setDistance(0);
			}
		}
		
		q.add(s);
		
		while(!q.isEmpty()) {
			Vertex<T> u = q.poll();
			u.dijkstra(q);
		}
	}
	
	public Vertex<T> getVertex(T e){
		return vertices.get(e);
	}
	
	public List<Vertex<T>> getVertices(){
		List<Vertex<T>> l = new ArrayList<>();
		
		for (Map.Entry<T, Vertex<T>> vertex : vertices.entrySet()) {
			l.add(vertex.getValue());
		}
		
		return l;
	}
}
