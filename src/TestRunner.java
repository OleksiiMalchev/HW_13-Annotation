
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        start(TestClass.class);

    }
    private static void start(Class<?> clazz) throws ClassNotFoundException {
        Method[] methods = clazz.getMethods();
        List<Integer> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            Test annotation = method.getAnnotation(Test.class);
            if (annotation != null) {
                annotatedMethods.add(annotation.priority());
                System.out.println("Works method Test" + annotation.priority());
            }
        }
    }
}
