package org.adventofcode.day2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// 3x3 Keypad 
// 1 2 3
// 4 5 6
// 7 8 9

// 5x5 Keypad
//    1
//  2 3 4
//5 6 7 8 9
//  A B C
//    D

public class KeypadMoverTest {

	private static final String INPUT = "RRLLDDRLLDURLDUUDULDLRLDDDRLDULLRDDRDLUUDLLRRDURRLUDUDULLUUDRUURRDDDDURUULLDULRLRRRDLLLRDLRDULDLRUUDRURLULURUUDRLUUDRDURUUDDDRDLLRDLUDRLUUUUUULDURDRDDURLDDRLUUDLRURRDRLDRDLRRRLURULDLUUURDRLUULRDUDLDRRRDDLDDDRLRLLDRDUURDULUURRRRUDLLUDLDRLLRRULLLRDRDRRDRDRDUULUDLULRLLDRULURLURDLLDDRRLUDRDUULLDRULLLRLULUDDLURLUULDRUDRLDUUDDLLLRURDRLDRLUUUUUUDRUDLDLULULRRURRDDDUDRRRDDDLDDLRLLDDUULLUDRURDDDRDDLURRURULULUUDRLLUUDDDRUULRDLDLLRUUDRRLRRRULLRRURUDDUUDULDUDUUUDURUDUUDUDRULUDULRDUDUUUUDLLURDLRRUDURDDUULLDLLRDUDULRLRDURLRDRDLRDLRURUDURLULDDDLDRLULLRLURRLLDLRLLULLDUURUUDRULDDUDLDDR\n"
			+ "LUURULURUURRRDLRDRDDDUDULRDDLUUDUUULRLRRLRUDDLDLURLRULUUDUUDLDRLLUURLUUURDUDLUULLUUDUUDRDUDUDURLLURDUDLDLDDLDUDRLLUULDDRUDDDRLRUDRDUDULLRRDLLDDLRLLLRLRURURLLDULUDDUULULDRRLUURDULRULUDULDULDULRULLLRRDRLDRLDUULLDDULRLUDLLLULDDLULLUULUURRULDLUULDRRUDDDLRDLULDULDRRDLRRRLRUDURUDDDUDDURRRLDUULRDDLRRRLRUULDDURDRDUULDLLULULDRDRUULDLULRUUDUDLUDRLRDURRRRLULURDRLLLUDRRRDRURRLRLLUURDLURLURDULURUDDULLDUUDDLRLUULRDUUDRDRUDRLUUUDURLLRDRRDRURDDDDULLDDUDLDUUDLRLURURLDRRDRDUDLRRDRUDRDLURRLLLULULULRUDDDULULULDDRRLULUUUURDDURURLDLDDDDDRULUUUULLUDDDRRLUULDUULRUUDUURRLLRDDRUURL\n"
			+ "RRRLLLLUULLRRLLDRULULLLRDLLDLDDLURUDLULUULLRURLDULLUDULDRURDURLULLDUDDRLLRUURDLLULUURLULLDLRRDDDULUURRUDRDRDURULDLLURUDLLLDDUDLLLLRLDRDRDDRRDLUUDLLLULLLLLDDRDLULLLLRURRRUUUULLDLRDLDLRRRULRRRRLDLLRDURULDDLURURUULULDRDDDURLRDDRDULLUURUDUUUDRDRRLURULULRLUUDDRDULDRLULULUULRLDRLUDRRDDDRUDDRDDRDDRRLRDLRURDULULRRUUURDRRRDURDDRUDULUUDRDDLDRDDDULDLRDUULDUULRUDLRRDDDLLDDLLLRRDLDUULUULULURRULLRRUDUDRUDRRRLDLRLURRLUDLLLUUDDUDRURUUDDURDURULRLDUDRDLULDUDRUDDDR\n"
			+ "DRDRRUUUUURRLUDLDLRUUULRLDLRRRDDUDLUUDUDDLRDUDLRRLLURUUDULLUDLULLDLLDDULUDDUDUULURLDLDDUUDDRDDRLUURLUUDUDUDURULLDRLDDRUDLURRRLDRLRULDDLDDLDDDULDUDDLLDULUUDUDDUULDRLDRLRURDULUDDRRLRRLRRDULDRRDUDUDRLDURRLRLRDLRLRRLRDDDRULLULULDUDDLDLULRLLURRRRULUULRUDLDLRDLLURURUUURDRRRLDDRLRLURDDURDDUURUUUDDLRUURRRDLLUULUDRLDDRDDDDUUDRLRRDULDULRDLLLRULULLRDRULLRDLRUUURRRURLRRDLDRDDLURLDLULLDUURRDULUUURRLLDDUUUULDDDDLRDDDRDLDLLUURLDDRULUDDRDDDLRDU\n"
			+ "DRRRLURUDUDUULDLLURLUUDDRRRDUDLURLLDRRLLDDURULUDUURURULLRLDLLUURDLLDLLDLDLRUDLLLLDRLLUDLLDULDDRRURDRRLRLRRUURRUDURRLDRDLDURUULUDRLLURLUDURDULLRLLDLURLRRDLLLLUUDRDULLDLURDULDRDURRRLDRLURULULURLLLRRRUULRLRRDRDDDLULRLRRDLUDDUUUUUDRRDLDUDUURLDRRRLRUDRULDRLURUULRDLDDLRURDLURULRRLDURLDUURURULRDUDRRUDUDDLRLUURURULDDLULULULDULRRLRRURUURLRLLDRRLUDLUURDRRURRUUDULRLURRLRLRDDRURDDLRRDUDRLLUUUDULRDRULUURRLRLRDUDULDRDLLUDRDLLDRULDLUUURDDRDDUDDULLLDRRDDUDDDDLDDRLRULRRRURRDRULLDDDURDDLURRDDDUDLURRUDUDLLDDDLRUUDRLRRLRDUUUDDL";

	private KeypadMover keypad;
	private static Map<Integer, String> keypads3x3;
	private static Map<Integer, String> keypads5x5;

	@BeforeClass
	public static void setUpClass() {
		keypads3x3 = new HashMap<>();
		keypads3x3.put(11, "7");
		keypads3x3.put(12, "4");
		keypads3x3.put(13, "1");
		keypads3x3.put(21, "8");
		keypads3x3.put(22, "5");
		keypads3x3.put(23, "2");
		keypads3x3.put(31, "9");
		keypads3x3.put(32, "6");
		keypads3x3.put(33, "3");

		keypads5x5 = new HashMap<>();
		keypads5x5.put(13, "5");
		keypads5x5.put(22, "A");
		keypads5x5.put(23, "6");
		keypads5x5.put(24, "2");
		keypads5x5.put(31, "D");
		keypads5x5.put(32, "B");
		keypads5x5.put(33, "7");
		keypads5x5.put(34, "3");
		keypads5x5.put(35, "1");
		keypads5x5.put(42, "C");
		keypads5x5.put(43, "8");
		keypads5x5.put(44, "4");
		keypads5x5.put(53, "9");
	}

	@Before
	public void setUp() {
		keypad = new KeypadMover(22, keypads3x3);
	}

	@Test
	public void moveUponUpToTwoFromFive() {
		Assert.assertEquals("2", keypad.getCode("UU"));
	}

	@Test
	public void moveUponoLeftToFourFromFive() {
		Assert.assertEquals("4", keypad.getCode("LL"));
	}

	@Test
	public void moveUponDownToEightFromFive() {
		Assert.assertEquals("8", keypad.getCode("DD"));
	}

	@Test
	public void moveUponRightToSixFromFive() {
		Assert.assertEquals("6", keypad.getCode("RR"));
	}

	@Test
	public void stayUponUnknow() {
		Assert.assertEquals("5", keypad.getCode(""));
	}

	@Test
	public void moveUponRightNewLineRight() {
		Assert.assertEquals("66", keypad.getCode("R\nR"));
	}

	@Test
	public void moveUponCodeIs1985() {
		Assert.assertEquals("1985", keypad.getCode("ULL\nRRDDD\nLURDL\nUUUUD"));
	}

	@Test
	public void moveUponInputCodeIs82958() {
		Assert.assertEquals("82958", keypad.getCode(INPUT));
	}

	@Test
	public void moveTestCharsOn5x5Keypad() {
		keypad = new KeypadMover(13, keypads5x5);
		Assert.assertEquals("5DB3", keypad.getCode("ULL\nRRDDD\nLURDL\nUUUUD"));
	}

	@Test
	public void moveInputOn5x5Keypad() {
		keypad = new KeypadMover(13, keypads5x5);
		Assert.assertEquals("B3DB8", keypad.getCode(INPUT));
	}

}