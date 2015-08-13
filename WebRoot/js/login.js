/**   
 * @author lihailong
 * @date 2015-05-13
 * @Description: login js file.
 * @version 1.0   
 */

/**
 * 刷新验证码
 * 
 * @param img
 */
function refresh(img) {
	$(img).attr("src", "authImg?_" + new Date().getTime());
}