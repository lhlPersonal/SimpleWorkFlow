<%@include file="../include/header.jsp"%>
<div align="center">
	<s:form action="processAdd">
		<s:textfield name="emp.name" label="员工用户名" />
		<s:textfield name="emp.password" label="员工密码" />
		<s:textfield name="emp.salary" label="员工月薪" />
		<s:token />

		<s:submit value="添加新员工" theme="simple" />
		<s:reset theme="simple" value="重新输入" />

	</s:form>
</div>
<%@include file="../include/footer.jsp"%>
