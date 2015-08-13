package com.lhl.sw.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

	/**
	 * ����һ������
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * ɾ��һ������
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * ����һ������
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * �������¶���
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * ��ѯ
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * ��ѯ����
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param);

	/**
	 * ��ѯ����
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param);

	/**
	 * 查找单个实例
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public T findT(String hql, List<Object> param);

	/**
	 * ��ѯ����(���ҳ)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 *            ��ѯ�ڼ�ҳ
	 * @param rows
	 *            ÿҳ��ʾ������¼
	 * @return
	 */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * ��ѯ����(���ҳ)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows);

	/**
	 * ���һ������
	 * 
	 * @param c
	 *            ��������
	 * @param id
	 * @return Object
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * ���һ������
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	public T get(String hql, Object[] param);

	/**
	 * ���һ������
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Object[] param);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @return ��Ӧ��Ŀ
	 */
	public Integer executeHql(String hql);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @param param
	 * @return ��Ӧ��Ŀ
	 */
	public Integer executeHql(String hql, Object[] param);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param);

}