#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    int pid;

    pid = fork();

    if (pid == -1)
    {
        printf("\nError\n");
        exit(1);
    }
    else if (pid == 0)
    {
        // Child process
        printf("Child process\n");
        execlp("/bin/ls", "ls", NULL);

        // If execlp fails
        perror("execlp failed");
        exit(1);
    }
    else
    {
        // Parent process
        printf("\nParent Process\n");
        wait(NULL);   // Correct usage
        printf("Child complete\n");
        exit(0);
    }

    return 0;
}