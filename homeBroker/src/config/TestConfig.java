package config;

import java.util.Arrays;
import java.util.List;

import entities.Acao;
import entities.Bdr;
import entities.Fii;

public class TestConfig {

	Acao acao1 = new Acao("petrobras", "petr4", 34.50, "pn");
	Acao acao2 = new Acao("vale", "vale3", 71.50, "pn");
	Acao acao3 = new Acao("mrv engenharia", "mve3", 10.12, "On");
	Acao acao4 = new Acao("taesa", "taee11", 36.90, "unit");

	Bdr bdr1 = new Bdr("Unit Software inc", "u2st34", 6.21);
	Bdr bdr2 = new Bdr("Unit Software inc", "u2st34", 6.21);
	Bdr bdr3 = new Bdr("Unit Software inc", "u2st34", 6.21);
	Bdr bdr4 = new Bdr("Unit Software inc", "u2st34", 6.21);

	Fii fii1 = new Fii("Maxi renda", "Mxrf11", 10.84, 12.36);
	Fii fii2 = new Fii("Btg fundos ed fundos", "bcff11", 71.84, 9.34);
	Fii fii3 = new Fii("Vinci Officies fdo inv mob", "vino11", 7.66, 9.76);
	Fii fii4 = new Fii("Cshg real estate", "hgre11", 143.80, 8.21);

	List<Fii> listFii = Arrays.asList(fii1, fii2, fii3, fii4);
	List<Bdr> listBdr = Arrays.asList(bdr1, bdr2, bdr3, bdr4);
	List<Acao> listAcao = Arrays.asList(acao1, acao2, acao3, acao4);

	public List<Fii> listFii(){
		List<Fii> list = listFii;
		return list;
	}
	public List<Acao> listAcao(){
		List<Acao> list = listAcao;
		return list;
	}
	public List<Bdr> listBdr(){
		List<Bdr> list = listBdr;
		return list;
	}
	
	public void fii() {

		for (Fii fii : listFii) {
			System.out.println(fii);

		}

	}

	public void bdr() {

		for (Bdr bdr : listBdr) {
			System.out.println(bdr);

		}

	}

	public void acao() {

		for (Acao acao : listAcao) {
			System.out.println(acao);

		}

	}

	
}
