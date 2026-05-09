//M. Stencel 4AZI

public class Projekt2_2 {
    public static void main(String[] args){
        Rownanie r1 = new Rownanie();
        r1.Wartosci(2, 5, -6);
        System.out.println("Równanie 1: 2x² + 5x - 6");


        System.out.println("Liczba pierwiastków w równaniu: " + r1.ilePierwiastkow());
        System.out.println("Dla x = 4 y wynosi: " + r1.obliczY(4));
        System.out.println();

        System.out.println("Zmiana parametrów obiektu do innego równania");
        r1.Wartosci(5, -2, 4);
        System.out.println("Równanie: 5x² - 2x + 4");
        System.out.println("Liczba pierwiastków w równaniu: " + r1.ilePierwiastkow());
        System.out.println("Dla x = 2 y wynosi: " + r1.obliczY(2));

    }
}

class Rownanie {
    private double a;
    private double b;
    private double c;

    public Rownanie(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void Wartosci(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double obliczY (double x){
        return (this.a * x * x) + (this.b * x) + this.c;
    }

    public int ilePierwiastkow() {
        double delta = (this.b * this.b) - (4 * this.a * this.c);

        if (delta < 0) return 0;
        else if (delta == 0) return 1;
        else return 2;
    }
}