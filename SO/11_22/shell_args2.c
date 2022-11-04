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
    int ch, k;

    for (int i = 0; i < NARGS; i++)
        list[i] = malloc(BUFSIZE);

    do {
        printf("%% ");
        k = 0;

        do {
            scanf("%s", list[k++]);

            ch = getchar();

            if (ch == '\n') {
                free(list[k]);
                list[k] = NULL;
                break;
            }

        } while (1);

        if (strcmp(list[0], "exit") == 0) {
            // for (int i = 0; i < NARGS; i++)
            //     free(list[i]);
            exit(0);
        }

        pid = fork();

        if (pid < 0)
            exit(-1);
        else if (pid == 0) {
            if (execvp(list[0], list) == -1) {
                fprintf(stderr, "Command \'%s\' not found\n", list[0]);
                exit(-1);
            }
        }

        wait(NULL);

        list[k] = malloc(BUFSIZE);

    } while (1);

    return 0;
}
