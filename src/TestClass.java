import java.lang.reflect.Method;

public class TestClass {

    @Test(priority = 3)
    public void SomeMethodTest(){
    }
    @Test(priority = 5)
    public void SomeMethodTest1(){
    }
    @Test(priority = 1)
    public void SomeMethodTest2(){
    }
    @BeforeSuite
    public void SomeMethodTest5(){
    }
    @AfterSuite
    public void SomeMethodTest6(){
    }
}
