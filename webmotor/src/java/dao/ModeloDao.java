
package dao;

import java.io.Serializable;
import java.util.LinkedList;
import model.Marca;
import model.Modelo;


public class ModeloDao extends GenericDao<Modelo> implements Serializable{
  public LinkedList<Modelo> filtrarPorMarca(Marca marca){
    LinkedList<Modelo> modelos = new LinkedList<>();
    for (Modelo mod : lista){
        if (mod.getMarca().equals(marca)){
            modelos.add(mod);
        }  
    }
    return modelos;
  }

   public Modelo findById(int id){
       for(Modelo m :lista){
           if(m.getId() == id){
               return m;
           }
       }
       return null;
   }  
}
