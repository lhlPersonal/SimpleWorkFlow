<%@include file="include/header.jsp"%>
<table width="780" align="center">
	<tr>
		<td>请输入用户名和密码来登录<br /> <s:if test="tip!=null">
				<div class="error">
					<s:property value="tip" />
				</div>
			</s:if> <s:actionerror cssClass="error" />
			<div align="center">
				<s:form action="processLogin">
					<s:textfield name="manager.name" label="用户名" />
					<s:textfield name="manager.pass" label="密码" />
					<s:textfield name="vercode" label="验证码" />
					<tr>
						<td colspan="2"><s:submit value="登录" theme="simple" /> <s:reset
								theme="simple" value="重填" /></td>
					</tr>
				</s:form>
			</div> 验证码：<img name="d" src="authImg">
		</td>
	</tr>
</table>
<%@include file="include/footer.jsp"%>