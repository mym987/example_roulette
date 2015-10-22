package roulette.bets;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import roulette.Bet;

public class BetFactory {
	Map<String, Integer> oddMap;
	Map<String, String> descriptionMap;
	String[] bets = "OddEven RedBlack ThreeConsecutive".split(" ");

	public BetFactory() {
		oddMap = new HashMap<>();
		descriptionMap = new HashMap<>();
		oddMap.put("OddEven", 1);
		oddMap.put("RedBlack", 1);
		oddMap.put("ThreeConsecutive", 11);
		descriptionMap.put("RedBlack", "Red Black Bet");
		descriptionMap.put("OddEven", "Odd Even Bet");
		descriptionMap.put("ThreeConsecutive", "3 Consecutive Bet");
	}

	public Bet getBet(int betType) {
		try {
			String name = this.getClass().getPackage().getName() + "." + bets[betType-1];
			Class[] types = { String.class, Integer.TYPE };
			Constructor constructor = Class.forName(name).getDeclaredConstructor(types);
			return (Bet) constructor.newInstance(descriptionMap.get(bets[betType-1]), oddMap.get(bets[betType-1]));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void printAllBets() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < bets.length; k++) {
			System.out.println(String.format("%d) %s", (k + 1), bets[k]));
		}
	}
}
