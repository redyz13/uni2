#include <stdio.h>
#include <string.h>

int inserisci_canzone(char *nome_file, char *nome_canzone, char *nome_artista);
int visualizza_canzoni(char *nome_file, char *nome_ricerca);
int modifica_nome(char *nome_file, char *nome_vecchio, char *nome_nuovo);
int cancella_artista(char *nome_file, char *nome_rimozione);
void leggi_stringa(char *s, int buff);

int main(void) {
    char nome_ricerca[30];
    char nome_canzone[30];
    char nome_artista[30];
    char nome_nuovo[30];
    char nome_vecchio[30];
    char nome_rimozione[30];
    char nome_file[30];

    printf("Inserisci il nome del file contenente il database di canzoni: ");
    leggi_stringa(nome_file, 30);

    FILE *f;
    if ((f = fopen(nome_file, "a")) == NULL) {
        printf("\nErrore di lettura o creazione file");
        return -1;
    }

    fclose(f);
    printf("\nFile \"%s\" caricato\n\n", nome_file);

    char c;
    int eseguito;

    do {
        printf("0. Esci dal programma\n1. Visualizza canzoni artista\n2. Inserisci canzone\n");
        printf("3. Modifica nome artista\n4. Cancella canzoni artista\n");
        printf("\nSelezione: ");
        scanf("%c", &c);
        getchar();

        switch(c) {
            case '0':
                return 0;

            case '1':
                printf("\nInserire il nome dell'artista di cui cercare le canzoni: ");
                leggi_stringa(nome_ricerca, 30);

                eseguito = visualizza_canzoni(nome_file, nome_ricerca);

                if (eseguito == 0)
                    printf("\nNessuna canzone dell'artista \"%s\" trovata\n\n", nome_ricerca);
                else if (eseguito == -1)
                    printf("\nIl file non può essere aperto\n\n");

                break;

            case '2':
                printf("\nInserire il nome della canzone: ");
                leggi_stringa(nome_canzone, 30);
                printf("Inserire il nome dell'artista: ");
                leggi_stringa(nome_artista, 30);

                eseguito = inserisci_canzone(nome_file, nome_canzone, nome_artista);

                if (eseguito)
                    printf("\nCanzone \"%s\" inserita con successo\n\n", nome_canzone);
                else if (eseguito == -1)
                    printf("\nIl file non può essere aperto\n\n");
                else if (eseguito == 0)
                    printf("\nCanzone già esistente\n\n");

                break;

            case '3':
                printf("\nInserire il nome dell'artista da modificare: ");
                leggi_stringa(nome_vecchio, 30);
                printf("Inserire il nuovo nome dell'artista da modificare: ");
                leggi_stringa(nome_nuovo, 30);

                eseguito = modifica_nome(nome_file, nome_vecchio, nome_nuovo);

                if (eseguito == 1)
                    printf("\nOperazione eseguita\n\n");
                else if (eseguito == 0)
                    printf("\nIl file non può essere aperto\n\n");
                else
                    printf("\nArtista non trovato\n\n");

                break;

            case '4':
                printf("\nInserire il nome dell'artista da rimuovere: ");
                leggi_stringa(nome_rimozione, 30);

                eseguito = cancella_artista(nome_file, nome_rimozione);

                if (eseguito == 1)
                    printf("\nOperazione eseguita\n\n");
                else if (eseguito == 0)
                    printf("\nIl file non può essere aperto\n\n");
                else
                    printf("\nArtista non trovato\n\n");

                break;

            default: printf("\nCarattere non valido\n\n");
        }

    } while (c != 0);

    return 0;
}

int inserisci_canzone(char *nome_file, char *nome_canzone, char *nome_artista) {
    FILE *fp;
    char nome_canzone_lettura[30];
    char nome_artista_lettura[30];

    if ((fp = fopen(nome_file, "r")) == NULL)
        return -1;
    else {
        while (!feof(fp)) {
            fscanf(fp, "%s%s", nome_canzone_lettura, nome_artista_lettura);
            if (strcmp(nome_canzone_lettura, nome_canzone) == 0 && strcmp(nome_artista_lettura, nome_artista) == 0) {
                fclose(fp);
                return 0;
            }
        }

        fclose(fp);

        if ((fp = fopen(nome_file, "a")) == NULL)
            return -1;

        fprintf(fp, "%s\t %s\n", nome_canzone, nome_artista);
        fclose(fp);

        return 1;
    }
}

int visualizza_canzoni(char *nome_file, char *nome_ricerca) {
    char nome_canzone[30];
    char nome_artista[30];
    int trovate = 0;

    FILE *fp;

    if ((fp = fopen(nome_file, "r")) == NULL)
        return -1;
    else {
        printf("\nCanzoni dell'artista \"%s\" trovate:\n", nome_ricerca);
        while (!feof(fp)) {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);
            if (strcmp(nome_ricerca, nome_artista) == 0 && !feof(fp)) {
                trovate = 1;
                printf("- %s\n", nome_canzone);
            }
        }

        if (!trovate)
            return 0;

        fclose(fp);
        putchar('\n');

        return 1;
    }
}

int modifica_nome(char *nome_file, char *nome_vecchio, char *nome_nuovo) {
    char nome_canzone[30];
    char nome_artista[30];
    int trovato = 0;

    FILE *fp;
    FILE *ftmp;

    if ((fp = fopen(nome_file, "r")) == NULL)
        return 0;
    else {
        if ((ftmp = fopen("temp.txt", "w")) == NULL)
            return 0;
        else {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);

            printf("\nCanzoni a cui è stato sostuito l'artista:\n");

            while (!feof(fp)) {
                if (strcmp(nome_vecchio, nome_artista) == 0) {
                    trovato = 1;
                    printf("-- %s\n", nome_canzone);
                    fprintf(ftmp, "%s\t %s\n", nome_canzone, nome_nuovo);
                }
                else
                    fprintf(ftmp, "%s\t %s\n", nome_canzone, nome_artista);

                fscanf(fp, "%s%s", nome_canzone, nome_artista);
            }

            fclose(ftmp);
        }

        fclose(fp);
    }

    remove(nome_file);
    rename("temp.txt", nome_file);

    return trovato ? 1 : -1;
}

int cancella_artista(char *nome_file, char *nome_rimozione) {
    char nome_canzone[30];
    char nome_artista[30];
    int trovato = 0;

    FILE *fp;
    FILE *ftmp;

    if ((fp = fopen(nome_file, "r")) == NULL)
        return 0;
    else {
        if ((ftmp = fopen("temp.txt", "w")) == NULL)
            return 0;
        else {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);

            printf("\nCanzoni cancellate:\n");

            while (!feof(fp)) {
                if (strcmp(nome_rimozione, nome_artista) == 0) {
                    trovato = 1;
                    printf("-- %s\n", nome_canzone);
                    fscanf(fp, "%s%s", nome_canzone, nome_artista);
                }
                else {
                    fprintf(ftmp, "%s\t %s\n", nome_canzone, nome_artista);
                    fscanf(fp, "%s%s", nome_canzone, nome_artista);
                }
            }

            fclose(ftmp);
        }

        fclose(fp);
    }

    remove(nome_file);
    rename("temp.txt",nome_file);

    return trovato ? 1 : -1;
}

void leggi_stringa(char *s, int buff) {
    int ch, i = 0;

    while((ch = getchar()) != '\n')
        if (i < buff)
            s[i++] = ch;

    s[i] = '\0';
}
