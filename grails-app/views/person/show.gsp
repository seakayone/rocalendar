<!doctype html>
<html>
<head>
<meta name="layout" content="main" />
<title>Person show</title>
</head>

<body>
	<div id="page-body" class="content">
		<h1>Person Details</h1>
		<p>
		<ul>
			<li>Username: ${personInstance?.username.encodeAsHTML()}
			</li>
			<li>Email: ${personInstance?.profile?.email.encodeAsHTML()}
			</li>
		</ul>
		</p>
		<h1>Events</h1>
		<h1>Venues</h1>
	</div>
</body>
</html>
