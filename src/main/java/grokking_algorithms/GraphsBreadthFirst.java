package grokking_algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

//Cria um grafo com uma rede de amigos e faz uma busca pelo primeiro amigo cujo nome termine com a letra m
public class GraphsBreadthFirst {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> graph = criaGrafo();
		busca(graph);
	}

	//busca
	private static void busca(HashMap<String, ArrayList<String>> graph) {
		Queue<String> queue = new ArrayDeque<>();
		queue.addAll(graph.get("you"));
		ArrayList<String> buscados = new ArrayList<>();
		
		while (!queue.isEmpty()) {
			String person = queue.poll();
			if (!buscados.contains(person)) {
				if (pessoaTerminaComaLetraM(person)) {
					System.out.println(person + " termina com a letra 'M'");
					return;
				} else {
					queue.addAll(graph.get(person));
					buscados.add(person);
				}
			}
		}
	}

	private static HashMap<String, ArrayList<String>> criaGrafo() {
		//O grafo que irá conter uma pessoa como chave e um arrayList
		//composto dos amigos desta pessoa.
		HashMap<String, ArrayList<String>> graph = new HashMap<>();
		
		//Criando os objetos ArrayList com os relacionamentos do grafo
		ArrayList<String> myFriends = new ArrayList<>();
		myFriends.add("alice");
		myFriends.add("bob");
		myFriends.add("claire");
		
		ArrayList<String> aliceFriends = new ArrayList<>();
		aliceFriends.add("peggy");
		
		ArrayList<String> bobFriends = new ArrayList<>();
		bobFriends.add("anuj");
		bobFriends.add("peggy");
		
		ArrayList<String> claireFriends = new ArrayList<>();
		claireFriends.add("thom");
		claireFriends.add("jonny");
		
		ArrayList<String> peggyFriends = new ArrayList<>();
		
		ArrayList<String> anujFriends = new ArrayList<>();
		
		ArrayList<String> thomFriends = new ArrayList<>();
		
		ArrayList<String> jonnyFriends = new ArrayList<>();
		
		//Adicionando as "pessoas/suas amigas" ao grafo.
		graph.put("you", myFriends);
		graph.put("alice", aliceFriends);
		graph.put("bob", bobFriends);
		graph.put("claire", claireFriends);
		graph.put("anuj", anujFriends);
		graph.put("peggy", peggyFriends);
		graph.put("thom", thomFriends);
		graph.put("jonny", jonnyFriends);
		return graph;
	}

	private static boolean pessoaTerminaComaLetraM(String person) {
		char ultimaLetra = person.charAt(person.length()-1);
		if (ultimaLetra == 'm' || ultimaLetra == 'M')
			return true;
		return false;
	}

}
