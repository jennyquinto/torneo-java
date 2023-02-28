package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Equipo extends Dbdata{
    public int id;
    public String nombre;
    public String dt;
    public int municipioId;
    Dbdata dbData;
    
    public Equipo (){
        this.dbData = new Dbdata();
    }
    
    public ArrayList<Equipo> select(){
        try{Connection connection = DriverManager.getConnection(dbData.getUrl(), dbData.user, dbData.getPassword());
            String query = "SELECT * FROM equipo";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Equipo> listaEquipo = new ArrayList<>();
            while(rs.next()){
               Equipo equipo = new Equipo();
               equipo.id = rs.getInt(1);
               equipo.nombre = rs.getString(2);
               equipo.dt = rs.getString(3);
               equipo.municipioId = rs.getInt(4);
               listaEquipo.add(equipo);
            }
            connection.close();
            return listaEquipo;
            
        }
        catch(Exception e){
            System.out.println("Error "+ e.toString());
            return null;
            
        }
    }
    
    public boolean insert(){
        try{Connection connection = DriverManager.getConnection(dbData.getUrl(), dbData.user, dbData.getPassword());
            String query = "INSERT INTO equipo VALUES (null,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, nombre);
            sentencia.setString(2, dt);
            sentencia.setInt(3, municipioId);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            
            if(filasAfectadas>0){
                System.out.println("El equipo se insertó correctamente");
                return true;
                  
            }
            else{
                System.out.println("El equipo no se insertó");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Error al insertar"+ e.toString());
            return false;
            
        }
    }
    
    public boolean update(){ 
        try{Connection connection = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword());
            String query = "UPDATE equipo SET nombre=?, dt=?, municipioEquipo=? WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, nombre);
            sentencia.setString(2, dt);
            sentencia.setInt(3, municipioId);
            sentencia.setInt(4,id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if(filasAfectadas>0){
                System.out.println("Equipo se actualizó");
                return true;
            }
            else{
                System.out.println("El equipo no se actualizó");
                return false;
            }
            
        }
        catch(Exception e){
            System.out.println("Error al actualizar municipio "+ e.toString());
            return false;
        }
    }
    
    public Equipo find(int id){
        try{Connection connection = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword());
            String query = "SELECT * FROM equipo WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Equipo equipo = new Equipo();
            if(rs.next()){
                equipo.id = rs.getInt(1);
                equipo.nombre = rs.getString(2);
                equipo.dt = rs.getString(3);
                equipo.municipioId = rs.getInt(4);
                
            }
            else{
                equipo = null;
            }
            connection.close();
            return equipo;
            } 
        catch (Exception e) {
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public boolean delete(int id){
        try {Connection connection = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword());
            String query = "DELETE FROM equipo WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if(filasAfectadas>0){
                System.out.println("Equipo borrado correctamente");
                return true;
                
            }
            else{
                System.out.println("Equipo no borrado");
                return  false;
                
            }
            
        } catch (Exception e) {
            System.out.println("Error al actualizar equipo "+ e.toString());
            return false;
        }
        
    }
    
    
    @Override
    public String toString() {
        return id + " - " + nombre + " - " + dt + " - " + municipioId;
    }
}
