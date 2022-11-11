#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void) {
    pid_t pid1, pid2;

    pid1 = fork();

    if (pid1 < 0) exit(-1);
    else if (pid1 == 0) { // Figlio 1
        printf("Sono P1 e il mio PID è %d\n", getpid());
        for (int i = 1; i <= 5; i++)
            printf("%d\n", i);
        exit(0);
    }
    // Padre
    else if (pid1 > 0) {
        pid2 = fork();

        if (pid2 < 0) exit(-1);
        else if (pid2 == 0) { // Figlio 2
            for (int i = 1; i <= 5; i++)
                printf("%d\n", getppid());
            execl("/bin/ls", "ls", NULL);
        }
        // Padre
        else if (pid2 > 0) {
            printf("Terminato il figlio con PID %d\n", wait(NULL));
            printf("Terminato il figlio con PID %d\n", wait(NULL));
            exit(0);
        }
    }

}