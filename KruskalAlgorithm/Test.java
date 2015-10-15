package KruskalAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		int membershipFlagCounter = 2;

		ArrayList<Edge> spanningTree = new ArrayList<Edge>();

		Edge edgeOne = new Edge(1, new char[] { 'a', 'b' }, 0);
		Edge edgeTwo = new Edge(2, new char[] { 'b', 'c' }, 0);
		Edge edgeThree = new Edge(3, new char[] { 'b', 'e' }, 0);
		Edge edgeFour = new Edge(5, new char[] { 'a', 'e' }, 0);
		Edge edgeFive = new Edge(2, new char[] { 'd', 'h' }, 0);
		Edge edgeSix = new Edge(8, new char[] { 'h', 'g' }, 0);
		Edge edgeSeven = new Edge(9, new char[] { 'g', 'd' }, 0);
		Edge edgeEight = new Edge(10, new char[] { 'c', 'd' }, 0);
		//Edge edgeNine = new Edge(9, new char[] { 'g', 'd' }, 0);
		//Edge edgeTen = new Edge(9, new char[] { 'g', 'd' }, 0);
		//Edge edgeEleven = new Edge(9, new char[] { 'g', 'd' }, 0);
		//Edge edgeTwelve = new Edge(9, new char[] { 'g', 'd' }, 0);

		spanningTree.add(edgeOne);
		spanningTree.add(edgeTwo);
		spanningTree.add(edgeThree);
		spanningTree.add(edgeFour);
		spanningTree.add(edgeFive);
		spanningTree.add(edgeSix);
		spanningTree.add(edgeSeven);
		spanningTree.add(edgeEight);
		//spanningTree.add(edgeNine);
		//spanningTree.add(edgeTen);
		//spanningTree.add(edgeEleven);
		//spanningTree.add(edgeTwelve);

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

				minTree.add(spanningTree.get(i));

			} else {
				
				if(spanningTree.get(i).ifEdgeConnectsTwoTrees(minTree)){
					
					System.out.print("Krawêdz ³¹czy dwa drzewa   ");
					System.out.println(spanningTree.get(i).getTip());
					
					
					
					//minTree.add(spanningTree.get(i));
				}
				
				// tutaj loopa jest pomijana
				if (spanningTree.get(i).checkForLoops(minTree)) {
					System.out.println("Loop!");
					//dodaæ przypadek po³¹czenia dwóch drzew
				} else {

					System.out.print("Nie ma wspólnych wierzcho³ków dla: ");
					System.out.println(spanningTree.get(i).getTip()[0] + " "
							+ spanningTree.get(i).getTip()[1]);

					spanningTree.get(i).setMembershipFlag(
							membershipFlagCounter++);
					minTree.add(spanningTree.get(i));
					
					
					

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
