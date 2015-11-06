<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html lang="en">
	<%@ include file="/WEB-INF/jsp/architecture/head.jsp" %>
<body>
<div class="demo-layout mdl-layout mdl-js-layout">
    <header class="demo-header mdl-layout__header mdl-color--green mdl-color--grey-100 mdl-color-text--white">
                          <div class="mdl-layout__header-row">
                                       <span class="mdl-layout-title">Menu</span>
                                       <div class="mdl-layout-spacer"></div>
                                       <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                                                    <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                                                                 <i class="material-icons">Pesquisar</i>
                                                    </label>
                                                    <div class="mdl-textfield__expandable-holder">
                                                                 <input class="mdl-textfield__input" type="text" id="search" />
                                                                 <label class="mdl-textfield__label mdl-color--grey-100" for="search">Pesquisa</label>
                                                    </div>
                                       </div>
                                       <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                                                    <i class="material-icons">more_vert</i>
                                       </button>
                                       <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                                                    <li class="mdl-menu__item"><i class="material-icons">perm_data_setting</i>Configurações</li>
                                                    <li class="mdl-menu__item"><i class="material-icons">account_box</i>Meus Dados</li>
                                                    <li class="mdl-menu__item sair"><i class="material-icons">exit_to_app</i>Sair do Sistema</li>
                                       </ul>
                          </div>
             </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--green mdl-color-text--white">
	    <header class="demo-drawer-header">
	        <div class="demo-avatar-background">
	            <img src="${imagens}/user.jpg" class="demo-avatar">
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

	<main class="mdl-layout__content">
			<decorator:body />
	</main>
</div>
	<%@ include file="/WEB-INF/jsp/architecture/jquery.jsp" %>
	<%@ include file="/WEB-INF/jsp/architecture/erro.jsp" %>
</body>
</html>
