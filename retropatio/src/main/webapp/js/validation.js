function mensagem(msg){
	alert(msg);
}

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
			var br = $("<br />");
			br.insertAfter(input);
			span.insertAfter(br);
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


/** MODAL **/

var head = $("head");
var body = $("body");
var fundo = $(".bgModal").length > 0 ? $(".bgModal") : $("<div />",{class:'bgModal'});
var style = $("<style />",{
	id:"stModal",
	text:".bgModal{\n\tdisplay:none;\n\ttop:0px;\n\tleft:0px;\n\twidth:100%;\n\theight:100%;\n\tz-index:9997;\n\tposition:absolute;\n\tbackground-color:rgba(0, 0, 0, 0.5)!important\n\t}"
})

function Modal(opcoes){
   criarFundo();
   criarModal(opcoesModal(opcoes));
}

function opcoesModal(opcoes){
	var tipo = $.extend({
		titulo:"",
		msg:"",
		btns:false,
		tipobtn:""
   },opcoes);
	return tipo;
}

function criarFundo(){
	if(head.find(style).length == 0){head.append(style)}
	if(body.find(fundo).length == 0){body.append(fundo)}
}

function destroyModal(time){
	$("#modal").fadeOut(time > 0 ? time : 250, function(){ 
		$(this).remove()
		$(".bgModal, #stModal, #srcModal").fadeOut(time > 0 ? time : 350, function(){ 
			$(this).remove()
		});
	});
}

function criarModal(tipo){
	fundo.fadeIn(350, function(){
		if(tipo.titulo.length > 0 || tipo.msg.length > 0){
			var titulo = "";
			
			switch(tipo.titulo){
				case 'login':
					tipo.titulo = "Erro";
					break;
					
				case 'mensagem':
					tipo.titulo = "Atenção";
					break;
					
				default:
					tipo.titulo = "Aviso";
					break;
			}
			criaJanelaModal(tipo);	
		}
	});
}

function criaJanelaModal(tipo){
	
	/** Estrutura Janela Modal **/
	
	var corFundoPadrao = "#FFF";
	var corFontePadrao = corFundoPadrao;
	var corFundoTituloPadrao = "#16a085";
	var classe = 
	
	"\n.modal{\n\t" +
		"width:35%;\n\t" +
		"z-index:99999;\n\t" +
		"position:absolute;\n\t" + 
		"background-color:" + corFundoPadrao + ";\n\t" +
	    "border-radius: 2px;\n\t" +
	    "box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n" +
	"}";
			
	/** Titulo janela Modal **/
	classe += "\n.titleModal{\n\t" +
		"background-color:" + corFundoTituloPadrao + ";\n\t" +
		"color:" + corFontePadrao + ";\n\t" +
	    "padding: 10px 0px 0px 20px;\n" +
	    "height: 30px;\n" + 
	"}";
	
	/** Corpo Mensagem Modal **/
	classe += "\n.msgModal{\n\t" +
		"margin: 0 auto;\n\t" +
	    "padding: 25px;\n\t" +
	    "text-align: justify;\n" +
	"}";
	
	/** Botoes Modal **/
	classe += "\n.btnModal{\n\t" +
		"float:right;\n\t"+
	    "opacity: 0.8;\n\t" +
	    "box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n\t" +
	    "transition: 0.1s ease;\n\t" +
		"margin: 18px;\n\t" +
	    "width: 120px;\n\t" +
	    "height: 32px;\n\t" +
	    "background-color:"+ corFundoTituloPadrao + ";\n\t" +
	    "border: none;\n\t" +
	    "border-radius: 2px;\n\t" +
	    "color:" + corFontePadrao + ";\n\t" +
	    "font-family: 'Roboto', sans-serif;\n\t" +
	    "font-weight: 500;\n\t" +
	    "text-transform: uppercase;\n\t" +
	    "transition: 0.1s ease;\n\t" +
	    "cursor: pointer;\n\t" +
	"}";
	
	/** Botoes Modal Hover **/
	classe += "\n.btnModal:hover{\n\t" +
		"background-color:"+ corFundoPadrao + ";\n\t" +
		"color:" + corFundoTituloPadrao + ";\n\t" +
	"}";
	
	style.append(classe);
	
	var janelaPrincipal = $("<div />",{id:"modal",class:"modal"});
	
	var titleJP = $("<div />",{text:tipo.titulo, class:'titleModal'});
	var textoJP = $("<p />",{text:tipo.msg, class:'msgModal'});
	var btnOK; var btnSim; var btnNao; var btnCancelar;
	
	janelaPrincipal.append(titleJP).append(textoJP);
	if(tipo.btns){
		
	}else{
		btnOK = $("<button />",{text:"Ok", onclick:"destroyModal()", class:'btnModal'});
		janelaPrincipal.append(btnOK);
	}
	body.append(janelaPrincipal);
	janelaPrincipal.center();
	janelaPrincipal.fadeIn(250);
	
}

jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + 
                                                $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + 
                                                $(window).scrollLeft()) + "px");
    return this;
}

