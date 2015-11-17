<div class="mdl-grid demo-content">
	<form action="<c:url value='/container/cadastrar' />" method="post" class="mdl-card mdl-cell--12-col mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color-text--grey-600">
				<h2 class="mdl-card__title-text"><fmt:message key="label.cadastrar.saida"/></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<div class="group-input">
					<div class="mdl-cell--3-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.container.numero" id="entrada.container.numero" placeholder="<fmt:message key="label.numero"/>" />
					</div>
					<div class="mdl-cell--2-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" placeholder="<fmt:message key="label.tamanho"/>" value="${saidaTamanhoContainer}" readonly />
					</div>
					<div class="mdl-cell--2-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" placeholder="<fmt:message key="label.modelo"/>" value="${saidaModeloContainer}" readonly />
					</div>
					<div class="mdl-cell--3-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" placeholder="<fmt:message key="label.armador"/>" value="${saidaArmador}" readonly />
					</div>
					<div class="mdl-cell--2-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" placeholder="<fmt:message key="label.quadra"/>" value="${saidaQuadra}" readonly />
					</div>
				</div>
				<div class="group-input">
					<div class="mdl-cell--4-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" name="entrada.motorista.pessoa.cpf" id="entrada.motorista.pessoa.cpf" placeholder="<fmt:message key="label.cpf"/>" />
					</div>
					<div class="mdl-cell--4-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" name="entrada.motorista.pessoa.cnh" id="entrada.motorista.pessoa.cnh" placeholder="<fmt:message key="label.cnh"/>" />
					</div>
					<div class="mdl-cell--4-col margin-bottom-10" style="margin-right: 5px;">
						<input class="mdl-cell--12-col" type="text" name="entrada.motorista.dataCadastro" id="entrada.motorista.dataCadastro" placeholder="<fmt:message key="label.data.cadastro"/>" value="${dataAtual}" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.motorista.pessoa.nome" id="entrada.motorista.pessoa.nome" placeholder="<fmt:message key="label.nome"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.caminhao.empresa.nomeEmpresa" id="entrada.caminhao.empresa.nomeEmpresa" placeholder="<fmt:message key="label.nome.empresa"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.caminhao.placa1" id="entrada.caminhao.placa1" placeholder="<fmt:message key="label.placa1"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.caminhao.placa2" id="entrada.caminhao.placa2" placeholder="<fmt:message key="label.placa2"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.caminhao.marca.nomeMarca" id="entrada.caminhao.marca.nomeMarca" placeholder="<fmt:message key="label.marca"/>" />
					</div>
					<div class="mdl-cell--6-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="entrada.caminhao.modelo.nomeModelo" id="entrada.caminhao.modelo.nomeModelo" placeholder="<fmt:message key="label.modelo"/>" />
					</div>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<a href="javascript:formSubmit()" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.salvar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
				<a href="javascript:limpaCampos()" class="mdl-button mdl-js-button btnPadrao btnPadraoCancelar right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.limpar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
			</div>
	</form>
</div>

