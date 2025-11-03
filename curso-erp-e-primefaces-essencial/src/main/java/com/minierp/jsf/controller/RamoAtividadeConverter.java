package com.minierp.jsf.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.minierp.jsf.model.RamoAtividade;


public class RamoAtividadeConverter implements Converter {
	
	private List<RamoAtividade> listaRamoAtividades;

	
	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
		this.listaRamoAtividades = listaRamoAtividades;
	}

	@Override
	//Quando houver uma submissão , seu usuário escolhe o ramo atividade devolvendo o ramo da String
	public Object getAsObject(FacesContext context, UIComponent component, String value) {	
		if (value == null) {
			return null;
		}
		Long Id = Long.valueOf(value);
		for(RamoAtividade ramoAtividade: listaRamoAtividades){
			if (Id.equals(ramoAtividade.getId())) {
				return ramoAtividade;
			}
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {	
		if (value == null) {
			return null;
		}
		RamoAtividade ramoAtividade =(RamoAtividade) value;
		return ramoAtividade.getId().toString();
	}

}
