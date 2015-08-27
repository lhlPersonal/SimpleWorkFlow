<%@include file="../include/header.jsp"%>
<table width="780" border="0" align="center" cellpadding=0
	cellspacing="1" bgcolor="#CCCCCC">
	<tr bgcolor="#e1e1e1">
		<td colspan="5"><div class="mytitle">
				当前用户：
				<s:property value="#session.user" />
			</div></td>
	</tr>
	<tr class="pt9" height="30">
		<td><b>发薪月份</b></td>
		<td><b>薪水</b></td>
	</tr>
	<s:iterator value="salarys" status="index">
		<s:if test="#index.odd == true">
			<tr style="background-color:#cccccc" class="pt9" height="24">
		</s:if>
		<s:else>
			<tr class="pt9" height="24">
		</s:else>
		<td><s:property value="payMonth" /></td>
		<td><s:property value="amount" /></td>
		</tr>
	</s:iterator>
</table>
<%@include file="../include/footer.jsp"%>
