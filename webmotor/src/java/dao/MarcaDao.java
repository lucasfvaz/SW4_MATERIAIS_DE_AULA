
package dao;

import model.Marca;
import model.Modelo;


public class MarcaDao extends GenericDao<Marca>{
    
    public Marca findById(int id){
        return findByExample(new Marca(id,""));
    }
    
   
}
