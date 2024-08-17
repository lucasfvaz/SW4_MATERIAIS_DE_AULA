
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "somador")
@SessionScoped
public class Somador implements Serializable {

    private Integer valor,soma = 0;
    
    public Somador() {
        
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getSoma() {
        return soma;
    }

    public String somar(){
        soma += valor;
        valor = null;
        return null;
    }
     public String subtrair(){
        soma -= valor;
        valor = null;
        return null;
    }
    
    
}
