/*
*  Il processo figlio scrive sullo schermo i primi dieci
*  numeri di Fibonacci mentre il padre i primi 10 fattoriali
*/
#include <stdio.h>
#include <unistd.h>

typedef unsigned(*func_t)(unsigned n);

unsigned fib(unsigned n) {
    if (n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}

unsigned fact(unsigned n) {
    if (n == 0) return 1;

    return fact(n - 1) * n;
}

void printFunc(func_t func, unsigned n) {
    for (int i = 0; i < n; i++)
        printf("%u ", func(i));
}

int main(void) {
    pid_t pid = fork();

    if (pid == 0)
        printFunc(fib, 10);
    else if (pid > 0)
        printFunc(fact, 10);
    
    putchar('\n');

    return 0;
}