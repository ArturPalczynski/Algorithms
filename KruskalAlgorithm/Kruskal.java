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

		// sortowanie listy kraw�dzi po wzgl�dem wagi kraw�dzi (niemalej�co)
		BubleSorting.sortEdges(inputEdges);

		ArrayList<Edge> minimalSpanningTree = new ArrayList<Edge>();

		minimalSpanningTree.add(inputEdges.get(0));
		minimalSpanningTree.get(0).setMembershipFlag(1);

		for (int i = 0; i < inputEdges.size(); i++) {

			// sprawdzamy czy aspiruj�ca kraw�dz ma jeden wirzcho�ek wsp�lny z
			// kraw�dzimi w minimalTree
			if (oneVertexinCommon()) {

				// ustawiamy flage w nowo dodawanej kraw�dzi na tak� jaka jest w
				// kraw�dzi kt�ra ma wsp�lny wierzcho�ek z t� nowo dodawan�
				// kraw�dzi�
				inputEdges.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertex(inputEdges.get(i),
								minimalSpanningTree).getMembershipFlag());

				minimalSpanningTree.add(inputEdges.get(i)); // po dodani flaki
															// dodajemy kraw�dz
															// do minimalnego
															// drzewa

			} else {

				// tutaj trzeba sprawdzi� czy kraw�dz aspiruj�ca ma dwa
				// wierzcho�ki wsp�lne z kraw�dziami w minimal tree
				// je�li tak to mamy dwie opcje
				// jedna gdy te kraw�dzi kt�re maj� wsp�lne wierzcho�ki maj� t�
				// sam� flage - wtedy jest loopa - trzeba usun�� t� aspiruj�c�
				// kraw�dz
				// druga opcja to gdy kraw�dzi posiadaj�ce wsp�lne wierzcho�ki z
				// kraw�dzi� aspiruj�c� maj� inne flagi
				// wtedy trzeba po��czy� te dwa drzewa w jedno i zmini� w nich
				// flagi na takie same

				if (inputEdges.get(i).checkForLoops(minimalSpanningTree)) {
					inputEdges.remove(i);
				} else {

					// tutaj b�dziemy czeka� na opcj� gdy aspiruj�ca kraw�d� nie
					// ma �adnych wierzcho�k�w wsp�lnych z kraw�dzimi w
					// minimalTree
					//je�li tak b�dzi to dodajemy t� kraw�dz do rozwi�zania z unikatow� flag� (flag++)
					
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
		// Napisa� funkcj� kt�ra sprawdza czy wierzcho�ki nowo dodawanej
		// kraw�dzi maj� obydwie falgi z tego samego drzewa
		// je�li tak to j� od�ucamy a je�li nie to dodajemy je do minimalnego
		// drzewa i zmieniamy falgi na takie
		// jakie by�y w wi�kszym dzrewie
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
