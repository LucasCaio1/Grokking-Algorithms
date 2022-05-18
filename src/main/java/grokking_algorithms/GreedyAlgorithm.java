package grokking_algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GreedyAlgorithm {

	public static void main(String[] args) {

		Set<String> statesNeeded = estadosQuePrecisamDeCobertura();

		HashMap<String, Set> stations = estacoesEOsEstadosQueElasCobrem();

		Set<String> finalStations = new TreeSet<>();

		while (!statesNeeded.isEmpty()) {
			String bestStation = null;
			Set<String> statesCoveredBestStation = new TreeSet<>();
			for (String station : stations.keySet()) {
				Set<String> covered = statesNeeded.stream().filter(stations.get(station)::contains).collect(Collectors.toSet());
				if (covered.size() > statesCoveredBestStation.size()) {
					bestStation = station;
					statesCoveredBestStation = covered;
				}

			}
			finalStations.add(bestStation);
			statesNeeded.removeAll(statesCoveredBestStation);
		}
		
		finalStations.stream().forEach(System.out::println);
	}

	private static HashMap<String, Set> estacoesEOsEstadosQueElasCobrem() {
		HashMap<String, Set> stations = new HashMap<>();
		stations.put("kone", Arrays.asList("id", "nv", "ut").stream().collect(Collectors.toSet()));
		stations.put("ktwo", Arrays.asList("wa", "id", "mt").stream().collect(Collectors.toSet()));
		stations.put("kthree", Arrays.asList("or", "nv", "ca").stream().collect(Collectors.toSet()));
		stations.put("kfour", Arrays.asList("nv", "ut").stream().collect(Collectors.toSet()));
		stations.put("kfive", Arrays.asList("ca", "az").stream().collect(Collectors.toSet()));
		return stations;
	}

	private static Set<String> estadosQuePrecisamDeCobertura() {
		Set<String> statesNeeded = Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az").parallelStream()
				.collect(Collectors.toSet());
		return statesNeeded;
	}

}
