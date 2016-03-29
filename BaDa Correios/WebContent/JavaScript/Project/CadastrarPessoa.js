$(document).ready(function() {
	
    $('#CidadeId').prop( "disabled", true );    
	
	$( "#EstadoId" ).change(function(event) {
		var Estado=$('#EstadoId').val();
			$.get('CadastrarPessoasGetCidades',{EstadoId:Estado},function(responseText) { 
				$('#CidadeId').html(responseText);         
				if(Estado != "0"){
					$('#CidadeId').prop( "disabled", false );
				}else{
					$('#CidadeId').prop( "disabled", true );
				}
			});			
    });
  
	
});