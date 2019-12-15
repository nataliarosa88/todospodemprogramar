<%--
  Created by STS
  Author: Natalia Rosa
  Date: 08/07/19
  Time: 17:00
--%>
<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Everybody can code</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-default">
			<a href="main" class="navbar-brand">Everybody can code</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="login">Login</a></li>
					<li><a href="user">Programmers</a></li>
					<li><a href="findall">Employers [Hire us!]</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>

		<c:when test="${mode=='MODE_USER' }">
			<div class="container text-center" id="tasksDiv">
				<h3>${id }</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserName</th>
								<th>Name</th>
								<th>Experience</th>
								<th>Hobby</th>
								<th>Contact</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${user.id}</td>
								<td>${user.username}</td>
								<td>${user.name}</td>
								<td>${user.experience}</td>
								<td>${user.hobby}</td>
								<td>${user.contact}</td>
								<td><a href="delete?id=${user.id }"><span
										class="glyphicon glyphicon-trash"></span></a></td>
								<td><a href="edit?id=${user.id }"><span
										class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_ADMIN' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Users</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserName</th>
								<th>Name</th>
								<th>Experience</th>
								<th>Hobby</th>
								<th>Contact</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.username}</td>
									<td>${user.name}</td>
									<td>${user.experience}</td>
									<td>${user.hobby}</td>
									<td>${user.contact}</td>
									<td><a href="delete?id=${user.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="edit?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>


		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Everybody can code</h1>
					<h3>Everybody can code is an app that provides the connection
						between programmers with employers only by the technical and
						hobbies aspects.</h3>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<h2>For Programmers</h2>
							<h4>The programmer can register your profile, skills and
								hobbies to be visible to employers that are hiring people by
								your competence and hobbies not by other aspects</h4>
						</div>
						<div class="col-md-4">
							<h2>For Employers</h2>
							<h4>The employer will see a random list of programmers based
								on the employer location</h4>
						</div>
						<div class="col-md-4">
							<h2>For APIs</h2>
							<h4>Other apps can send a list of programmers with their
								acceptance via our API Rest. Test it with Postman.</h4>
							<code>http://todospodemprogramar.com.br:8080/app-beta/saveuser?username=yourusername...</code>
						</div>
					</div>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>Programmers</h3>
				<hr>
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
				<form class="form-horizontal" method="POST" action="users">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="name"
								value="${user.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Experience</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="experience"
								value="${user.experience }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Hobby </label>
						<div class="col-md-3">
							<input type="text" required class="form-control" name="hobby"
								value="${user.hobby }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Contact </label>
						<div class="col-md-3">
							<input type="text" required class="form-control" name="contact"
								value="${user.contact }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_USERS' }">

			<div class=" col-md-8 col-md-offset-2">
				<c:forEach var="user" items="${users }">

					<div class="col-md-3 ">
						<div class="panel panel-default panelSize">
							<div class="panel-heading text-center">
								<strong>${user.username}</strong>
							</div>
							<div class="panel-body">
								<div>
									<strong>Name:</strong> ${user.name}
								</div>
								<div>
									<strong>Experience:</strong> ${user.experience}
								</div>
								<div>
									<strong>Hobby:</strong> ${user.hobby}
								</div>
								<div>
									<strong>Contact:</strong> ${user.contact}
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="users">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="username"
								value="${user.username }" readonly="readonly" style="color: #787878;"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="name"
								value="${user.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Experience</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="experience"
								value="${user.experience }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Hobby </label>
						<div class="col-md-3">
							<input type="text" required class="form-control" name="hobby"
								value="${user.hobby }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Contact </label>
						<div class="col-md-3">
							<input type="text" required class="form-control" name="contact"
								value="${user.contact }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="findbyid">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" required class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>