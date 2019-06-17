package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

/**
 * ģ�Ͳ�Ľӿڣ����ڶ����û�ģ��ķ���
 * 
 * @author ��կ
 *
 */
public interface UsersService {
	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * 
	 * @param userId       �û����
	 * @param userPwd      �û�����
	 * @param permissionId �û�Ȩ��
	 * @return �ɹ����ص�¼�û���������Ϣ��ʧ�ܷ���null
	 */
	public abstract Users login(Integer userId, String userPwd, Integer permissionId);

	/**
	 * ������û���Ϣ
	 * 
	 * @param users ���û���Ϣ
	 * @return ��ӳɹ�����com.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users insert(Users users);

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @param users      ��ѯ����
	 * @param pageNumber ��ѯҳ��
	 * @return �ɹ����� org.springframework.data.domain.Page���͵�ʵ�������򷵻�Null
	 */
	public abstract Page<Users> select(Users users, Integer pageNumber);

	/**
	 * �޸�ָ����ŵ��û���״̬
	 * 
	 * @param userId     �û����
	 * @param userStatus �û�״̬
	 * @return �ɹ����ش���0��������ʧ�ܷ���0
	 */
	public abstract Integer updateStatus(Integer userId, Integer userStatus);

	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * 
	 * @param userId �û����
	 * @return �ɹ�����com.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users selectById(Integer userId);

	/**
	 * �޸�ָ����ŵ��û���Ϣ
	 * 
	 * @param users �޸ĵ��û���Ϣ
	 * @return �ɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer update(Users users);

	/**
	 * ���ݲ������޸�ָ����ŵ��û�ͷ���û����롢�û��ǳ�
	 * 
	 * @param users �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateMessage(Users users);

}
