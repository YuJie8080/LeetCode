package common;

public class RandomInput {

    public static int[] array(int length, int min, int max) {
        int[] r = new int[length];
        for (int i = 0; i < length; i++) {
            r[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return r;
    }

}
