package practica;

public class Nodo {

    private int tag;
    private String cargo;
    private String usuario;
    private String nombre;
    private String id;
    Nodo liga; 
    Nodo subLista; 

    public Nodo(String cargo, String usuario, int tag) {
        this.tag=tag;
        this.cargo = cargo;
        this.usuario = usuario;
        
        this.liga = null;
        this.subLista = null;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
  
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getSubLista() {
        return subLista;
    }

    public void setSubLista(Nodo subLista) {
        this.subLista = subLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
