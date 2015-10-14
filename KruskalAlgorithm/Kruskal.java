package KruskalAlgorithm;

import java.util.ArrayList;

public class Kruskal {

	public static void main(String[] args) {

		Edge edgeOne = new Edge(1, new char[] { 'a', 'c' }, 1);
		Edge edgeTwo = new Edge(6, new char[] { 'a', 'b' }, 2);
		Edge edgeThree = new Edge(5, new char[] { 'a', 'd' }, 3);
		Edge edgeFour = new Edge(5, new char[] { 'b', 'c' }, 4);
		Edge edgeFive = new Edge(5, new char[] { 'c', 'd' }, 5);
		Edge edgeSix = new Edge(3, new char[] { 'b', 'e' }, 6);
		Edge edgeSeven = new Edge(6, new char[] { 'c', 'e' }, 7);
		Edge edgeEight = new Edge(4, new char[] { 'c', 'f' }, 8);
		Edge edgeNine = new Edge(2, new char[] { 'd', 'f' }, 9);
		Edge edgeTen = new Edge(6, new char[] { 'e', 'f' }, 10);
		// Edge edgeEleven = new Edge(35, new char[] { 'g', 'h' });
		// Edge edgeTwelve = new Edge(44, new char[] { 'e', 'h' });

		ArrayList<Edge> inputEdges = new ArrayList<Edge>();

		inputEdges.add(edgeFour);
		inputEdges.add(edgeTwo);
		inputEdges.add(edgeEight);
		inputEdges.add(edgeNine);
		inputEdges.add(edgeSeven);
		inputEdges.add(edgeOne);
		inputEdges.add(edgeThree);
		inputEdges.add(edgeFive);
		inputEdges.add(edgeSix);
		inputEdges.add(edgeTen);
		// kruskalTree.add(edgeEleven);
		// kruskalTree.add(edgeTwelve);

		// sortowanie listy krawêdzi po wzglêdem wagi krawêdzi (niemalej¹co)
		BubleSorting.sortEdges(inputEdges);

		ArrayList<Edge> minimalSpanningTree = new ArrayList<Edge>();

		minimalSpanningTree.add(inputEdges.get(0));
		minimalSpanningTree.get(0).setMembershipFlag(1);

		for (int i = 0; i < inputEdges.size(); i++) {

			if (minimalSpanningTree.get(i).getMembershipFlag() == inputEdges
					.get(i).getMembershipFlag()) {

				System.out.print("Loop ");

			} else {

			}

		}

		System.out.println();
		int weightSum = 0;

		for (int t = 0; t < minimalSpanningTree.size(); t++) {

			System.out.println(minimalSpanningTree.get(t).getTip());
			weightSum += minimalSpanningTree.get(t).getWeight();
		}

		System.out.println(weightSum);

		// TODO
		// Napisaæ funkcjê która sprawdza czy wierzcho³ki nowo dodawanej
		// krawêdzi maj¹ obydwie falgi z tego samego drzewa
		// jeœli tak to j¹ od¿ucamy a jeœli nie to dodajemy je do minimalnego
		// drzewa i zmieniamy falgi na takie
		// jakie by³y w wiêkszym dzrewie
	}
}
