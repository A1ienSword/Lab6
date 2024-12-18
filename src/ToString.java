import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD}) // Цель - тип или поле
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
public @interface ToString {
    String value() default "YES"; // Необязательное свойство со значением по умолчанию YES
}