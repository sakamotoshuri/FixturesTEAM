<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dto.Fixturesdto" %>
      <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class=exclamation2 >
	備品管理
	</div>
     <nav class="navbar navbar-expand-lg navbar-dark " style =" background-color: #48CFAE;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="RegesterProduct">登録</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  カテゴリ
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=IT機器">IT機器</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=机">机</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=イス">イス</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=延長コード">延長コード</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=ホワイトボード">ホワイトボード</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=ロッカー">ロッカー</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=加湿器">加湿器</a></li>
                  <li><a class="dropdown-item" href="CategorySerchFixtures?category=トイレ">トイレ</a></li>
                  <li><hr class="dropdown-divider"></li>
                </ul>
              </li>
            </ul>
            <form class="d-flex" action="ProductSerchExcute" method="post">
             <input class="form-control me-2" type="text" name = "fixtures_name"placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>	


<table border="1">

	
		<tr>
			<th>id</th>
			<th>備品名</th>
			<th>個数</th>
			<th>カテゴリ</th>
		</tr>
	
		<%
	List<Fixturesdto> lista = (ArrayList<Fixturesdto>)request.getAttribute("list");
	for(Fixturesdto s : lista) {
		%>
	
		<tr>
			<td><a href = "FixturesSerchId?fixtures_id=<%=s.getFixtures_id() %>"><%=s.getFixtures_id()%></a></td>
			<td><%=s.getFixtures_name()%></td>
			<td><%=s.getQuantity()%></td>
			<td><a href = "CategorySerchFixtures?category=<%=s.getCategory() %>"><%=s.getCategory() %></a></td>
		</tr>

	<%} %>
	</table>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>