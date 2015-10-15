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

			// sprawdzamy czy aspiruj¹ca krawêdz ma jeden wirzcho³ek wspólny z
			// krawêdzimi w minimalTree

			if (spanningTree.get(i).oneVertexInCommon(minTree)) {

				System.out.println("One common vertex for: " + i + " "
						+ spanningTree.get(i).getTip()[0] + " "
						+ spanningTree.get(i).getTip()[1]);

				// ustawiamy flage w nowo dodawanej krawêdzi na tak¹ jaka jest w
				// krawêdzi która ma wspólny wierzcho³ek z t¹ nowo dodawan¹
				// krawêdzi¹
				spanningTree.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertexTest(
								spanningTree.get(i), minTree)
								.getMembershipFlag());

				minTree.add(spanningTree.get(i)); // po dodani flagi
													// dodajemy krawêdz
													// do minimalnego
													// drzewa

				System.out.println(minTree.size());

			} else {
//usuwamy loope
				if(spanningTree.get(i).checkForLoops(minTree)){
					System.out.println("Loopa usuniêta");
					spanningTree.remove(i);
				}else{
					
					System.out.println("Nie ma wspólnych wierzcho³ków dla: ");
					System.out.println(spanningTree.get(i).getTip()[0]+" "+spanningTree.get(i).getTip()[1] );
//tutaj dociera opcja ze sprawdzana krawêdz nie ma wspólnych wierzcho³ków z drzewem					
					
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
