package KruskalAlgorithm;

import java.util.ArrayList;

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

		for (int i = 0; i < minimalTreeList.size(); i++) {

			if (toCompareFirstTip == minimalTreeList.get(i).getTip()[0]
					|| toCompareFirstTip == minimalTreeList.get(i).getTip()[1]) {

				firstTipCounter++;

			}
			if (toCompareSecondTip == minimalTreeList.get(i).getTip()[1]
					|| toCompareSecondTip == minimalTreeList.get(i).getTip()[0]) {

				secondTipCounter++;

			}
		}

		if ((firstTipCounter > 0) && (secondTipCounter > 0)) {

			loopExistance = true;
		}

		return loopExistance;
	}

}
