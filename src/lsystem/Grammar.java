package lsystem;

import java.util.ArrayList;
import java.util.HashMap;


public class Grammar {
	private String nom;
	private int level;
	private String start;
	private String result;
	private String precRes;//Etat precedent
	
	private HashMap<String,ArrayList<String>> generation;
	
	public Grammar(String nom){
		this.nom=nom;
		level=0;
		start=" ";
		result="";
		generation = new HashMap<String,ArrayList<String>>();
	}
	public boolean find(String ch){
		if(ch.length()==1){
			for(String key: generation.keySet()){
				if(key.equals(ch)){
					
					return true;
				}
			}
		}
		return false;
	}
	
	public String search(String start){
		
		if(find(start)){
			//if(Math.random()>0.5){
			int index=(int)(Math.random()*100)%(generation.get(start).size());
			return generation.get(start).get(index);
				//}
		}
		return start;
	}
	
	public void addGeneration(String start,String ref){
		if(!find(start)){
			ArrayList<String> p=new ArrayList<String>();
			p.add(ref);
			generation.put(start, p);
			return;
		}
		generation.get(start).add(ref);
	}
	public void clean(){
		result="";
	}
	public void iterate(int num){
		if(result==""){
		result=start;
		}
		precRes=result;//Etat précédent
		for(int i=0;i<num;i++){
			String tmp="";
			for(int j=0;j<result.length();j++){	
				String s=""+result.charAt(j);
					tmp+=search(s);
				
			}
			result=tmp;
		}
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getStart() {
		return start;
	}
	public void setResult(String result){
		this.result=result;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getResult() {
		return result;
	}
	public String getPrecRes() {
		return precRes;
	}
	public HashMap<String, ArrayList<String>> getGeneration() {
		return generation;
	}	
}
