package com.springcloud.common;

import java.util.Date;

/**
 * �ļ��ϴ��Ĺ�����
 * 
 * @author ��կ
 *
 */
public class UploadUtils {
	/**
	 * ����µ��ļ����ƣ�������+��λ���������
	 * 
	 * @return �����µ��ļ�����
	 */
	public static String getFileName() {
		String fileName = null;

		// ���1-1000֮��������
		int num = (int) (Math.random() * 1000 + 1);

		// �����������Ϊ4λ
		String tempNum = "000" + num;
		tempNum = tempNum.substring(tempNum.length() - 4);

		// ��ú�����
		Date date = new Date();
		fileName = date.getTime() + tempNum;

		return fileName;
	}

	/**
	 * �����ļ�����չ��
	 * 
	 * @param fileName �ļ���
	 * @return �ɹ������ļ���չ�������򷵻�null
	 */
	public static String getExendedName(String fileName) {
		if (fileName == null || fileName.length() == 0) {
			return null;
		}
		// ����ļ����С����һ�γ��ֵ�λ��
		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return null;
		}
		return fileName.substring(index);
	}

//	�ж�ͼƬ�ĺ�׺��
//	public static void main(String[] args) {
//		System.out.println(getExendedName("sadfas.asdas.jpg"));
//	}
//	

//	��ȡ���ֵĳ���
//	public static void main(String[] args) {
//		for(int i =0;i < 5 ; i++)
//		System.out.println(getFileName());
//	}
}