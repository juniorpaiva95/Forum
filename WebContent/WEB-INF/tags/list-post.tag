<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"
body-content="empty"%>
<%@ attribute name="postagens" required="true" 
	rtexprvalue="true" type="java.util.List"%>

<c:forEach var="p" items="${ postagens }">

<div class="col-lg-4">
                                  <div class="ibox">
                                    <div class="ibox-content">
                                      <a href="/Forum/postagem/?title=${ p.getTitulo() }" class="btn-link">
                                        <h2>
                                          <c:out value="${ p.getTitulo() }"></c:out>
                                        </h2>
                                      </a>
                                      <div class="small m-b-xs">
                                        <strong><c:out value="${ p.getUsuario().getNome() }"></c:out></strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 04 Dec 2015</span>
                                      </div>
                                      <p>
                                        <c:out value="${ p.getTexto() }"></c:out>
                                      </p>
                                      <div class="row">
                                        <div class="col-md-6">
                                          <h5>Tema:</h5>
                                          <button class="btn btn-white btn-xs" type="button"><c:out value="${ p.getTema().getNome() }"></c:out></button>

                                        </div>
                                        <div class="col-md-6">
                                          <div class="small text-right">
                                            <h5>Estatísticas:</h5>
                                            <div> <i class="fa fa-comments-o"> </i> <c:out value="${ p.getComentarios().size() }"></c:out> comments </div>
                                            <i class="fa fa-eye"> </i> 17 views
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
</c:forEach>