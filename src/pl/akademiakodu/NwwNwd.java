package pl.akademiakodu;

import java.util.Scanner;

public class NwwNwd {


    public static void main(String[] args) {
        int x,y;

        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj pierwsza liczbe: ");
        x = sc.nextInt();

        System.out.print("Podaj druga liczbe: ");
        y = sc.nextInt();

        System.out.println("NWD liczb " + x + " i " + y + " wynosi: " + nwd(x,y));
        System.out.println("NWW liczb " + x + " i " + y + " wynosi: " + nww(x,y));
        System.out.println("NWD inny algorytm: "  + nwdSecondAlgorythm(x,y));
        System.out.println("NWW inny algorytm: "  + nwwSecondAlgorythm(x,y));

    }


    // Obliczamy NWD: algorytm Euklidesa
    public static int nwd(int x, int y) {
        while (x != y) {
            if (x > y)
                x -= y; //skrocony zapis
            else
                y -= x; //skrocony zapis
        }
        return x;
    }

    public static int nww(int a, int b) {
        int nww = Math.abs(a * b) / nwd(a,b);
        return nww;
    }

    public static int nwdSecondAlgorythm(int a, int b)
    {
        int pom;

        while(b!=0)
        {
            pom = b;
            b = a%b;
            a = pom;
        }
        return a;
    }

    public static int nwwSecondAlgorythm(int a, int b)
    {
        int nwwSecondAlgorythm = Math.abs(a * b) / nwdSecondAlgorythm(a,b);
        return nwwSecondAlgorythm;
    }

}
