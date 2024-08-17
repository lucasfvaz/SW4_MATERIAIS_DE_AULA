/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.LinkedList;
import model.Modelo;
import model.Veiculo;


public class VeiculoDao extends GenericDao<Veiculo> {
    public LinkedList<Veiculo> filtrarPorModelo( Modelo m){
        LinkedList<Veiculo> resp = new LinkedList<>();
        for(Veiculo v : lista){
            if(v.getModelo().equals(m)){
                resp.add(v);
            }
        }
        return resp;
    }
}
