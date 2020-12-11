package src.less15.ref.onlyfalse;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassOnlyTrue {


    public static void main(String[] args) throws Exception {

        setFinalStatic(Boolean.class.getField("FALSE"), true);

        System.out.format("Все у нас всегда будет %s", 2 == 5);
        System.out.println();
        System.out.format("Все у нас всегда будет %s", 5 == 5);
    }

    private static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifierField = Field.class.getDeclaredField("modifiers");
        modifierField.setAccessible(true);
        modifierField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
}
