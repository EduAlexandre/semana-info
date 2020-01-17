jQuery.validator.addMethod("cpf", function(value, element) {
   value = jQuery.trim(value);

    value = value.replace('.','');
    value = value.replace('.','');
    cpf = value.replace('-','');
    while(cpf.length < 11) cpf = "0"+ cpf;
    var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
    var a = [];
    var b = new Number;
    var c = 11;
    for (i=0; i<11; i++){
        a[i] = cpf.charAt(i);
        if (i < 9) b += (a[i] * --c);
    }
    if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
    b = 0;
    c = 11;
    for (y=0; y<10; y++) b += (a[y] * c--);
    if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }

    var retorno = true;
    if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) retorno = false;

    return this.optional(element) || retorno;

}, "Informe um CPF válido");


$(document).ready(function(){
	
	//FORM USUARIO
	$("#cadUSer").validate({
		rules:{
			name:{
				required: true,
				maxlength: 100,
			},
			cpf:{
				cpf: true,
				required: true,
				minlength: 11,
				remote:{
					url: '/verificationCPF',
					type: "get",
					dataType: "json",
					data:{
						cpf: function()
	                      {
	                          return $('#cpf').val();
	                      }
					}
				}
			},
			email:{
				required: true,
				remote:{
					url: '/verificationEmail',
					type: "get",
					dataType: "json",
					data:{
						email: function()
	                      {
	                          return $('#email').val();
	                      }
	
					}
				}
			},
			senha:{
				required: true,
			},
			password:{
				required: true,
				equalTo: "#senha"
			},
			
			submitHandler: function(form){
				form.submit()
			}
			
		},
		messages:{
			name:{
				required: "Este campo é obrigatório.",
				maxlength: "O maximo de caracteres é 100",
			},
			cpf:{
				cpf: 'CPF inválido',
				required: "O campo cpf é obrigatório.",
				remote: "CPF informado já está vinculado a uma conta!"
				
			},
			email:{
				required: "Este campo é obrigatório.",
				remote: "Email informado já está vinculado a uma conta!",
			},
			senha:{
				required: "Este campo é obrigatório.",
			},
			password:{
				required: "O campo confirmação de senha é obrigatório.",
	            equalTo: "O campo confirmação de senha deve ser identico ao campo senha."
			}
		}
				
	});
	
	//FORM Login
	$("#log").validate({
		rules:{
			username:{
				required: true,
				maxlength: 100,
			},
			password:{
				required: true,
			},			
			submitHandler: function(form){
				form.submit()
			}
			
		},
		messages:{
			username:{
				required: "Este campo é obrigatório.",
				maxlength: "O maximo de caracteres é 100",
			},
			password:{
				required: "Este campo é obrigatório.",
			}
		}
				
	});
	
});