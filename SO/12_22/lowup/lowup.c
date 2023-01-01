#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <fcntl.h>

#define BUFSIZE 1024

int main(int argc, char **argv) {
    int fd1, fd2;

    if (argc <= 2) {
        printf("Utilizzo: %s input_file output_file\n", argv[0]);
        exit(1);
    } 

    fd1 = open(argv[1], O_RDONLY);
    fd2 = open(argv[2], O_WRONLY);

    if (fd1 < 0 || fd2 < 0) {
        write(STDERR_FILENO, "File non trovati\n", 17);
        exit(1);
    }

    char buff[BUFSIZE];
    char c;

    int nbytes = read(fd1, buff, BUFSIZE);

    while (nbytes > 0) {
        for (int i = 0; i < nbytes; i++) {
            if (isupper(buff[i])) {
                c = tolower(buff[i]);
                write(fd2, &c, 1);
            }
            else if (islower(buff[i])) {
                c = toupper(buff[i]);
                write(fd2, &c, 1);
            }
            else
                write(fd2, &buff[i], 1);
        }

        nbytes = read(fd1, buff, BUFSIZE);
    }

    write(STDOUT_FILENO, "Operazione completata\n", 22);

    return 0;
}
