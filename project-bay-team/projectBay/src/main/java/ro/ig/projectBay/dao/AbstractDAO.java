package ro.ig.projectBay.dao;


/**
 * The Interface AbstractDAO.
 *
 * @param <T> the generic type
 */
public interface AbstractDAO<T> {

	/**
	 * Adds an object.
	 *
	 * @param object the object
	 */
	T add(T object);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	T find(long id);

	/**
	 * Update.
	 *
	 * @param t the t
	 * @return the t
	 */
	T edit(final T t);
	
	/**
	 * Delete the object.
	 *
	 * @param object the object
	 */
	void delete(long id);
}
