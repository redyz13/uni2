#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void sig_usr(int signo) {
    if (signo == SIGUSR1)
        printf("Ricevuto SIGUSER1\n");
    else if (signo == SIGUSR2)
        printf("Ricevuto SIGUSER2\n");
    else
        printf("Ricevuto SIGINT\n");
}

int main(void) {
    if (signal(SIGUSR1, sig_usr) == SIG_ERR) {
        printf("Errore di sistema: SIGUSR1\n");
        exit(1);
    }
    if (signal(SIGUSR2, sig_usr) == SIG_ERR) {
        printf("Errore di sistema: SIGUSR2\n");
        exit(1);
    }
    if (signal(SIGINT, sig_usr) == SIG_ERR) {
        printf("Errore di sistema: SIGINT\n");
        exit(1);
    }

    while (1) pause();
}
