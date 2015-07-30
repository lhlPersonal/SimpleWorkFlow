# SimpleWorkFlow

this project is a simple workflow system build by spring4.0.6 & struts2.3.16.3 & hibernate4.3.10 & Quartz.

structure module:mysql+DAO+Bean+Service+Action+JSP

roles:employee & manager.

functions of employee:

1.系统自动记录员工的出勤记录，包含迟到、早退、旷工。
2.员工可以查看本人最近3天的考勤记录，如果发现不符，则向经理提出申请，系统自动将申请转交给经理。
3.经理通过审核，则申请自动生效，更改考勤记录。
4.可以查看自己的工资记录。

functions of manager:

1.签核员工的申请。
2.查看新增员工。
3.查看员工上月工资。
4.经理的考勤不能申请。(简化)
5.其它与员工相同。

Quartz:an auto shedule framework of task and provide more functions than timer.

1.员工每天的考勤记录：早晚自动插入旷工记录各一条，如果员工完成考勤则更改该记录。
2.工资结算：每月3日自动结算上月工资。


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





