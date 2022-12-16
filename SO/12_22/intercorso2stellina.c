#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

int fib(int n) {
    if (n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}

int fatt(int n) {
    // Correggere lo 0
    if (n == 0) return 1;

    return fatt(n - 1) * n;
}

void sig_handler1(int signo) {
    // Controllo che il segnale sia SIGINT
    if (signo == SIGINT) {
        int j = 0;
        // Stampa della somma dei 4 numeri di fibonacci
        for (int i = 0; i < 4; i++) {
            j += fib(i);
        }
        printf("%d\n", j);
    }
}

void sig_handler2(int signo) {
    if (signo == SIGINT) {
        char c;
        printf("Devo continuare l'esecuzione s/n ?\n");
        scanf("%c", &c);
        if (c == 'n') {
            // Invia un segnale a sé stesso per la terminazione dell'esecuzione
            if ((raise(SIGKILL)) < 0) {
                printf("Errore di raise");
                exit(1);
            }
        }
    }
}

int main(void) {
    pid_t pid1, pid2;
    int value1, value2;
    // Ignoro i Ctrl + C nel padre per non permettere la terminazione dello stesso
    if ((signal(SIGINT,SIG_IGN)) == SIG_ERR) {
        // In caso di SIG_ERR stampo un errore
        printf("Erroe nella signal\n");
        // Esco dal programma con status == 1
        exit(1);   
    }

    pid1 = fork();

    if (pid1 < 0) {
        // Controllo di errore della fork
        printf("Errore nella fork();");
        exit(1);
    }

    // Primo figlio
    if (pid1 == 0) {
        if ((signal(SIGINT, sig_handler1)) == SIG_ERR) {
            printf("Errore nella signal\n");
            exit(1);
        }
        // Stampo i primi 30 numeri di fibonacci
        for (int i = 0; i < 30; i++) {
            printf("%d\n", fib(i));
        }
        exit(0);
    }
    else if (pid1 > 0) {
        pid2 = fork();

        // Controllo la fork
        if (pid2 < 0) {
            printf("Errore nella fork();");
            exit(1);
        }
        // Secondo figlio
        if (pid2 == 0) {
            if (signal(SIGINT, sig_handler2) == SIG_ERR) {
                printf("Errore nella signal\n");
                exit(1);
            }
            for (int i = 0; i < 20; i++) {
                printf("%d\n", fatt(i)); // Scordatino \n
            }
            exit(0);
        }
        else {
            value1 = wait(NULL);
            value2 = wait(NULL);
            // Controllo della wait
            if ((value1 < 0) || value2 < 0) {
                printf("Errore nella wait();");
                exit(1);
            }
            else {
                printf("I figli %d e %d sono terminati", value1, value2);
                exit(0);
            }
        }
    }
} // Scordatina