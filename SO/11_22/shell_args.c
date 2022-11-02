#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

#define BUFSIZE 64
#define NARGS 128

int main(void) {
    pid_t pid;
    char *list[NARGS];
    char buff[BUFSIZE];
    int ch, k;

    do {
        printf("%% ");
        k = 0;

        do {
            list[k] = malloc(BUFSIZE);
            scanf("%s", buff);

            ch = getchar();

            strcpy(list[k++], buff);

            if (ch == '\n') {
                list[k] = NULL;
                break;
            }

        } while (1);

        if (strcmp(list[0], "exit") == 0) {
            for (int i = 0; i < k; i++)
                free(list[i]);
            exit(0);
        }

        pid = fork();

        if (pid < 0)
            exit(-1);
        else if (pid == 0) {
            if (execvp(list[0], list) == -1) {
                printf("Command \'%s\' not found\n", list[0]);
                exit(-1);
            }
        }

        wait(NULL);

        for (int i = 0; i < k; i++)
            free(list[i]);

    } while (1);

    return 0;
}
