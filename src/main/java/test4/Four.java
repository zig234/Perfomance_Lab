package test4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Four {
    public static void main(String[] msi) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        for (String name : msi) {
            parser(list, name);
            System.out.println(test4(list));
            list.clear();
        }

    }

    public static void parser(ArrayList<Integer> list, String name) throws IOException {
        Scanner scanner = new Scanner(new File(name));
        int i = 0;
        while (scanner.hasNextInt())
            list.add(i++, scanner.nextInt());
    }

    public static int test4(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : list) {
            if (i < min)
                min = i;
            sum += i;
        }
        int res = sum - min * list.size();
        int srz = sum / list.size();
        int i = 0;
        int count = 0;
        while (i < list.size()) {
            if (list.get(i) > srz)
                list.set(i, list.get(i) - 1);
            else if (list.get(i) < srz)
                list.set(i, list.get(i) + 1);
            else {
                i++;
                continue;
            }
            count++;
        }
        return Math.min(res, count);
    }
}
