<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<c:forEach items="${user.blogs}" var="blog">
  <div class="tab-pane" id="blog_${blog.id}">
	<h1><c:out value="${blog.name}" /></h1>
	<p>
	
	<a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a>
	
	<c:out value="${blog.url}" /></p>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td><c:out value="${item.title}" /></td>
					<td><c:out value="${item.link}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</c:forEach>
