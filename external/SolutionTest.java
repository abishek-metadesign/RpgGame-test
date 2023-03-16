package uk.co.metadesignsolutions.external;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.co.metadesignsolutions.Solution;
import uk.co.metadesignsolutions.external.testlogger.Position;
import uk.co.metadesignsolutions.external.testlogger.TestPrinter;

class SolutionTest {

    private static TestPrinter testPrinter;
    private static Solution solution;


    @BeforeAll
    public static void setupAll(){
        testPrinter= new TestPrinter();
        solution = new Solution();
    }

    @AfterAll
    public static void tearDownAll(){
        testPrinter=null;
        solution =null;
    }

    @Test
    public  void test1(){
      testPrinter.print(()->{
          String solve = solution.solve("D,T,X,F", "S");
          Assertions.assertEquals("F:1,H:0,D:1,T:1,X:1",solve);
      }, 20,Position.MID);
    }

    @Test
    public  void test2(){
        testPrinter.print(()->{
            String solve = solution.solve("D,T,X,F", "S,H,F");
            Assertions.assertEquals("F:0,H:0,D:0,T:0,X:4",solve);
        }, 20,Position.MID);
    }

    @Test
    public  void test3(){
        testPrinter.print(()->{
            String solve = solution.solve("D,T,X,F", "S,H,F,F");
            Assertions.assertEquals("F:0,H:4,D:0,T:0,X:0",solve);
        }, 20,Position.MID);
    }


    @Test
    public  void test4(){
        testPrinter.print(()->{
            String solve = solution.solve("F,H,D,T,X", "S,H,B,F,F");
            Assertions.assertEquals("F:0,H:3,D:1,T:0,X:1",solve);
        }, 20,Position.MID);
    }



    @Test
    public  void test5(){
        testPrinter.print(()->{
            String solve = solution.solve("F,F,F,F,F,F", "S,B,H");
            Assertions.assertEquals("F:6,H:0,D:0,T:0,X:0",solve);
        }, 20,Position.MID);
    }

    @Test
    public  void test6(){
        testPrinter.print(()->{
            String solve = solution.solve("D,H,D,D,F,T", "S,B,H");
            Assertions.assertEquals("F:1,H:5,D:0,T:0,X:0",solve);
        }, 20,Position.MID);
    }


    @Test
    public  void test7(){
        testPrinter.print(()->{
            String solve = solution.solve("D,H,D,D,F,T,T", "S,S,H");
            Assertions.assertEquals("F:1,H:4,D:0,T:2,X:0",solve);
        }, 20,Position.MID);
    }

    @Test
    public  void test8(){
        testPrinter.print(()->{
            String solve = solution.solve("T,T,T,D,T,T", "S,S,H,S");
            Assertions.assertEquals("F:0,H:0,D:1,T:5,X:0",solve);
        }, 20,Position.MID);
    }

    @Test
    public  void test9(){
        testPrinter.print(()->{
            String solve = solution.solve("T,T,T,D,T,T", "S,S,H,B,F");
            Assertions.assertEquals("F:0,H:0,D:5,T:0,X:1",solve);
        }, 20,Position.MID);
    }


}