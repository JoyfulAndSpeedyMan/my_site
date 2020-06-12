package utils;

import java.util.List;

public class ListUtil {
    public static void printList(List<?> list){
        for (Object item : list){
            System.out.println(item.toString());
        }
    }
}
