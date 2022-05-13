package grokking_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {

	static ArrayList<String> nodesProcessadas = new ArrayList<>();
	static HashMap<String, HashMap<String, Integer>> graph = criaGrafo();

	static HashMap<String, Integer> distanceCost = criaDistanceCost();

	static HashMap<String, String> parents = criaParents();

	public static void main(String[] args) {

		Integer caminhoMaisRapido = dijkistra();
		System.out.println(caminhoMaisRapido);
		System.out.println();
		
		caminho();
	}

	private static void caminho() {
		String node = "fin";
		while (node != "start") {
			System.out.println(node);
			node = parents.get(node);
		}
		System.out.println("start");
	}

	private static Integer dijkistra() {
		String node = find_lowest_cost_node(distanceCost);
		while (node != null) {
			Integer cost = distanceCost.get(node);
			HashMap<String, Integer> neighbors = graph.get(node);

			for (String n : neighbors.keySet()) {
				Integer newCost = neighbors.get(n) + cost;
				if (distanceCost.get(n) > newCost) {
					distanceCost.put(n, newCost);
					parents.put(n, node);
				}

			}
			nodesProcessadas.add(node);
			node = find_lowest_cost_node(distanceCost);

		}

		return distanceCost.get("fin");
	}

	private static HashMap<String, String> criaParents() {
		HashMap<String, String> parents = new HashMap<>();
		parents.put("a", "start");
		parents.put("b", "start");
		parents.put("fin", null);
		return parents;
	}

	private static HashMap<String, Integer> criaDistanceCost() {
		HashMap<String, Integer> distanceCost = new HashMap<>();
		distanceCost.put("a", 6);
		distanceCost.put("b", 2);
		distanceCost.put("fin", Integer.MAX_VALUE);

		return distanceCost;
	}

	private static HashMap<String, HashMap<String, Integer>> criaGrafo() {
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

		HashMap<String, Integer> startNeighbors = new HashMap<>();
		startNeighbors.put("a", 6);
		startNeighbors.put("b", 2);

		HashMap<String, Integer> aNeighbors = new HashMap<>();
		aNeighbors.put("fin", 1);

		HashMap<String, Integer> bNeighbors = new HashMap<>();
		bNeighbors.put("a", 3);
		bNeighbors.put("fin", 5);

		HashMap<String, Integer> finNeighbors = new HashMap<>();

		graph.put("start", startNeighbors);
		graph.put("a", aNeighbors);
		graph.put("b", bNeighbors);
		graph.put("fin", finNeighbors);
		return graph;
	}

	private static String find_lowest_cost_node(HashMap<String, Integer> distanceCosts) {
		Integer lowestCost = Integer.MAX_VALUE;
		String lowestCostNode = null;

		for (String n : distanceCosts.keySet()) {
			Integer cost = distanceCosts.get(n);
			if (cost < lowestCost && !nodesProcessadas.contains(n)) {
				lowestCost = cost;
				lowestCostNode = n;
			}
		}
		return lowestCostNode;
	}

}
