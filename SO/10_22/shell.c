#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void read_string(char *str, size_t buff) {
    int ch, i = 0;

    while ((ch = getchar()) != '\n')
        if (i < buff)
            str[i++] = ch;

    str[i] = '\0';
}

int main(void) {
    pid_t pid;
    char name[50];

    do {
        printf("%% ");
        read_string(name, 50);

        pid = fork();

        if (pid < 0)
            exit(-1);
        else if (pid == 0) {
            if (execlp(name, name, NULL) == -1) {
                printf("Command \'%s\' not found\n", name);
                exit(-1);
            }
        }

        wait(NULL);
    } while (1);

    return 0;
}