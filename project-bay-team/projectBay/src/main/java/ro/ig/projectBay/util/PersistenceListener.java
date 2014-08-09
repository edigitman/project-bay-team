package ro.ig.projectBay.util;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import ro.ig.projectBay.model.Collaborator;
import ro.ig.projectBay.model.Company;
import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public class PersistenceListener<T> {

	@PostPersist
	public void postPersist(T entity) {
		if (entity instanceof Collaborator) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Collaborator) entity).getId()
					+ " de tipul Collaborator");
		}
		if (entity instanceof Company) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Company");
		}
		if (entity instanceof Project) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Project) entity).getId() + " de tipul Project");
		}
		if (entity instanceof User) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((User) entity).getId() + " de tipul User");
		}
		if (entity instanceof Company) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a persistat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}

		/*
		 * if (entity instanceof EmailLog) {
		 * System.out.println("S-a persistat obiectul cu id-ul: " + ((EmailLog)
		 * entity).getId() + " de tipul EmailLog"); }
		 */
	}

	@PostRemove
	public void postRemove(T entity) {
		if (entity instanceof Collaborator) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Collaborator) entity).getId()
					+ " de tipul Collaborator");
		}
		if (entity instanceof Company) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Company");
		}
		if (entity instanceof Project) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Project) entity).getId() + " de tipul Project");
		}
		if (entity instanceof User) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((User) entity).getId() + " de tipul User");
		}
		if (entity instanceof Company) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a sters obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}

		/*
		 * if (entity instanceof EmailLog) {
		 * System.out.println("S-a sters obiectul cu id-ul: " + ((EmailLog)
		 * entity).getId() + " de tipul EmailLog"); }
		 */
	}

	@PostUpdate
	public void postUpdate(T entity) {
		if (entity instanceof Collaborator) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Collaborator) entity).getId()
					+ " de tipul Collaborator");
		}
		if (entity instanceof Company) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Company");
		}
		if (entity instanceof Project) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Project) entity).getId() + " de tipul Project");
		}
		if (entity instanceof User) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((User) entity).getId() + " de tipul User");
		}
		if (entity instanceof Company) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}
		if (entity instanceof Company) {
			System.out.println("S-a updatat obiectul cu id-ul: "
					+ ((Company) entity).getId() + " de tipul Collaborateurs");
		}

		/*
		 * if (entity instanceof EmailLog) {
		 * System.out.println("S-a updatat obiectul cu id-ul: " + ((EmailLog)
		 * entity).getId() + " de tipul EmailLog"); }
		 */
	}

}
