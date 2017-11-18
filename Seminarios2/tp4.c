#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>
/*
 Esta "constante simbólica" serve para dar confiabilidade à medição do tempo, já que
os sistemas operacionais têm concorrência entre os processos e o tempo de execução
varia de rodada para rodada.
*/


void swap(int *a, int *b)
{
  int t=*a; *a=*b; *b=t;
}
void quicksort(int arr[], int beg, int end)
{
  if (end > beg + 1)
  {
    int piv = arr[beg], l = beg + 1, r = end;
    while (l < r)
    {
      if (arr[l] <= piv)
        l++;
      else
        swap(&arr[l], &arr[--r]);
    }
    swap(&arr[--l], &arr[beg]);
    quicksort(arr, beg, l);
    quicksort(arr, r, end);
  }
}

void makesort(int i){
    int arr[i];
    int j;
    for(j = 0; j < i; j++) {
        arr[j] = rand();
    }
    quicksort(arr, 0, i-1);
}

int main(){
    #define REPETICOES 100
        for(int numThreads = 2; numThreads <= 128; numThreads*=2){
            printf("%d\n", numThreads);
            omp_set_num_threads(numThreads); // seta o número de threads
      
            for(int i=5000; i <= 20000; i+=5000){
              double somaTempo=0;
              int v;
              #pragma omp parallel private(v)
              #pragma omp for
                for(v = 0; v < REPETICOES; v++){
                    double tempoInicial = omp_get_wtime();
                    makesort(i);
                    double tempoFinal = omp_get_wtime();
                    somaTempo = somaTempo + (tempoFinal - tempoInicial);
                }
                somaTempo /= (double)REPETICOES; // média do tempo, em segundos
                printf("%g\n", somaTempo);
            }
        }
    return 0;
}



// RESULTADOS APOS EXECUÇÃO:
// 2 THREADS
// 0.00138461 -5.000 elementos na array 
// 0.00372492 -10.000 elementos na array 
// 0.00473055 -15.000 elementos na array 
// 0.008692 -20.000 elementos na array 
// 4 THREADS
// 0.00287514 -5.000 elementos na array 
// 0.0056934 -10.000 elementos na array 
// 0.00981087 -15.000 elementos na array 
// 0.0120547 -20.000 elementos na array 
// 8 THREADS
// 0.00599854 -5.000 elementos na array 
// 0.0132222 -10.000 elementos na array 
// 0.0198296 -15.000 elementos na array 
// 0.025833 -20.000 elementos na array 
// 16 THREADS
// 0.0116864 -5.000 elementos na array 
// 0.02481 -10.000 elementos na array 
// 0.0397229 -15.000 elementos na array 
// 0.0525207 -20.000 elementos na array 
// 32 THREADS
// 0.0209677 -5.000 elementos na array 
// 0.0440488 -10.000 elementos na array 
// 0.073164 -15.000 elementos na array 
// 0.101636 -20.000 elementos na array 
// 64 THREADS
// 0.0414572 -5.000 elementos na array 
// 0.084547 -10.000 elementos na array 
// 0.207357 -15.000 elementos na array 
// 0.278153 -20.000 elementos na array 
// 128 THREADS
// 0.12354 -5.000 elementos na array 
// 0.271028 -10.000 elementos na array 
// 0.351682 -15.000 elementos na array 
// 0.557005 -20.000 elementos na array 

// OS: UBUNTU 17.04
// MEMORY: 3.8 Gib
// PROCESSOR: Intel® Core™ i3-2350M CPU @ 2.30GHz × 4 
// OS TYPE: 64-bit
// DISK: 66,1 GB