public class Projekt2_1 {
    public static void main(String[] args) {


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