package com.suman;

//assertion

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
//@Disabled
@RunWith(JUnitPlatform.class)
public class StringUtilsTestUnit5
{

  @Test
  public void testConvertToDoubleOK()
  {
    // Test case with the age is a numeric string
    String age = "1990";
    Double expAge = Double.valueOf(age);
    Double actual = StringUtils.convertToDouble(age);



    // Or Java 8 Lambdas style

		    assertAll("Do many assertions.Java 8 Lambdas style", () -> {
		      assertNotNull(actual, () -> "The actual is NULL");
		      assertEquals(expAge, actual,
		          () -> "The expected is: " + expAge + " while the actual is:" + actual);
		    															});

  }

  @Test
  @DisplayName("Test1")
  public void testConvertToDoubleWithNullArgument() 
  {
    String age = null;
    Double actual = StringUtils.convertToDouble(age);
    assertNull(actual, "The actual is not null");
    assertNull(actual, () -> "The actual is not null");
  }



  @Test
  public void testConvertToDoubleThrowException() {
    // Test with the age is a non numeric string
    String age = "hi";
      assertThrows(NumberFormatException.class, () -> {
      StringUtils.convertToDouble(age);
    });

  }

  @Test
  public void testIsNullOrBlankOK() {
    String input = null;
    assertTrue(StringUtils.isNullOrBlank(input));
    assertTrue(StringUtils.isNullOrBlank(input), () -> "The string is not null or blank");
    input = " ";
    assertTrue(StringUtils.isNullOrBlank(input));
    input = "abc";
    assertFalse(StringUtils.isNullOrBlank(input));
  }

  @Test
  public void testGetDefaultIfNull() {
    String st = null;
    String defaultSt = "abc";
    String actual = StringUtils.getDefaultIfNull(st, defaultSt);
    assertSame(defaultSt, actual);
    assertSame(defaultSt, actual, () -> "Expected ouput is not same with actual");
    st = "def";
    actual = StringUtils.getDefaultIfNull(st, defaultSt);
    assertNotSame(defaultSt, actual);
    assertNotSame(defaultSt, actual, () -> "Expected ouput is same with actual");
    st = "";
    actual = StringUtils.getDefaultIfNull(st, defaultSt);
    if (actual.equals(defaultSt)) {
      fail("The actual should be empty");
      fail(() -> "The actual should be empty");
    }

  }

  @Test
  public void testConcatWithRegularInput() {
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
}
