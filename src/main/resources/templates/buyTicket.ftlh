<#if messages??>
    <td>${messages}</td>
</#if>

<#if flight??>
    <table>
        <tr>
            <td>${flight.numberFlight}</td>
            <td>${flight.dateStart}</td>
            <td>${flight.dateEnd}</td>
            <td>${flight.timeFlight}</td>
            <td>${flight.airportStart.name}</td>
            <td>${flight.airportStart.name}</td>
        </tr>
    </table>

<form  method="post">
    <div><label> Name : <input type="text" name="name"/> </label></div>
    <div><label> Surname : <input type="text" name="surname"/> </label></div>
    <div><label> PasspordID : <input type="text" name="passportID"/> </label></div>
    <div><input type="submit" value="Buy"/></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>

</#if>