<%@page import="modelo.Usuario"%>
<nav class="navbar-default navbar-static-side" role="navigation">
  <div class="sidebar-collapse">
    <ul class="nav metismenu" id="side-menu">
      <li class="nav-header">
        <div class="dropdown profile-element"> <span>
          <img alt="image" class="img-circle" src="/Forum/template/img/profile_small.jpg" />
        </span>
        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
          <span class="clear"> <span class="block m-t-xs">
          <% Usuario u = (Usuario)request.getAttribute("userLogged"); %> 
          <%-- <strong class="font-bold"><% out.print(u.getLogin()); %></strong> --%>
        </span> <span class="text-muted text-xs block">Estudante - PWEB2<b class="caret"></b></span> </span> </a>
        <ul class="dropdown-menu animated fadeInRight m-t-xs">
          <li><a href="login.html">Logout</a></li>
        </ul>
      </div>
      <div class="logo-eslement">
        IN+
      </div>
    </li>
    <!-- <li>
      <a href="/Forum/template/forum.jsp"><i class="fa fa-th-large"></i> <span class="nav-label">Forum</span> <span class="fa arrow"></span></a>
    </li> -->
     <li>
      <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">Postagens</span> <span class="fa arrow"></span></a>
      <ul class="nav nav-second-level collapse">
        <li><a href="/Forum/postagem">Listar</a></li>
        <li><a href="/Forum/template/criar-postagem.jsp">Cadastrar</a></li>
      </ul>
    </li>
  </ul>

</div>
</nav>
