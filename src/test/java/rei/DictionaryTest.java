package rei;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rei.Dictionary;

public class DictionaryTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void ShouldReturnTrueForRealWord() throws IOException {
		String input = "king";
		Dictionary dictionary = new Dictionary();
		//Boolean status = true;
		//assertTrue(status);
		Boolean status = dictionary.isEnglishWord(input);
		
		assertTrue(status);
	}
	
	@Test
	public void ShouldReturnFalseForRealWord() throws IOException {
		String input = "somereallyinvalidword";
		Dictionary dictionary = new Dictionary();
		//Boolean status = true;
		//assertTrue(status);
		Boolean status = dictionary.isEnglishWord(input);
		
		assertTrue(!status);
	}
	
	@Test
	public void notAlphabets() throws IOException {
		String input = "^@*^^%&%&%";
		Dictionary dictionary = new Dictionary();
		Boolean status = dictionary.isEnglishWord(input);
		
		assertTrue(!status);
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
}
