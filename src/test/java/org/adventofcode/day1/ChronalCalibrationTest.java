package org.adventofcode.day1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChronalCalibrationTest {

	private ChronalCalibrator calibrator = new ChronalCalibrator();

	@Test
	void calibrateWithFrequencyZeroValue() throws Exception {
		Assertions.assertEquals(0, calibrator.calibrate(0, Arrays.asList("0")));
	}

	@Test
	void calibrateWithFrequencyPlusOneValue() throws Exception {
		Assertions.assertEquals(1, calibrator.calibrate(0, Arrays.asList("+1")));
	}

	@Test
	void calibrateWithFrequencyMinusTwoValue() throws Exception {
		Assertions.assertEquals(-2, calibrator.calibrate(0, Arrays.asList("-2")));
	}

	@Test
	void calibrateWithFrequencyMultipleValues1231() throws Exception {
		Assertions.assertEquals(3, calibrator.calibrate(0, Arrays.asList("+1", "-2", "+3", "+1")));
	}

	@Test
	void calibrateWithFrequencyMultipleValues111() throws Exception {
		Assertions.assertEquals(3, calibrator.calibrate(0, Arrays.asList("+1", "+1", "+1")));
	}

	@Test
	void calibrateWithFrequencyMultipleValues112() throws Exception {
		Assertions.assertEquals(0, calibrator.calibrate(0, Arrays.asList("+1", "+1", "-2")));
	}

	@Test
	void calibrateWithFrequencyMultipleValues123() throws Exception {
		Assertions.assertEquals(-6, calibrator.calibrate(0, Arrays.asList("-1", "-2", "-3")));
	}

	@Test
	void testInput() throws Exception {
		Path path = Paths.get(getClass().getClassLoader().getResource("org/adventofcode/day1/input.txt").toURI());
		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		List<String> frequency = lines.collect(Collectors.toList());
		lines.close();

		Assertions.assertEquals(592, calibrator.calibrate(0, frequency));
	}
	
	@Test
	void reachTheSameFrequencyTwice11() throws Exception {
		Assertions.assertEquals(0, calibrator.reachTheSameFrequnecyTwice(0, Arrays.asList("-1", "+1")));
	}
	
	@Test
	void reachTheSameFrequencyTwice33424() throws Exception {
		Assertions.assertEquals(10, calibrator.reachTheSameFrequnecyTwice(0, Arrays.asList("+3", "+3", "+4", "-2", "-4")));
	}
	
	@Test
	void reachTheSameFrequencyTwice63856() throws Exception {
		Assertions.assertEquals(5, calibrator.reachTheSameFrequnecyTwice(0, Arrays.asList("-6", "+3", "+8", "+5", "-6")));
	}
	
	@Test
	void reachTheSameFrequencyTwice77274() throws Exception {
		Assertions.assertEquals(14, calibrator.reachTheSameFrequnecyTwice(0, Arrays.asList("+7", "+7", "-2", "-7", "-4")));
	}
	
	@Test
	void reachTheSameFrequencyTwiceWithInput() throws Exception {
		Path path = Paths.get(getClass().getClassLoader().getResource("org/adventofcode/day1/input.txt").toURI());
		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		List<String> frequency = lines.collect(Collectors.toList());
		lines.close();

		Assertions.assertEquals(241, calibrator.reachTheSameFrequnecyTwice(0, frequency));
	}
}
