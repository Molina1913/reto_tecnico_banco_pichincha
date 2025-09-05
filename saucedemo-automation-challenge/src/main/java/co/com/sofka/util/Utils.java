package co.com.sofka.util;

import java.util.List;

public class Utils {
    public static <T> T selectRandomItem(List<T> list) {
        int indexSelected = (int) (Math.random() * list.size());
        return list.get(indexSelected);
    }
}
