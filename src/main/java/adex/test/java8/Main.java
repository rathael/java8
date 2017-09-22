package adex.test.java8;

import java.util.ArrayList;

import adex.test.java8.entities.Gasto;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		Main main = new Main();

		main.testStream();
	}

	public void testStream() {
		ArrayList<Gasto> lista = new ArrayList<Gasto>();

		lista.add(new Gasto("A", 80));
		lista.add(new Gasto("B", 50));
		lista.add(new Gasto("C", 70));
		lista.add(new Gasto("D", 95));

		double resultado = lista.stream()
				.mapToDouble(gasto -> gasto.getImporte() * 1.21)
				.filter(gasto -> gasto < 100)
				.sum();

		System.out.println(resultado);
		
		double resultado2 = lista.stream()
				.mapToDouble((gasto) -> {Double value = gasto.getImporte() * 1.21; System.out.println("----> " + value); return value;})
				.filter(gasto -> gasto < 100)
				.sum();
		
		System.out.println(resultado2);
		
		double resultado3 = lista.stream()
				.mapToDouble((gasto) -> this.calcularIva(gasto.getImporte()))
				.filter(gasto -> gasto < 100)
				.sum();
		
		System.out.println(resultado3);
	}
	
	public Double calcularIva(Integer importe) {
		return importe * 1.21;
	}
}
