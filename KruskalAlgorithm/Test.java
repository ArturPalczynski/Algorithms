package KruskalAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		ArrayList<Edge> spanningTree = new ArrayList<Edge>();

		Edge edgeOne = new Edge(1, new char[] { 'a', 'b' }, 0);
		Edge edgeTwo = new Edge(2, new char[] { 'b', 'c' }, 0);
		Edge edgeThree = new Edge(3, new char[] { 'b', 'e' }, 0);
		Edge edgeFour = new Edge(6, new char[] { 'a', 'e' }, 0);
		Edge edgeFive = new Edge(4, new char[] { 'd', 'h' }, 0);

		spanningTree.add(edgeOne);
		spanningTree.add(edgeTwo);
		spanningTree.add(edgeThree);
		spanningTree.add(edgeFour);
		spanningTree.add(edgeFive);

		BubleSorting.sortEdges(spanningTree);

		ArrayList<Edge> minTree = new ArrayList<Edge>();
		minTree.add(edgeOne);
		minTree.get(0).setMembershipFlag(1);

		for (int i = 1; i < spanningTree.size(); i++) {

			// sprawdzamy czy aspiruj�ca kraw�dz ma jeden wirzcho�ek wsp�lny z
			// kraw�dzimi w minimalTree

			if (spanningTree.get(i).oneVertexInCommon(minTree)) {

				System.out.println("One common vertex for: " + i + " "
						+ spanningTree.get(i).getTip()[0] + " "
						+ spanningTree.get(i).getTip()[1]);

				// ustawiamy flage w nowo dodawanej kraw�dzi na tak� jaka jest w
				// kraw�dzi kt�ra ma wsp�lny wierzcho�ek z t� nowo dodawan�
				// kraw�dzi�
				spanningTree.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertexTest(
								spanningTree.get(i), minTree)
								.getMembershipFlag());

				minTree.add(spanningTree.get(i)); // po dodani flagi
													// dodajemy kraw�dz
													// do minimalnego
													// drzewa

				System.out.println(minTree.size());

			} else {
//usuwamy loope
				if(spanningTree.get(i).checkForLoops(minTree)){
					System.out.println("Loopa usuni�ta");
					spanningTree.remove(i);
				}else{
					
					System.out.println("Nie ma wsp�lnych wierzcho�k�w dla: ");
					System.out.println(spanningTree.get(i).getTip()[0]+" "+spanningTree.get(i).getTip()[1] );
//tutaj dociera opcja ze sprawdzana kraw�dz nie ma wsp�lnych wierzcho�k�w z drzewem					
					
				}

			}
		}

		for (Edge e : minTree) {
			System.out.println(e.getTip()[0] + " " + e.getTip()[1] + " "
					+ e.getMembershipFlag());
		}
	}

	public static Edge serchForEdgeWithOneCommonVertexTest(Edge edge,
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
