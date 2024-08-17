
package beans;

import dao.ModeloDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.Marca;
import model.Modelo;


@Named(value = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable {
    
    private Marca marcaSelecionada;
    private Modelo modeloSelecionada;
    private LinkedList<SelectItem>itensModelo;
    
    @Inject
    ModeloDao modeloDao;
   
    
    
    
    public BuscaBean() {
    }
   
    @PostConstruct
    public void iniciar(){
        itensModelo = new LinkedList<SelectItem>();
        itensModelo.add(new SelectItem(null,"Selecione a marca primeiro"));
    }
    
    
    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
        itensModelo.clear();
        if (marcaSelecionada  == null){
            itensModelo.add(new SelectItem(null,"Selecione a marca primeiro"));
        }else{
            itensModelo.add(new SelectItem(null,"Modelo..."));
            for(Modelo m :  modeloDao.filtrarPorMarca(marcaSelecionada)){
                itensModelo.add( new SelectItem(m, m.getNome()));
            }
        }
    }
    
    
     public Modelo getModeloSelecionada() {
        return modeloSelecionada;
    }

    public void setModeloSelecionada(Modelo modeloSelecionada) {
        this.modeloSelecionada = modeloSelecionada;
    }

    public LinkedList<SelectItem> getItensModelo() {
        return itensModelo;
    }

    public void setItensModelo(LinkedList<SelectItem> itensModelo) {
        this.itensModelo = itensModelo;
    }

    public ModeloDao getModeloDao() {
        return modeloDao;
    }

    public void setModeloDao(ModeloDao modeloDao) {
        this.modeloDao = modeloDao;
    }
    
    
}
