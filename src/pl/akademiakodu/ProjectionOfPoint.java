package pl.akademiakodu;
import java.util.Scanner;

public class ProjectionOfPoint {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj kolejno 6 wspolrzednych odpowiednio dla punktow: ");
        System.out.println("P1=(x1,y1), P2=(x2,y2) i punktu 'rzucanego' P0=(x0,y0). ");
        System.out.println("Podane wspolrzedne oddzielaj ENTERem. ");

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();

        projectionPoint(x1,y1,x2,y2,x0,y0);

    }


    private static void projectionPoint (double x1, double y1, double x2, double y2, double x0, double y0){

        double S = 0.0, s = 0.0;
        double xd = 0.0, yd = 0.0;
        double W = 0.0;
        double Wx = 0.0, Wy = 0.0;

        // S - wspolczynnik kierunkowy prostej przechodzacej przez punkty p1 i p2
        S = (y2 - y1)/(x2 - x1);

        // ponizej wzory na wspolrzedne rzutu punktu p0 na prosta przechodzaca przez p1 i p2
        // wzory na wspolrzedne rzutu: xd, yd zostaly wyliczone z ukladu metoda wyznacznikow
        W = -S - 1/S;
        Wx = y1 - S*x1 - y0 - (1/S)*x0;
        Wy = -S*(y0 + (1/S)*x0) - (1/S)*(y1 - S*x1);
        xd = Wx / W;
        yd = Wy / W;

        System.out.println("Wspolrzedne P0 wynosza: (" + x0 + ";" + y0 + ")");
        System.out.println("Wspolrzedne P1 wynosza: (" + x1 + ";" + y1 + ")");
        System.out.println("Wspolrzedne P2 wynosza: (" + x2 + ";" + y2 + ")");

        System.out.println("Wspolrzedne rzutu P0 wynosza: (" + xd + ";" + yd + ")");

    }

}
