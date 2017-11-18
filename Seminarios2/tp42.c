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
void quicksort(int arr[], int beg, int end, int thread)
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
    if(thread > 1) {
      omp_set_num_threads(thread);
    #pragma omp parallel sections
      {
      #pragma omp section
        quicksort(arr, beg, l, thread/2);
      #pragma omp section
        quicksort(arr, r, end, thread/2);
      }
    }else{
      quicksort(arr, beg, l,1);
      quicksort(arr, r, end,1);
    }
  }
}
void makesort(int i, int numThreads){
    int arr[i];
    int j;
    for(j = 0; j < i; j++) {
        arr[j] = rand();
    }
    quicksort(arr, 0, i-1, numThreads);
}

int main(){
#define REPETICOES 10
  for(int numThreads = 2; numThreads <= 128; numThreads*=2){
    printf("%d\n", numThreads);
    for(int i=5000; i <= 20000; i+=5000){
      double somaTempo=0;
      int v;
        for(v = 0; v < REPETICOES; v++){
            double tempoInicial = omp_get_wtime();
            makesort(i, numThreads);
            double tempoFinal = omp_get_wtime();
            somaTempo = somaTempo + (tempoFinal - tempoInicial);
        }
        somaTempo /= (double)REPETICOES; // média do tempo, em segundos
        printf("%i - %g\n", i, somaTempo);
    }
  }
  return 0;
}



// RESULTADOS APOS EXECUÇÃO:
// ELEMENTOS | TEMPO
// 2 THREADS
// 5000 - 0.00105482
// 10000 - 0.00220747
// 15000 - 0.00352911
// 20000 - 0.00440111
// 4 THREADS
// 5000 - 0.000962313
// 10000 - 0.00216734
// 15000 - 0.00341745
// 20000 - 0.00446199
// 8 THREADS
// 5000 - 0.00114143
// 10000 - 0.00271163
// 15000 - 0.0039636
// 20000 - 0.00520526
// 16 THREADS
// 5000 - 0.00143103
// 10000 - 0.0029867
// 15000 - 0.00427649
// 20000 - 0.00587969
// 32 THREADS
// 5000 - 0.00110953
// 10000 - 0.00313731
// 15000 - 0.00480775
// 20000 - 0.00688976
// 64 THREADS
// 5000 - 0.00178105
// 10000 - 0.00312223
// 15000 - 0.0046397
// 20000 - 0.00631197
// 128 THREADS
// 5000 - 0.00194677
// 10000 - 0.0035074
// 15000 - 0.00487906
// 20000 - 0.00684299


// Após realizar os testes para verificar o tempo de execução quando o número de threads vai reduzindo pela metade
// foi observado grande aperfeiçoamento e bons resultados mesmo quando começamos com 128 threads, que na execução comum
// é algo lento e inutil quando comparado ao uso de poucas threads. A diferença das formas de uso é muito palpavel.

// OS: UBUNTU 17.04
// MEMORY: 3.8 Gib
// PROCESSOR: Intel® Core™ i3-2350M CPU @ 2.30GHz × 4 
// OS TYPE: 64-bit
// DISK: 66,1 GB