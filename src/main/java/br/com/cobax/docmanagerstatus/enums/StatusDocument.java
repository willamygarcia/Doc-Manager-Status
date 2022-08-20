package br.com.cobax.docmanagerstatus.enums;

public enum StatusDocument {
	
	EM_ANALISE(1,"Em Análise"),
	ANALIZADO(2, "Analizado"),
	NAO_ANALISADO(3, "Não Analisado"),
	ARQUIVADO(4, "Arquivado");
	
	private int codigo;
	private String descricao;
	
	private StatusDocument(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
		
	}
	public String getDescricao() {
		return descricao;
		
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static StatusDocument toEnum(Integer codigo) {
		if(codigo == null){
			return null;
		}
		for(StatusDocument status : StatusDocument.values()) {
			if(codigo.equals(status.getCodigo())){
				return status;
			}
		}
		
		throw new IllegalArgumentException("Codigo de Status Inválido");
	}
}

