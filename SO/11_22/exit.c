#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
    pid_t pid;
    int status;

    pid = fork();

    if (pid == 0) {
        printf("Figlio: sto per terminare\n");
        exit(0);
    }
    else if (pid > 0) {
        pid = wait(&status);

        if (WIFEXITED(status))
            printf("Terminazione volontaria di %d con stato %d\n", pid,
                   WEXITSTATUS(status));
        else if (WIFSIGNALED(status))
            printf("Terminazione involontaria per segnale %d\n", WTERMSIG(status));
    }
}
