#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <signal.h>

unsigned fib(unsigned n) {
    if (n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}

void sig_hdl(int signo) {
    pid_t pid;

    if (signal(SIGINT, sig_hdl) == SIG_ERR) {
        printf("Errore di sistema: SIGINT\n");
        exit(1);
    }

    pid = fork();

    if (pid < 0)
        exit(-1);
    else if (pid == 0) {
        char c;

        printf("\n\nVuoi uccidere il padre? (s/n): ");
        scanf("%c", &c);

        if (c == 's')
            kill(getppid(), SIGKILL);

        raise(SIGKILL);
    }
}

int main(void) {
    pid_t pid;

    setbuf(stdout, NULL);

    signal(SIGINT, SIG_IGN);

    pid = fork();

    if (pid < 0)
        exit(-1);
    else if (pid == 0) {
        if (signal(SIGINT, sig_hdl) == SIG_ERR) {
            printf("Errore di sistema: SIGINT\n");
            exit(1);
        }

        for (int i = 0; i < 45; i++)
            printf("%u ", fib(i));

        putchar('\n');
    }
    else {
        wait(NULL);
        printf("\nTerminato il figlio con PID: %d\n", pid);
    }

    return 0;
}
