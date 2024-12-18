import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Цель - тип
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
public @interface Cache {
    String[] value() default {}; // Необязательное свойство со значением по умолчанию - пустой массив
}