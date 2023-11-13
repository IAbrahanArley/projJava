package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import config.TestConfig;
import entities.Acao;
import entities.Account;
import entities.Ativo;
import entities.Bdr;
import entities.Fii;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// INSTACINADO LISTA DO TIPO ACCOUNT
		List<Account> listAcc = new ArrayList<>();
		TestConfig config = new TestConfig();
		Account acc = new Account();
		
		

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
				//Gerando numero aleatorio para conta
				Random ran = new Random();
				int ranNum = ran.nextInt(10000);

				// transformando inteiro em string
				String numAccount = String.valueOf(ranNum);

				// concatenando string para criaçao final do numero da conta
				numAccount = numAccount + "-01";

				// INSTANCIANDO UMA NOVA CONTA
				acc = new Account(name, pass, numAccount, 0.0);

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
					// for para percorrer clients cadastrados
					for (Account account : listAcc) {
						// if para validar conta e senha
						if (account.getAccNumber().equals(accNum) && account.getPassword().equals(passUser)) {
							System.out.println("" 
									+ "=============================\n" 
									+ "    Bem vindo "
									+ account.getHolder()  + "\n"
									+ "=============================\n"
									+ "1 - Depostito              \n"
									+ "2 - Sacar            \n" 
									+ "3 - Saldo \n"
									+ "4 - Comprar ativo \n" 
									+ "5 - Vender ativo \n"
									+ "6 - Meus ativos \n" 
									+ "0 - Sair                     \n"
									+ "=============================\n");
							key = sc.nextInt();
							switch (key) {
							case 1:
								
								System.out.println("Valor do deposito:");
								double value = sc.nextDouble();
								
								// metodo para deposito 
								account.deposit(value);
								
								break;
							case 2:
								System.out.println("Valor do saque:");
								value = sc.nextDouble();
								
								//metodo para saque
								account.withdraw(value);

								break;
							case 3:
								// metodo para exibir saldo
								account.showBalance();
								break;
							case 4:
								System.out.println("" 
										+ "=============================\n" 
										+ "    O que deseja comprar? \n"
										+ "=============================\n"
										+ "1 - Ações              \n"
										+ "2 - Bdr            \n" 
										+ "3 - Fii \n"
										+ "0 - Sair                     \n"
										+ "=============================\n");
										int compra = sc.nextInt();
										switch (compra) {
										case 1:
											
											System.out.println("" 
													+ "=============================\n" 
													+ "       Ações disponiveis \n ");
											config.acao();
											System.out.println("Digite o codigo da ação:");
											sc.nextLine();
											String cod = sc.nextLine();
											List<Acao> listAcao = config.listAcao();
											for (Acao conf : listAcao ) {
												if (conf.getcod().equals(cod)) {
													System.out.println("Digite a quantidade:");
													int quant = sc.nextInt();
													double total = conf.getprice() * quant;
													if ( account.getAmount() >= total) {
														double totalValue = conf.getprice() * quant;
														System.out.println("Compra efetuada com sucesso!");
														System.out.println(account.buy(totalValue, conf.getName(), conf.getcod(), conf.getprice(), quant));
														System.out.println("Saldo atual: " + account.getAmount());
													} else {
														System.out.println("Saldo insuficinte, faça um deposito");
														System.out.println("Saldo atual: " + account.getAmount());
													}
												} 
											}
											
											break;

										case 2:
											System.out.println("" 
													+ "=============================\n" 
													+ "       Bdr's disponiveis \n ");
											config.acao();
											System.out.println("Digite o codigo da Bdr:");
											sc.nextLine();
											cod = sc.nextLine();
											List<Bdr> listBdr = config.listBdr();
											for (Bdr conf : listBdr ) {
												if (conf.getcod().equals(cod)) {
													System.out.println("Digite a quantidade:");
													int quant = sc.nextInt();
													double total = conf.getprice() * quant;
													if ( account.getAmount() >= total) {
														double totalValue = conf.getprice() * quant;
														System.out.println("Compra efetuada com sucesso!");
														account.buy(totalValue, conf.getName(), conf.getcod(), conf.getprice(), quant);
														System.out.println("Saldo atual: " + account.getAmount());
													} else {
														System.out.println("Saldo insuficinte, faça um deposito");
														System.out.println("Saldo atual: " + account.getAmount());
													}
												} 
											}

											break;
										case 3:
											System.out.println("" 
													+ "=============================\n" 
													+ "       Fii's disponiveis \n ");
											config.fii();
											System.out.println("Digite o codigo do Fii:");
											sc.nextLine();
											cod = sc.nextLine();
											List<Fii> listFii = config.listFii();
											for (Fii conf : listFii ) {
												if (conf.getcod().equals(cod)) {
													System.out.println("Digite a quantidade:");
													int quant = sc.nextInt();
													double total = conf.getprice() * quant;
													if ( account.getAmount() >= total) {
														double totalValue = conf.getprice() * quant;
														System.out.println("Compra efetuada com sucesso!");
														account.buy(totalValue, conf.getName(), conf.getcod(), conf.getprice(), quant);
														
														System.out.println("Rendimento recebido no valor de: " + conf.calcularRendimento(conf.getDy(), conf.getprice(), quant)); 
														account.deposit(conf.calcularRendimento(conf.getDy(), conf.getprice(), quant));
														System.out.println("Saldo atual: " + account.getAmount());
													} else {
														System.out.println("Saldo insuficinte, faça um deposito");
														System.out.println("Saldo atual: " + account.getAmount());
													}
												} 
											}
											break;
										
										case 0:
											
											break;

										default:
											break;
										}
								break;
							case 5:
								System.out.println("" 
										+ "=============================\n" 
										+ "    O que deseja vender? "
										+ "=============================\n"
										+ "1 - Ações              \n"
										+ "2 - Bdr            \n" 
										+ "3 - Fii \n"
										+ "0 - Sair                     \n"
										+ "=============================\n");
										compra = sc.nextInt();
										switch (compra) {
										case 1:
											System.out.println("" 
													+ "=============================\n" 
													+ "         Suas ações  \n ");
											config.acao();
											System.out.println("Digite o codigo da ação:");
											sc.nextLine();
											String cod = sc.nextLine();
											List<Acao> listAcao = config.listAcao();
											for (Acao conf : listAcao ) {
												if (conf.getcod().equals(cod)) {
													System.out.println("Digite a quantidade:");
													int quant = sc.nextInt();
													double total = conf.getprice() * quant;
													if ( account.getAmount() >= total) {
														double totalValue = conf.getprice() * quant;
														System.out.println("Compra efetuada com sucesso!");
														
														System.out.println("Saldo atual: " + account.getAmount());
													} else {
														System.out.println("Saldo insuficinte, faça um deposito");
														System.out.println("Saldo atual: " + account.getAmount());
													}
												} 
											}
											break;

										case 2:
											
											break;
										case 3:
											
											break;
										case 0:
											
											break;

										default:
											break;
										}
								break;
							case 6:
								List<Ativo> meuAtivo = new ArrayList<>();
								meuAtivo = account.getAtivos(); 
								for (Ativo ativo : meuAtivo) {
									System.out.println(ativo);
									
								}
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
