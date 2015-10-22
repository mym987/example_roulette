package roulette.bets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import roulette.Bet;

public class BetFactory {
	List<String> bets = new ArrayList<String>();
	
	public BetFactory() {
		bets.add(0, "OddEven");
		bets.add(1, "RedBlack");
		bets.add(2, "ThreeConsecutive");
	}

	public Bet getBet(int betType) {
		switch (betType) {
		case 1:
			return new OddEven("Odd even", 1);
		case 2:
			return new RedBlack("Red black", 1);
		case 3:
			return new ThreeConsecutive("TreeConsecutive", 11);
		default:
			return null;
		}
	}

	public List<String> getPossibleBets() {
		return Collections.unmodifiableList(bets);
	}

	public void printAllBets() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < bets.size(); k++) {
			System.out.println(String.format("%d) %s", (k + 1), bets.get(k)));
		}
	}
}
