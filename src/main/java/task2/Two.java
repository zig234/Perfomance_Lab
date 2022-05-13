package task2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Two {
    public static void main(String[] msi) throws IOException {
        ArrayList<Float> list = new ArrayList<>();
        parser(list, msi[0]);
        float x_cen = list.get(0);
        float y_cen = list.get(1);
        float r = list.get(2);
        int rad = (int) r;
        list.clear();
        parser(list, msi[1]);
        int i = -1;
        while (++i < list.size() - 1)
            circle(x_cen, y_cen, rad, list.get(i), list.get(++i));
    }

    public static void parser(ArrayList<Float> list, String name) throws IOException {
        Scanner scanner = new Scanner(new File(name));
        scanner.useLocale(Locale.US); // Чтобы читались точки как десятичный разделитель
        int i = 0;
        while (scanner.hasNextFloat())
            list.add(i++, scanner.nextFloat());
    }

    public static void circle(float x_cen, float y_cen, int rad, float x, float y) {
        double v = Math.pow((x - x_cen), 2) + Math.pow((y - y_cen), 2);
        if (v == Math.pow(rad, 2))
            System.out.println(0);
        else if (v < Math.pow(rad, 2))
            System.out.println(1);
        else if (v > Math.pow(rad, 2))
            System.out.println(2);
    }
}
