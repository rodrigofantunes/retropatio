<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/jsp/architecture/head.jsp" %>
	<title>Login || <fmt:message key="label.nome.app" /></title>
	<style type="text/css">
		body {
			padding-top: 56px;
			padding-bottom: 69px;
		}
	</style>
</head>
<body class="avoid-fout">
	<div class="avoid-fout-indicator avoid-fout-indicator-fixed">
		<div class="progress-circular progress-circular-alt progress-circular-center">
			<div class="progress-circular-wrapper">
				<div class="progress-circular-inner">
					<div class="progress-circular-left">
						<div class="progress-circular-spinner"></div>
					</div>
					<div class="progress-circular-gap"></div>
					<div class="progress-circular-right">
						<div class="progress-circular-spinner"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<header class="header header-waterfall">
		<span class="header-logo">RetroPátio</span>
	</header>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-lg-push-4 col-sm-6 col-sm-push-3">
					<section class="content-inner">
						<div class="card-wrap">
							<div class="card">
								<div class="card-main">
									<div class="card-header">
										<div class="card-inner">
											<h1 class="card-heading">Login</h1>
										</div>
									</div>
									<div class="card-inner">
										<p class="text-center">
											<span class="avatar avatar-inline avatar-lg">
												<img alt="Login" src="${imgDir}/users/avatar-001.jpg">
											</span>
										</p>
										<form class="form" action="<c:url value="/autenticar"/>" method="post">
											<div class="form-group form-group-label">
												<div class="row">
													<div class="col-md-10 col-md-push-1">
														<label class="floating-label" for="login-username">Login</label>
														<input class="form-control" name="usuario.login" value="${usuario.login}" type="text">
													</div>
												</div>
											</div>
											<div class="form-group form-group-label">
												<div class="row">
													<div class="col-md-10 col-md-push-1">
														<label class="floating-label" for="login-password">Senha</label>
														<input class="form-control" name="usuario.senha" value="${usuario.senha}" type="password">
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-md-10 col-md-push-1">
														<button type="submit" class="btn btn-block waves-attach waves-button">Logar</button>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<p>RetroPátio</p>
		</div>
	</footer>

	<%@ include file="/WEB-INF/jsp/architecture/jquery.jsp" %>
	<%@ include file="/WEB-INF/jsp/architecture/erro.jsp" %>
</body>
</html>