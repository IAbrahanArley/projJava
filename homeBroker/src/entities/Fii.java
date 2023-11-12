package entities;

public class Fii extends Ativo implements Calculo{
	
	private Double dy;
	
	public Fii(String name, String cod, Double price, Double dy) {
		super(name, cod, price);
		this.dy = dy;
	}

	public Double getDy() {
		return dy;
	}

	public void setDy(Double dy) {
		this.dy = dy;
	}

	@Override
	public double calcularRendimento(double dy, double atvValue, int quant) {
		
		return (atvValue * ((dy / 100)) * quant) / 12;
	}

	
	
	
}
