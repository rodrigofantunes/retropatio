<div class="mdl-grid demo-content">
	<form action="<c:url value='/consulta' />" method="post" class="mdl-card mdl-cell--12-col mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color-text--grey-600">
				<h2 class="mdl-card__title-text"><fmt:message key="label.selecione.tipo.consulta"/></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<div class="group-input" style="margin-bottom: 25px;">
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1">
					  <input type="radio" id="option-1" class="mdl-radio__button" name="tipoPesquisa" value="1" checked>
					  <span class="mdl-radio__label"><fmt:message key="label.entrada"/></span>
					</label>
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
					  <input type="radio" id="option-2" class="mdl-radio__button" name="tipoPesquisa" value="2">
					  <span class="mdl-radio__label"><fmt:message key="label.saida"/></span>
					</label>
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-3">
					  <input type="radio" id="option-3" class="mdl-radio__button" name="tipoPesquisa" value="3">
					  <span class="mdl-radio__label"><fmt:message key="label.motorista"/></span>
					</label>
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-4">
					  <input type="radio" id="option-4" class="mdl-radio__button" name="tipoPesquisa" value="4">
					  <span class="mdl-radio__label"><fmt:message key="label.container"/></span>
					</label>
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-5">
					  <input type="radio" id="option-5" class="mdl-radio__button" name="tipoPesquisa" value="5">
					  <span class="mdl-radio__label"><fmt:message key="label.quadra"/></span>
					</label>
					<a href="javascript:formSubmit()" style="margin-top: -12px;" class="mdl-button mdl-js-button btnPadrao " data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.consultar"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
				</div>
				<div class="group-input">
					<div class="mdl-cell--4-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="consulta.dataInicial" id="consulta.dataInicial" placeholder="<fmt:message key="label.data.inicial"/>" value="${dataAtual}" />
					</div>
					<div class="mdl-cell--4-col margin-bottom-10">
						<input class="mdl-cell--12-col" type="text" name="consulta.dataFinal" id="consulta.dataFinal" placeholder="<fmt:message key="label.data.final"/>" value="${dataAtual}" />
					</div>
				</div>
			</div>
	</form>
<c:if test="!empty listaConsulta">
	<div class="mdl-card mdl-cell--12-col mdl-shadow--6dp" style="margin-top:10px">
			<div class="mdl-card__supporting-text">
				<table class="mdl-data-table mdl-js-data-table mdl-cell--12-col is-upgraded" data-upgraded=",MaterialDataTable" style="width: 100%; max-height:300px!important">
			  <thead>
			  <c:if test="${consulta.tipoPesquisa != 5}">
			    <tr>
			      <c:if test="${consulta.tipoPesquisa == 1}"><th><fmt:message key="label.data.entrada" /></th></c:if>
			      <c:if test="${consulta.tipoPesquisa == 2}"><th><fmt:message key="label.data.saida" /></th></c:if>
			      <th><fmt:message key="label.motorista" /></th>
			      <th><fmt:message key="label.caminhao" /> - <fmt:message key="label.placa" />s</th>
			      <th><fmt:message key="label.container" /> - <fmt:message key="label.container.tamanho" /></th>
			      <th><fmt:message key="label.quadra" /></th>
			      <th></th>
			    </tr>
			   </c:if>
			  </thead>
			  <tbody>
			  <c:forEach items="${listaConsulta}" var="consulta">
			  	<c:if test="${consulta.tipoPesquisa != 5}">
				  <tr class="">
				  	<c:if test="${consulta.tipoPesquisa == 1}"><td>${consulta.dataEntrada}</td></c:if>
				  	<c:if test="${consulta.tipoPesquisa == 2}"><td>${consulta.dataSaida}</td></c:if>
				  	<td>${consulta.motorista.pessoa.nome}</td>
				  	<td>${consulta.caminhao.placa1} - ${consulta.caminhao.placa2}</td>
				  	<td>${consulta.container.numero} - ${consulta.container.tamanho.tamanho}</td>
				  	<td>${consulta.quadra.letra}${consulta.quadra.numero}-F${consulta.quadra.fileira}-<c:if test="${consulta.quadra.altura == 0}" >Piso </c:if><c:if test="${consulta.quadra.altura > 0}" >A${consulta.quadra.numero}</c:if></td>
				  	<td></td>
				  </tr>
				 </c:if>
			  </c:forEach>
			  </tbody>
			</table>
			</div>
	</div>
</c:if>
</div>


