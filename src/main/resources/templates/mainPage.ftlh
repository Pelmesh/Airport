<#if massages??>
    <p>${massages}</p>
</#if>>


<form action="" method="post">
    <div>
        <label>Start</label>
        <label>
            <input type="datetime-local" name="strDateStart"
                <#if dateStart??>
                   value="${dateStart}"
                </#if>
                   >
        </label>
        <label>End</label>
        <label>
            <input type="datetime-local" name="strDateEnd"
                    <#if dateEnd??>
                        value="${dateEnd}"
                    </#if>>
        </label>
        <input type="submit">
    </div>
    <div>
        <label>
            <select name="airportStart">
                <option selected disabled value="null">DEPARTURE</option>
                <#list airports as airport>
                    <option value="${airport.id}">${airport.city},${airport.name}</option>
                </#list>
            </select>
        </label>
        <label>
            <select name="airportEnd">
                <option selected disabled value="null">ARRIVAL</option>
                <#list airports as airport>
                    <option value="${airport.id}">${airport.city},${airport.name}</option>
                </#list>
            </select>
        </label>
    </div>
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
            <td>${flight.airportEnd.id},${flight.airportEnd.name}</td>
            <a href="/buy/${flight.id}">buy</a>
        </tr>
    </#list>
</table>