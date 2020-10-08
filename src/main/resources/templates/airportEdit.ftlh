<#if messages??>
    <td>${messages}</td>
</#if>

<form action="/admin/airports/${airport.id}" method="post">
    Edit airport ${airport.id},${airport.name}
    <div><label> Country: <input type="text" value="${airport.country}" name="country"/> </label></div>
    <div><label> City: <input type="text" value="${airport.city}"  name="city"/> </label></div>
    <div><label> Name: <input type="text" value="${airport.name}"  name="name"/> </label></div>
    <div><label> IATA: <input type="text" value="${airport.IATA}"  name="IATA"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Save"/></div>
</form>