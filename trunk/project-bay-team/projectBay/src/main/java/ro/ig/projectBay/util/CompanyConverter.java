package ro.ig.projectBay.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ig.projectBay.dao.CompanyDAO;
import ro.ig.projectBay.model.Company;

@FacesConverter(forClass = Company.class, value = "companyConverter")
public class CompanyConverter implements Converter {

	/*
	 * @ManagedProperty(value = "#{companyService}") private CompanyService
	 * companyService;
	 */
	@Autowired
	CompanyDAO companyDAO;

	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		// Object myObject = null;
		// if (component instanceof SelectOneMenu) {
		// Object list = ((SelectOneMenu) component).getValue();
		// List<Company> companyList = (ArrayList<Company>) list;
		// for (Object o : companyList) {
		// String id = "" + ((Company) o).getId();
		// if (value.equals(id)) {
		// myObject = o;
		// break;
		// }
		// }
		// if (myObject == null)
		// for (Object o : companyList) {
		// String id = "" + ((Company) o).getId();
		// if (value.equals(id)) {
		// myObject = o;
		// break;
		// }
		// }
		// }
		// return myObject;

		Integer id = new Integer(value);
		return companyDAO.findById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		String str = "";
		if (value instanceof Company) {
			str = "" + ((Company) value).getId();
		}
		return str;

	}
}
