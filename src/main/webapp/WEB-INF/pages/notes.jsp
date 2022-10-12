<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:user_wrapper>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notes.css" type="text/css"/>

    <div id="current_note_container">
        <div id="selected_note">
            <h1>Create A New Note</h1>
            <form action="/note/add" method="post">
                <label>Title: </label>
                <input type="text" name="title" value="${newNote.title}">
                <br><br><br>
                <textarea rows="10" cols="55" type="text" name="content" value="${newNote.content}"></textarea>
                <br><br>
                <input type="submit" value="Create New Note">
            </form>
        </div>
    </div>
    <div id="notes_container">
        <h1>Your Notes</h1>
        <div id="create_new_note_button">

        </div>

        <div id="notes_collection">

        <c:choose>
            <c:when test = "${notes.size() > 0}">
                <c:forEach var="note" items="${notes}">
                    <div id="note_list_item" onclick="selectNote('${note.title}', '${note.created}', '${note.content}', ${note.note_id})">
                        <b><c:out value="${note.title}"/></b><br>
                        <c:out value="${note.created}"/><br>
                        <c:out value="${note.content}"/></div><br>
                </c:forEach>
            </c:when>
            <c:otherwise>
                Your Currently Don't Have Any Notes.
            </c:otherwise>
        </c:choose>
        </div>
    </div>

    <script>
        function showCreateNote(){
            document.getElementById("selected_note").innerHTML =
                '<h1>Create A New Note</h1>' +
                '<form action="/note/add" method="post">' +
                '<br><label>Title: </label>' +
                '<input type="text" name="title" value="${newNote.title}">' +
                '<br><br>' +
                '<textarea rows="10" cols="55" type="text" name="content" value="${newNote.content}"></textarea>' +
                '<br><br>' +
                '<input type="submit" value="Create New Note">' +
                '</form>';

            document.getElementById("create_new_note_button").innerHTML = '';
        }

        function selectNote(title, created, content, id){
            document.getElementById("selected_note").innerHTML =
                '<div id="new_note_text"><h1>'+ title + '</h1><br>' + created + '<br><br>' + content + '<br><br>' +
                '<br><form action="/note/delete" method="post">' +
                '<input type="hidden" name="note_id" value="'+ id +'" />' +
                '<input type="submit" value="Delete Note">' +
                '</form><br><br></div>';
            document.getElementById("create_new_note_button").innerHTML =
                '<button onclick="showCreateNote()">Add A Note</button>';
        }
    </script>
</t:user_wrapper>