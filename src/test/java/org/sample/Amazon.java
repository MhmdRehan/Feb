package org.sample;

import org.junit.Test;

public class Amazon extends BaseClass{

	@Test
	public void atc1() {
		launchBrowser();
		launchUrl("https://www.amazon.in/");

	}
}
