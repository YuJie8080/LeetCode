package common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Input {

    public static int[] randomArray(int length, int min, int max) {
        int[] r = new int[length];
        for (int i = 0; i < length; i++) {
            r[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return r;
    }

    public static <T> T arrayToTreeNode(Integer[] array, Class<T> clazz) throws Exception {
        if (array == null || array.length == 0) {
            return null;
        }
        Field valField = clazz.getDeclaredField("val");
        valField.setAccessible(true);
        Field leftField = clazz.getDeclaredField("left");
        leftField.setAccessible(true);
        Field rightField = clazz.getDeclaredField("right");
        rightField.setAccessible(true);
        ArrayList<T> nodes = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                nodes.add(i, null);
                continue;
            }
            Constructor<T> constructorMethod = clazz.getDeclaredConstructor();
            constructorMethod.setAccessible(true);
            T node = constructorMethod.newInstance();
            valField.set(node, array[i]);
            nodes.add(i, node);
        }
        for (int i = 0; i < array.length; i++) {
            T node = nodes.get(i);
            if (node == null) {
                continue;
            }
            if (2 * i + 2 < array.length) {
                rightField.set(node, nodes.get(2 * i + 2));
            }
            if (2 * i + 1 < array.length) {
                leftField.set(node, nodes.get(2 * i + 1));
            }
        }
        return nodes.get(0);
    }

}
