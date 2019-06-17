package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * ���Ʋ㣺������ͼ������ݣ�������ģ�Ͳ���Ӧ�ķ����������ݷ��ص���ͼ����
 * 
 * @author ��կ
 *
 */
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/login")
	public ResultValue login(@RequestParam("userId") Integer userId, @RequestParam("userPwd") String userPwd,
			@RequestParam("permissionId") Integer permissionId) {
		ResultValue rv = new ResultValue();

		try {
			Users login = this.usersService.login(userId, userPwd, permissionId);
			if (login != null) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);

				return rv;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��¼��Ϣ����ȷ�����������룡");
		return rv;
	}

	/**
	 * ������û���Ϣ
	 * 
	 * @param users ���û���Ϣ
	 * @return
	 */
	@RequestMapping(value = "/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();

		try {
			Users insert = this.usersService.insert(users);
			if (insert != null) {
				rv.setCode(0);
				rv.setMessage("¼���û��ɹ���");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("¼���û�ʧ�ܣ�");
		return rv;
	}

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			// ��÷�ҳ������
			List<Users> list = page.getContent();
			// �ж��Ƿ��ѯ��������
			if (list != null && list.size() > 0) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				// ����ҳ��Ϣ��ӵ�Map��

				map.put("userList", list);

				PageUtils pageUtils = new PageUtils((int) page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				// ����ҳ��Ϣ��ӵ�Map��
				map.put("pageUtils", pageUtils);
				// ��Map��ӵ�ResultValue������
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	@RequestMapping(value = "/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,
			@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();

		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if (status > 0) {
				rv.setCode(0);
				rv.setMessage("�û�״̬�޸ĳɹ���");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�״̬�޸�ʧ�ܣ�");
		return rv;
	}

	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * 
	 * @param userId �û����
	 * @return
	 */
	@RequestMapping(value = "/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();

		try {
			// ����service�еķ���������ò�ѯ���
			Users users = this.usersService.selectById(userId);
			// ����ɹ�
			if (users != null) {
				// ���ý����״̬Ϊ0
				rv.setCode(0);
				// ����Map���ϱ����ѯ���
				Map<String, Object> map = new HashMap<>();
				// ����ѯ������浽Map������
				map.put("users", users);
				// ��Map������ӵ�ResultValue������
				rv.setDataMap(map);
				// ����ResultValue
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ȡ�û���Ϣʧ�ܣ�");
		return rv;
	}

	/**
	 * �޸��û�����Ϣ
	 * 
	 * @param users �û���Ϣ
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		try {
			// ����Service����Ӧ�ķ����޸��û���Ϣ��������޸��Ƿ�ɹ�
			Integer update = this.usersService.update(users);
			// ����޸ĳɹ�
			if (update > 0) {
				// ���ý��״̬Ϊ0
				rv.setCode(0);
				rv.setMessage("�޸ĳɹ���");
				// ����ResultValue�Ķ���
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û���Ϣ�޸�ʧ�ܣ�");
		return rv;
	}
	
	/**
	 * 	�޸��û�ͷ���û����롢�û��ǳ�
	 * @param users	�û���Ϣ
	 * @return	
	 */
	@RequestMapping(value = "/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Integer message = this.usersService.updateMessage(users);
			if (message > 0) {
				// ���ý��״̬Ϊ0
				rv.setCode(0);
				rv.setMessage("�û���Ϣ�޸ĳɹ���");
				// ����ResultValue�Ķ���
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û��޸���Ϣʧ�ܣ�");
		return rv;
	}
}
