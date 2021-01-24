package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessFrezeitbad.Freizeitbad;

class FreizeitbadTest {

	Freizeitbad f;
	@BeforeEach
	public void setUp() throws Exception {
		this.f = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		this.f = null;
	}
	
	@Test
	void test() {
		assertTrue(() -> this.f.getBeckenlaenge() == 25);
	}
}
