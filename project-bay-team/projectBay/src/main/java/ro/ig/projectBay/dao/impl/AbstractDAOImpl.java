package ro.ig.projectBay.dao.impl;

import java.util.Collection;

import ro.ig.projectBay.dao.AbstractDAO;

public class AbstractDAOImpl <T> implements AbstractDAO <T> {

	public void add(T object){}
	public Collection<T> getAll(){ return null;}
	public void edit(T initialObject, T newObject){}
	public void delete(T object){}
}
