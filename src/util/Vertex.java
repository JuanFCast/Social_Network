package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Vertex<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private T element;
	private String color;
	private double distance;
	
	private Vertex<T> parent;
	private List<Edge> adj;
	
	public Vertex(T e){
		element = e;
		adj = new ArrayList<>();
		color = null;
		parent = null;
	}
	
	public boolean insertAdj(Edge e) {
		if(!adj.contains(e)) {
			adj.add(e);
			return true;
		} else {
			return false;
		}
	}
	
	//Getters & Setters
	@SuppressWarnings("unchecked")
	public List<Vertex<T>> getAdjV(){
		List<Vertex<T>> l =  new ArrayList<>();
		
		for (Edge edge : adj) {
			l.add((Vertex<T>) edge.getAdj(this));
		}
		
		return l;
	}
	
	public List<T> getAdj(){
		List<T> l =  new ArrayList<>();
		
		for (Edge edge : adj) {
			@SuppressWarnings("unchecked")
			Vertex<T> v = (Vertex<T>) edge.getAdj(this);
			if(v != null) {
				l.add(v.getElement());
			}
		}
		
		return l;
	}
	
	@SuppressWarnings("unchecked")
	public void BFS(Queue<Vertex<T>> q) {
		for (Edge ed : adj) {
			Vertex<T> v = (Vertex<T>) ed.getAdj(this);
			if(v.color.equals("WHITE")) {
				v.setColor("GRAY");
				v.setDistance(distance() + 1);
				v.setParent(this);
				q.add(v);
			}
		}
	}
	
	public Vertex<T> getParent(){
		return parent;
	}
	public String getColor() {
		return color;
	}
	public double distance() {
		return distance;
	}
	public T getElement() {
		return element;
	}
	public List<Edge> getAdjE() {
		return adj;
	}
	
	public void setColor(String c) {
		color = c;
	}
	public void setDistance(double d) {
		distance = d;
	}
	public void setParent(Vertex<T> p) {
		parent = p;
	}
}
