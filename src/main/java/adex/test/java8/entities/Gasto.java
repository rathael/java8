package adex.test.java8.entities;

public class Gasto {

	private String name;
	
	private Integer importe;
	
	public Gasto() {
	}

	public Gasto(String name, Integer importe) {
		super();
		this.name = name;
		this.importe = importe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

}
