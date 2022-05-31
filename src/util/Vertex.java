package util;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T element;
	private String color;
	
	private List<Edge> adj;
	
	public Vertex(T e){
		element = e;
		adj = new ArrayList<>();
		color = null;
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
	public List<Vertex<T>> getAdj(){
		List<Vertex<T>> l =  new ArrayList<>();
		
		for (Edge edge : adj) {
			l.add((Vertex<T>) edge.getAdj(this));
		}
		
		return l;
	}
	
	public String getColor() {
		return color;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setColor(String c) {
		color = c;
	}
}
