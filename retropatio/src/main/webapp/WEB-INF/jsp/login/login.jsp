<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html lang="en">
	<%@ include file="/WEB-INF/jsp/architecture/headLogin.jsp" %>
	<title>Retropátio | Login</title>
<body>
<div class="sombra"></div>
	<form action="<c:url value="/autenticar"/>" method="post" id="login-box">
	  <div class="left">
	    <h1>Retropátio - Login</h1>
	    
	    <input class="form-control" name="usuario.login" value="${usuario.login}" type="text" placeholder="Login">
	    <input class="form-control" name="usuario.senha" value="${usuario.senha}" type="password" placeholder="Senha">
	    <input type="submit" name="signup_submit" value="Logar" />
	  </div>
	</form>
	<%@ include file="/WEB-INF/jsp/architecture/jquery.jsp" %>
	<%@ include file="/WEB-INF/jsp/architecture/erro.jsp" %>
</body>
</html>

		
	