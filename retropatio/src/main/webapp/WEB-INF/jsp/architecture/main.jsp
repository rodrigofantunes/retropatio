<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html lang="en">
	<%@ include file="/WEB-INF/jsp/architecture/head.jsp" %>
	<title>Retropátio</title>
<body>
<div class="demo-layout mdl-layout mdl-js-layout">
    <header class="demo-header mdl-layout__header mdl-color--green mdl-color--grey-100 mdl-color-text--white">
                          <div class="mdl-layout__header-row">
                                       <span class="mdl-layout-title">Retropátio</span>
                                       <div class="mdl-layout-spacer"></div>
                                       <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                                                    <i class="material-icons">more_vert</i>
                                       </button>
                                       <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                                       			<c:if test="${sessaoLogada.usuario.perfil.acessoConfiguracao}">
                                                    <li class="mdl-menu__item"><i class="material-icons">perm_data_setting</i>Configurações</li>
                                                </c:if>    
                                                    <li class="mdl-menu__item"><i class="material-icons">account_box</i>Meus Dados</li>
                                                    <li class="mdl-menu__item sair"><i class="material-icons">exit_to_app</i>Sair do Sistema</li>
                                       </ul>
                          </div>
             </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--green mdl-color-text--white">
	    <header class="demo-drawer-header">
	        <div class="demo-avatar-background">
	        	<i class="material-icons demo-avatar" style="font-size: 3.3em;">&#xE851;</i>
	            <div class="demo-nome-botoes-user">
                	<span class="demo-nome-user">${sessaoLogada.nome}
                		<a class="demo-botoes-avatar mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon sair" href="javascript:void(0);" >
	                		<i class="material-icons">exit_to_app</i>
	                	</a>
                	</span>
	                
	            </div>
	        </div>
	    </header>
	<%@ include file="/WEB-INF/jsp/architecture/menu.jsp" %>
	</div>

	<div class="mdl-layout__content back-color">
			<decorator:body />
	</div>
</div>
	<%@ include file="/WEB-INF/jsp/architecture/jquery.jsp" %>
	<%@ include file="/WEB-INF/jsp/architecture/erro.jsp" %>
</body>
</html>
