<div class="mdl-grid demo-content">
	<form action="<c:url value='/motorista/cadastrar' />" method="post" class="mdl-card mdl-cell--12-col mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color-text--grey-600">
				<h2 class="mdl-card__title-text"><fmt:message key="label.cadastrar.motorista"/></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<div class="group-input">
					<div class="mdl-cell--4-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="motorista.pessoa.cpf" id="motorista.pessoa.cpf" placeholder="<fmt:message key="label.cpf"/>" />
					</div>
					<div class="mdl-cell--4-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="motorista.pessoa.cnh" id="motorista.pessoa.cnh" placeholder="<fmt:message key="label.cnh"/>" />
					</div>
					<div class="mdl-cell--4-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="motorista.dataCadastro" id="motorista.dataCadastro" placeholder="<fmt:message key="label.data.cadastro"/>" value="${dataAtual}" />
					</div>
				</div>
				<div class="mdl-cell--12-col margin-bottom-10">
					<input class="mdl-cell--12-col" type="text" name="motorista.pessoa.nome" id="motorista.pessoa.nome" placeholder="<fmt:message key="label.nome"/>" />
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<a href="javascript:formSubmit()" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.salvar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
				<a href="javascript:limpaCampos()" class="mdl-button mdl-js-button btnPadrao btnPadraoCancelar right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.limpar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
			</div>
	</form>
</div>
