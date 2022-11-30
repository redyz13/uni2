#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <signal.h>

typedef unsigned(*func_t)(unsigned n);

unsigned fib(unsigned n) {
    if (n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}

unsigned fact(unsigned n) {
    if (n == 0) return 1;

    return fact(n - 1) * n;
}

void printFunc(func_t func, unsigned n) {
    sleep(2);
    for (int i = 0; i < n; i++)
        printf("%u ", func(i));
}

void sig_hdl(int signo) {
    if (signo == SIGINT)
        printf("\nPID processo 1: %d\n", getpid());
}

void sig_hdl2(int signo) {
    char c;

    if (signo == SIGINT) {
        printf("\n\nVuoi continuare l'esecuzione? (s/n): ");
        scanf("%c", &c);
        if (c == 's') {
            putchar('\n');
            return;
        }
        else
            exit(0);
    }
}

int main(void) {
    pid_t pid1, pid2;
    
    signal(SIGINT, SIG_IGN);

    pid1 = fork();

    if (pid1 < 0)
        exit(-1);
    else if (pid1 == 0) {
        if (signal(SIGINT, sig_hdl) == SIG_ERR) {
            printf("Errore di sistema: SIGINT\n");
            exit(1);
        }

        printFunc(fib, 30);
        putchar('\n');
    }
    else {
        pid2 = fork();

        if (pid2 < 0)
            exit(-1);
        else if (pid2 == 0) {
            if (signal(SIGINT, sig_hdl2) == SIG_ERR) {
                printf("Errore di sistema: SIGINT\n");
                exit(1);
            }

            printFunc(fact, 20);
            putchar('\n');
        }
        else {
            wait(NULL);
            wait(NULL);
            printf("\nTerminato il figlio 1 con PID: %d", pid1);
            printf("\nTerminato il figlio 2 con PID: %d\n", pid2);
        }
    }

    return 0;
}