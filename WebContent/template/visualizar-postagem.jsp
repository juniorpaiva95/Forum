<!DOCTYPE html>
<%@page import="util.Utilitaries"%>
<%@page import="modelo.Postagem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@page import="fachada.Fachada"%>

<html>

  <head>

    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>INSPINIA</title>

        <link href="/Forum/template/css/bootstrap.min.css" rel="stylesheet">
          <link href="/Forum/template/font-awesome/css/font-awesome.css" rel="stylesheet">

            <link href="/Forum/template/css/animate.css" rel="stylesheet">
              <link href="/Forum/template/css/style.css" rel="stylesheet">

              </head>

              <body class="">

                <div id="wrapper">

                  <%@include file="includes/menu-sidebar.jsp" %>

                  <div id="page-wrapper" class="gray-bg">
                    <div class="row border-bottom">
                      <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                          <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                          <form role="search" class="navbar-form-custom" action="search_results.html">
                            <div class="form-group">
                              <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                              </div>
                            </form>
                          </div>
                          <ul class="nav navbar-top-links navbar-right">
                            <li>
                              <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                            </li>
                            <li class="dropdown">
                              <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                              </a>
                              <ul class="dropdown-menu dropdown-messages">
                                <li>
                                  <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                      <img alt="image" class="img-circle" src="img/a7.jpg">
                                      </a>
                                      <div class="media-body">
                                        <small class="pull-right">46h ago</small>
                                        <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                      </div>
                                    </div>
                                  </li>
                                  <li class="divider"></li>
                                  <li>
                                    <div class="dropdown-messages-box">
                                      <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                        </a>
                                        <div class="media-body ">
                                          <small class="pull-right text-navy">5h ago</small>
                                          <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                          <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                        </div>
                                      </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                      <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                          <img alt="image" class="img-circle" src="img/profile.jpg">
                                          </a>
                                          <div class="media-body ">
                                            <small class="pull-right">23h ago</small>
                                            <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                            <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                          </div>
                                        </div>
                                      </li>
                                      <li class="divider"></li>
                                      <li>
                                        <div class="text-center link-block">
                                          <a href="mailbox.html">
                                            <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                          </a>
                                        </div>
                                      </li>
                                    </ul>
                                  </li>
                                  <li class="dropdown">
                                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                      <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-alerts">
                                      <li>
                                        <a href="mailbox.html">
                                          <div>
                                            <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                            <span class="pull-right text-muted small">4 minutes ago</span>
                                          </div>
                                        </a>
                                      </li>
                                      <li class="divider"></li>
                                      <li>
                                        <a href="profile.html">
                                          <div>
                                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                            <span class="pull-right text-muted small">12 minutes ago</span>
                                          </div>
                                        </a>
                                      </li>
                                      <li class="divider"></li>
                                      <li>
                                        <a href="grid_options.html">
                                          <div>
                                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                            <span class="pull-right text-muted small">4 minutes ago</span>
                                          </div>
                                        </a>
                                      </li>
                                      <li class="divider"></li>
                                      <li>
                                        <div class="text-center link-block">
                                          <a href="notifications.html">
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                          </a>
                                        </div>
                                      </li>
                                    </ul>
                                  </li>


                                  <li>
                                    <a href="/Forum/logout">
                                      <i class="fa fa-sign-out"></i> Log out
                                    </a>
                                  </li>
                                </ul>

                              </nav>
                            </div>
                            <div class="row wrapper border-bottom white-bg page-heading">
                              <div class="col-sm-4">
                                <h2>Bem-vindo ao Forum PWEB-2</h2>
                                <ol class="breadcrumb">
                                  <li>
                                    <a href="/Forum/">Forum</a>
                                  </li>
                                  <li class="active">
                                  <jsp:useBean id="daoPostagem" class="daojpa.DAOPostagem"/>
<%
	Fachada.inicializar();
   	String id = request.getParameter("id");
   	Postagem p = daoPostagem.localizarPeloId(Integer.parseInt(id));
	Fachada.finalizar();
%>
                                    <strong><% out.print(p.getTitulo()); %></strong>
                                  </li>
                                </ol>
                              </div>
                              <div class="col-sm-8">
                                <div class="title-action">
                                  <a href="" class="btn btn-primary">This is action area</a>
                                </div>
                              </div>
                            </div>

                            <div class="wrapper wrapper-content">
                              <div class="row">
                                <div class="col-lg-10 col-lg-offset-1">
                    <div class="ibox">
                        <div class="ibox-content">
                            <div class="pull-right">
                                <button class="btn btn-white btn-xs" type="button">Model</button>
                                <button class="btn btn-white btn-xs" type="button">Publishing</button>
                                <button class="btn btn-white btn-xs" type="button">Modern</button>
                            </div>
                            <div class="text-center article-title">
                            <span class="text-muted"><i class="fa fa-clock-o"></i> <% out.print(Utilitaries.formatarDataEHora(p.getCreated_at())); %></span>
                                <h1>
                                    <% out.print(p.getTitulo()); %>
                                </h1>
                            </div>
                            <p>
                                <c:out value="${ p.getTexto() }"></c:out>
                            </p>
                            <hr>
                            <div class="row">
                                <div class="col-md-6">
                                        <h5>Tema:</h5>
                                        <button class="btn btn-white btn-xs" type="button">
                                         <% out.print(p.getTema().getNome()); %>
                                        </button>
                                </div>
                                <div class="col-md-6">
                                    <div class="small text-right">
                                        <h5>Estatisticas:</h5>
                                        <div> <i class="fa fa-comments-o"> </i> <% out.print(p.getComentarios().size()); %> comments </div>
                                        <i class="fa fa-eye"> </i> <% out.print(p.getViews()); %> views
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">

                                    <h2>Comments:</h2>
                                    <div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="img/a1.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    Andrew Williams
                                                </a>
                                                <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                                                default model text, and a search for 'lorem ipsum' will uncover many web sites still
                                                default model text.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="img/a2.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    Michael Novek
                                                </a>
                                                <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                                                default model text, and a search for 'lorem ipsum' will uncover many web sites still
                                                default model text, and a search for 'lorem ipsum' will uncover many web sites still
                                                in their infancy. Packages and web page editors now use Lorem Ipsum as their
                                                default model text.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="img/a3.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    Alice Mediater
                                                </a>
                                                <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                                                default model text, and a search for 'lorem ipsum' will uncover many web sites still
                                                in their infancy. Packages and web page editors now use Lorem Ipsum as their
                                                default model text.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="img/a5.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    Monica Flex
                                                </a>
                                                <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                                                default model text, and a search for 'lorem ipsum' will uncover many web sites still
                                                in their infancy. Packages and web page editors now use Lorem Ipsum as their
                                                default model text.
                                            </p>
                                        </div>
                                    </div>


                                </div>
                            </div>


                        </div>
                    </div>
                </div>
                              </div>
                            <%@include file="includes/footer.jsp" %>

                          </div>
                        </div>

                        <!-- Mainly scripts -->
                        <script src="/Forum/template/js/jquery-3.1.1.min.js"></script>
                        <script src="/Forum/template/js/bootstrap.min.js"></script>
                        <script src="/Forum/template/js/plugins/metisMenu/jquery.metisMenu.js"></script>
                        <script src="/Forum/template/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

                        <!-- Custom and plugin javascript -->
                        <script src="/Forum/template/js/inspinia.js"></script>
                        <script src="/Forum/template/js/plugins/pace/pace.min.js"></script>



                      </body>

                    </html>
