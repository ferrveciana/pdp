/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author narcisbustins
 */
public class Desplaçament extends Activitat{
    
    private PuntInteres origen;
    private PuntInteres desti;
    
    public Desplaçament(int _durada,PuntInteres _origen,PuntInteres _desti,float _preu) {
        super(_durada,_preu);
        
        origen = _origen;
        desti = _desti;
    }

    @Override
    public PuntInteres piActual() {
        return desti;
    }

    public boolean teTransport(LocalDateTime hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methode
    }

    @Override
    int satisfaccio(List<String> preferenciesClients) {
        
       int suma = 0;
        List<String> llistaCaracteristiques = desti.obtenirCaracteristiques();
        for (String c:llistaCaracteristiques){
            if (preferenciesClients.contains(c)) suma++;
        }
        
        return suma;
    }

    @Override
    LocalDateTime hPropera(LocalDateTime hora) {
        if (origen.getCiutat().equals(desti.getCiutat())){//si es urba
            return hora;
        }
        else return hora; //per implementar no urbans
        
    }
}
