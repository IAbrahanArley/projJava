package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// INSTACINADO LISTA DO TIPO ACCOUNT
		List<Account> listAcc = new ArrayList<>();
		
		int i = 1;
		do {
			// Menu principal
			System.out.println(""
					+ "=============================\n"
					+ "            Home             \n"
					+ "=============================\n"
					+ "1 - Criar conta              \n"
					+ "2 - Acessar conta            \n"
					+ "0 - Sair                     \n"
					+ "=============================\n");
			int opt = sc.nextInt();
			switch(opt) {
			  case 1:
				  System.out.println("Digite seu nome:");
				  sc.nextLine();
				  String name = sc.nextLine();
				  System.out.println("Digite a senha:");
				  String pass = sc.nextLine();
				  //gerando numero aleatorio para conta
				  Random ran = new Random();
				  int ranNum = ran.nextInt(10000);
				  
				  //transformando inteiro em string
				  String numAccount = String.valueOf(ranNum);
				  
				  //contavatenando string para criaçao final do numero da conta
				  numAccount = numAccount + "-01";
				  
				  // INSTANCIANDO UMA NOVA CONTA
				  Account acc = new Account(name, pass, numAccount);
				  
				  // ARMAZENANDO CONTA NOVA EM ARRAY
				  listAcc.add(acc);
				  System.out.println("Conta criada com sucesso!");
				  // Exibir dados do cadastro
				  acc.showData();
				  break;
			  case 2:
			    // code block
			    break;
			  case 0 :
				  i = 0;
			  default:
			    // code block
			}
		}
		while (i != 0);
		System.out.println("Aplicação encerrada!");
		
		
		sc.close();
	}

}
