
public class TestClass {

    @Test(priority = 3)
    public void SomeMethodTest(){
        System.out.println("Work SomeMethodTest");
    }
    @Test(priority = 5)
    public void SomeMethodTest1(){
        System.out.println("Work SomeMethodTest1");
    }
    @Test(priority = 150)
    public void SomeMethodTest2(){
        System.out.println("Work SomeMethodTest2");
    }
//    @BeforeSuite
//    public void SomeMethodTest5(){
//        System.out.println("Work test BeforeSuite");
//    }
//    @BeforeSuite
//    public void SomeMethodTest55(){
//        System.out.println("Work test BeforeSuite");
//    }
    @AfterSuite
    public void SomeMethodTest6(){
        System.out.println("Work test AfterSuite");
    }
//    @AfterSuite
//    public void SomeMethodTest7(){
//        System.out.println("Work test AfterSuite");
//    }
}
