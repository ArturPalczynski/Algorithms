package KruskalAlgorithm;

import java.util.ArrayList;

public class Kruskal {

	public static void main(String[] args) {

		Edge edgeOne = new Edge(1, new char[] { 'a', 'b' }, 0);
		Edge edgeTwo = new Edge(5, new char[] { 'b', 'c' }, 0);
		Edge edgeThree = new Edge(3, new char[] { 'c', 'd' }, 0);
		Edge edgeFour = new Edge(6, new char[] { 'd', 'e' }, 0);
		Edge edgeFive = new Edge(4, new char[] { 'a', 'e' }, 0);
		Edge edgeSix = new Edge(3, new char[] { 'b', 'e' }, 0);
		// Edge edgeSeven = new Edge(6, new char[] { 'c', 'e' }, 0);
		// Edge edgeEight = new Edge(4, new char[] { 'c', 'f' }, 0);
		// Edge edgeNine = new Edge(2, new char[] { 'd', 'f' }, 0);
		// Edge edgeTen = new Edge(6, new char[] { 'e', 'f' }, 0);
		// Edge edgeEleven = new Edge(35, new char[] { 'g', 'h' });
		// Edge edgeTwelve = new Edge(44, new char[] { 'e', 'h' });

		ArrayList<Edge> inputEdges = new ArrayList<Edge>();

		inputEdges.add(edgeFour);
		inputEdges.add(edgeTwo);
		// inputEdges.add(edgeEight);
		// inputEdges.add(edgeNine);
		// inputEdges.add(edgeSeven);
		inputEdges.add(edgeOne);
		inputEdges.add(edgeThree);
		inputEdges.add(edgeFive);
		inputEdges.add(edgeSix);
		// inputEdges.add(edgeTen);
		// kruskalTree.add(edgeEleven);
		// kruskalTree.add(edgeTwelve);

		// sortowanie listy krawêdzi po wzglêdem wagi krawêdzi (niemalej¹co)
		BubleSorting.sortEdges(inputEdges);

		ArrayList<Edge> minimalSpanningTree = new ArrayList<Edge>();

		minimalSpanningTree.add(inputEdges.get(0));
		minimalSpanningTree.get(0).setMembershipFlag(1);

		for (int i = 0; i < inputEdges.size(); i++) {

			// sprawdzamy czy aspiruj¹ca krawêdz ma jeden wirzcho³ek wspólny z
			// krawêdzimi w minimalTree
			if (oneVertexinCommon()) {

				// ustawiamy flage w nowo dodawanej krawêdzi na tak¹ jaka jest w
				// krawêdzi która ma wspólny wierzcho³ek z t¹ nowo dodawan¹
				// krawêdzi¹
				inputEdges.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertex(inputEdges.get(i),
								minimalSpanningTree).getMembershipFlag());

				minimalSpanningTree.add(inputEdges.get(i)); // po dodani flaki
															// dodajemy krawêdz
															// do minimalnego
															// drzewa

			} else {

				// tutaj trzeba sprawdziæ czy krawêdz aspiruj¹ca ma dwa
				// wierzcho³ki wspólne z krawêdziami w minimal tree
				// jeœli tak to mamy dwie opcje
				// jedna gdy te krawêdzi które maj¹ wspólne wierzcho³ki maj¹ t¹
				// sam¹ flage - wtedy jest loopa - trzeba usun¹æ t¹ aspiruj¹c¹
				// krawêdz
				// druga opcja to gdy krawêdzi posiadaj¹ce wspólne wierzcho³ki z
				// krawêdzi¹ aspiruj¹c¹ maj¹ inne flagi
				// wtedy trzeba po³¹czyæ te dwa drzewa w jedno i zminiæ w nich
				// flagi na takie same

				if (inputEdges.get(i).checkForLoops(minimalSpanningTree)) {
					inputEdges.remove(i);
				} else {

					// tutaj bêdziemy czekaæ na opcjê gdy aspiruj¹ca krawêdŸ nie
					// ma ¿adnych wierzcho³ków wspólnych z krawêdzimi w
					// minimalTree
					//jeœli tak bêdzi to dodajemy t¹ krawêdz do rozwi¹zania z unikatow¹ flag¹ (flag++)
					
					if (true) {

					}
				}
			}
		}

		System.out.println();
		// int weightSum = 0;
		//
		// for (int t = 0; t < minimalSpanningTree.size(); t++) {
		//
		// System.out.println(minimalSpanningTree.get(t).getTip());
		// weightSum += minimalSpanningTree.get(t).getWeight();
		// }
		//
		// System.out.println(weightSum);

		// TODO
		// Napisaæ funkcjê która sprawdza czy wierzcho³ki nowo dodawanej
		// krawêdzi maj¹ obydwie falgi z tego samego drzewa
		// jeœli tak to j¹ od¿ucamy a jeœli nie to dodajemy je do minimalnego
		// drzewa i zmieniamy falgi na takie
		// jakie by³y w wiêkszym dzrewie
	}

	public static Edge serchForEdgeWithOneCommonVertex(Edge edge,
			ArrayList<Edge> minimalEdges) {

		Edge theSameOneVertex = new Edge();

		for (int i = 0; i < minimalEdges.size(); i++) {

			if (edge.getTip()[0] == minimalEdges.get(i).getTip()[0]
					|| edge.getTip()[0] == minimalEdges.get(i).getTip()[1]
					|| edge.getTip()[0] == minimalEdges.get(i).getTip()[0]
					|| edge.getTip()[0] == minimalEdges.get(i).getTip()[1]) {

				theSameOneVertex = minimalEdges.get(i);
				break;

			}

		}

		return theSameOneVertex;

	}
}
