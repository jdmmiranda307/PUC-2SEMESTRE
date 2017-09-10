public class Series{
	private String nome, formato, duracao, pais_origem, idioma_original, emissora_original, transmissao_original;
	private int num_temporadas, num_episodios;
	
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

	Series(String nome, String formato, String duracao, String pais_origem, String idioma_original, String emissora_original, String transmissao_original, int num_temporadas, int num_episodios){
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
	Series(){
		this.setNome('');
		this.setFormato('');
		this.setDuracao('');
		this.setPaisOrigem('');
		this.setIdiomaOriginal('');
		this.setEmissoraOriginal('');
		this.setTransmissaoOriginal('');
		this.setNumTemporadas(0);
		this.setNumEpisodios(0);
	}

	public void imprimir(){
		System.out.print(this.getNome() + ' ' + this.getFormato() + ' ' + this.getDuracao() + ' ' + this.getPaisOrigem() + ' ' + this.getIdiomaOriginal() + ' ' + this.getEmissoraOriginal() + ' ' + this.getTransmissaoOriginal() + ' ' + this.getNumTemporadas() + ' ' + this.getNumEpisodios())
	}

	public void ler(String arq){
		
	}
}