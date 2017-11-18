import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TP04Q03{
    public static void main(String args[]){
        MyIO.setCharset("UTF-8");
        String[] in  = new String[1000];
        PilhaSeries pilha = new PilhaSeries();
        
        int numIn = 0;
        do{     
            in[numIn] = MyIO.readLine(); 
        } while(in[numIn++].equals("FIM") == false);
        numIn--;
        for(int i = 0; i < numIn; i++){
            Serie s = new Serie();
            s.ler(in[i]);
            try{
                pilha.inserir(s);
            } catch(Exception e){
                System.err.print("Erro na execucao");
            }
        }
        int limit = Integer.parseInt(MyIO.readLine());
        
        for(int i = 0; i < limit; i++){
            Serie s = new Serie();
            int pos;
            String line = MyIO.readLine();

            if(line.contains("I")){
                s.ler(line.substring(2));
                try{
                    pilha.inserir(s);
                } catch(Exception e){
                    System.err.print("Erro na execucao");
                }
            }
            else if(line.contains("R")){
                try{
                    Serie se = pilha.remover();
                    MyIO.println("(R) " + se.getNome());
                } catch(Exception e){
                    System.err.print("Erro na execucao");
                }
            }
        }
        pilha.mostrar();
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
    //  Recebe como parametro o nome do arquivo que sera acessado
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

//inspirada na pilha:
/**
 * Pilha estatica 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PilhaSeries {
    private Serie[] series = new Serie[1000];
    private int topo;
 
 
   /**
    * Construtor da classe.
    */
   public PilhaSeries () {
      this(1000);
   }
 
 
   /**
    * Construtor da classe.
    * @param tamanho Tamanho da PilhaSeries.
    */
   public PilhaSeries (int tamanho){
      series = new Serie[tamanho];
      topo = 0;
   }
 
 
   /**
    * Insere um elemento na ultima posicao da pilha.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a pilha estiver cheia.
    */
   public void inserir(Serie s) throws Exception {
 
      //validar insercao
      if(topo >= series.length){
         throw new Exception("Erro ao inserir!");
      }
 
      series[topo] = s;
      topo++;
   }
 
 
   /**
    * Remove um elemento da ultima posicao da pilha.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a pilha estiver vazia.
    */
   public Serie remover() throws Exception {
 
      //validar remocao
      if (topo == 0) {
         throw new Exception("Erro ao remover!");
      }
 
      return series[--topo];
   }
 
 
   /**
    * Mostra os array separados por espacos.
    */
   public void mostrar (){
      for(int i = topo -1; i >= 0; i--){
          series[i].imprimir();
      }
   }
 
   /**
    * Retorna um boolean indicando se a pilha esta vazia
    * @return boolean indicando se a pilha esta vazia
    */
   public boolean isVazia() {
      return topo == 0; 
   }
}