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
	void save(T o);

	/**
	 * ɾ��һ������
	 * 
	 * @param o
	 */
	void delete(T o);

	/**
	 * ����һ������
	 * 
	 * @param o
	 */
	void update(T o);

	/**
	 * �������¶���
	 * 
	 * @param o
	 */
	void saveOrUpdate(T o);

	/**
	 * ��ѯ
	 * 
	 * @param hql
	 * @return
	 */
	List<T> find(String hql);

	List find1(String hql);

	/**
	 * ��ѯ����
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	List<T> find(String hql, Object[] param);

	List find2(String hql, Object[] param);

	/**
	 * ��ѯ����
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	List<T> find(String hql, List<Object> param);

	/**
	 * 查找单个实例
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	T findT(String hql, List<Object> param);

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
	List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * ��ѯ����(���ҳ)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	/**
	 * ���һ������
	 * 
	 * @param c
	 *            ��������
	 * @param id
	 * @return Object
	 */
	T get(Class<T> c, Serializable id);

	/**
	 * ���һ������
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	T get(String hql, Object[] param);

	/**
	 * ���һ������
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	T get(String hql, List<Object> param);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @return
	 */
	Long count(String hql);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	Long count(String hql, Object[] param);

	/**
	 * select count(*) from ��
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	Long count(String hql, List<Object> param);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @return ��Ӧ��Ŀ
	 */
	Integer executeHql(String hql);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @param param
	 * @return ��Ӧ��Ŀ
	 */
	Integer executeHql(String hql, Object[] param);

	/**
	 * ִ��HQL���
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	Integer executeHql(String hql, List<Object> param);

	/**
	 * 执行存储过程
	 * 
	 * @param procName
	 * @param params
	 */
	int callProcedure(String procName, Object[] params);

}