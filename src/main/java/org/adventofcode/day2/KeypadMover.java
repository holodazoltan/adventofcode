package org.adventofcode.day2;

import java.util.Map;

public class KeypadMover {

	private int position;
	private Map<Integer, String> keypads;

	public KeypadMover(int position, Map<Integer, String> keypads) {
		this.position = position;
		this.keypads = keypads;
	}

	public String getCode(String directions) {
		StringBuffer code = new StringBuffer();
		String[] splittedDirections = directions.split("");
		for (String splittedDirection : splittedDirections) {
			if ("\n".equals(splittedDirection)) {
				code.append(keypads.get(position));
			} else {
				move(splittedDirection);
			}
		}
		return code.append(keypads.get(position)).toString();
	}

	private void move(String direction) {
		int x = position / 10;
		int y = position % 10;
		int newPosition = 0;
		switch (direction) {
		case "U":
			newPosition = x * 10 + y + 1;
			break;
		case "L":
			newPosition = (x - 1) * 10 + y;
			break;
		case "D":
			newPosition = x * 10 + y - 1;
			break;
		case "R":
			newPosition = (x + 1) * 10 + y;
			break;

		default:
			break;
		}
		if (keypads.get(newPosition) != null) {
			position = newPosition;
		}
	}

}
