package rei;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class SearchWordsTest {

	@Test
	public void shouldTakeUserInput() {
	//	SearchWords sw = new SearchWords();
		String input = "working";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals("working", SearchWords.getInput());
	
	}
	
	
}

