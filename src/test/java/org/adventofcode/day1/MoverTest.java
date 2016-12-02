package org.adventofcode.day1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoverTest {

	private static final String[] INPUTS = { "R4", "R3", "L3", "L2", "L1", "R1", "L1", "R2", "R3", "L5", "L5", "R4",
			"L4", "R2", "R4", "L3", "R3", "L3", "R3", "R4", "R2", "L1", "R2", "L3", "L2", "L1", "R3", "R5", "L1", "L4",
			"R2", "L4", "R3", "R1", "R2", "L5", "R2", "L189", "R5", "L5", "R52", "R3", "L1", "R4", "R5", "R1", "R4",
			"L1", "L3", "R2", "L2", "L3", "R4", "R3", "L2", "L5", "R4", "R5", "L2", "R2", "L1", "L3", "R3", "L4", "R4",
			"R5", "L1", "L1", "R3", "L5", "L2", "R76", "R2", "R2", "L1", "L3", "R189", "L3", "L4", "L1", "L3", "R5",
			"R4", "L1", "R1", "L1", "L1", "R2", "L4", "R2", "L5", "L5", "L5", "R2", "L4", "L5", "R4", "R4", "R5", "L5",
			"R3", "L1", "L3", "L1", "L1", "L3", "L4", "R5", "L3", "R5", "R3", "R3", "L5", "L5", "R3", "R4", "L3", "R3",
			"R1", "R3", "R2", "R2", "L1", "R1", "L3", "L3", "L3", "L1", "R2", "L1", "R4", "R4", "L1", "L1", "R3", "R3",
			"R4", "R1", "L5", "L2", "R2", "R3", "R2", "L3", "R4", "L5", "R1", "R4", "R5", "R4", "L4", "R1", "L3", "R1",
			"R3", "L2", "L3", "R1", "L2", "R3", "L3", "L1", "L3", "R4", "L4", "L5", "R3", "R5", "R4", "R1", "L2", "R3",
			"R5", "L5", "L4", "L1", "L1" };

	private Mover mover;

	@Before
	public void setUp() {
		mover = new Mover();
	}

	@Test
	public void startWithFaceNorthTest() {
		Assert.assertEquals(CardinalEnum.NORTH, mover.getFace());
	}

	@Test
	public void moveFromStarterToLeftWithFaceToWestTest() {
		mover.move("L0");
		Assert.assertEquals(CardinalEnum.WEST, mover.getFace());
	}

	@Test
	public void moveFromStarterToRighttWithFaceToEastTest() {
		mover.move("R0");
		Assert.assertEquals(CardinalEnum.EAST, mover.getFace());
	}

	@Test
	public void moveFromStarterToLeftLeftWithFaceToSouthTest() {
		mover.move("L0", "L0");
		Assert.assertEquals(CardinalEnum.SOUTH, mover.getFace());
	}

	@Test
	public void moveFromStarterToRigthRightWithFaceToSouthTest() {
		mover.move("R0", "R0");
		Assert.assertEquals(CardinalEnum.SOUTH, mover.getFace());
	}

	@Test
	public void moveFromStarterToLeftRightWithFaceToNorthTest() {
		mover.move("L0", "R0");
		Assert.assertEquals(CardinalEnum.NORTH, mover.getFace());
	}

	@Test
	public void moveFromStarterToRightLeftWithFaceToNorthTest() {
		mover.move("R0", "L0");
		Assert.assertEquals(CardinalEnum.NORTH, mover.getFace());
	}

	@Test
	public void measureDistanceWhenStaysStartCoordinate() {
		Assert.assertEquals(0, mover.getDistance(), 0.1f);
	}

	@Test
	public void measureDistanceWhenMoveLeftWithTwo() {
		mover.move("L2");
		Assert.assertEquals(2, mover.getDistance(), 0.1f);
	}

	@Test
	public void measureDistanceWhenMoveLeftWithTwoAndRighWithThree() {
		mover.move("L2", "R3");
		Assert.assertEquals(5, mover.getDistance(), 0.1f);
	}

	@Test
	public void measureDistanceWhenMoveRightWithThreeThreeTimes() {
		mover.move("R2", "R2", "R2");
		Assert.assertEquals(2, mover.getDistance(), 0.1f);
	}

	@Test
	public void measureDistanceWhenMoveMore() {
		mover.move("R5", "L5", "R5", "R3");
		Assert.assertEquals(12, mover.getDistance(), 0.1f);
	}

	@Test
	public void measureDistanceWhenMovesAreRealInputs() {
		mover.move(INPUTS);
		Assert.assertEquals(288, mover.getDistance());
	}
	
	@Test
	public void measureDistanceWhenMovesTwiceAndAreMockInputs() {
		mover.move(true, "R8", "R4", "R4", "R8");
		Assert.assertEquals(4, mover.getDistance());
	}
	
	@Test
	public void measureDistanceWhenMovesTwiceAreRealInputs() {
		mover.move(true, INPUTS);
		Assert.assertEquals(111, mover.getDistance());
	}

}
