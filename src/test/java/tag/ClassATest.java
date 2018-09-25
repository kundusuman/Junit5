package tag;
//  TAG

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ClassATest
{
    @Test
    @Tag("development")
    @Tag("production")
    void testCaseA(TestInfo testInfo) 
    {
    	System.out.println("testA");
    }

    @Test
    @Tag("development")
    void testCaseB(TestInfo testInfo)
    {
    	System.out.println("testB");
    }

    @Test
    @Tag("production")
    void testCaseC(TestInfo testInfo)
    {
    	System.out.println("testC");
    }
}