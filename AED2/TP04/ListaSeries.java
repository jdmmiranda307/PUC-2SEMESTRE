class ListaSeries {
   private Series[] series;
   private int n;
 
 
   /**
    * Construtor da classe.
    */
   public void Lista () {
      this(1000);
   }
 
 
   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public void Lista (int tamanho){
      series = new Series[tamanho];
      n = 0;
   }
 
 
   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Serie s) throws Exception {
 
      //validar insercao
      if(n >= series.length){
         throw new Exception("Erro ao inserir!");
      } 
 
      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         series[i] = series[i-1];
      }
 
      series[0] = x;
      n++;
   }
 
 
   /**
    * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Serie s) throws Exception {
 
      //validar insercao
      if(n >= series.length){
         throw new Exception("Erro ao inserir!");
      }
 
      series[n] = s;
      n++;
   }
 
 
   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Serie s, int pos) throws Exception {
 
      //validar insercao
      if(n >= series.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }
 
      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         series[i] = series[i-1];
      }
 
      series[pos] = s;
      n++;
   }
 
 
   /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public int removerInicio() throws Exception {
 
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
 
      int resp = series[0];
      n--;
 
      for(int i = 0; i < n; i++){
         series[i] = series[i+1];
      }
 
      return resp;
   }
 
 
   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public int removerFim() throws Exception {
 
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
 
      return series[--n];
   }
 
 
   /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public int remover(int pos) throws Exception {
 
      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }
 
      int resp = series[pos];
      n--;
 
      for(int i = pos; i < n; i++){
         series[i] = series[i+1];
      }
 
      return resp;
   }
 
 
   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");
      for(int i = 0; i < n; i++){
         System.out.print(series[i] + " ");
      }
      System.out.println("]");
   }
 
 
   /**
    * Procura um elemento e retorna se ele existe.
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
   public boolean pesquisar(Serie s) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (series[i] == s);
      }
      return retorno;
   }
   public void mostrarRec (){
      System.out.print("[ ");
      mostrarRec(0);
      System.out.println("]");
   }
 
   public void mostrarRec(int i){
      if(i < n){
         System.out.print(series[i] + " ");
         mostrarRec(i + 1);
      }
   }
 
}