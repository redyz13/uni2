#include <stdio.h>
#include <string.h>
#include "database.h"

Artista creaArtista(char *nome, char *genere, bool gruppo, int anni) {
    Artista a;

    strcpy(a.nome, nome);
    strcpy(a.genere, genere);
    a.gruppo = gruppo;
    a.anni = anni;

    return a;
}

Canzone creaCanzone(Artista artista, char *titolo) {
    Canzone c;

    c.artista = artista;
    strcpy(c.titolo, titolo);
    
    return c;
}

int caricaFile(char *nomeFile) {
    FILE *fp;
    
    if ((fp = fopen(nomeFile, "a")) == NULL)
        return -1;

    fclose(fp);

    return 1;
}

int visualizzaCanzoni(char *nomeFile, char *nomeRicerca) {
    FILE *fp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int trovate = 0;
    
    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    
    printf("\n[Canzoni dell'artista \"%s\"]\n", nomeRicerca);

    while (!feof(fp)) {
        fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura);

        if (strcmp(nomeRicerca, nomeArtistaLettura) == 0) {
            trovate = 1;
            printf("- %s\n", nomeCanzoneLettura);
        }
    }
    
    fclose(fp);
    
    if (!trovate) return 0;

    putchar('\n');

    return 1;
}

int inserisciCanzone(char *nomeFile, Canzone canzone) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    
    if ((fp = fopen(nomeFile, "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;
    
    // Se devo inserire la prima canzone
    char c = fgetc(fp);
    if (c == EOF) {
        fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);

        fclose(fp);
        fclose(ftmp);

        remove(nomeFile);
        rename("tmp", nomeFile);

        return 1;
    }
    else rewind(fp);

    while (!feof(fp)) {
        fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura);

        if (strcmp(canzone.artista.nome ,nomeArtistaLettura) == 0) {
            // Canzone già esistente
            if (strcmp(canzone.titolo, nomeCanzoneLettura) == 0)
                return 0;
            // Canzone da aggiungere più piccola di quella letta, inserisco quella da aggiungere
            else if (strcmp(canzone.titolo, nomeCanzoneLettura) < 0) {
                fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);
            }

            // Aggiungo dopo la canzone che ho letto dal file
            fprintf(ftmp, "%s\t %s\n", nomeArtistaLettura, nomeCanzoneLettura);
        }
    }

    fclose(fp);
    fclose(ftmp);

    remove(nomeFile);
    rename("tmp", nomeFile);
    
    return 1;
}