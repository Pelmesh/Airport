<#if messages??>
    <td>${messages}</td>
</#if>
<#list users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td><a href="/admin/users/${user.id}">edit</a></td>
        <td><form action="/admin/users/delete/${user.id}" method="post">
            <input type="submit" value="delete"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form></td>
    </tr>
</#list>