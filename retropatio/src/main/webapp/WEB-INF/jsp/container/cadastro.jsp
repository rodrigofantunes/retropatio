<div class="mdl-grid demo-content">
	<form action="<c:url value='/container/cadastrar' />" method="post" class="mdl-card mdl-cell--12-col mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color-text--grey-600">
				<h2 class="mdl-card__title-text"><fmt:message key="label.cadastrar.container"/></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<div class="group-input">
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="container.numero" id="container.numero" placeholder="<fmt:message key="label.numero"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<select name="container.armador.id" class="mdl-select__input mdl-cell--12-col">
							<option value="0">Selecione um armador</option>
							<option value="2">Teste 1</option>
							<option value="4">Teste 2</option>
							<option value="5">Teste 3</option>
<%-- 							<c:forEach items="${listaArmadores}" var="armador">   --%>
<%-- 						        <option value="${armador.id}">${armador.nomeArmador}</option>   --%>
<%-- 						    </c:forEach>  --%>
						</select>
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<select name="container.tamanho.id" class="mdl-select__input mdl-cell--12-col">
							<option value="0">Selecione o Tamanho</option>
							<option value="1">Teste 1</option>
							<option value="3">Teste 2</option>
							<option value="4">Teste 3</option>
<%-- 							<c:forEach items="${listaTamanhoContainer}" var="tamanho">   --%>
<%-- 						        <option value="${tamanho.id}">${tamanho.tamanho}</option>   --%>
<%-- 						    </c:forEach>  --%>
						</select>
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<select name="container.modelo.id" class="mdl-select__input mdl-cell--12-col">
							<option value="0">Selecione o Modelo</option>
							<option value="1">Teste 1</option>
							<option value="2">Teste 2</option>
							<option value="3">Teste 3</option>
<%-- 							<c:forEach items="${listaModeloContainer}" var="modelo">   --%>
<%-- 						        <option value="${modelo.id}">${modelo.nomeModelo}</option>   --%>
<%-- 						    </c:forEach>  --%>
						</select>
					</div>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<a href="javascript:formSubmit()" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.salvar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
				<a href="javascript:limpaCampos()" class="mdl-button mdl-js-button btnPadrao btnPadraoCancelar right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.limpar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
			</div>
	</form>
</div>

