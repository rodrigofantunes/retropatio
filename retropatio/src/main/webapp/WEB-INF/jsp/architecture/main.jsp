<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html lang="en">
	<%@ include file="/WEB-INF/jsp/architecture/head.jsp" %>
<body>

	<div id="topo">
		<ul id="menu">
			<li>Cadastrar</li>
			<li>Consultar</li>
			<li>Entradas</li>
			<li>Saidas</li>
			<li>
				Opções
				<ul>
					<li>Cadastrar Usuario</li>
					<li>Configurar Sistema</li>
				</ul>
			</li>
		</ul>	
	</div>

		<div id="content">
			<main>
				<decorator:body />
			</main>
		</div>
<%@ include file="/WEB-INF/jsp/architecture/jquery.jsp" %>
<%@ include file="/WEB-INF/jsp/architecture/erro.jsp" %>
</body>
</html>
