package org.adventofcode.day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChronalCalibrator {

	public int calibrate(int start, List<String> frequencies) {
		int sum = start;
		for (String frequency : frequencies) {
			sum = add(sum, frequency);
		}
		return sum;
	}

	private int add(int sum, String frequency) {
		return  sum + Integer.parseInt(frequency);
	}

	public int reachTheSameFrequnecyTwice(int start, List<String> frequencies) {
		Set<Integer> partialSum = new HashSet<Integer>();
		partialSum.add(start);
		int sum = start;
		while (true) {
			for (String frequency : frequencies) {
				sum = add(sum, frequency);
				if (partialSum.contains(sum)) {
					return sum;
				} else {
					partialSum.add(sum);
				}
			}
		}
	}

}
