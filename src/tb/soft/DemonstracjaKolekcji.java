package tb.soft;
import java.util.*;

/**
 * Program: Aplikacja działająca w oknie konsoli, która umożliwia testowanie
 *          operacji wykonywanych na kolekcjach
 *    Plik: DemonstracjaKolekcji.java
 *
 *   Autor: Arkadia Kowalczyk
 *    Data: listopad 2021
 */
public class DemonstracjaKolekcji {
    private final BettaPerson ania = new BettaPerson("Ania", "Nowak");
    private final BettaPerson ania2 = new BettaPerson("Ania","Nowak");
    private final BettaPerson aniaS = new BettaPerson("Ania","Nowak");
    private final BettaPerson basia = new BettaPerson("Basia", "Kowal");
    private final BettaPerson cezary = new BettaPerson("Cezary","Cezary");

    private final Person agnieszka = new Person("Agnieszka","Cezary");
    private final Person agnieszka2 = new Person("Agnieszka", "Cezary");
    private final Person agnieszkaS = new Person("Agnieszka", "Cezary");
    private final Person bubbles = new Person("Mrs","Bubbles");
    private final Person calineczka = new Person("Calineczka","Andersen");

    private Person temp = null;

    private final Comparator<Person> comparator = new NFComparator();

    private final Scanner scan = new Scanner(System.in);

    public DemonstracjaKolekcji() throws PersonException {
    }


    public static void main(String[] args) throws PersonException{
        DemonstracjaKolekcji app = new DemonstracjaKolekcji();
        app.sekwencja();
        System.exit(0);
    }
     public void sekwencja() throws PersonException{

        ania.setBirthYear(2000);
        ania2.setBirthYear(2000);
        aniaS.setBirthYear(1980);

        agnieszka.setBirthYear(2002);
        agnieszka2.setBirthYear(2002);
        agnieszkaS.setBirthYear(1999);

        //1. HashSet

        HashSet<Person> z1 = new HashSet<>();
        System.out.println("\nOPERACJE DLA: "+z1.getClass());
        wykonaj(z1);

        //2. TreeSet

         TreeSet<Person> z2 = new TreeSet<Person>();
         System.out.println("\nOPERACJE DLA: "+z2.getClass());
         wykonaj(z2);

        //3. ArrayList

         ArrayList<Person> z3 = new ArrayList<Person>();
         System.out.println("\nOPERACJE DLA: "+z3.getClass());
         wykonaj(z3);
        //4. LinkedList

         LinkedList<Person> z4 = new LinkedList<Person>();
         System.out.println("\nOPERACJE DLA: "+z4.getClass());
         wykonaj(z4);
        //5. HashMap
         HashMap z5 = new HashMap();
         System.out.println("\nOPERACJE DLA: "+z5.getClass());
         wykonaj(z5);
        //6. TreeMap
         TreeMap z6 = new TreeMap();
         System.out.println("\nOPERACJE DLA: "+z6.getClass());
         wykonaj(z6);
         //7. Comparable vs Comparator

         System.out.println("Comparable ania - ania2: "+ ania.compareTo(ania2));
         System.out.println("Comparator ania - ania2: " + comparator.compare(ania,ania2));
try {


    System.out.println("Comparable ania - null: " + ania.compareTo(null));
}catch(Exception e){System.out.println("Comparable ania - null:  nie mozna porownac z nullem");}

         try {

             System.out.println("Comparator ania - null: " + comparator.compare(ania,null));

         }catch(Exception e){System.out.println("Comparator ania - null:  nie mozna porownac z nullem");}


         System.out.println("Comparable ania - agnieszka: "+ ania.compareTo(agnieszka));
         System.out.println("Comparator ania - agnieszka: " + comparator.compare(ania,agnieszka));

         System.out.println("Comparable ania - aniaS: "+ ania.compareTo(aniaS));
         System.out.println("Comparator ania - aniaS: " + comparator.compare(ania,aniaS));
    }

    private void wykonaj(AbstractMap zestaw) {System.out.println("Teraz BEZ equals i hashcode");
        //Dodawanie
        {
            System.out.println("\nDODAWANIE:" +
                    "\n" +
                    "\nDodaje 'agnieszka' po raz pierwszy: ");
            dodajMapa(zestaw, agnieszka);

            System.out.println("\nDodaje 'agnieszka' po raz drugi");
            dodajMapa(zestaw, agnieszka);

            System.out.println("\nDodaje 'agnieszka2'");
            dodajMapa(zestaw, agnieszka2);

            System.out.println("\nDodaje 'agnieszkaS'");
            dodajMapa(zestaw, agnieszkaS);

            System.out.println("\nDodaje 'bubbles'");
            dodajMapa(zestaw, bubbles);

            System.out.println("\nDodaje 'calineczka'");
            dodajMapa(zestaw, calineczka);
        }

        iteracja(zestaw);


        System.out.println("\nUsuwam 'bubbles'");
        akcja(zestaw, bubbles, 2);
        System.out.println("\nUsuwam 'bubbles' raz jeszcze");
        akcja(zestaw, bubbles, 2);
        System.out.println("\nUsuwam 'agnieszka'");
        akcja(zestaw, agnieszka, 2);

        iteracja(zestaw);

        System.out.println("\nUsuwam wszystko");
        zestaw.clear();
        System.out.println(zestaw);


        System.out.println("Teraz Z equals i hashcode");
        przejdzdalej();
        //Dodawanie
        {
            System.out.println("\nDODAWANIE:" +
                    "\n" +
                    "\nDodaje 'ania' po raz pierwszy: ");
            akcja(zestaw, ania, 1);

            System.out.println("\nDodaje 'ania' po raz drugi");
            akcja(zestaw, ania, 1);

            System.out.println("\nDodaje 'ania2'");
            akcja(zestaw, ania2, 1);

            System.out.println("\nDodaje 'aniaS'");
            akcja(zestaw, aniaS, 1);

            System.out.println("\nDodaje 'basia'");
            akcja(zestaw, basia, 1);

            System.out.println("\nDodaje 'cezary'");
            akcja(zestaw, cezary, 1);
        }

        iteracja(zestaw);

        System.out.println("\nUsuwam 'basia'");
        akcja(zestaw, basia, 2);
        System.out.println("\nUsuwam 'basia' raz jeszcze");
        akcja(zestaw, basia, 2);
        System.out.println("\nUsuwam 'ania'");
        akcja(zestaw, ania, 2);

        iteracja(zestaw);

        System.out.println("\nUsuwam wszystko");
        zestaw.clear();
        System.out.println(zestaw);
        przejdzdalej();
    }

    private void iteracja(AbstractMap zestaw) {
        System.out.println("\nIteracja");
        for(int i=0; i<=5 ; i++){
            if(zestaw.get(i)!=null) {
                temp = (Person) zestaw.get(i);
                System.out.println(i + ". " + temp + " " + temp.getBirthYear());
            }
        }
    }

    private void dodajMapa(AbstractMap zestaw, Person kto){
        for(int i=0; (zestaw.putIfAbsent(i,kto))!=null ; i++);
        System.out.println(zestaw);
    }

    private void wykonaj(AbstractCollection<Person> zestaw) {
        System.out.println("Teraz BEZ equals i hashcode");
        //Dodawanie
        {
            System.out.println("\nDODAWANIE:" +
                    "\n" +
                    "\nDodaje 'agnieszka' po raz pierwszy: ");
            akcja(zestaw, agnieszka, 1);

            System.out.println("\nDodaje 'agnieszka' po raz drugi");
            akcja(zestaw, agnieszka, 1);

            System.out.println("\nDodaje 'agnieszka2'");
            akcja(zestaw, agnieszka2, 1);

            System.out.println("\nDodaje 'agnieszkaS'");
            akcja(zestaw, agnieszkaS, 1);

            System.out.println("\nDodaje 'bubbles'");
            akcja(zestaw, bubbles, 1);

            System.out.println("\nDodaje 'calineczka'");
            akcja(zestaw, calineczka, 1);
        }

        iteracja(zestaw);


        System.out.println("\nUsuwam 'bubbles'");
        akcja(zestaw, bubbles, 2);
        System.out.println("\nUsuwam 'bubbles' raz jeszcze");
        akcja(zestaw, bubbles, 2);
        System.out.println("\nUsuwam 'agnieszka'");
        akcja(zestaw, agnieszka, 2);

        iteracja(zestaw);

        System.out.println("\nUsuwam wszystko");
        zestaw.clear();
        System.out.println(zestaw);


        System.out.println("Teraz Z equals i hashcode");
        przejdzdalej();
        //Dodawanie
        {
            System.out.println("\nDODAWANIE:" +
                    "\n" +
                    "\nDodaje 'ania' po raz pierwszy: ");
            akcja(zestaw, ania, 1);

            System.out.println("\nDodaje 'ania' po raz drugi");
            akcja(zestaw, ania, 1);

            System.out.println("\nDodaje 'ania2'");
            akcja(zestaw, ania2, 1);

            System.out.println("\nDodaje 'aniaS'");
            akcja(zestaw, aniaS, 1);

            System.out.println("\nDodaje 'basia'");
            akcja(zestaw, basia, 1);

            System.out.println("\nDodaje 'cezary'");
            akcja(zestaw, cezary, 1);
        }

        iteracja(zestaw);

        System.out.println("\nUsuwam 'basia'");
        akcja(zestaw, basia, 2);
        System.out.println("\nUsuwam 'basia' raz jeszcze");
        akcja(zestaw, basia, 2);
        System.out.println("\nUsuwam 'ania'");
        akcja(zestaw, ania, 2);

        iteracja(zestaw);

        System.out.println("\nUsuwam wszystko");
        zestaw.clear();
        System.out.println(zestaw);
        przejdzdalej();
    }

    private void przejdzdalej()  {
        System.out.println("\nWcisnij dowolny przycisk by przejsc dalej");
        scan.nextLine();

    }

    private void iteracja(AbstractCollection<Person> zestaw) {
        System.out.println("\nITERACJA");
        Iterator<Person> iterator = zestaw.iterator();
        Iterator<Person> rok = zestaw.iterator();
        for (int i = 0; i<zestaw.size(); ) System.out.println(++i + ". "+ iterator.next()+" "+ rok.next().getBirthYear());
    }

    private void akcja(AbstractCollection<Person> zestaw, Person kto, int co) {
        try {
            System.out.println("Przed wykonaniem akcji: "+zestaw);

            switch (co) {
                case 1:
                    if (!(zestaw.add(kto))) System.out.print("To te same osoby - Nie ");
                    System.out.print("Dodaje ");

                    break;
                case 2:
                    zestaw.remove(kto);
                    System.out.print("Usuwam ");

                    break;
            }



        System.out.println(kto);
        System.out.println("Po wykonaniu akcji: "+ zestaw);
        } catch (Exception e){
        System.out.println("OOPS... najprawdopodbniej działasz obiektem klasy Person (a nie BettaPerson)" +
                " na kolekcji która wymaga porządku. ");
    }
    }

    private void akcja(AbstractMap zestaw, Person kto, int co){
        try {
            System.out.println("Przed wykonaniem akcji: "+zestaw);

            switch (co) {
                case 1:
                    for(int i=0; (zestaw.putIfAbsent(i,kto))!=null ; i++);
                    System.out.println("Dodaje ");

                    break;
                case 2:

                    for(int i=0; i<=5 ; i++){
                        if(zestaw.get(i)==kto) zestaw.remove(i);
                    }

                    System.out.print("Usuwam ");

                    break;
            }



            System.out.println(kto);
            System.out.println("Po wykonaniu akcji: "+ zestaw);
        } catch (Exception e){
            System.out.println("OOPS... najprawdopodbniej działasz obiektem klasy Person (a nie BettaPerson)" +
                    " na kolekcji która wymaga porządku. ");
        }
    }
}
