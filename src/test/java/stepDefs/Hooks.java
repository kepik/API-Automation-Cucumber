package stepDefs;

import io.cucumber.java.*;

public class Hooks {
//    @BeforeAll
//    public void setUp() {
//        //System.out.println("before run test");
//    }
//    @AfterAll
//    public void tearDown() {
//        //System.out.println("after run test");
//    }
    @Before
    public void beforeTest() {
        //System.out.println("before test");
    }
    @After
    public void afterTest() {
        //System.out.println("after test");
    }
}
