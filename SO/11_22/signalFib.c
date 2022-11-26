#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void sig_hdl(int signo) {
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

unsigned fib(unsigned n) {
    if (n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}

int main(void) {
    setbuf(stdout, NULL);

    if (signal(SIGINT, sig_hdl) == SIG_ERR) {
        printf("Errore di sistema: SIGINT\n");
        exit(1);
    }

    for (int i = 0; i <= 40; i++)
        printf("%u ", fib(i));

    putchar('\n');
}
