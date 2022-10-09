<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:user_wrapper>

    <h1>Your Notes</h1>
    <c:choose>
        <c:when test = "${notes.size() > 0}">

            <c:forEach var="note" items="${notes}">
                <c:out value="${note.title}"/><br>
                <c:out value="${note.created}"/><br>
                <c:out value="${note.content}"/>

                <form action="/note/delete" method="post">
                    <input type="hidden" name="note_id" value="${note.note_id}" />
                    <input type="submit" value="Delete Note">
                </form><br>
                <br>
            </c:forEach>

        </c:when>
        <c:otherwise>

            Your Currently Don't Have Any Notes.

        </c:otherwise>
    </c:choose>

    <br>
    <h1>Create New Note</h1>
    <form action="/note/add" method="post">
        <label>Title: </label>
        <input type="text" name="title" value="${newNote.title}">
        <label>Content: </label>
        <input type="text" name="content" value="${newNote.content}">
        <input type="submit" value="Create New Note">
    </form>

</t:user_wrapper>