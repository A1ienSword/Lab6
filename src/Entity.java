import java.lang.reflect.Field;

@Validate(value = {A.class, B.class})
public abstract class Entity {
    @Invoke
    public void display() {
        System.out.println("Displaying entity information.");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append("{");

        Field[] fields = getAllFields(getClass());
        boolean hasVisibleFields = false;

        for (Field field : fields) {
            ToString toStringAnnotation = field.getAnnotation(ToString.class);
            if (toStringAnnotation != null && toStringAnnotation.value().equals("NO")) {
                continue;
            }
            if (toStringAnnotation == null || toStringAnnotation.value().equals("YES")) {
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if (value != null) {
                        if (hasVisibleFields) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(field.getName()).append("=").append(value);
                        hasVisibleFields = true;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        stringBuilder.append("}");
        return hasVisibleFields ? stringBuilder.toString() : getClass().getSimpleName() + "{}";
    }

    private Field[] getAllFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        if (clazz.getSuperclass() != null) {
            Field[] superFields = getAllFields(clazz.getSuperclass());
            Field[] combined = new Field[fields.length + superFields.length];
            System.arraycopy(superFields, 0, combined, 0, superFields.length);
            System.arraycopy(fields, 0, combined, superFields.length, fields.length);
            return combined;
        }
        return fields;
    }
}
