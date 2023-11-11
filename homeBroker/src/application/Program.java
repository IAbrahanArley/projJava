package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// INSTACINADO LISTA DO TIPO ACCOUNT
		List<Account> listAcc = new ArrayList<>();

		int opt = 1;
		do {
			// Menu principal
			System.out.println("" + "=============================\n" + "            Home             \n"
					+ "=============================\n" + "1 - Criar conta              \n"
					+ "2 - Acessar conta            \n" + "0 - Sair                     \n"
					+ "=============================\n");
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				System.out.println("Digite seu nome:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Digite a senha:");
				String pass = sc.nextLine();
				// gerando numero aleatorio para conta
				Random ran = new Random();
				int ranNum = ran.nextInt(10000);

				// transformando inteiro em string
				String numAccount = String.valueOf(ranNum);

				// concatenando string para criaçao final do numero da conta
				numAccount = numAccount + "-01";

				// INSTANCIANDO UMA NOVA CONTA
				Account acc = new Account(name, pass, numAccount, 0.0);

				// ARMAZENANDO CONTA NOVA EM ARRAY
				listAcc.add(acc);
				System.out.println("Conta criada com sucesso!");
				// Exibir dados do cadastro
				acc.showData();
				break;
			case 2:
				System.out.println("Numero da conta:");
				sc.nextLine();
				String accNum = sc.nextLine();
				System.out.println("Senha:");
				String passUser = sc.nextLine();
				int key = 1; 
				do {
					for (Account account : listAcc) {
						
						if (account.getAccNumber().equals(accNum) && account.getPassword().equals(passUser)) {
							System.out.println("" 
									+ "=============================\n" 
									+ "    Bem vindo "
									+ account.getHolder()  + "\n"
									+ "=============================\n"
									+ "1 - Depostito              \n"
									+ "2 - Sacar            \n" 
									+ "3 - Saldo \n"
									+ "4 - Comprar ação \n" 
									+ "5 - Vender ação \n" 
									+ "0 - Sair                     \n"
									+ "=============================\n");
							key = sc.nextInt();
							switch (key) {
							case 1:
								System.out.println("Valor do deposito:");
								double value = sc.nextDouble();
								account.deposit(value);
								break;
							case 2:
								System.out.println("Valor do deposito:");
								value = sc.nextDouble();
								account.withdraw(value);

								break;
							case 3:
								account.showBalance();
								break;
							case 4:
								
								break;
							case 5:
								
								break;
							case 0:
								key = 0;
								break;
							default:
								throw new IllegalArgumentException("Unexpected value: " + key);
							}
						}
					}
				} while(key != 0 );
				break;
			case 0:
				opt = 0;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
		} while (opt != 0);
		System.out.println("Aplicação encerrada!");

		sc.close();
	}

}
