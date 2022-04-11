

public class Estudiante extends Usuario {
	private String Nombre;
	private String Apellido;
	private String Telefono;
	private int idEstudiante;
	public Estudiante() {
		
	}
	
	public Estudiante(String nombre, String apellido, String telefono) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}


	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}
