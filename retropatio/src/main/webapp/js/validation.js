function mensagem(msg){
	alert(msg);
}

$(document).ready(function() {
	
	$.fn.extend({
		validaErros:function(classe,msg){
			var input = $("[name='"+classe+"']");
			input.next().attr("class","erro").each(function(){
				this.remove();
			})
			var span = $("<span />",{
					id:classe+"-erro",
					text:msg,
					class:'erro'
				});
			span.insertAfter(input);
		},
		verificaEmail:function(url){
			var email = $(this);
			email.blur(function(){
				var retorno = "";
				var texto = "";
					$.post(url,	{'email' : email.val()},function(emUso){
						if(emailValido && emUso.length > 0){
							texto = "O email está em uso";
							validacaoEmail(texto,email);
						}else{
							erro.hide();
							email.removeClass("error").attr("aria-invalid",false);	
							return;
						}
					});
			});
		},
		verificaLogin:function(url){
			var login = $(this);
			login.blur(function(){
			$.post(url,
					{'login' : login.val()},
					function(emUso){
						if(emUso.length > 0){
							var erro = $("#" + login.prop("name") + "-error");
							if(erro.length <= 0){
								erro = $("<label />",{
									id: login.prop("name") + "-error",
									class:"error",
									"for":login.prop("name"),
								});
								erro.insertAfter(login);
							}
							$("[id='" + login.prop("name") + "-error']").remove();
							erro.insertAfter(login).show().text("O login está em uso");
							login.addClass("error").attr("aria-invalid",true);
						}
						else{
							erro.hide();
							login.removeClass("error").attr("aria-invalid",false);	
						}
			});
		});
	},
	});
	
validaForm({
	verificaEmail:{	url : "/retropatio/validation/verificaEmail"},
	verificaLogin:{	url : "/retropatio/validation/verificaLogin"},
});
	
function validacaoEmail(texto, email){
	var erro = $("#" + email.prop("name") + "-error");
	if(erro.length <= 0){
		erro = $("<label />",{
			id: email.prop("name") + "-error",
			class:"error",
			"for":email.prop("name"),
		});
	}
	$("[id='" + email.prop("name") + "-error']").remove();
	erro.insertAfter(email).show().text(texto);
	email.addClass("error").attr("aria-invalid",true);
}

function validaForm(options){
	
	 var settings = $.extend( {
	      'verificaEmail' : {'url':''},
	      'verificaLogin' : {'url':''},
	    }, options);
	
	var forms = $(document.forms);
	forms.each(function(){
		var form = $(this);
		form.validate();
		
		var nome = form.find("input[name*='nome']");
		if(nome.length){nome.rules("add",{required: true, minlength: 5, maxlength: 100 })}
		
		var login = form.find("input[name*='login']");
		if(login.length){
			login.rules("add",{required: true, minlength: 3, maxlength: 20});
			if(settings.verificaLogin.url.length > 0){
				login.verificaLogin(settings.verificaLogin.url);
			}
		}

		var senha = form.find("input[name*='senha']");
		if(senha.length){senha.rules("add",{required: true, minlength: 5, maxlength: 15 })}

		var repeteSenha = form.find("input[name*='repeteSenha']");
		if(repeteSenha.length){repeteSenha.rules("add",{required: true, minlength: 5, maxlength: 15 })}
		
		var dddTel = form.find("input[name*='dddTel']");
		if(dddTel.length){dddTel.rules("add",{required: true, maxlength:2, number:true })}
		
		var telefone = form.find("input[name*='telefone']");
		if(telefone.length){telefone.rules("add",{telefone: true})}
		
		var dddCel = form.find("input[name*='dddCel']");
		if(dddCel.length){dddCel.rules("add",{required: true, maxlength:2, number:true })}
		
		var celular = form.find("input[name*='celular']");
		if(celular.length){celular.rules("add",{telefone: true, messages:{ telefone	: "Por favor, um celular válido"}})}
		
		var nascimento = form.find("input[name*='nasc']");
		if(nascimento.length){nascimento.rules("add",{datePTBR: true})}
		
		var email = form.find("input[name*='email']");
		if(email.length){
			email.rules("add",{validaEmail: true})
			if(settings.verificaEmail.url.length > 0){
				email.verificaEmail(settings.verificaEmail.url);
			}
		}
		
	})
}

});


