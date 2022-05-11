package grokking_algorithms;

import java.util.ArrayList;
import java.util.List;

public class SomandoArrayRecursivamente {

		public static void main(String[] args) {
		
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(12);
			list.add(3);
			list.add(6);
			System.out.println(sum(list));
			
		}

		private static int sum(List<Integer> list) {
			int total = 0;
			total += list.get(0);
			list.remove(0);
			if (list.size() > 0) {
				total += sum(list);
			}
			return total;
		}
}
