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
	
	//FORM CAD PALESTRA
	$("#cadPalestra").validate({
		rules:{
			nameEvent:{
				required: true,
				maxlength: 100,
			},
			amountVacancies:{
				required: true,
			},
			description:{
				required: true,
			},
			timeIni:{
				required: true,
				timeSpeaker:true,
				remote:{
					url: '/verificationTimeIni',
					type: "get",
					dataType: "json",
					data:{
						time: function()
	                      {
	                          return $('#timeIni').val();
	                      },
	                    room: function()
	                      {
	                    	return $('#sala').val();
	                      }
	
					}
				}
			},
			timeFim:{
				required: true,
				remote:{
					url: '/verificationTimeFim',
					type: "get",
					dataType: "json",
					data:{
						time: function()
	                      {
	                          return $('#timeFim').val();
	                      },
	                    room: function()
	                      {
	                    	return $('#sala').val();
	                      }
	
					}
				}
			},
			speaker:{
				required: true,
			},
			room:{
				required: true,
			},
			submitHandler: function(form){
				form.submit()
			}
			
		},
		messages:{
			nameEvent:{
				required:"Este campo é obrigatório.",
				maxlength: 100,
			},
			amountVacancies:{
				required: "Este campo é obrigatório.",
			},
			description:{
				required: "Este campo é obrigatório.",
			},
			timeIni:{
				required: "Este campo é obrigatório.",
				remote: "Este horario não esta disponivel para a sala selecionada!",
				timeSpeaker: "O palestrante informado já esta com este horario reservado!"
			},
			timeFim:{
				required: "Este campo é obrigatório.",
				remote: "Este horario não esta disponivel para a sala selecionada!"
			},
			speaker:{
				required: "Este campo é obrigatório.",
			},
			room:{
				required: "Este campo é obrigatório.",
			}
		}
				
	});
	
	jQuery.validator.addMethod("timeSpeaker", function(value, element) {
		   value = jQuery.trim(value);
		   var teste = true;
		   $.ajax({
                   type:'GET',
                   url:'/verificationTimeSpeaker',
                   async: false, 
                   dataType: "json",
                   data:{
                	   time: function()
	                      {
	                          return $('#timeIni').val();
	                      },
	                   palestrante: function()
	                      {
	                    	return $('#palestrante').val();
	                      }
                   }
		   }).done(function(retorno) {
	            if(retorno == true){
	            	teste = true;
	            }else{
	            	teste = false
	            }
	            
	       })
		   return teste;
		   

	}), "oiioio";
	
	//FORM CAD PALESTRA
	$("#formregister").validate({
		rules:{
			,
			timeIni:{
				remote:{
					type:'get',
		            url:'/verificationTimeIniUser',
		            dataType: "json",
		            data:{
		         	   time: function()
		                   {
		                       return $('#timeIni').val();
		                   },
		                   id:{
		                	   return $('#idUser').val();
		                   }
		            }
				}
			},
			submitHandler: function(form){
				form.submit()
			}
			
		},
		messages:{
			activity:{
				required: "e"
			},
			timeIni:{
				remote: "oio"
			}
		}
				
	});
});