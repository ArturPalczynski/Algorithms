package KruskalAlgorithm;

import java.util.ArrayList;


public class BubleSorting {
	
	public static ArrayList<Edge> sortEdges(ArrayList<Edge> edgeList){
		
		int size = edgeList.size();
		ArrayList<Edge> outputList = new ArrayList<Edge>();
		
		for(int i=0;i<size;i++){
			
			for(int j=0;j<size-1;j++){
				
				if(edgeList.get(j).getWeight() > edgeList.get(j+1).getWeight()){
					
					Edge tempEdge = edgeList.get(j);
					edgeList.set(j, edgeList.get(j+1));
					edgeList.set(j+1, tempEdge);
					
				}
				
			}
			
		}
		return outputList;
		
	}
	
		
	
}
