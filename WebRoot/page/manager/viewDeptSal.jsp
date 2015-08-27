<%@include file="../include/header.jsp"%>

<table width=80% border=0 align="center" cellspacing="1"
	bgcolor="#cccccc">
	<tr bgcolor="#e1e1e1">
		<td colspan="5"><div class="mytitle">您正在查看上个月部门的全部工资</div></td>
	</tr>
	<tr class="pt9" height="30">
		<td><b>员工名</b></td>
		<td><b>薪水</b></td>
	</tr>
	<s:iterator value="sals" status="index">
		<s:if test="#index.odd == true">
			<tr style="background-color:#dddddd" class="pt9" height="24">
		</s:if>
		<s:else>
			<tr class="pt9" height="24">
		</s:else>
		<td><s:property value="empName" /></td>
		<td><s:property value="amount" /></td>
		</tr>
	</s:iterator>
</table>

<%@include file="../include/footer.jsp"%>