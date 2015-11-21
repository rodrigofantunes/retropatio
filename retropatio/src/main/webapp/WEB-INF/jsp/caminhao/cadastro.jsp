<div class="mdl-grid demo-content">
	<form action="<c:url value='/caminhao/cadastrar' />" method="post" class="mdl-card mdl-cell--12-col mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color-text--grey-600">
				<h2 class="mdl-card__title-text"><fmt:message key="label.cadastrar.caminhao"/></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<div class="group-input">
				<div class="mdl-cell--12-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="caminhao.empresa.nomeEmpresa" id="caminhao.empresa.nomeEmpresa" placeholder="<fmt:message key="label.nome.empresa"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="caminhao.placa1" id="caminhao.placa1" placeholder="<fmt:message key="label.placa1"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="caminhao.placa2" id="caminhao.placa2" placeholder="<fmt:message key="label.placa2"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="caminhao.marca.nomeMarca" id="caminhao.marca.nomeMarca" placeholder="<fmt:message key="label.marca"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="caminhao.modelo.nomeModelo" id="caminhao.modelo.nomeModelo" placeholder="<fmt:message key="label.modelo"/>" />
					</div>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<a href="javascript:formSubmit()" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.salvar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
				<a href="javascript:limpaCampos()" class="mdl-button mdl-js-button btnPadrao btnPadraoCancelar right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.limpar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
			</div>
	</form>
</div>

