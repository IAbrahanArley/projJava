package entities;

public class Account {

	private String holder;
	private String password;
	private String accNumber;
		
	public Account() {
	}

	public Account(String holder, String password, String accNumber) {
		super();
		this.holder = holder;
		this.password = password;
		this.accNumber = accNumber;
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
	
	public void showData() {
		System.out.println("Dados cadastrado: ");
		System.out.println("Holder: " + holder);
		System.out.println("Numero da conta: " + accNumber);
	}
	
}	
	