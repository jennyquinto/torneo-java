package Model;

public class Jugador {
   private int id;
   private String nombre;
   private Equipo equipo;
   private Posicion posicion; 
   
   public Jugador (int id, String nombre, Equipo equipo, Posicion posicion){
       this.id = id;
       this.nombre = nombre;
       this.equipo = equipo;
       this.posicion = posicion;
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
   public Equipo getEquipo(){
       return equipo;
   }
   public void setEquipo(Equipo equipo){
       this.equipo = equipo;
   }
   public Posicion getPosicion(){
       return posicion;
   }
      
   @Override
   public String toString(){
       return id + " - " + nombre;
   }
   
}
