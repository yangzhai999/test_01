package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;

/**
 * ���ڶ���һ�������������ģ��ķ���
 * 
 * @author ��կ
 *
 */
public interface TypeService {

	/**
	 * ��ѯ����һ��������Ϣ
	 * 
	 * @return �ɹ�����
	 */
	public abstract List<TypeOne> selectAllTypeOne();

	/**
	 * ����һ������Ų�ѯ��Ӧ�Ķ��������Ϣ
	 * 
	 * @param typeOneId һ�������
	 * @return �ɹ�����java.util.List����ʵ�������򷵻�null
	 */
	public abstract List<TypeTwo> selectTypeTwoByTypeOneId(Integer typeOneId);

}
