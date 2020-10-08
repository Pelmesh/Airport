<#if messages??>
    <td>${messages}</td>
</#if>
<form action="/admin/users/${user.id}" method="post">
    user: ${user.username}
    <div><label> User Name : <input type="text" name="username" value="${user.username}"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Save"/></div>
</form>



