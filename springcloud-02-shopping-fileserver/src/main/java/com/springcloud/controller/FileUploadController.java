package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	// ��application.properties�ļ��л��ָ������ֵ������ֵ����Ӧ�ĳ�Ա����
	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	/**
	 * �ϴ��û�ͷ��
	 * 
	 * @param file ͷ��ͼƬ
	 * @return
	 */
	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userImage") MultipartFile file) {
		ResultValue rv = new ResultValue();

		// �ϴ��ļ�
		try {
			Map<String, Object> map = this.fileUpload(file, userPath);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				rv.setMessage("�û�ͷ���ϴ��ɹ���");
				return rv;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�ͷ���ϴ�ʧ�ܣ�");
		return rv;
	}

	/**
	 * �ϴ��û�ͷ��
	 * 
	 * @param file ͷ��ͼƬ
	 * @return
	 */
	@RequestMapping(value = "/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		ResultValue rv = new ResultValue();

		// �ϴ��ļ�
		try {
			Map<String, Object> map = this.fileUpload(file, goodsPath);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				rv.setMessage("��ƷͼƬ�ϴ��ɹ���");
				return rv;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ƷͼƬ�ϴ�ʧ�ܣ�");
		return rv;
	}
	
	/**
	 * ɾ����ƷͼƬ
	 * @return
	 */
	@RequestMapping(value="/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg")String goodsImg) {
		ResultValue rv = new ResultValue();
		try {
			//��URL�л����ƷͼƬ������
			int indexOf=goodsImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = goodsImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
				if(file.exists()) {
					if(file.isFile()) {
						file.delete();						
						rv.setCode(0);
						return rv;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	/**
	 * �ϴ��ļ�
	 * 
	 * @param file �ϴ����ļ���
	 * @param path �ϴ��ļ���·��
	 * @return ʧ�ܷ���null
	 * @throws IOException
	 */
	private Map<String, Object> fileUpload(MultipartFile file, String path) throws IOException {
		Map<String, Object> map = null;

		// ����µ��ļ���
		String fileName = UploadUtils.getFileName();
		// �����ϴ����ļ�����ȡ�ļ�����չ��
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
		// �ϴ��ļ�
		// 1�����ļ�ת��Ϊ�ֽ����͵�����
		byte[] bytes = file.getBytes();
		// 2.����File��Ķ��������ļ����ϴ�·�����ļ���
		File saveFile = new File(path + fileName + extendedName);
		// 3.�ϴ��ļ�
		FileCopyUtils.copy(bytes, saveFile);

		map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);

		return map;
	}
	
	/**
	 * ɾ���û�ͷ��ͼƬ
	 * @return
	 */
	@RequestMapping(value="/deleteUserImg")
	public ResultValue deleteUserImg(@RequestParam("userImg")String userImg) {
		ResultValue rv = new ResultValue();
		try {
			//��URL�л����ƷͼƬ������
			int indexOf=userImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = userImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
				if(file.exists()) {
					if(file.isFile()) {
						file.delete();						
						rv.setCode(0);
						return rv;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
}