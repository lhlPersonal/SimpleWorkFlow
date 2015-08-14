<%@include file="../include/header.jsp"%>
<table width="780" align="center">
	<tr>
		<td colspan="3"><br /> <br />
			<div class="mytitle">电子打卡系统</div></td>
	</tr>
	<tr>
		<td colspan="3" style="text-align : center;"><br /> <br /> <br />
			<s:if test="comeValid">
				<s:form action="employeeCome" theme="simple">
					<s:submit key="come.punch" />
				</s:form>
			</s:if>
			<s:if test="leaveValid">
				<s:form action="employeeLeave" theme="simple">
					<s:hidden value="leave" />
					<s:submit key="leave.punch" />
				</s:form>
			</s:if> <br />
			</div></td>
	</tr>
</table>
<%@include file="../include/footer.jsp"%>

