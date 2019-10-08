package hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


	@Test
	void argsWithValue() {

		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		String[] args = {"F,D,T","An,I,P"};
		Main.main(args);
		
		String result = "{D=1, T=0, F=0, H=2, X=0}";
		String test = os.toString();
		assertTrue(test.contains(result));
	}
	
	@Test
	void argsWithNoValue() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		String[] args = {"F,D,T", ""};
		Main.main(args);
		
		String result = "{D=0, T=1, F=1, H=0, X=1}";
		String test = os.toString();
		assertTrue(test.contains(result));
	}
	
}
