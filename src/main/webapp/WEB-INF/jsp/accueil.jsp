<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Liste des terrains</h1>
	<div>
		<h2>Filtres</h2>
		<!-- Formulaire pour appliquer des filtres -->
		<form method="get" action="accueil">
			<div>
				<label for="surface.min">Surface minimum : </label>
				<input type="number" step=".1" name="surface.min" id="surface.min" />
			</div>
			<div>
				<label for="surface.max">Surface maximum : </label>
				<input type="number" step=".1" name="surface.max" id="surface.max" />
			</div>
			<div>
				<label for="proprio.nom">Nom du proprietaire : </label>
				<input type="text" name="proprio.nom" id="proprio.nom" />
			</div>
			<input type="submit" value="Filtrer" />
		</form>
		
		<!-- Formulaire pour appliquer des tris -->
		<form method="get" action="accueil">
			<select name="tri">
				<option value="surface.totale">Surface totale</option>
				<option value="surface.cons">Surface constructible</option>
				<option value="proprio.nom">Nom de proprietaire</option>
			</select>
			<input type="submit" value="Trier" />
		</form>
	</div>
	
	<c:forEach var="current" items="${listeTerrains }">
		<div>
			<p>${current.surfaceTotale }</p>
			<p>${current.surfaceConstructible }</p>
			<p>${current.proprietaire.nom } - ${current.proprietaire.prenom }</p>
			<form method="get" action="gererTerrain">
				<input type="hidden" name="id" value="${current.id }" />
				<input type="submit" value="Modifier le terrain" />
			</form>
		</div>
		<hr>
	</c:forEach>
	<form method="get" action="gererTerrain">
		<input type="submit" value="Ajouter un terrain" />
	</form>
</body>
</html>