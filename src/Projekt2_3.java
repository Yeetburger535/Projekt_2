//M. Stencel 4AZI

public class Projekt2_3 {
    public static void main(String[] args) {
        Wielomian w[] = new Wielomian[3];
        w[0] = new FunkcjaLiniowa(2, 1); // 2x + 1
        w[1] = new FunkcjaKwadratowa(1, -2, 2); // x*x - 2x + 2
        w[2] = new FunkcjaKwadratowa(1, 0, -1); // x*x - 1
        for (int i=0; i<3; i++) {
            w[i].wypiszMiejscaZerowe();
        }
    }
}

interface Wielomian {
    void wypiszMiejscaZerowe();
}

class FunkcjaLiniowa implements Wielomian {
    private double a, b;

    public FunkcjaLiniowa(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        if (a == 0){
            if (b == 0) {
                System.out.print("nieskończenie wiele");
            }
            else {
                System.out.println("brak");
            }
        }
        else {
            double wynik = -b / a;
            System.out.println(formatuj(wynik));
        }
    }

    private String formatuj (double liczba){
        return (liczba % 1 == 0) ? String.valueOf((long) liczba) : String.valueOf(liczba);
    }
}

class FunkcjaKwadratowa implements Wielomian {
    private double a, b, c;

    public FunkcjaKwadratowa(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        if (a == 0){
            new FunkcjaLiniowa(a, b).wypiszMiejscaZerowe();
            return;
        }

        double delta = (b * b) - (4 * a * c);

        if(delta < 0) {
            System.out.println("brak");
        }
        else if (delta == 0) {
            double x0 = -b / 2 * a;
            System.out.println(formatuj(x0));
        }
        else {
            double pierwDelta = Math.sqrt(delta);
            double x1 = (-b - pierwDelta) / (2 * a);
            double x2 = (-b + pierwDelta) / (2 * a);

            if (x1 > x2) {
                double temp = x1;
                x1 = x2;
                x2 = temp;
            }

            System.out.println(formatuj(x1) + " " + formatuj(x2));
        }
    }

    private String formatuj(double liczba){
        return (liczba % 1 == 0) ? String.valueOf((long) liczba) : String.valueOf(liczba);
    }
}