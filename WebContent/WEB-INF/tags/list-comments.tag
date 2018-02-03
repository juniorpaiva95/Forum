<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"
body-content="empty"%>
<%@ attribute name="comentarios" required="true" 
	rtexprvalue="true" type="java.util.List"%>
	
	
<c:forEach var="comentario" items="${ comentarios }">
	<div class="social-feed-box">
                                        <div class="social-avatar">
                                            <a href="" class="pull-left">
                                                <img alt="image" src="/Forum/template/img/a1.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="#">
                                                    <c:out value="${ comentario.getUsuario().getNome() }"></c:out>
                                                </a>
                                                <small class="text-muted">
													<c:out value="${ Utilitaries.formatarDataEHora(comentario.getCreated_at()) }"></c:out>
												</small>
                                            </div>
                                        </div>
                                        <div class="social-body">
                                            <p>
                                                <c:out value="${ comentario.getComentario() }"></c:out>
                                            </p>
                                        </div>
                                    </div>
</c:forEach>