package adex.test.java8.entities;

public class Person {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Person(String nombre) {
		super();
		this.nombre = nombre;
	}
}
