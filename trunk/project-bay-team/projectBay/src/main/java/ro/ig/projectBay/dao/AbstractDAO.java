package ro.ig.projectBay.dao;

import java.util.Collection;

public interface AbstractDAO <T>{

	public void add(T object);
	public Collection<T> getAll();
	public void edit(T initialObject, T newObject);
	public void delete(T object);
}
