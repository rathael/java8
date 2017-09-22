package adex.test.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import adex.test.java8.entities.Gasto;
import adex.test.java8.entities.Person;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		Main main = new Main();

		//main.testStream();
		main.testOrderPerson();
	}

	/**
	 * Prueba mapToDouble
	 */
	public void testStream() {
		ArrayList<Gasto> lista = new ArrayList<Gasto>();

		lista.add(new Gasto("A", 80));
		lista.add(new Gasto("B", 50));
		lista.add(new Gasto("C", 70));
		lista.add(new Gasto("D", 95));

		double resultado = lista.stream().mapToDouble(gasto -> gasto.getImporte() * 1.21).filter(gasto -> gasto < 100)
				.sum();

		System.out.println(resultado);

		double resultado2 = lista.stream().mapToDouble((gasto) -> {
			Double value = gasto.getImporte() * 1.21;
			System.out.println("----> " + value);
			return value;
		}).filter(gasto -> gasto < 100).sum();

		System.out.println(resultado2);

		double resultado3 = lista.stream().mapToDouble((gasto) -> this.calcularIva(gasto.getImporte()))
				.filter(gasto -> gasto < 100).sum();

		System.out.println(resultado3);
	}

	public Double calcularIva(Integer importe) {
		return importe * 1.21;
	}

	/**
	 * Ordernar por lambda
	 */
	public void testOrderPerson() {

		// Ordenar tradicional

		ArrayList<Person> milista = new ArrayList<Person>();
		milista.add(new Person("Miguel"));
		milista.add(new Person("Alicia"));

		Collections.sort(milista, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getNombre().compareTo(p2.getNombre());
			}

		});

		for (Person p : milista) {
			System.out.println(p.getNombre());
		}

		// Ordenar con lambda

		milista = new ArrayList<Person>();
		milista.add(new Person("Miguel"));
		milista.add(new Person("Alicia"));

		Collections.sort(milista, (Person p1, Person p2) -> p1.getNombre().compareTo(p2.getNombre()));

		for (Person p : milista) {
			System.out.println(p.getNombre());
		}

	}
}
