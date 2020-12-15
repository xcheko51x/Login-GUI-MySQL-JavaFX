package sample;

public class Usuario {

    int idUsuario;
    String nombre;
    String usuario;
    String contrasena;

    public Usuario(int idUsuario, String nombre, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String mostrarUsuario() {
        return idUsuario + ", " +nombre + ", " + usuario + ", " + contrasena;
    }
}
