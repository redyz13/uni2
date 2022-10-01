#include "stdbool.h"

#define LEN 30

typedef struct Artista {
    char nome[LEN+1];
    char genere[LEN+1];
    bool gruppo;
    int anni;
} Artista;

typedef struct Canzone {
    char titolo[LEN+1];
    Artista artista;
} Canzone;

Artista creaArtista(char *nome, char *genere, bool gruppo, int anni);

Canzone creaCanzone(Artista artista, char *titolo);

int caricaFile(char *nomeFile);

int visualizzaCanzoni(char *nomeFile, char *nomeRicerca);

int inserisciCanzone(char *nomeFile, Canzone canzone);

int modificaNome(char *nomeFile, char *nomeVecchio, char *nomeNuovo);

int cancellaArtista(char *nomeFile, char *nomeRimozione);

int query1(char *nomeFile);

int query2(char *nomeFile);