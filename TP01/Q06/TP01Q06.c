#include <stdio.h>
main()
{
	char in[];
    char line[];
    int numIn = 0;
    do{     
         in[numIn] = MyIO.readLine(); 
    } while((in[numIn++] == ("FIM")) == false);
    numIn--;
    for(int i = 0; i < numIn; i++){
            printf("%s\n", palindromo(in[i]));
    }
}