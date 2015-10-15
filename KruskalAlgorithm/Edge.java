package KruskalAlgorithm;

import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;

public class Edge {

	private int weight;
	private char[] tip = new char[2];
	private int membershipFlag = 0;

	public int getMembershipFlag() {
		return membershipFlag;
	}

	public void setMembershipFlag(int membershipFlag) {
		this.membershipFlag = membershipFlag;
	}

	public Edge() {

	}

	public Edge(int weight, char[] tips, int flag) {

		this.weight = weight;
		this.tip = tips;
		this.membershipFlag = flag;

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public char[] getTip() {
		return tip;
	}

	public void setTip(char[] tip) {
		this.tip = tip;
	}

	public boolean checkForLoops(ArrayList<Edge> minimalTreeList) {

		boolean loopExistance = false;

		int firstTipCounter = 0;
		int secondTipCounter = 0;

		char toCompareFirstTip = this.getTip()[0];
		char toCompareSecondTip = this.getTip()[1];

		int flagOneInMinimalTree = 0;
		int flagsTwoInMinimalTree = 0;

		for (int i = 0; i < minimalTreeList.size(); i++) {

			if (toCompareFirstTip == minimalTreeList.get(i).getTip()[0]
					|| toCompareFirstTip == minimalTreeList.get(i).getTip()[1]) {

				firstTipCounter++;
				flagOneInMinimalTree = minimalTreeList.get(i)
						.getMembershipFlag();
				break;

			}
			if (toCompareSecondTip == minimalTreeList.get(i).getTip()[1]
					|| toCompareSecondTip == minimalTreeList.get(i).getTip()[0]) {

				secondTipCounter++;
				flagsTwoInMinimalTree = minimalTreeList.get(i)
						.getMembershipFlag();
				break;
			}

		}

		if (((firstTipCounter > 0) && (secondTipCounter > 0))) {

			if (flagOneInMinimalTree == flagOneInMinimalTree) {
				loopExistance = true;
			} else {
				loopExistance = false; // sytuacja kiedy krawêdz nale¿y do
										// ró¿nych drzew

			}
		}

		return loopExistance;

	}

	public boolean dontHaveCommonVertex(Edge edge) {

		boolean dontHaveCommonVertex = false;

		if (this.getTip()[0] == edge.getTip()[0]
				|| this.getTip()[0] == edge.getTip()[1]
				|| this.getTip()[1] == edge.getTip()[0]
				|| this.getTip()[1] == edge.getTip()[1]) {

		} else {
			dontHaveCommonVertex = true;
		}

		return dontHaveCommonVertex;

	}

	public boolean oneVertexInCommon(ArrayList<Edge> minimalTree) {

		int firstVertexOccurrence = 0;
		int secondVertexOccurrence = 0;

		boolean oneCommonVertex = false;

		for (int i = 0; i < minimalTree.size(); i++) {

			if (this.getTip()[0] == minimalTree.get(i).getTip()[0]
					|| this.getTip()[0] == minimalTree.get(i).getTip()[1]) {

				firstVertexOccurrence++;

			}
			if (this.getTip()[1] == minimalTree.get(i).getTip()[0]
					|| this.getTip()[1] == minimalTree.get(i).getTip()[1]) {
				
				secondVertexOccurrence++;
			}

		}

		if (firstVertexOccurrence > 0 && secondVertexOccurrence>0 ) {

			oneCommonVertex = false; //loop!

		}else{
			
			if((firstVertexOccurrence>0 && secondVertexOccurrence==0) || (firstVertexOccurrence==0 && secondVertexOccurrence>0) ){
				
				oneCommonVertex = true;
				
			}
		}

		return oneCommonVertex;
	}
}
