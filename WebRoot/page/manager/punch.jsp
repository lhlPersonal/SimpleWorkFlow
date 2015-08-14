<%@include file="../include/header.jsp"%>
<table width="780" align="center">
	<tr>
		<td colspan="3"><br> <br>
			<div class="mytitle">电子打卡系统</div></td>
	</tr>
	<tr>
		<td colspan="3"><br> <br> <br> <!-- 当punchIsValid为1、3时，可上班打卡 -->
			<s:if test="punchIsValid==1 
	|| punchIsValid==3">
				<s:form action="managerCome">
					<s:submit key="come.punch" />
				</s:form>
			</s:if> <br> <br> <br></td>
	</tr>
	<tr>
		<td colspan="3">
			<!-- 当punchIsValid为2、3时，可下班打卡 --> <s:if
				test="punchIsValid==2
	|| punchIsValid==3">
				<s:form action="managerLeave">
					<s:submit key="leave.punch" />
				</s:form>
			</s:if> <br>
		</td>
	</tr>
</TABLE>
<%@include file="../include/footer.jsp"%>

