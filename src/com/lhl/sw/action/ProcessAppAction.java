package com.lhl.sw.action;

import com.lhl.sw.action.base.EmpBaseAction;

public class ProcessAppAction
	extends EmpBaseAction
{
	//�����춯�ĳ���ID
	private int attId;
	//ϣ��ı䵽��������
	private int typeId;
	//��������
	private String reason;
	//������
	private String tip;
	//attId���Ե�setter��getter����
	public void setAttId(int attId)
	{
		this.attId = attId;
	}
	public int getAttId()
	{
		return this.attId;
	}

	//typeId���Ե�setter��getter����
	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}
	public int getTypeId()
	{
		return this.typeId;
	}

	//reason���Ե�setter��getter����
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public String getReason()
	{
		return this.reason;
	}

	//tip���Ե�setter��getter����
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	//�����û�����
	public String execute()
		throws Exception
	{
		//�����춯����
		boolean result = mgr.addApplication(attId , 
			typeId , reason);
		//�������ɹ�
		if (result)
		{
			setTip("���Ѿ�����ɹ����ȴ�������");
		}
		else
		{
			setTip("����ʧ�ܣ���ע�ⲻҪ�ظ�����");
		}
		return SUCCESS;
	}
}