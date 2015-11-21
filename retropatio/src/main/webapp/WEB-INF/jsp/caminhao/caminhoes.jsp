<div class="mdl-grid demo-content">
	<c:if test="${!empty listaCaminhoes}">
	<div class="demo-cards mdl-cell mdl-cell--12-col mdl-cell--12-col-tablet mdl-grid mdl-grid--no-spacing">
       <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
         <table class="mdl-data-table mdl-js-data-table mdl-cell--12-col is-upgraded" data-upgraded=",MaterialDataTable" style="width: 100%; max-height:300px!important">
			  <thead>
			    <tr>
			      <th><fmt:message key="label.caminhao" /> - <fmt:message key="label.placa" /></th>
			      <th><fmt:message key="label.carroceria" /> - <fmt:message key="label.placa" /></th>
			      <th><fmt:message key="label.empresa" /></th>
			      <th><fmt:message key="label.marca" /> - <fmt:message key="label.modelo" /></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listaCaminhoes}" var="caminhao">
				  <tr class="">
				  	<td>${caminhao.caminhao.placa1}</td>
				  	<td>${caminhao.caminhao.placa2}</td>
				  	<td>${caminhao.caminhao.empresa.nomeEmpresa}</td>
				  	<td>${caminhao.marca.nomeMarca} - ${caminhao.modelo.nomeModelo}</td>
				  	<td></td>
				  </tr>
			  </c:forEach>
			  </tbody>
			</table>
         <div class="mdl-card__actions mdl-card--border">
         <span class="mdl-card__supporting-text mdl-color-text--grey-600"><fmt:message key="label.caminhaos.cadastrados"/></span>
           <a href="<c:url value="/caminhao/cadastro" />" class="mdl-button mdl-js-button btnPadrao right" data-upgraded=",MaterialButton,MaterialRipple"><fmt:message key="label.cadastrar.caminhao"/><span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a>
         </div>
       </div>
     </div>
     </c:if>
</div>