
package beans;

import dao.MarcaDao;
import dao.ModeloDao;
import dao.VeiculoDao;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.Marca;
import model.Modelo;

@Named("aplicacao")
@ApplicationScoped
public class AplicacaoBean {
    private MarcaDao marcaDao;
    private ModeloDao modeloDao;
    private VeiculoDao veiculoDao;
    
    private List<SelectItem> itensMarca;
    public AplicacaoBean(){
      
      
    }

    
    
    @PostConstruct
      public void iniciar(){
        marcaDao = new MarcaDao();
        Marca m  = new Marca(1,"Volkswagen");
        marcaDao.inserir(m);
        modeloDao.inserir(new Modelo(1,"Fusca",m));
        m = new Marca(2,"Ford");
        
        marcaDao.inserir(m);
        m = new Marca(3,"Fiat");
        marcaDao.inserir(m);
        
        
        veiculoDao = new VeiculoDao();
     }
      
     public List<SelectItem> getItensMarca(){
         if(itensMarca == null){
             itensMarca =  new LinkedList<>();
             itensMarca.add(new SelectItem(null,"Selecione a marca"));
             for(Marca m : marcaDao.listar()){
                 itensMarca.add(new SelectItem(null,"Selecione a marca"));
             }
         }
         return itensMarca;
     }
     
     @Produces
     public MarcaDao getMarcaDao(){
         return marcaDao;
     }
     
     
     @Produces
     public VeiculoDao getVeiculoDao(){
         return veiculoDao;
     }
     
     
     
     
}
