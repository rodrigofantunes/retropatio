<div class="mdl-grid demo-content">
	<c:if test="${!empty listaEntradas}">
	<div class="demo-cards mdl-cell mdl-cell--12-col mdl-cell--12-col-tablet mdl-grid mdl-grid--no-spacing">
       <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
         <table class="mdl-data-table mdl-js-data-table mdl-cell--12-col is-upgraded" data-upgraded=",MaterialDataTable" style="width: 100%; max-height:300px!important">
			  <thead>
			    <tr>
			      <th><fmt:message key="label.data.entrada" /></th>
			      <th><fmt:message key="label.motorista" /></th>
			      <th><fmt:message key="label.caminhao" /> - <fmt:message key="label.placa" />s</th>
			      <th><fmt:message key="label.container" /> - <fmt:message key="label.container.tamanho" /></th>
			      <th><fmt:message key="label.quadra" /></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listaEntradas}" var="entrada">
				  <tr class="">
				  	<td>${entrada.dataEntrada}</td>
				  	<td>${entrada.motorista.pessoa.nome}</td>
				  	<td>${entrada.caminhao.placa1} - ${entrada.caminhao.placa2}</td>
				  	<td>${entrada.container.numero} - ${entrada.container.tamanho.tamanho}</td>
				  	<td>${entrada.quadra.letra}${entrada.quadra.numero}-F${entrada.quadra.fileira}-<c:if test="${entrada.quadra.altura == 0}" >Piso </c:if><c:if test="${entrada.quadra.altura > 0}" >A${entrada.quadra.numero}</c:if></td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
         <div class="mdl-card__actions mdl-card--border">
         <span class="mdl-card__supporting-text mdl-color-text--grey-600"><fmt:message key="label.ultimas.entradas"/></span>
           <a href="#" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.cadastrar.entrada"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
         </div>
       </div>
     </div>
     </c:if>
     <c:if test="${!empty listaSaidas}">
     <div class="demo-cards mdl-cell mdl-cell--12-col mdl-cell--12-col-tablet mdl-grid mdl-grid--no-spacing">
       <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
         <table class="mdl-data-table mdl-js-data-table mdl-cell--12-col is-upgraded" data-upgraded=",MaterialDataTable" style="width: 100%; max-height:300px!important">
			  <thead>
			    <tr>
			      <th><fmt:message key="label.data.saida" /></th>
			      <th><fmt:message key="label.motorista" /></th>
			      <th><fmt:message key="label.caminhao" /> - <fmt:message key="label.placa" />s</th>
			      <th><fmt:message key="label.container" /> - <fmt:message key="label.container.tamanho" /></th>
			      <th><fmt:message key="label.quadra" /></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listaSaidas}" var="saida" >
				  <tr class="">
				  	<td>${saida.dataSaida}</td>
				  	<td>${saida.motorista.pessoa.nome}</td>
				  	<td>${saida.caminhao.placa1} - ${saida.caminhao.placa2}</td>
				  	<td>${saida.container.numero} - ${saida.container.tamanho.tamanho}</td>
				  	<td>${saida.quadra.letra}${saida.quadra.numero}-F${saida.quadra.fileira}-<c:if test="${saida.quadra.altura == 0}" >Piso </c:if><c:if test="${saida.quadra.altura > 0}" >A${saida.quadra.numero}</c:if></td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
	         <div class="mdl-card__actions mdl-card--border">
	           <span class="mdl-card__supporting-text mdl-color-text--grey-600"><fmt:message key="label.ultimas.saidas"/></span>
	           <a href="#" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.cadastrar.saida"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
	         </div>
       </div>
     </div>
     </c:if>
</div>