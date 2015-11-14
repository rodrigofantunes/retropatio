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
			  <c:forEach var="entrada" items="${listaEntradas}">
				  <tr class="">
				  	<td>${entrada.dataEntrada}</td>
				  	<td>${entrada.motorista.pessoa.nome}</td>
				  	<td>${entrada.caminhao.placa1} - ${entrada.caminhao.placa2}</td>
				  	<td>${entrada.container.numero} - ${entrada.container.tamanho.tamanho}</td>
				  	<td>${entrada.quadra.letra}${entrada.quadra.numero}-F${entrada.quadra.fileira}-${entrada.quadra.altura == 0 ? 'Piso' : 'A' + entrada.quadra.numero}</td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
         <div class="mdl-card__supporting-text mdl-color-text--grey-600">
           <fmt:message key="label.5.ultimas.entradas"/>
         </div>
         <div class="mdl-card__actions mdl-card--border">
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
			  <c:forEach var="saida" items="${listaSaidas}">
				  <tr class="">
				  	<td>${Saida.dataSaida}</td>
				  	<td>${Saida.motorista.pessoa.nome}</td>
				  	<td>${Saida.caminhao.placa1} - ${Saida.caminhao.placa2}</td>
				  	<td>${Saida.container.numero} - ${Saida.container.tamanho.tamanho}</td>
				  	<td>${Saida.quadra.letra}${Saida.quadra.numero}-F${Saida.quadra.fileira}-${Saida.quadra.altura == 0 ? 'Piso' : 'A' + entrada.quadra.numero}</td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
         <div class="mdl-card__supporting-text mdl-color-text--grey-600">
           <fmt:message key="label.5.ultimas.saidas"/>
         </div>
         <div class="mdl-card__actions mdl-card--border">
           <a href="#" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.cadastrar.saida"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
         </div>
       </div>
     </div>
     </c:if>
</div>