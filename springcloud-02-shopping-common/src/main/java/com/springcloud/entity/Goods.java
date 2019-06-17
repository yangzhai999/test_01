package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GOODS���Ӧ��ʵ���࣬���ڱ�����Ʒ�����Ϣ
 * 
 * @author ��կ
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	/**
	 * ��Ʒ���
	 */
	private Integer goodsId;

	/**
	 * ��Ʒ����
	 */
	private String goodsName;

	/**
	 * ��Ʒ�۸�
	 */
	private Double goodsPrice;

	/**
	 * ��Ʒ�ۿۼ�
	 */
	private Double goodsDiscount;

	/**
	 * ��Ʒ״̬��0Ԥ�ۣ�1�����У�2���¼�
	 */
	private Integer goodsStatus;

	/**
	 * ��Ʒ����
	 */
	private Integer goodsNum;

	/**
	 * �Ƿ���Ʒ��0ʱ��Ʒ��1������Ʒ
	 */
	private Integer goodsNew;

	/**
	 * �Ƿ����� ��0ʱ������1��������
	 */
	private Integer goodsHot;

	/**
	 * ��Ʒ����0-4 5������
	 */
	private Integer goodsLevel;

	/**
	 * ��Ʒ���
	 */
	private String goodsDesc;

	/**
	 * ��Ʒ����
	 */
	private String goodsDetail;

	/**
	 * ��ƷͼƬ
	 */
	private String goodsImg;

	/**
	 * ��Ʒ���
	 */
	private Integer typeTwoId;

	/**
	 * ��ѯ��������Ʒ�۸������
	 */
	private Double goodsPriceMin;

	/**
	 * ��ѯ��������Ʒ�۸������
	 */
	private Double goodsPriceMax;

	/**
	 * ��ѯ������һ�������
	 */
	private Integer typeOneId;

	/**
	 * ��Ʒ���������ڱ���ͳ�Ʒ���Ľ��
	 */
	private Integer goodsSum;

}