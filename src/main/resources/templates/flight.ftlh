<#if messages??>
    <td>${messages}</td>
</#if>

<form action="/admin/flight" method="post">
    <div>
        <label>Start</label>
        <input type="datetime-local" name="strDateStart" required>
        <label>End</label>
        <input type="datetime-local" name="strDateEnd" required>
        <input type="submit">
    </div>
    <div>
        <label>
            <select name="airportStart">
                <#list airports as airport>
                    <option value="${airport.id}">${airport.name},${airport.IATA}</option>
                </#list>
            </select>
        </label>
        <label>
            <select name="airportEnd">
                <#list airports as airport>
                    <option value="${airport.id}">${airport.name},${airport.IATA}</option>
                </#list>
            </select>
        </label>
    </div>
    <div><label> TotalNumberSeats : <input type="text" name="totalNumberSeats"/> </label></div>
    <div><label> NumberlFlight : <input type="text" name="numberFlight"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>

<table>
    <#list flights as flight>
        <tr>
            <td>${flight.id}</td>
            <td>${flight.numberFlight}</td>
            <td>${flight.dateStart}</td>
            <td>${flight.dateEnd}</td>
            <td>${flight.timeFlight}</td>
            <td>${flight.totalNumberSeats}</td>
            <td>${flight.remainingNumberSeats}</td>
            <td>${flight.airportStart.id},${flight.airportStart.name}</td>
            <td>${flight.airportEnd.id},${flight.airportStart.name}</td>
            <td><a href="/admin/flights/${flight.id}">edit</a></td>
            <td><form action="/admin/flights/delete/${flight.id}" method="post">
                    <input type="submit" value="delete"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form></td>
        </tr>
    </#list>
</table>
