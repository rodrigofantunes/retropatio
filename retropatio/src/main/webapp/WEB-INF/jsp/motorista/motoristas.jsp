<div class="mdl-grid demo-content">
	<c:if test="${!empty listaMotoristas}">
	<div class="demo-cards mdl-cell mdl-cell--12-col mdl-cell--12-col-tablet mdl-grid mdl-grid--no-spacing">
       <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
         <table class="mdl-data-table mdl-js-data-table mdl-cell--12-col is-upgraded" data-upgraded=",MaterialDataTable" style="width: 100%; max-height:300px!important">
			  <thead>
			    <tr>
			      <th><fmt:message key="label.data.motorista" /></th>
			      <th><fmt:message key="label.motorista" /></th>
			      <th><fmt:message key="label.caminhao" /> - <fmt:message key="label.placa" />s</th>
			      <th><fmt:message key="label.container" /> - <fmt:message key="label.container.tamanho" /></th>
			      <th><fmt:message key="label.quadra" /></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listaMotoristas}" var="motorista">
				  <tr class="">
				  	<td>${motorista.dataEntrada}</td>
				  	<td>${motorista.motorista.pessoa.nome}</td>
				  	<td>${motorista.caminhao.placa1} - ${motorista.caminhao.placa2}</td>
				  	<td>${motorista.container.numero} - ${motorista.container.tamanho.tamanho}</td>
				  	<td>${motorista.quadra.letra}${motorista.quadra.numero}-F${motorista.quadra.fileira}-<c:if test="${motorista.quadra.altura == 0}" >Piso </c:if><c:if test="${motorista.quadra.altura > 0}" >A${motorista.quadra.numero}</c:if></td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
         <div class="mdl-card__actions mdl-card--border">
         <span class="mdl-card__supporting-text mdl-color-text--grey-600"><fmt:message key="label.motoristas.cadastrados"/></span>
           <a href="#" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.cadastrar.motorista"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
         </div>
       </div>
     </div>
     </c:if>
</div>