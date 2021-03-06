package common;

import java.util.List;

public class Output {

    public static void array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void array(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void list(List<? extends Object> list) {
        list(list, " ");
    }

    public static void list(List<? extends Object> list, String separator) {
        for (Object obj : list) {
            System.out.print(obj + separator);
        }
        System.out.println();
    }

}
