
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TestRunner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        start(TestClass.class);
    }

    public static void start(Class<?> clazz) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Method> methodsInClazzWithAnnotation = new ArrayList<>();
        Constructor<?> constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Method beforeTest = null;
        Method afterTest = null;
        int countBefore = 0;
        int countAfter = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsInClazzWithAnnotation.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeTest = method;
                countBefore++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterTest = method;
                countAfter++;
            }
            if (countBefore  > 1 || countAfter>1) {
                throw new RuntimeException("Methods with @BeforeSuite and @AfterSuite annotations within the " +
                        "same “test class” must occur in a single instance");
            }
        }
        if(countBefore!=0){
            beforeTest.invoke(instance);
        }
        methodsInClazzWithAnnotation.stream().sorted(new AnnotationComparator()).forEach(method -> {
            try {
                method.invoke(instance);
                System.out.println("Test priority: " + method.getAnnotation(Test.class).priority());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        if(countAfter!=0){
            afterTest.invoke(instance);
        }
    }
}
