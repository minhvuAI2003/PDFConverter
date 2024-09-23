<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="frame.css" rel="stylesheet">
<link href="frame2.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<!-- Font Awesome CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<!-- jQuery -->
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<!-- Bootstrap JS -->
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
<style>
.thongbao {
	margin-top: 320px;
	text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="index.jsp" class="navbar-brand">PDF Converter</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav navbar-right">
					<li><p class="navbar-text">Already have an account?</p></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">

										<form class="form" role="form" method="post"
											action="<%=request.getContextPath()%>/login"
											accept-charset="UTF-8" id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="exampleInputEmail2">Email
													address</label> <input type="email" class="form-control"
													id="exampleInputEmail2" placeholder="Email address"
													name="email" required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputPassword2">Password</label>
												<input type="password" class="form-control"
													id="exampleInputPassword2" placeholder="Password"
													name="password" required>

											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary btn-block">Sign
													in</button>
											</div>

										</form>
									</div>
									<div class="bottom text-center">
										New here ? <a href="registration.jsp"><b>Join Us</b></a>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="thongbao">
		<h3>
			Sorry, your email or password not found. Please <a href="login.jsp">log
				in</a> agian
		</h3>
	</div>
</body>
</html>