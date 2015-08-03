package com.lhl.sw.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhl.sw.dao.BaseDAO;

@Repository
public class BaseDAOImpl_JPA<T> implements BaseDAO<T> {

	@PersistenceContext
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public Serializable save(T o) {
		this.manager.persist(o);
		return "1";
	}

	public void delete(T o) {
		this.manager.remove(o);
	}

	public void update(T o) {
		this.manager.merge(o);
	}

	public void saveOrUpdate(T o) {
		this.update(o);
	}

	public List<T> find(String hql) {
		return this.manager.createNamedQuery(hql).getResultList();
	}

	public List<T> find(String hql, Object[] param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.getResultList();
	}

	public List<T> find(String hql, List<Object> param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.getResultList();
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows)
				.getResultList();
	}

	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows)
				.getResultList();
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.manager.find(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
		return (long) this.manager.createQuery(hql).getMaxResults();
	}

	public Long count(String hql, Object[] param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (long) q.getMaxResults();
	}

	public Long count(String hql, List<Object> param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (long) q.getMaxResults();
	}

	public Integer executeHql(String hql) {
		return this.manager.createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		javax.persistence.Query q = this.manager.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

}