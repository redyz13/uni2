public class Test {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();

        rubrica.aggiungiContatto(new Contatto("Luca", "Luca", "Casillo", "Via Boh", "1112233444", "luca@boh.it"));
        rubrica.aggiungiContatto(new Contatto("Stellina", "Rosa", "Carotenuto", "Via Torre", "6666634961", "mao@boh.it"));
        rubrica.aggiungiContatto(new Contatto("Paolo", "2223344555"));

        System.out.println("Test: ");
        System.out.print(rubrica.ricercaNome("Luca") + " ");
        System.out.print(rubrica.ricercaCognome("Casillo") + " ");
        System.out.print(rubrica.ricercaNomeCognome("Luca", "Casillo") + " ");
        System.out.println(rubrica.ricercaTelefono("1112233444") + "\n");


        rubrica.getContatto(0).aggiungiNumero("6665765863");

        System.out.println("Test: ");
        System.out.print(rubrica.ricercaNome("Paoloo") + " ");
        System.out.print(rubrica.ricercaCognome("Paolo") + " ");
        System.out.print(rubrica.ricercaNomeCognome("Paolo", "Paolo") + " ");
        System.out.println(rubrica.ricercaTelefono("3335795853") + "\n");

        System.out.println("Rubrica: ");
        System.out.println(rubrica + "\n");

        System.out.print("Contatto Luca:");
        System.out.print(rubrica.getContatto(0));
    }
}
