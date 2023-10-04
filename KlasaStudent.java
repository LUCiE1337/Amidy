import java.util.ArrayList;
import java.util.List;

class Student
{
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;
    private List<Double> oceny = new ArrayList<>();

    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;
        this.oceny.add(ocena);
    }

    public void WyswietlInformacje()
    {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Ocena: " + ocena);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
    }

    public void ZmienKierunek(String nowyKierunek)
    {
        this.kierunek = nowyKierunek;
        WyswietlInformacje();
    }

    public void ZmienOcene(double nowaOcena)
    {
        this.oceny.add(nowaOcena);
        this.ocena = nowaOcena;
        WyswietlInformacje();
    }

    public void ZmienImie(String noweImie)
    {
        this.imie = noweImie;
        WyswietlInformacje();
    }

    public void ZmienNazwisko(String noweNazwisko)
    {
        this.nazwisko = noweNazwisko;
        WyswietlInformacje();
    }

    public boolean SprawdzZaliczenie()
    {
        return ocena >= 3.0;
    }

    public void UstawPlec(char nowaPlec)
    {
        this.plec = nowaPlec;
        WyswietlInformacje();
    }

    public double ObliczSredniaOcen()
    {
        double suma = 0;
        for (double ocena : oceny)
        {
            suma += ocena;
        }
        return oceny.size() > 0 ? suma / oceny.size() : 0.0;
    }

    public static double WyswietlSredniaOcenaKierunku(String kierunek, List<Student> studenci)
    {
        double suma = 0;
        int liczbaStudentow = 0;

        for (Student student : studenci)
        {
            if (student.kierunek.equals(kierunek))
            {
                suma += student.ObliczSredniaOcen();
                liczbaStudentow++;
            }
        }

        return liczbaStudentow > 0 ? suma / liczbaStudentow : 0.0;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        List<Student> studenci = new ArrayList<>();

        // Dodajmy kilku studentów do listy
        studenci.add(new Student("Jan", "Kowalski", 4.5, 'M', "Informatyka"));
        studenci.add(new Student("Anna", "Nowak", 3.0, 'K', "Matematyka"));
        studenci.add(new Student("Marek", "Smith", 2.5, 'M', "Informatyka"));

        // Wyświetl informacje o studentach
        for (Student student : studenci)
        {
            student.WyswietlInformacje();
            System.out.println("Średnia ocena: " + student.ObliczSredniaOcen());
            System.out.println("Zaliczenie: " + student.SprawdzZaliczenie());
            System.out.println();
        }

        // Zmiana kierunku i oceny
        studenci.get(0).ZmienKierunek("Elektronika");
        studenci.get(1).ZmienOcene(4.0);

        // Wyświetl średnią ocenę dla kierunku "Informatyka"
        double sredniaInformatyka = Student.WyswietlSredniaOcenaKierunku("Informatyka", studenci);
        System.out.println("Średnia ocena dla kierunku Informatyka: " + sredniaInformatyka);
    }
}
