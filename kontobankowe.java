class Klient
{
    private String nazwaKlienta;
    private int numerIdKlienta;
    private String adresKlienta;

    public Klient(String nazwaKlienta, int numerIdKlienta, String adresKlienta)
    {
        this.nazwaKlienta = nazwaKlienta;
        this.numerIdKlienta = numerIdKlienta;
        this.adresKlienta = adresKlienta;
    }

    public String getNazwaKlienta()
    {
        return nazwaKlienta;
    }

    public int getNumerIdKlienta()
    {
        return numerIdKlienta;
    }

    public String getAdresKlienta()
    {
        return adresKlienta;
    }

    public void wyswietlInformacje()
    {
        System.out.println("Klient: " + nazwaKlienta);
        System.out.println("Numer ID klienta: " + numerIdKlienta);
        System.out.println("Adres klienta: " + adresKlienta);
    }
}

class KontoBankowe
{
    private String numerKonta;
    private double saldo;
    private Klient wlascicielKonta;

    public KontoBankowe(String numerKonta, double saldo, Klient wlascicielKonta)
    {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlascicielKonta = wlascicielKonta;
    }

    public String getNumerKonta()
    {
        return numerKonta;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public Klient getWlascicielKonta()
    {
        return wlascicielKonta;
    }

    public void wpłac(double kwota)
    {
        if (kwota > 0)
        {
            saldo += kwota;
            System.out.println("Wpłata na konto: " + numerKonta + " Kwota: " + kwota);
        }
        else
        {
            System.out.println("Błąd: Kwota wpłaty musi być większa od zera.");
        }
    }

    public void wypłac(double kwota)
    {
        if (kwota > 0 && kwota <= saldo)
        {
            saldo -= kwota;
            System.out.println("Wypłata z konta: " + numerKonta + " Kwota: " + kwota);
        }
        else
        {
            System.out.println("Błąd: Niepoprawna kwota wypłaty lub brak wystarczających środków na koncie.");
        }
    }

    public void wyswietlInformacje()
    {
        System.out.println("Konto: " + numerKonta);
        System.out.println("Saldo: " + saldo);
        wlascicielKonta.wyswietlInformacje();
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Klient klient1 = new Klient("Jan Kowalski", 1, "ul. Dąbrowskiego 23");
        Klient klient2 = new Klient("Anna Nowak", 2, "ul. Piłsudskiego 2");

        KontoBankowe konto1 = new KontoBankowe("50932137", 1000.0, klient1);
        KontoBankowe konto2 = new KontoBankowe("42029956", 500.0, klient2);

        klient1.wyswietlInformacje();
        System.out.println();
        konto1.wyswietlInformacje();
        System.out.println();

        klient2.wyswietlInformacje();
        System.out.println();
        konto2.wyswietlInformacje();
        System.out.println();

        konto1.wpłac(500.0);
        konto1.wypłac(200.0);
        konto1.wyswietlInformacje();
        System.out.println();

        konto2.wpłac(300.0);
        konto2.wypłac(800.0);
        konto2.wyswietlInformacje();
    }
}