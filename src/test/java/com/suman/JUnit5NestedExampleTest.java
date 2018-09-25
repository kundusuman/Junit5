package com.suman;

// LifeCycle and nested

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("JUnit 5 Nested Example")
@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class JUnit5NestedExampleTest {

	JUnit5NestedExampleTest(){
		System.out.println("constructor");
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all test methods");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("Before each test method");
	}
	@Test
	//@RepeatedTest(5)
	void test() {
		System.out.println("1st test");
	}

	@AfterEach
	void afterEach() {
		System.out.println("After each test method");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After all test methods");
	}

//	@Nested
//	@DisplayName("Tests for the method A")
//	class A {
//
//		@BeforeEach
//		void beforeEach() {
//			System.out.println("Before each test method of the A class");
//		}
//
//		@AfterEach
//		void afterEach() {
//			System.out.println("After each test method of the A class");
//		}
//
//		@Test
//		@DisplayName("Example test for method A")
//		void sampleTestForMethodA() {
//			System.out.println("Example test for method A");
//		}

//		@Nested
//		@DisplayName("Tests for the method A1")
//		class A1 {
//			@Test
//			@DisplayName("Example test for method A1")
//			void sampleTestForMethodA1() {
//				System.out.println("Example test for method A1");
//			}
//		}
//	}
}

