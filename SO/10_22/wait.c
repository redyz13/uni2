#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void) {
    pid_t pid1, pid2;
    int status1, status2;

    pid1 = fork();
    
    if (pid1 == 0)
        printf("[P1] Processo con PID: %d; PID del padre: %d\n", getpid(), getppid());
    else if (pid1 > 0) {
        pid2 = fork();

        if (pid2 == 0)
            printf("[P2] Somma del pid del processo con quello del padre: %d\n", getpid() + getppid());
        else if (pid2 > 0) {
            printf("\nTerminato il figlio con PID: %d\n", wait(NULL));
            printf("\nTerminato il figlio con PID: %d\n", wait(NULL));
        }
    }

    return 0;
}