package ro.ig.projectBay.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ro.ig.projectBay.dao.AbstractDAO;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {

	/** The em. */
	@PersistenceContext
	protected EntityManager em;

	/** The type. */
	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T add(T object) {
		this.em.persist(object);
		return object;
	}

	public T find(long id) {
		return (T) this.em.find(type, id);
	}

	public T edit(final T object) {
		return this.em.merge(object);
	}

	public void delete(long id) {
		em.remove(this.em.getReference(type, id));
	}
}
