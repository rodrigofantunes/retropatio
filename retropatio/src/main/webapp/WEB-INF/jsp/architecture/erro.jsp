<c:if test="${!empty errors}">
	<script>
		$(document).ready(function(){
			<c:forEach var="error" items="${errors}">
				<c:if test="${error.category == 'erro'}">
					$("input").validaErros('${error.category}','${error.message}');
				</c:if>
				<c:if test="${error.category == 'login' || error.category == 'mensagem'}">
						mensagem('${error.message}');
				</c:if>
			</c:forEach>
			
		})
	</script>
</c:if>