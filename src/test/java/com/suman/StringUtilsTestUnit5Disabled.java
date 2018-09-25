package com.suman;
import static org.hamcrest.CoreMatchers.is;
//assumtion
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
public class StringUtilsTestUnit5Disabled {

  @Test
  public void testConcatWithRegularInput() {
//  assumeTrue(0 == 0);
// assumeFalse(0 == 0);
	//  assumeThat('a',is('b'));
//	  System.out.println("hello from junit");
    String st1 = "Hello";
    String st2 = "World";
    String st3 = "!";
    String expect = st1 + st2 + st3;
    String actual = StringUtils.concat(st1, st2, st3);
    assertEquals(expect, actual);
  }


  @Test
  public void testConcatWithNullInput() {
    String st1 = "Hello";
    String st2 = "World";
    String st3 = null;
    String expect = st1 + st2;
    String actual = StringUtils.concat(st1, st2, st3);
    assertEquals(expect, actual);
  }

  @Test
  public void testConcatWithAllNullInput() {
    String actual = StringUtils.concat();
    assertNull(actual);
  }
    @Test
    public void convertToIntNullParameterTryCatchIdiom() {
      String st = null;
      try {
        StringUtils.convertToInt(st);
        fail("Expected an IllegalArgumentException to be thrown");
      } catch (IllegalArgumentException e) {
        assertEquals("String must be not null or empty", e.getMessage());
      }
    }
  
}
