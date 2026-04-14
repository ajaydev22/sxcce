#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int pid;

    printf("\nFork function testing\n");
    printf("Process ID = %d\n", getpid());
    printf("Parent Process ID = %d\n", getppid());

    pid = fork();

    if (pid == -1)
    {
        printf("Error occurred: Process cannot be created\n");
        exit(1);
    }

    if (pid != 0)
    {
        // Parent process
        printf("Parent: My ID = %d\n", getpid());
        printf("My Parent ID = %d\n", getppid());
        exit(0);
    }
    else
    {
        // Child process
        printf("Child: My ID = %d\n", getpid());
        printf("My Parent ID = %d\n", getppid());
        exit(0);
    }

    return 0;
}