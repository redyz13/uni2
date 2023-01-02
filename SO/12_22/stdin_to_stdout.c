#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define BUFSIZE 8192

int main(void) {
    int n;
    char buf[BUFSIZE];

    while ((n = read(STDIN_FILENO, buf, BUFSIZE)) > 0) {
        if (write(STDOUT_FILENO, buf, n) != n) {
            printf("Write error\n");
            exit(1);
        }
    }
    if (n < 0) {
        printf("Read error\n");
        exit(1);
    }

    return 0;
}