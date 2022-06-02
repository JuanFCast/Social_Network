package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import util.AVL;
import util.Graph;

public class SocialNetwork {

	private final String PATH_FOR_AVL = "data/usersForAVL.ced";
	private final String PATH_FOR_GRAPH = "data/usersForGraph.ced";
	private AVL<Person> usersbyEmail;
	private Graph<Person> network;
	
	public SocialNetwork() {
		usersbyEmail = new AVL<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
		network = new Graph<>();
		
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addRegister(Person p) {
		if(usersbyEmail.search(p) == null) {
			usersbyEmail.add(p);
			network.insert(p);
			
			saveData();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean makeARelation(Person p, Person p2) {
		return network.insertAdj(network.getVertex(p), network.getVertex(p2), 1);
	}
	
	public Person searchRegister(Person p) {
		Person pc = usersbyEmail.search(p);
		return (pc != null)?pc:null;
	}
	
	public List<Person> getListContains(String s) {
		List<Person> l = new ArrayList<>();
		List<Person> a = usersbyEmail.searchList();
		for (Person person : a) {
			if(person.getUserName().contains(s)) {
				l.add(person);
			}
		}
		
		return l;
	}
	
	public List<Person> getContacts(Person p){
		List<Person> l = network.getVertex(p).getAdj();
		
		return l;
	}
	
	private void loadData() throws ClassNotFoundException, IOException, Exception{
		if(loadDataForAVL() && loadDataForGraph()) {
			
		} else {
			throw new Exception("Error completing data upload");
		}
	}
	
	private void saveData(){
		try {
			saveDataForAVL();
			saveDataForGraph();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean loadDataForAVL() throws ClassNotFoundException, IOException {
		File fileAVL = new File(PATH_FOR_AVL);		
		if(fileAVL.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileAVL));
			List<Person> l = (List<Person>) ois.readObject();
			for (Person person : l) {
				usersbyEmail.add(person);
			}
			ois.close();
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean loadDataForGraph() throws ClassNotFoundException, IOException {
		File fileGraph = new File(PATH_FOR_GRAPH);
		
		if(fileGraph.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileGraph));
			network = (Graph<Person>) ois.readObject();
			ois.close();
			return true;
		}
		
		return false;
	}
	
	private void saveDataForAVL() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_FOR_AVL));
		oos.writeObject(usersbyEmail.searchList());
		oos.close();
	}
	
	private void saveDataForGraph() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_FOR_GRAPH));
		oos.writeObject(network);
		oos.close();
	}
	
}
