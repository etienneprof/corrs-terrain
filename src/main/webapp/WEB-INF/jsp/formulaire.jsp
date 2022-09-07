<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de terrain</title>
</head>
<body>
	<h1>Gestion d'un terrain</h1>
	<form method="post" action="gererTerrain">
		<input type="hidden" name="id" value="${terrain.id }"/>
		<div>
			<label for="surfaceT">Surface totale : </label>
			<input type="range" id="surfaceT" name="surfaceT" value="${terrain.surfaceTotale }" step=".1" min="1" max="1500" oninput="this.nextElementSibling.value=this.value" />
			<input type="number" step=".1" oninput="this.previousElementSibling.value=this.value"/>
		</div>
		<div>
			<label for="surfaceC">Surface constructible : </label>
			<input type="range" id="surfaceC" name="surfaceC" value="${terrain.surfaceConstructible }" step=".1" min="1" max="1500" oninput="this.nextElementSibling.value=this.value" />
			<input type="number" step=".1" oninput="this.previousElementSibling.value=this.value"/>
		</div>
		
		<select name="prop.id">
			<option value="0">Ajouter un proprietaire</option>
			<c:forEach items="${listeProprios }" var="current">
				<option value="${current.id}" ${current.id == terrain.proprietaire.id ? "selected" : ""}>${current.nom} ${current.prenom }</option>
			</c:forEach>
		</select>
		
		<div>
			<label for="prop.nom">Nom du proprietaire : </label>
			<input type="text" id="prop.nom" name="prop.nom" value="${terrain.proprietaire.nom }" />
		</div>
		<div>
			<label for="prop.prenom">Prenom du proprietaire : </label>
			<input type="text" id="prop.prenom" name="prop.prenom" value="${terrain.proprietaire.prenom }" />
		</div>
		<input type="submit" value="Enregistrer" />
	</form>
	<a href="accueil">Retour a l'accueil</a>
</body>
</html>