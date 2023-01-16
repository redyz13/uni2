import java.util.Date;

public abstract class ListaPacchi implements Lista {
    protected int codiceLista;
    protected Date dataCreazione, dataConsegnaRegali;

    @Override
    public abstract void aggiungi(Pacco d);

    @Override
    public abstract void rimuovi(Pacco d);

    public abstract void modifica(Date dataConsegnaRegali);
}
