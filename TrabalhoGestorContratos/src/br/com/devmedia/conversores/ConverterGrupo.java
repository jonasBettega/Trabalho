package br.com.devmedia.conversores;
import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;


import br.com.trabalho.beans.Grupo;
import br.com.trabalho.jpa.EntityManagerUtil;


public class ConverterGrupo implements Converter, Serializable {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.equals("Selecione um grupo")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Grupo.class, 
				Integer.parseInt(string));
	}
	
	// converte do objeto para a tela
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		if (o == null){
			return null;
		}
		Grupo obj = (Grupo) o;
		return obj.getId().toString();
	}

}