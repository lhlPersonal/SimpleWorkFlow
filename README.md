# SimpleWorkFlow

this project is a simple workflow system build by spring4.0.6 & struts2.3.16.3 & hibernate4.3.10 & Quartz.

structure module:mysql+DAO+Bean+Service+Action+JSP

roles:employee & manager.

functions of employee:

1.ϵͳ�Զ���¼Ա���ĳ��ڼ�¼�������ٵ������ˡ�������
2.Ա�����Բ鿴�������3��Ŀ��ڼ�¼��������ֲ�����������������룬ϵͳ�Զ�������ת��������
3.����ͨ����ˣ��������Զ���Ч�����Ŀ��ڼ�¼��
4.���Բ鿴�Լ��Ĺ��ʼ�¼��

functions of manager:

1.ǩ��Ա�������롣
2.�鿴����Ա����
3.�鿴Ա�����¹��ʡ�
4.����Ŀ��ڲ������롣(��)
5.������Ա����ͬ��

Quartz:an auto shedule framework of task and provide more functions than timer.

1.Ա��ÿ��Ŀ��ڼ�¼�������Զ����������¼��һ�������Ա����ɿ�������ĸü�¼��
2.���ʽ��㣺ÿ��3���Զ��������¹��ʡ�


tables:

employee & manager
salary
attend
attendType
application
checkback

class:

Employee:
id,name,password,salary,Manager,set<Payment>,set<Attend>

Manager(extends Employee):
set<Employee>,Set<CheckBack>


Payment:
id,total,month,Emoployee

Attend:
id,AttendType,Employee,Datetime

AttendType:
Enum(late,before,miss)

Application:
id,Employee,reason,AttendType,Datetime,isPass

CheckBack:
id,Application,Manager,allow





