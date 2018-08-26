package points;

/*
import points.PointPosition;
import points.PointChange;
*/

import java.util.Scanner;

public class PointCalling {

    public static final int ADD_X = 0;
    public static final int ADD_Y = 1;
    public static final int MINUS_X = 2;
    public static final int MINUS_Y = 3;

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

        /*
        //Dane probne:
        double x1 = 1.0, y1 = 3.0;
        double x2 = 3.0, y2 = 1.0;
        //double x0 = 1.0, y0 = 1.0;
        //double x0 = 3.0, y0 = 3.0;
        double x0 = 0.0, y0 = 0.0;
        */

        System.out.println("Program POINT z wykorzystaniem JavaBean.");
        changingPointPosition();
        projectionPoint(x1,y1,x2,y2,x0,y0);

    }


    private static void changingPointPosition(){
        PointPosition poz = new PointPosition(20,40);
        PointChange z = new PointChange();

        System.out.println("Punkt przed zmianą (x,y): (" + poz.getX()+";"+poz.getY()+")");
        z.addX(poz);
        z.addY(poz);
        System.out.println("Punkt po zmianie (x+1,y+1): (" + poz.getX()+";"+poz.getY()+")");

        /*
        System.out.println("x= " + poz.getX());
        System.out.println("y= " + poz.getY());
        */
        z.minusX(poz);
        z.minusY(poz);
        /*
        System.out.println("x= " + poz.getX());
        System.out.println("y= " + poz.getY());
        */

        int option = ADD_X;

        switch (option) {
            case ADD_X:
                z.addX(poz);
                break;
            case ADD_Y:
                z.addY(poz);
                break;
            case MINUS_X:
                z.minusX(poz);
                break;
            case MINUS_Y:
                z.minusY(poz);
                break;
        }
        System.out.println("Punkt po zmianie SWITCH: (" + poz.getX() + ";" + poz.getY() + ")");

    }


    private static void projectionPoint (double x1, double y1, double x2, double y2, double x0, double y0){
        PointPosition p1 = new PointPosition(x1, y1);
        PointPosition p2 = new PointPosition(x2, y2);
        PointPosition p0 = new PointPosition(x0, y0);

        double S = 0.0, s = 0.0;
        double xd = 0.0, yd = 0.0;
        double W = 0.0;
        double Wx = 0.0, Wy = 0.0;

        x1 = p1.getX();
        y1 = p1.getY();
        x2 = p2.getX();
        y2 = p2.getY();
        x0 = p0.getX();
        y0 = p0.getY();

        // S - wspolczynnik kierunkowy prostej przechodzacej przez punkty p1 i p2
        S = (p2.getY() - p1.getY())/(p2.getX() - p1.getX());

        // ponizej wzory na wspolrzedne rzutu punktu p0 na prosta przechodzaca przez p1 i p2
        // wzory na wspolrzedne rzutu: xd, yd zostaly wyliczone z ukladu metoda wyznacznikow
        W = -S - 1/S;
        Wx = y1 - S*x1 - y0 - (1/S)*x0;
        Wy = -S*(y0 + (1/S)*x0) - (1/S)*(y1 - S*x1);
        xd = Wx / W;
        yd = Wy / W;

        System.out.println("Wspolrzedne P0 wynosza: (" + p0.getX() + ";" + p0.getY() + ")");
        System.out.println("Wspolrzedne P1 wynosza: (" + p1.getX() + ";" + p1.getY() + ")");
        System.out.println("Wspolrzedne P2 wynosza: (" + p2.getX() + ";" + p2.getY() + ")");

        /*
        //Wielkosci pomocnicze:
        System.out.println("S wynosi: " + S);
        System.out.println("Wyznacznik glowny wynosi: " + W);
        System.out.println("Wyznacznik Wx wynosi: " + Wx);
        System.out.println("Wyznacznik Wy wynosi: " + Wy);
        */

        System.out.println("Wspolrzedne rzutu P0 wynosza: (" + xd + ";" + yd + ")");

    }

}


//zrobic klase PointProjection i przeniesc kod odpowiednio: we wzorach wykorzystac gety i sety