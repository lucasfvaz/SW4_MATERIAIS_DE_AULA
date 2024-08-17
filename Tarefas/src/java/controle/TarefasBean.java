package controle;

import dados.Tarefa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "tarefasBean")
@SessionScoped
public class TarefasBean implements Serializable {
    
    private ArrayList<Tarefa> listaTarefas;
    private Tarefa atual;
    boolean editando = false;
    public TarefasBean() {
        listaTarefas = new ArrayList<>();
        atual= new Tarefa();
            
        
    }

   
    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public Tarefa getAtual() {
        return atual;
    }

    public void setAtual(Tarefa atual) {
        this.atual = atual;
    }
     public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

     public  String incluir(){
         Date agora = new Date();
         if (atual.getPrazo().before(agora)) {
             FacesContext.getCurrentInstance().addMessage(null,
                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                             "Data deve ser futura",
                             "Data deve ser futura"));
             return null;
         }
         if(!editando){
         listaTarefas.add(atual);
         }
         atual = new Tarefa();
         editando = false;
         return null;
     }
     public  void excluir(Tarefa t){
         listaTarefas.remove(t);   
     }
     
     public  void editar(Tarefa t){
         atual = t;
         editando = true;
     }
}
