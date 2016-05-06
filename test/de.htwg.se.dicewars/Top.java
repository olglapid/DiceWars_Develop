package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.TUI;

public class Top {

	@Test
	public final void testBot() {
		String value="";
		String value1="";
		int ctr = 10;
		value=TUI.top(ctr);
		
		for(int i=0;i<ctr;i++){
			value1+=" / \\ ";
		}
		value1+="/\n";
		assertEquals(value1, value);
	}

}
