#include <stdio.h>
#include <string.h>
#include <ctype.h>

    //METHOD THAT RECIEVES A CHAR AS PARAM, VERIFY IF THIS CHAR IS A PALINDROME 
    // ITERING BY THE FIRST POSITION AND THE LAST AND INCRESING AND DRECRISING THE POSITIONS TO VERIFY THE WORD.
    //AND RETURNS 0 IF THE CURRENT WORD IS FIM OR ANY OTHER NUMBER IF ITS NOT
int isPalindromo(char str[2000]){
  int i, j;
  int fim = strcmp(str, "FIM");
  if(fim != 0){
    int len = strlen(str); 
    i = 0; 
    j = (len - 1); 

    int palindromo = 1;

    while((i <= j) && (palindromo == 1)) {
      if((str[i]) != (str[j]))
        palindromo = 0;
      else {
        i++;
        j--;
      }
    }

    if(palindromo == 1)
       printf("SIM\n");
    else
       printf("NAO\n");
  }
  return fim;
}

int main() {
  char str[2000];
  int fim = 1;
  do{
    scanf (" %2000[^\n]", str);
    fim = isPalindromo(str);
  }while(fim != 0);
  return 0;
}
