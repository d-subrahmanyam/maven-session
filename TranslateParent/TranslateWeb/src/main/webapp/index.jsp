<html>
<body>
	<center>
		<form action="/TranslateServlet" method="POST">
			<table>
				<tr>
					<td>Enter a text to translate</td>
					<td><input type="text" name="inputText"></td>
				</tr>
				<tr>
					<td>Select the language to translate</td>
					<td>
					<select name="lang" >
						<option name="French">French
						<option name="German">German
						<option name="Spanish">Spanish
					</select>
					</td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="Translate"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>
