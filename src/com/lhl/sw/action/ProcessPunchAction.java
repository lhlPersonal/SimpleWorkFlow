package com.lhl.sw.action;

import com.lhl.sw.action.base.EmpBaseAction;
import com.lhl.sw.util.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessPunchAction extends EmpBaseAction {
	private String tip;

	// tip���Ե�setter��getter����
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	// �����ϰ�򿨵ķ���
	public String come() throws Exception {
		return process(true);
	}

	// �����°�򿨵ķ���
	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean isCome) throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(Constant.USER);
		System.out.println("-----��----" + user);
		String dutyDay = new java.sql.Date(System.currentTimeMillis())
				.toString();
		// ����ҵ���߼��������������
		int result = mgr.punch(user, dutyDay, isCome);
		switch (result) {
//		case PUNCH_FAIL:
//			setTip("��ʧ��");
//			break;
//		case PUNCHED:
//			setTip("���Ѿ�����ˣ���Ҫ�ظ���");
//			break;
//		case PUNCH_SUCC:
//			setTip("�򿨳ɹ�");
//			break;
		}
		return SUCCESS;
	}
}