<html>
<body>
<%! 
	String makeItLower(String data){
		return data.toLowerCase();
	}
%>
lower case "Hello World": <%= makeItLower("Hello World!") %>
</body>
</html>