package grokking_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {

	public static void main(String[] args) {
		
		HashMap<String, ArrayList<HashMap<String, Integer>>> graph = new HashMap<>();
		
		
		ArrayList<HashMap<String, Integer>> startNodes = new ArrayList<>();
		startNodes.add(hashMapStringInteger("a", 6));
		startNodes.add(hashMapStringInteger("b", 2));
		
		ArrayList<HashMap<String, Integer>> aNodes = new ArrayList<>();
		aNodes.add(hashMapStringInteger("fin", 1));
		
		ArrayList<HashMap<String, Integer>> bNodes = new ArrayList<>();
		bNodes.add(hashMapStringInteger("a", 3));
		bNodes.add(hashMapStringInteger("fin", 5));
		
		graph.put("start", startNodes);
		graph.put("a", aNodes);
		graph.put("b", bNodes);
		
		
		
		
		

	}

	private static void retornaNodesNeibors(HashMap<String, ArrayList<HashMap<String, Integer>>> graph, String node) {
		graph.get(node).forEach(a -> System.out.println(a.keySet().iterator().next()));
	}
	
	private static HashMap<String, Integer> hashMapStringInteger(String key, Integer value){
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(key, value);
		return hm;
	}

}
