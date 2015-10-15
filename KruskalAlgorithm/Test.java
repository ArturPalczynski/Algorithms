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
		//Edge edgeFive = new Edge(4, new char[] { 'a', 'e' }, 0);
		
		spanningTree.add(edgeOne);
		spanningTree.add(edgeTwo);
		spanningTree.add(edgeThree);
		spanningTree.add(edgeFour);
		//spanningTree.add(edgeFive);
		
		
		BubleSorting.sortEdges(spanningTree);
		
		ArrayList<Edge> minTree = new ArrayList<Edge>();
		minTree.add(edgeOne);
		minTree.get(0).setMembershipFlag(1);
		
		
		for (int i = 1; i < spanningTree.size(); i++) {

			// sprawdzamy czy aspiruj¹ca krawêdz ma jeden wirzcho³ek wspólny z
			// krawêdzimi w minimalTree

			if (spanningTree.get(i).oneVertexInCommon(minTree)) {

				System.out.println("One common vertex for: "+i+" "+spanningTree.get(i).getTip()[0]+" "+spanningTree.get(i).getTip()[1]);
				
				// ustawiamy flage w nowo dodawanej krawêdzi na tak¹ jaka jest w
				// krawêdzi która ma wspólny wierzcho³ek z t¹ nowo dodawan¹
				// krawêdzi¹
				spanningTree.get(i).setMembershipFlag(
						serchForEdgeWithOneCommonVertexTest(spanningTree.get(i),
								minTree).getMembershipFlag());

				minTree.add(spanningTree.get(i)); 			// po dodani flagi
															// dodajemy krawêdz
															// do minimalnego
															// drzewa

				System.out.println(minTree.size());
				
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
				System.out.println("B³¹d");

			}
		}
		
		for(Edge e:minTree){
			System.out.println(e.getTip()[0]+" "+e.getTip()[1]+" "+e.getMembershipFlag());
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
