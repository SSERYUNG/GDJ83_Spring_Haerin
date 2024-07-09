package com.sun.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends DefaultTest {

	@AfterClass
	public static void afterAll() {
		System.out.println("====After All====");
	}

	@BeforeClass
	public static void beforeAll() {
		System.out.println("====Before All====");
	}

	@Before
	public void before() {
		System.out.println("---Before---");
	}

	@After
	public void after() {
		System.out.println("---After---");
	}

	@Test
	public void t1() {

		System.out.println("t1메서드");
		fail("---t1실패---");
	}

	@Test
	public void t2() {

		System.out.println("t2메서드");
		assertEquals(0, 0);
	}

}
