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
    FILE *fd;
    
    if ((fp = fopen(nomeFile, "a")) == NULL)
        return -1;
    if ((fd = fopen("dettagliArtisti", "a")) == NULL)
        return -1;

    fclose(fp);
    fclose(fd);

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
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

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

static int inserisciDettagli(Artista artista) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char genereLettura[LEN+1];
    int gruppoLettura;
    int anniLettura;
    int inserito = 0;
    
    if ((fp = fopen("dettagliArtisti", "r")) == NULL) return -1;
    if ((ftmp = fopen("tmp", "w")) == NULL) return -1;
    
    char c = fgetc(fp);
    if (c == EOF) {
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, (int)artista.gruppo,
                artista.anni, artista.genere);

        fclose(fp);
        fclose(ftmp);

        remove("dettagliArtisti");
        rename("tmp", "dettagliArtisti");

        return 1;
    }
    else rewind(fp);

    while (!feof(fp)) {
        if (fscanf(fp, "%s%d%d%s", nomeArtistaLettura, &gruppoLettura,
                   &anniLettura, genereLettura) != 4)
            break;

        // Stesso nome artista
        if (strcmp(artista.nome ,nomeArtistaLettura) == 0) {
            return 0;
        }
        // Il nome dell'artista da aggiungere è più piccolo di quello letto, inserisco quello da aggiungere
        else if (!inserito && strcmp(artista.nome, nomeArtistaLettura) < 0) {
            inserito = 1;
            fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, (int)artista.gruppo,
                    artista.anni, artista.genere);
        }

        // Aggiungo dopo la canzone che ho letto dal file
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", nomeArtistaLettura, (int)gruppoLettura,
                anniLettura, genereLettura);
    }
    
    if (!inserito)
        fprintf(ftmp, "%s\t %d\t %d\t %s\n", artista.nome, (int)artista.gruppo,
                artista.anni, artista.genere);

    fclose(fp);
    fclose(ftmp);

    remove("dettagliArtisti");
    rename("tmp", "dettagliArtisti");
    
    return 1;
}

int inserisciCanzone(char *nomeFile, Canzone canzone) {
    FILE *fp;
    FILE *ftmp;
    char nomeArtistaLettura[LEN+1];
    char nomeCanzoneLettura[LEN+1];
    int inserito = 0;
    
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
        if ((fscanf(fp, "%s%s", nomeArtistaLettura, nomeCanzoneLettura)) != 2)
            break;

        // Stesso nome artista
        if (!inserito && strcmp(canzone.artista.nome ,nomeArtistaLettura) == 0) {
            // Canzone già esistente
            if (strcmp(canzone.titolo, nomeCanzoneLettura) == 0)
                return 0;
            // Canzone da aggiungere più piccola di quella letta, inserisco quella da aggiungere
            else if (strcmp(canzone.titolo, nomeCanzoneLettura) < 0) {
                inserito = 1;
                fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);
            }
        }
        // Il nome dell'artista da aggiungere è più piccolo di quello letto, inserisco quello da aggiungere
        else if (!inserito && strcmp(canzone.artista.nome, nomeArtistaLettura) < 0) {
            inserito = 1;
            fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);
        }

        // Aggiungo dopo la canzone che ho letto dal file
        fprintf(ftmp, "%s\t %s\n", nomeArtistaLettura, nomeCanzoneLettura);
    }
    
    if (!inserito) 
        fprintf(ftmp, "%s\t %s\n", canzone.artista.nome, canzone.titolo);

    fclose(fp);
    fclose(ftmp);

    remove(nomeFile);
    rename("tmp", nomeFile);
    
    if (inserisciDettagli(canzone.artista) < 1)
        printf("\n[Artista non aggiornato]\n");
    else
        printf("\n[Artista aggiunto]\n");
    
    return 1;
}