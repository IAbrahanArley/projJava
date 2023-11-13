package entities;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private String holder;
	private String password;
	private String accNumber;
	private Double amount;
	private List<Ativo> ativos = new ArrayList<>();	
	public Account() {
	}

	public Account(String holder, String password, String accNumber, Double amount) {
		super();
		this.holder = holder;
		this.password = password;
		this.accNumber = accNumber;
		this.amount = amount;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	
	
	public Double getAmount() {
		return amount;
	}

	public List<Ativo> getAtivos() {
		return ativos;
	}

	// metodo para exibir dados do cadastro
	
	public void showData() {
		System.out.println("Dados cadastrado: ");
		System.out.println("Holder: " + holder);
		System.out.println("Numero da conta: " + accNumber);
	}

	

	// metodos para deposito, saque e extrato respeqctivamente ↓↓↓↓↓↓↓↓↓
	
	public double deposit(double value) {
		return amount += value;
	}
	
	public double withdraw(double value) {
		return amount -= value;	
	}
	
	public void showBalance() {
		System.out.println("Saldo atual: " + amount);
	}
	
	// metodo para compra do ativo
	public Ativo buy(double totalValue, String name, String cod, Double price, Integer quant) {
		Ativo ativo = new Ativo (name, cod, price, quant);
		ativos.add(ativo);
		amount -= totalValue;
		return ativo;
	}
	// metodo para venda do ativo
		public Ativo shell(String cod, int quant) {
			List<Ativo> meuAtivo = new ArrayList<>();
		
			meuAtivo = getAtivos(); 
			
			Ativo test = new Ativo();
			int count = 0;
			for (Ativo conf : meuAtivo ) {
				
				test = conf;
				if (conf.getcod().equals(cod)) {
					
					if (quant < conf.getQuant() ) {
						// se a quantidade vendida for menor que a da carteira tenho que deixar o restante
						int dif = conf.getQuant() - quant;
						conf.setQuant(dif);
						amount = amount + (conf.getprice() * quant);
						System.out.println("Venda concluida com sucesso!");
						return test;
					} else if( quant == conf.getQuant()) {
						// se a quantidade vendida for igual a da carteira tenho que remover o ativo
						meuAtivo.remove(count);
						amount = amount + (conf.getprice() * quant);
						System.out.println("Venda concluida com sucesso!");
						return test;
					} else {
						// se a quantidade vendida for maior que a carteira tenho que dizer ao usuario que valor vendido excede ao possuido 
						
						System.out.println("Quantidade inserida excede a quantidade da carteira");
					}
				} 
				count++;
			}
			return null;

		}

	
}
