import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TP04Q02{
	public static void main(String args[]){
		MyIO.setCharset("UTF-8");
	    String[] in  = new String[1000];
		ListaSeries lista = new ListaSeries();
		
	    int numIn = 0;
	    do{     
	        in[numIn] = MyIO.readLine(); 
	    } while(in[numIn++].equals("FIM") == false);
	    numIn--;
	    for(int i = 0; i < numIn; i++){
	    	Serie s = new Serie();
	    	s.ler(in[i]);
	    	try{
				lista.inserir(s, i);
			} catch(Exception e){
				System.err.print("Erro na execucao");
			}
	    }
		int limit = Integer.parseInt(MyIO.readLine());
		
		for(int i = 0; i < limit; i++){
			Serie s = new Serie();
			int pos;
			String line = MyIO.readLine();

			if(line.contains("II")){
				s.ler(line.substring(3));
				try{
					lista.inserirInicio(s);
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			else if(line.contains("IF")){
				s.ler(line.substring(3));
				try{
					lista.inserirFim(s);
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			else if(line.contains("I*")){
				pos =  Integer.parseInt((line.substring(3,5)));
				s.ler(line.substring(6));
				try{
					lista.inserir(s, pos);
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			else if(line.contains("RI")){
				try{
					Serie se = lista.removerInicio();
					MyIO.println("(R) " + se.getNome());
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			else if(line.contains("RF")){
				try{
					Serie se = lista.removerFim();
					MyIO.println("(R) " + se.getNome());
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			else if(line.contains("R*")){
				pos =  Integer.parseInt((line.substring(3,5)));
				try{
					Serie se = lista.remover(pos);
					MyIO.println("(R) " + se.getNome());
				} catch(Exception e){
					System.err.print("Erro na execucao");
				}
			}
			
		}
		lista.mostrar();
	}
}

class Serie{
	private String nome, formato, duracao, pais_origem, idioma_original, emissora_original, transmissao_original;
	private int num_temporadas, num_episodios;
	
	// Sets e gets das variaveis
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
    	return this.nome;
	}

	public void setFormato(String formato){
		this.formato = formato;
	}
	public String getFormato(){
    	return this.formato;
	}

	public void setDuracao(String duracao){
		this.duracao = duracao;
	}
	public String getDuracao(){
    	return this.duracao;
	}

	public void setPaisOrigem(String pais_origem){
		this.pais_origem = pais_origem;
	}
	public String getPaisOrigem(){
    	return this.pais_origem;
	}

	public void setIdiomaOriginal(String idioma_original){
		this.idioma_original = idioma_original;
	}
	public String getIdiomaOriginal(){
    	return this.idioma_original;
	}

	public void setEmissoraOriginal(String emissora_original){
		this.emissora_original = emissora_original;
	}
	public String getEmissoraOriginal(){
    	return this.emissora_original;
	}	

	public void setTransmissaoOriginal(String transmissao_original){
		this.transmissao_original = transmissao_original;
	}
	public String getTransmissaoOriginal(){
    	return this.transmissao_original;
	}


	public void setNumTemporadas(int num_temporadas){
		this.num_temporadas = num_temporadas;
	}
	public int getNumTemporadas(){
		return this.num_temporadas;
	}


	public void setNumEpisodios(int num_episodios){
		this.num_episodios = num_episodios;
	}
	public int getNumEpisodios(){
		return this.num_episodios;
	}

	// construtor com parametros
	Serie(String nome, String formato, String duracao, String pais_origem, String idioma_original, String emissora_original, String transmissao_original, int num_temporadas, int num_episodios){
		this.setNome(nome);
		this.setFormato(formato);
		this.setDuracao(duracao);
		this.setPaisOrigem(pais_origem);
		this.setIdiomaOriginal(idioma_original);
		this.setEmissoraOriginal(emissora_original);
		this.setTransmissaoOriginal(transmissao_original);
		this.setNumTemporadas(num_temporadas);
		this.setNumEpisodios(num_episodios);
	}

	// construtor sem parametros
	Serie(){
		this.setNome(null);
		this.setFormato(null);
		this.setDuracao(null);
		this.setPaisOrigem(null);
		this.setIdiomaOriginal(null);
		this.setEmissoraOriginal(null);
		this.setTransmissaoOriginal(null);
		this.setNumTemporadas(0);
		this.setNumEpisodios(0);
	}

	// Metodo que imprime todos os gets da classe
	public void imprimir(){
		MyIO.println(this.getNome() + ' ' + this.getFormato() + ' ' + this.getDuracao() + ' ' + this.getPaisOrigem() + ' ' + this.getIdiomaOriginal() + ' ' + this.getEmissoraOriginal() + ' ' + this.getTransmissaoOriginal() + ' ' + this.getNumTemporadas() + ' ' + this.getNumEpisodios());
	}

	// Metodo para buscar uma string entre as tags.
	// Recebe como parametro uma linha contendo tags htmls e textos
	// Retorna somente o texto sem as tags e outros caracters indesejados
	public String getString(String line){
		String result = "";
		int index = 0;
		while(line.charAt(index) != '<'){
			index++;
		}
		for(int i = index; i < line.length(); i++){
			if(line.charAt(i) == '<'){
				int j = i;
				while(line.charAt(j) != '>'){
					j++;
				}
				i = j;
			}
			else if(line.charAt(i) == '&' && line.charAt(i-1) == '>'){
				int j = i;
				while(line.charAt(j) != ';'){
					j++;
				}
				i = j;
			}
			else {
				result+=line.charAt(i);
			}
		}
		if(result.charAt(0) == ' '){
			String fixedResult = "";
			for(int i = 1; i < result.length(); i++){
				fixedResult += result.charAt(i);
			}
			return fixedResult;
		}
		return result;
	}

	// Metodo para buscar titulo da série entre as tags.
	// Recebe como parametro uma linha contendo tags htmls e textos
	// Retorna somente o titulo sem as tags e outros caracters indesejados
	public String getTitle(String line){
		String result = "";
		int index = 0;
		while(line.charAt(index) != '<'){
			index++;
		}
		for(int i = index; i < line.length(); i++){
			if(line.charAt(i) == '<'){
				int j = i;
				while(line.charAt(j) != '>'){
					j++;
				}
				i = j;
			}
			else if(line.charAt(i) == ' ' && line.charAt(i+1) == '('){
				i = line.length();
			}
			else {
				result+=line.charAt(i);
			}
		}
		return result;
	}

	// Metodo para buscar um valor entre as tags.
	// Recebe como parametro uma linha contendo tags htmls e textos
	// Retorna somente um inteiro sem as tags e outros caracters indesejados
	public int getNumber(String line){
		String result = "";
		int index = 0;
		while(line.charAt(index) != '<'){
			index++;
		}
		for(int i = index; i < line.length(); i++){
			if(line.charAt(i) == '<'){
				int j = i;
				while(line.charAt(j) != '>'){
					j++;
				}
				i = j;
			}
			else {
				if(line.charAt(i) == '0' || line.charAt(i) == '1' || line.charAt(i) == '2' || line.charAt(i) == '3' || line.charAt(i) == '4' || line.charAt(i) == '5' || line.charAt(i) == '6' || line.charAt(i) == '7' || line.charAt(i) == '8' || line.charAt(i) == '9')
					result+=line.charAt(i);
				else
					i = line.length();
			}
		}
		int number = Integer.parseInt(result);
		return number;
	}
	
	// Metodo que lê um arquivo html e busca dentro dele informações referentes a série para armazenar em variaveis
	//	Recebe como parametro o nome do arquivo que sera acessado
	public void ler(String arq){
		String searchedLine, result, line;
		int intResult = 0;
		try{
			FileReader fr = new FileReader("/tmp/" + arq);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				if(line.indexOf("firstHeading") != -1){
					result = getTitle(line);
					this.setNome(result);
				}
				else if(line.indexOf(">Formato</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setFormato(result);
				}
				else if(line.indexOf(">Duração</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setDuracao(result);
				}
				else if(line.indexOf("País de origem</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setPaisOrigem(result);
				}
				else if(line.indexOf(">Idioma original</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setIdiomaOriginal(result);
				}
				else if(line.indexOf(">Emissora de televisão original</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setEmissoraOriginal(result);
				}
				else if(line.indexOf(">Transmissão original</td>") != -1){
					line = br.readLine();
					result = getString(line);
					this.setTransmissaoOriginal(result);
				}
				else if(line.indexOf(">N.º de temporadas</td>") != -1){
					line = br.readLine();
					intResult = getNumber(line);
					this.setNumTemporadas(intResult);
				}
				else if(line.indexOf(">N.º de episódios</td>") != -1){
					line = br.readLine();
					intResult = getNumber(line);
					this.setNumEpisodios(intResult);
				}
				
			}
		}
		catch(IOException e){
        	System.err.print("Erro na abertura do arquivo");
    	}
	}
}

class ListaSeries {
   private Serie[] series = new Serie[1000];
   private int n;
 
 
   /**
    * Construtor da classe.
    */
   ListaSeries () {
      this(1000);
   }
 
 
   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   ListaSeries (int tamanho){
      series = new Serie[tamanho];
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
 
      series[0] = s;
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
   public Serie removerInicio() throws Exception {
 
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
 
      Serie resp = series[0];
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
   public Serie removerFim() throws Exception {
 
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
   public Serie remover(int pos) throws Exception {
 
      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }
 
      Serie resp = series[pos];
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
      for(int i = 0; i < n; i++){
         series[i].imprimir();
      }
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

