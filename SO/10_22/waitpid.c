#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
    pid_t pid1, pid2;

    pid1 = fork();
    if (pid1 < 0) exit(-1);

    // Primo figlio
    if (pid1 == 0) {
        printf("[P1] PID: %d\n\n", getpid());

        for (int i = 1; i <= 50; i++)
            printf("%d ", i);

        printf("\n\n");
    }
    // Padre
    else if (pid1 > 0) {
        pid2 = fork();
        if (pid2 < 0) exit(-1);

        // Secondo figlio
        if (pid2 == 0) {
            printf("[P2] PID del padre: %d\n\n", getppid());

            for (int i = 101; i <= 150; i++)
                printf("%d ", i);

            printf("\n\n");
        }
        // Padre
        else if (pid2 > 0) {
            printf("[P] Terminato il processo con pid %d\n", waitpid(pid1, NULL, 0));
            printf("[P] Terminato il processo con pid %d\n", waitpid(pid2, NULL, 0));
        }
    }

    return 0;
}