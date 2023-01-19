package interfacce;

import eccezioni.MotoreException;

// 3 punti per interfaccia ed eccezioni
public interface Auto {
    void Accendi(Auto a) throws MotoreException;
}