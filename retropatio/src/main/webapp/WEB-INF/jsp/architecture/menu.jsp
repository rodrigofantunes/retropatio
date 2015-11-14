<nav class="demo-navigation mdl-navigation">
	
	<c:if test="${sessaoLogada.perfil.acessoEntrada}">
<a class="mdl-navigation__link" href='<c:url value="/jsp/index.htm" />'><i class="material-icons" role="presentation">&#xE0B2;</i><fmt:message key="label.registrar.entrada" /></a>
	</c:if>
	
	<c:if test="${sessaoLogada.perfil.acessoSaida}">
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE0B5;</i><fmt:message key="label.registrar.saida" /></a>
	</c:if>
	
	<c:if test="${sessaoLogada.perfil.acessoCadastro}">
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE87C;</i><fmt:message key="label.cadastrar.motorista" /></a>
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE558;</i><fmt:message key="label.cadastrar.caminhao" /></a>
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE42B;</i><fmt:message key="label.cadastrar.container" /></a>
	</c:if>
	
	<c:if test="${sessaoLogada.perfil.acessoConsulta}">
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE8FF;</i><fmt:message key="label.consultas" /></a>
	</c:if>
	
	<c:if test="${sessaoLogada.perfil.acessoRelatorio}">
	<a class="mdl-navigation__link" href=""><i class="material-icons" role="presentation">&#xE8D2;</i><fmt:message key="label.relatorios" /></a>
	</c:if>
	
</nav>
