@ToString(value = "YES") // Аннотация @ToString на классе B
@Cache(value = {"cache1", "cache2"}) // Аннотация @Cache на классе B
public class B extends A {
    String text = "B";
}
