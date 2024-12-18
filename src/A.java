@Default(value = String.class) // Аннотация @Default на классе A
@Two(first = "A Class", second = 1) // Аннотация @Two на классе A
public class A extends Entity {
    String s = "hello"; // Это поле будет включено в вывод

    @ToString(value = "NO") // Это поле не будет включено в вывод
    int x = 42;
}
