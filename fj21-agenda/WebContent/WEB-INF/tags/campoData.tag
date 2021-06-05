<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="label" required="true" description="Label do campo" %>
<%@ attribute name="id" required="true" description="Id do campo" %>

<label>${label}</label> 
<input type="text" name="${id}" id="${id}" autocomplete="none"/><br />
		
<script type="text/javascript">
	$("#${id}").datepicker({
		dateFormat: 'dd/mm/yy',
	 	dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
	    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	    nextText: 'Próximo',
	    prevText: 'Anterior'
	});
</script>