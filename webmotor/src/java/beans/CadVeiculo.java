/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.VeiculoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Marca;
import model.Modelo;
import model.Veiculo;


@Named(value = "cadVeiculo")
@SessionScoped
public class CadVeiculo implements Serializable {
    Marca marcaSelecionada;
    Modelo modeloSelecionado;
    Veiculo veiculo;
    
    @Inject
    VeiculoDao veiculoDAO;
    
    public CadVeiculo() {
    }

    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(Modelo modeloSelecionado) {
        this.modeloSelecionado = modeloSelecionado;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public String confirmar(){
        Veiculo v = veiculoDAO.findByExample(veiculo);
        if (v != null){
            FacesContext.getCurrentInstance().addMessage(null, 
             new FacesMessage(FacesMessage.SEVERITY_ERROR,
             "Placa já cadastrada","Já existe veiculp com esta placa no cadastro"));
        }else{
            veiculoDAO.inserir(veiculo);
        }
        return null;
    }
    
    
}
