package entities;

public class Ativo {

	private String name;
	private String cod;
	private Double price;
	private Integer quant;
	public Ativo( ) {
		
	}
	
	public Ativo(String name, String cod, Double price, Integer quant) {
		this.name = name;
		this.cod = cod;
		this.price = price;
		this.quant = quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcod() {
		return cod;
	}

	public void setcod(String cod) {
		this.cod = cod;
	}

	public Double getprice() {
		return price;
	}

	public void setprice(Double price) {
		this.price = price;
	}
	
	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}


	// metodo sobre escrito para exibir ativos disponiveis
	@Override
	public String toString() {
		return "=========================== " 
				+ "\nAtivo nome:" + name 
				+ "\nCodigo:" + cod 
				+ "\nValor:" + price 
				+ "\nQuantidade disponivel:" + quant;
	}


	

}
