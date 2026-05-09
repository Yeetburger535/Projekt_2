//M. Stencel 4AZI

public class Projekt2_1 {
    public static void main(String[] args) {

        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        Rational r3 = new Rational (5,10);

        System.out.println("ułamek r1: " + r1);
        System.out.println("ułamek r2: " + r2);
        System.out.println("ułamek r3 (skrócony): " + r3);
        System.out.println("----");

        System.out.println("Testowanie działań arytmetycznych:");
        System.out.println("Dodawanie 1/2 + 2/3 = " + r1.add(r2));
        System.out.println("Odejmowanie 2/3 - 5/10 = " + r2.sub(r3));
        System.out.println("Mnożenie 2/3 * 5/10 = " + r2.mul(r3));
        System.out.println("Dzielenie 1/2 / 2/3 = " + r1.div(r2));
        System.out.println("----");

        System.out.println("Testowanie porównania:");
        System.out.println("Porównanie 1/2 do 2/3: " + r1.compareTo(r2));
        System.out.println("Porównanie 1/3 do 1/2: " + r2.compareTo(r1));
        System.out.println("Porównanie 5/10 do 1/2: " + r3.compareTo(r1));
        System.out.println("----");

        System.out.println("Próba utworzenia ułamka z zerem w mianowniku:");
            try {
                Rational rErr = new Rational(5, 0);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Złapano błąd: " + e.getMessage());
            }

    }
}


class Rational {
    private final int licznik;
    private final int mianownik;

    public Rational(int licznik, int mianownik) {
        if (mianownik == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerem!");
        }
        //nwd, żeby przechować ułamek w najprostszej postaci, bo po co sie meczyc z ulamkami typu 4/10
        int nwd = nwd(Math.abs(licznik), Math.abs(mianownik));

        int znak = (mianownik < 0) ? -1 : 1;

        this.licznik = znak * licznik / nwd;
        this.mianownik = Math.abs(mianownik) / nwd;
    }

    //metoda do obliczania największego wspólnego dzielnika
    private int nwd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    //dodawanie
    public Rational add(Rational arg) {
        int nowyLicz = (this.licznik * arg.mianownik) + (arg.licznik * this.mianownik);
        int nowyMian = this.mianownik * arg.mianownik;
        return new Rational(nowyLicz, nowyMian);
    }

    //mnożenie
    public Rational mul(Rational arg) {
        int nowyLicz = this.licznik * arg.licznik;
        int nowyMian = this.mianownik * arg.mianownik;
        return new Rational(nowyLicz, nowyMian);
    }

    //odejmowanie
    public Rational sub(Rational arg) {
        int nowyLicz = (this.licznik * arg.mianownik) - (arg.licznik * this.mianownik);
        int nowyMian = this.mianownik * arg.mianownik;
        return new Rational(nowyLicz, nowyMian);
    }

    //dzielenie
    public Rational div(Rational arg) {
        if (arg.mianownik == 0) {
            throw new ArithmeticException("Nie wolno dzielić przez 0");
        }
        int nowyLicz = this.licznik * arg.mianownik;
        int nowyMian = this.mianownik * arg.licznik;
        return new Rational (nowyLicz, nowyMian);
    }

    //równość
    public boolean equals(Rational arg) {
        if (arg == null) return false;
        return (this.licznik * arg.mianownik) == (arg.licznik * this.mianownik);
    }

    //porównanie
    public int compareTo(Rational arg) {
        int lewa = this.licznik * arg.mianownik;
        int prawa = arg.licznik * this.mianownik;

        if (lewa == prawa) return 0;
        else if (lewa < prawa) return -1;
        else return 1;
    }

    public String toString() {
        return licznik + "/" + mianownik;
    }

}