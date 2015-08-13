<%@include file="include/header.jsp"%>
<table width=780 align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
	<tr>
		<td colspan="3">请单击后面链接开始使用系统<a href="login.action">登录系统</a></td>
	</tr>
	<tr>
		<td colspan="3"><br>
			<p align="center">
				<span class="pt9">这仅仅是一个JavaEE的框架程序。应用模拟一个简单的工作流系统。系统包含两个角色，<br>
					普通员工的功能包括员工出勤打卡，员工的人事异动申请，员工查看工资单。<br>
					经理的功能包括管理部门员工，签核申请，每月工资自动结算等。
				</span>
			</p>
			<p align="center" class="pt9">
				应用模拟了简单的工作流，使用的轻量级J2EE架构。技术包括：Struts2.1,Spring2.5,Hibernate3.2<br>
				Quartz,整个应用使用Spring提供的DAO支持操作数据库,同时利用Spring的声明式事务。<br>
				程序中的权限检查使用Spring的AOP框架支持，也利用了Spring的任务调度抽象<br>
				Hibernate为底层的数据库访问提供支持,作为O/R Mapping框架使用。
			</p></td>
	</tr>
</table>
<%@include file="include/footer.jsp"%>
