#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

int fib(int n);
int fact(int n);
void hdl1(int signo);
void hdl2(int signo);

int main(void) {
    pid_t pid1, pid2;

    signal(SIGINT, SIG_IGN);

    pid1 = fork();

    if (pid1 < 0) exit(1);
    // Figlio 1
    else if (pid1 == 0) {
        if (signal(SIGINT, hdl1) == SIG_ERR) {
            printf("Errore SIGINT\n");
            exit(1);
        }
        for (int i = 0; i < 30; i++)
            printf("%d\n", fib(i));
        exit(0);
    }
    // Padre
    else if (pid1 > 0) {
        pid2 = fork();

        if (pid2 < 0) exit(1);
        // Figlio 2
        else if (pid2 == 0) {
            if (signal(SIGINT, hdl2) == SIG_ERR) {
                printf("Errore SIGINT\n");
                exit(1);
            }
            for (int i = 0; i < 20; i++)
                printf("%d\n", fact(i));
            exit(0);
        }
        // Padre
        else if (pid2 > 0) {
            wait(NULL);
            wait(NULL);
            printf("I due figli sono terminati, somma dei pid = %d", pid1 + pid2);
            exit(0);
        }
    }
} // Aggiunta dell'ultima parentesi dimenticata

void hdl1(int signo) {
    if (signo == SIGINT)
        printf("\nDecimo numero di fibonacci = %d\n", fib(10));
}

void hdl2(int signo) {
    if (signo == SIGINT) {
        char c;
        printf("\nVuoi continuare l'esecuzione (s/n): ");
        scanf("%c", &c);

        if (c == 's')
            return;
        else if (c == 'n')
            exit(0);
    }
}

int fib(int n) {
    if (n <= 1) return n;

    return (fib(n - 1) + fib(n - 2));
}

int fact(int n) {
    if (n == 0) return 1;

    return (n * fact(n - 1));
}