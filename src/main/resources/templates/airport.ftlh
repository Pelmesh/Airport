<#if messages??>
    <td>${messages}</td>
</#if>

<form action="/admin/airport" method="post">
    add airport
    <div><label> Country: <input type="text" name="country"/> </label></div>
    <div><label> City: <input type="text" name="city"/> </label></div>
    <div><label> Name: <input type="text" name="name"/> </label></div>
    <div><label> IATA: <input type="text" name="IATA"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Save"/></div>
</form>

<table>
    <#list airports as airport>
        <tr>
            <td>${airport.country}</td>
            <td>${airport.city}</td>
            <td>${airport.name}</td>
            <td>${airport.IATA}</td>
            <td><a href="/admin/airports/${airport.id}">edit</a></td>
            <td><form action="/admin/airports/delete/${airport.id}" method="post">
                    <input type="submit" value="delete"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form></td>
        </tr>
    </#list>
</table>
