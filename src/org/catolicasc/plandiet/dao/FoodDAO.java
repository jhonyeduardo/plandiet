package org.catolicasc.plandiet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.catolicasc.plandiet.modelo.Food;

public class FoodDAO {

	protected EntityManager entityManager;

	public FoodDAO() {
		this.entityManager = this.getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PlanDiet");
		if (this.entityManager == null) {
			this.entityManager = factory.createEntityManager();
		}

		return this.entityManager;
	}

	public Food getById(final int id) {
		return this.entityManager.find(Food.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Food> findAll() {
		return this.entityManager.createQuery("FROM " + Food.class.getName()).getResultList();
	}

	public void persist(Food food) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(food);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void merge(Food food) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(food);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void remove(Food food) {
		try {
			this.entityManager.getTransaction().begin();
			food = this.entityManager.find(Food.class, food.getId());
			this.entityManager.remove(food);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Food food = this.getById(id);
			this.remove(food);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
