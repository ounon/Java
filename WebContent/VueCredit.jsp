<%@page import="web.CreditModel"%>
<%
	CreditModel model = (CreditModel)request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
	<title>Crédit bancaire</title>
	<meta charset="utf-8">
</head>
<body>
	<div>
		<form action="calculerMensialite.do" method="post">
			<table>
				<tr>
					<td> Montant: </td>
					<td><input type="text" name="montant" value="<%=model.getMontant()%>"/></td>
					<td>DH</td>
				</tr>
				<tr>
					<td> Taux: </td>
					<td><input type="text" name="taux" value="<%=model.getTaux()%>"/></td>
					<td>%</td>
				</tr>
				<tr>
					<td> Durée: </td>
					<td><input type="text" name="duree" value="<%=model.getDuree()%>"/></td>
					<td>mois</td>
				</tr>
			</table>
			<button type="submit">Calculer</button>
		</form>
	</div>
	<div>
		mensualite = <%=model.getMensualite()%>
	</div>
</body>
</html>