public class Tarea {
    private int id;
    private String descripcion;
    private  boolean estaCompleta;
    private static int idCounter = 0;

    public Tarea(String descripcion) {
        this.id = idCounter++;
        this.descripcion = descripcion;
        this.estaCompleta = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstaCompleta() {
        return estaCompleta;
    }

    public void setEstaCompleta(boolean estaCompleta) {
        this.estaCompleta = estaCompleta;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estaCompleta=" + estaCompleta +
                '}';
    }
}
