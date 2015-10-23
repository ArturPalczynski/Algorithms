package KruskalAlgorithm;

import java.util.ArrayList;

public class Kruskal {

	public static void main(String[] args) {
		int membershipFlagCounter = 2;

		ArrayList<Edge> spanningTree = new ArrayList<Edge>();

		// Edge edgeThirteen = new Edge(14, new char[] { 'h', 'e' }, 0);
		// Edge edgeOne = new Edge(1, new char[] { 'a', 'b' }, 0);
		// Edge edgeTwo = new Edge(6, new char[] { 'b', 'c' }, 0);
		// Edge edgeThree = new Edge(8, new char[] { 'a', 'd' }, 0);
		// Edge edgeFour = new Edge(4, new char[] { 'b', 'd' }, 0);
		// Edge edgeFive = new Edge(41, new char[] { 'd', 'e' }, 0);
		// Edge edgeSix = new Edge(28, new char[] { 'a', 'h' }, 0);
		// Edge edgeSeven = new Edge(25, new char[] { 'd', 'h' }, 0);
		// Edge edgeEight = new Edge(5, new char[] { 'c', 'e' }, 0);
		// Edge edgeNine = new Edge(41, new char[] { 'd', 'e' }, 0);
		// Edge edgeTen = new Edge(45, new char[] { 'h', 'g' }, 0);
		// Edge edgeEleven = new Edge(35, new char[] { 'g', 'f' }, 0);
		// Edge edgeTwelve = new Edge(44, new char[] { 'e', 'f' }, 0);
		// Edge edgeThirteen = new Edge(1, new char[] { 'a', 'e' }, 0);

		Edge edgeOne = new Edge(1, new char[] { 'a', 'e' }, 0);
		Edge edgeTwo = new Edge(3, new char[] { 'a', 'f' }, 0);
		Edge edgeThree = new Edge(2, new char[] { 'b', 'c' }, 0);
		Edge edgeFour = new Edge(4, new char[] { 'b', 'e' }, 0);
		Edge edgeFive = new Edge(3, new char[] { 'd', 'e' }, 0);
		Edge edgeSix = new Edge(4, new char[] { 'a', 'b' }, 0);
		Edge edgeSeven = new Edge(6, new char[] { 'f', 'd' }, 0);
		Edge edgeEight = new Edge(7, new char[] { 'e', 'f' }, 0);
		Edge edgeNine = new Edge(8, new char[] { 'c', 'd' }, 0);

		spanningTree.add(edgeOne);
		spanningTree.add(edgeTwo);
		spanningTree.add(edgeThree);
		spanningTree.add(edgeFour);
		spanningTree.add(edgeFive);
		spanningTree.add(edgeSix);
		spanningTree.add(edgeSeven);
		spanningTree.add(edgeEight);
		spanningTree.add(edgeNine);
		// spanningTree.add(edgeTwelve);
		// spanningTree.add(edgeThirteen);

		BubleSorting.sortEdges(spanningTree);

		ArrayList<Edge> minTree = new ArrayList<Edge>();
		minTree.add(edgeOne);
		minTree.get(0).setMembershipFlag(1);

		for (int i = 1; i < spanningTree.size(); i++) {

			spanningTree.get(i).ifEdgeConnectsTwoTrees(minTree);

			if (spanningTree.get(i).oneVertexInCommon(minTree)) {

				System.out.println("One common vertex for: " + i + " "
						+ spanningTree.get(i).getTip()[0] + " "
						+ spanningTree.get(i).getTip()[1]);

				spanningTree.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertex(spanningTree.get(i),
								minTree).getMembershipFlag());

				minTree.add(spanningTree.get(i));

			} else {

				if (spanningTree.get(i).checkForLoops(minTree)) {

				} else {

					System.out.print("No common vertexs for ");
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

		int suma = 0;
		for (Edge e : minTree) {

			suma += e.getWeight();

		}

		System.out.println(suma);

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
