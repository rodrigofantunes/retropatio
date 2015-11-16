<script src="${jsDir}/jquery.js"></script>
<script src="${jsDir}/material.min.js"></script>
<script src="${jsDir}/jquery.validate.js"></script>
<script src="${jsDir}/masked.input.js"></script>
<script src="${jsDir}/validation.js"></script>

<script>
	$(document).ready(function(){
		var local="${fn:split(fn:replace(fn:replace(pageContext.request.servletPath,'/WEB-INF/jsp/', ''),'.jsp',''),'/')[1]}"; 
		if(local.match(new RegExp(/cad|form/ig))){
			validaForm({
				verificaEmail:{	url : "<c:url value='/validation/verificaEmail' />"},
				verificaLogin:{	url : "<c:url value='/validation/verificaLogin' />"},
			});
		}else{
			validaForm();
		}
		
		$("[name='logoff'], .sair").click(function(){
			$("<form />",{
				method:"post",
				action: "<c:url value='/home/logout' />"
			}).submit();
		});
	})
</script>