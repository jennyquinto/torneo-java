package Model;

public class Equipo {
   private int id;
   private String nombre;
   private String dt;
   private Municipio municipio;
   
   public Equipo (int id, String nombre, String dt, Municipio municipio){
    this.id = id;
    this.nombre = nombre;
    this.dt = dt;
    this.municipio = municipio;
   }
   
   public int getId(){
       return id;
   }
   public void setId(int id){
       this.id = id;
   }
   public String getNombre(){
       return nombre;
   }
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   public String getDt(){
       return dt;
   }
   public void setDt(String dt){
       this.dt = dt;
   }
   public Municipio getMunicipio(){
       return municipio;
   }
   public void setMunicipio(Municipio municipio){
       this.municipio = municipio;
   }
   
   @Override
   public String toString(){
       return id + " - " + nombre;
   }
   
}
