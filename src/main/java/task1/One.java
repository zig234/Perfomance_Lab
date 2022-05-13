package task1;

public class One {
    public static void main(String[] msi) {
        int n = 0;
        int m = 0;
        try {
            n = Integer.parseInt(msi[0].trim());
            m = Integer.parseInt(msi[1].trim());
        } catch (Exception msg) {
            System.out.println(msg.getMessage());
        }
        if (n > 0 && m > 0)
            way(n, m);
    }

    public static void way(int n, int m) {
        int i = 0;
        int c = 0;
        int[] mass = new int[m];
        while (true) {
            if (i == m) {
                i = 0;
                c--;
                System.out.print(mass[i]);
            }
            if (mass[m - 1] == 1)
                break;
            c = c < n ? c + 1 : 1;
            mass[i++] = c;
        }
    }
}
