package com.suman;
//testfactory
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
@RunWith(JUnitPlatform.class)
public class TranslationEngineDynamicTest {

  private TranslatorEngine translatorEngine;

  @BeforeEach
  public void setUp() {
    translatorEngine = new TranslatorEngine();
  }

   @TestFactory
  public Collection<DynamicTest> translateDynamicTests() {

    List<String> inPhrases =
        new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
    List<String> outPhrases =
        new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

    Collection<DynamicTest> dynamicTests = new ArrayList<>();

    for (int i = 0; i < inPhrases.size(); i++) {

      String phr = inPhrases.get(i);
      String outPhr = outPhrases.get(i);

      // create an test execution
      Executable exec = () -> assertEquals(outPhr, translatorEngine.tranlate(phr));

      // create a test display name
      String testName = "Test tranlate " + phr;
      // create dynamic test
      DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

      // add the dynamic test to collection
      dynamicTests.add(dTest);
    }
    return dynamicTests;
  }

 
}
