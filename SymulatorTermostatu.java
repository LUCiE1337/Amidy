class Termostat {
    private double aktualnaTemperatura = 20.0;
    private double ustawionaTemperatura = 22.0;
    private boolean ogrzewanieWlaczane = false;
    private boolean chlodzenieWlaczane = false;

    public void wlaczOgrzewanie() {
        ogrzewanieWlaczane = true;
        chlodzenieWlaczane = false;
        System.out.println("Włączono ogrzewanie.");
    }

    public void wlaczChlodzenie() {
        chlodzenieWlaczane = true;
        ogrzewanieWlaczane = false;
        System.out.println("Włączono chłodzenie.");
    }

    public void wylaczOgrzewanie() {
        ogrzewanieWlaczane = false;
        System.out.println("Wyłączono ogrzewanie.");
    }

    public void wylaczChlodzenie() {
        chlodzenieWlaczane = false;
        System.out.println("Wyłączono chłodzenie.");
    }

    public void sprawdzTemperature() {
        if (aktualnaTemperatura < ustawionaTemperatura && !ogrzewanieWlaczane) {
            wlaczOgrzewanie();
        } else if (aktualnaTemperatura > ustawionaTemperatura && !chlodzenieWlaczane) {
            wlaczChlodzenie();
        } else if (aktualnaTemperatura == ustawionaTemperatura) {
            wylaczOgrzewanie();
            wylaczChlodzenie();
        }
    }

    public void zmienTemperature(double nowaTemperatura) {
        ustawionaTemperatura = nowaTemperatura;
        System.out.println("Ustawiona temperatura zmieniona na " + nowaTemperatura + " stopni Celsjusza.");
    }

    public void symulujZmianeTemperatury()
    {
        for (int i = 0; i < 10; i++)                                // Symulacja zmiany temperatury co sekundę
        {
            if (ogrzewanieWlaczane)
            {
                aktualnaTemperatura += 0.5;
            }
            else if (chlodzenieWlaczane)
            {
                aktualnaTemperatura -= 0.5;
            }
            System.out.println("Aktualna temperatura: " + aktualnaTemperatura + " stopni Celsjusza");
            sprawdzTemperature();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
    public class SymulatorTermostatu
    {
        public static void main(String[] args)
        {
            Termostat termostat = new Termostat();
            termostat.symulujZmianeTemperatury();                   // Symulacja zmiany temperatury
            termostat.zmienTemperature(24.0);         //Zmiana ustawionej temperatury
            termostat.symulujZmianeTemperatury();                   // Kolejna symulacja zmiany temperatury
        }
    }