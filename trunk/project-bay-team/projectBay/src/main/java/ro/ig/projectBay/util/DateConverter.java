package ro.ig.projectBay.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.calendar.Calendar;

@FacesConverter(forClass = Date.class, value = "dateConverter")
public class DateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		Object myObject = null;
		if (component instanceof Calendar) {
			myObject= ((Calendar) component).getValue();
		}
		return myObject;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String str="";
		String[] parts;
		
		GregorianCalendar gc=new GregorianCalendar();
		Map<String,Integer> months=new HashMap<String,Integer>();
		months.put("Dec", 12);
		months.put("Nov", 11);
		months.put("Oct", 10);
		months.put("Sep", 9);
		months.put("Aug", 8);
		months.put("Jul", 7);
		months.put("Jun", 6);
		months.put("May", 5);
		months.put("Apr", 4);
		months.put("Mar", 3);
		months.put("Feb", 2);
		months.put("Jan", 1);
		
		if(value instanceof Date){
			gc.setTime((Date)value);
			parts = gc.getTime().toString().split(" ");
			str=parts[5]+"/"+months.get(parts[1])+"/"+parts[2];
		}
		return str;
	}

}

