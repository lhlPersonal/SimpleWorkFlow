<%@include file="../include/header.jsp"%>
<table width="780" border="0" align="center">
	<tr>
		<td><div align="center">
				<a href="employeePunch.action">打卡</a>
			</div></td>
		<td><div align="center">
				<a href="viewUnPunch.action">查看打卡异动</a>
			</div></td>
		<td><div align="center">
				<a href="viewemployeeSalary.action">查看历史工资</a>
			</div></td>
		<td><div align="center">
				<a href="logout.action">退出系统</a>
			</div></td>
	</tr>
</table>
<s:property value="#session.user" />
，欢迎您使用JavaEE简单工作流系统，您是普通员工
<%@include file="../include/footer.jsp"%>

