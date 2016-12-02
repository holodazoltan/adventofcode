package org.adventofcode.day1;

import java.util.ArrayList;
import java.util.List;

public class Mover {

	private int x, y = 0;
	private CardinalEnum face = CardinalEnum.NORTH;
	private List<Integer> alreadyX = new ArrayList<>();
	private List<Integer> alreadyY = new ArrayList<>();

	public CardinalEnum getFace() {
		return face;
	}

	public int getDistance() {
		return Math.abs(x) + Math.abs(y);
	}

	public void move(String... inputs) {
		move(false, inputs);
	}

	public void move(boolean isStopTwice, String... inputs) {
		for (String input : inputs) {
			measureDirection(input);
			Integer step = Integer.valueOf(input.substring(1, input.length()));
			for (int i = 0; i < step; i++) {
				for (int j = 0; j < alreadyX.size(); j++) {
					Integer pastX = alreadyX.get(j);
					Integer pastY = alreadyY.get(j);
					if (pastX.equals(x) && pastY.equals(y) && isStopTwice) {
						return;
					}
				}
				alreadyY.add(y);
				alreadyX.add(x);
				changesCoordinatedWithOne();
			}
		}
	}

	private void changesCoordinatedWithOne() {
		switch (face) {
		case NORTH:
			y = y + 1;
			break;
		case WEST:
			x = x - 1;
			break;
		case SOUTH:
			y = y - 1;
			break;
		case EAST:
			x = x + 1;
			break;
		default:
			break;
		}
	}

	private void measureDirection(String input) {
		String direction = input.substring(0, 1);
		boolean isLeft = "L".equals(direction);
		switch (face) {
		case NORTH:
			face = (isLeft) ? CardinalEnum.WEST : CardinalEnum.EAST;
			break;
		case WEST:
			face = (isLeft) ? CardinalEnum.SOUTH : CardinalEnum.NORTH;
			break;
		case SOUTH:
			face = (isLeft) ? CardinalEnum.EAST : CardinalEnum.WEST;
			break;
		case EAST:
			face = (isLeft) ? CardinalEnum.NORTH : CardinalEnum.SOUTH;
			break;
		default:
			break;
		}
	}

}