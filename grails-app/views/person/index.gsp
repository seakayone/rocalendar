<!doctype html>
<html>
<head>
	<meta name="layout" content="main" />
	<title>Person show</title>
</head>

<body>
	<h1>Person Details</h1>
	<div>Username: ${personInstance?.username.encodeAsHTML()}</div>
	<div>Email: ${personInstance?.profile?.email.encodeAsHTML()}</div>
	<h1>Events</h1>
	<h1>Venues</h1>
</body>
</html>
