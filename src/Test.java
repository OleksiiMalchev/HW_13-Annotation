import java.lang.annotation.*;

@Target( ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    public int priority() default 1;
}
