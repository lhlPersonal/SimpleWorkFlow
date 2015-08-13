<%@include file="include/header.jsp"%>
<div align="center">
	<s:form action="processLogin">
		<ul>
			<li><s:textfield name="manager.name" label="用户名" /> <s:textfield
					name="manager.password" label="密码" /> <s:textfield name="vercode"
					label="验证码" /></li>
			<li><img name="d" src="authImg" onclick="refresh(this)"></li>
			<li><s:submit value="登录" theme="simple" /> <s:reset
					theme="simple" value="重填" /></li>
		</ul>
	</s:form>
</div>

<%@include file="include/footer.jsp"%>
<script type="text/javascript" src="js/login.js"></script>
