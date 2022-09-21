#include <stdio.h>
#include <string.h>

int inserisci_canzone(char *nome_canzone, char *nome_artista);
int visualizza_canzoni(char *nome_ricerca);
int modifica_nome(char *nome_vecchio, char *nome_nuovo);
int cancella_artista(char *nome_rimozione);
void leggi_stringa(char *s, int buff);

int main(void) {
    while (!feof(stdin)) {
        printf("1. Visualizza canzoni artista\n2. Inserisci canzone\n");
        printf("3. Modifica nome artista\n4. Cancella canzoni artista\n[] Premere EOF per uscire\n");
        printf("\nSelezione: ");
        char c;
        scanf("%c", &c);
        getchar();

        char nome_ricerca[50];
        char nome_canzone[50];
        char nome_artista[50];
        char nome_nuovo[50];
        char nome_vecchio[50];
        char nome_rimozione[50];

        switch(c) {
            case '1':
                printf("\nInserire il nome dell'artista di cui cercare le canzoni: ");
                leggi_stringa(nome_ricerca, 50);

                visualizza_canzoni(nome_ricerca);

                break;

            case '2':
                printf("\nInserire il nome della canzone: ");
                leggi_stringa(nome_canzone, 50);
                printf("Inserire il nome dell'artista: ");
                leggi_stringa(nome_artista, 50);

                if (inserisci_canzone(nome_canzone, nome_artista) == 0)
                    printf("\nCanzone \"%s\" inserita con successo\n\n", nome_canzone);

                break;

            case '3':
                printf("\nInserire il nome dell'artista da modificare: ");
                leggi_stringa(nome_vecchio, 50);
                printf("Inserire il nuovo nome dell'artista da modificare: ");
                leggi_stringa(nome_nuovo, 50);

                if (modifica_nome(nome_vecchio, nome_nuovo) == 0)
                    printf("\nOperazione eseguita\n\n");

                break;

            case '4':
                printf("\nInserire il nuovo nome dell'artista da rimuovere: ");
                leggi_stringa(nome_rimozione, 50);

                if (cancella_artista(nome_rimozione) == 0)
                    printf("\nOperazione eseguita\n\n");

                break;

            default: printf("\nCarattere non valido\n\n");
        }
    }

    return 0;
}

int inserisci_canzone(char *nome_canzone, char *nome_artista) {
    FILE *fp;
    char nome_canzone_lettura[50];
    char nome_artista_lettura[50];

    if ((fp = fopen("archivio.txt", "r")) == NULL) {
        if ((fp = fopen("archivio.txt", "w")) == NULL) {
            printf("\nIl file non può essere né aperto né creato\n\n");
            return -1;
        }

        fprintf(fp, "%s\t %s\n", nome_canzone, nome_artista);
        fclose(fp);
        return 0;
    }
    else {
        while (!feof(fp)) {
            fscanf(fp, "%s%s", nome_canzone_lettura, nome_artista_lettura);
            if (strcmp(nome_canzone_lettura, nome_canzone) == 0 && strcmp(nome_artista_lettura, nome_artista) == 0) {
                fclose(fp);
                printf("\nCanzone già esistente\n\n");
                return -1;
            }
        }

        fclose(fp);

        if ((fp = fopen("archivio.txt", "a")) == NULL) {
            printf("\nIl file non può essere né aperto né creato\n\n");
            return -1;
        }

        fprintf(fp, "%s\t %s\n", nome_canzone, nome_artista);
        fclose(fp);
        return 0;
    }
}

int visualizza_canzoni(char *nome_ricerca) {
    char nome_canzone[50];
    char nome_artista[50];

    FILE *fp;

    if ((fp = fopen("archivio.txt", "r")) == NULL) {
        printf("\nIl file non può essere aperto\n\n");
        return -1;
    }
    else {
        printf("\nCanzoni dell'artista \"%s\":\n", nome_ricerca);
        while (!feof(fp)) {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);
            if (strcmp(nome_ricerca, nome_artista) == 0 && !feof(fp))
                printf("- %s\n", nome_canzone);
        }

        fclose(fp);
        putchar('\n');
        return 0;
    }
}

int modifica_nome(char *nome_vecchio, char *nome_nuovo) {
    char nome_canzone[50];
    char nome_artista[50];

    FILE *fp;
    FILE *ftmp;

    if ((fp = fopen("archivio.txt", "r")) == NULL) {
        printf("\nIl file non può essere aperto\n\n");
        return -1;
    }
    else {
        if ((ftmp = fopen("temp.txt", "w")) == NULL) {
            printf("Il file non può essere creato\n");
            return -1;
        }
        else {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);

            printf("\nCanzoni a cui è stato sostuito l'artista:\n");

            while (!feof(fp)) {

                if (strcmp(nome_vecchio, nome_artista) == 0) {
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

    remove("archivio.txt");
    rename("temp.txt", "archivio.txt");

    return 0;
}

int cancella_artista(char *nome_rimozione) {
    char nome_canzone[50];
    char nome_artista[50];

    FILE *fp;
    FILE *ftmp;

    if ((fp = fopen("archivio.txt", "r")) == NULL) {
        printf("\nIl file non può essere aperto\n\n");
        return -1;
    }
    else {
        if ((ftmp = fopen("temp.txt", "w")) == NULL) {
            printf("Il file non può essere creato\n");
            return -1;
        }
        else {
            fscanf(fp, "%s%s", nome_canzone, nome_artista);

            printf("\nArtista cancellato: %s\n", nome_rimozione);
            printf("Canzoni cancellate:\n");

            while (!feof(fp)) {
                if (strcmp(nome_rimozione, nome_artista) == 0) {
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

    remove("archivio.txt");
    rename("temp.txt", "archivio.txt");

    return 0;
}

void leggi_stringa(char *s, int buff) {
    int ch, i = 0;

    while((ch = getchar()) != '\n')
        if (i < buff)
            s[i++] = ch;

    s[i] = '\0';
}
