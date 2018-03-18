<%-- 
    Document   : ca2
    Created on : 16-03-2018, 12:09:01
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- CDN Polyfills which should allow you to use fetch (and promises) from IE and older browsers -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.3/fetch.min.js"></script>
    </head>
    <body class="container">
        <H2>Data Generator</h2>
      
        <input type="number" id="getPersonsByZip" placeholder="Get persons by zip">
            <input type="number" id="getPersonById" placeholder="Get person by id">
            <input type="number" id="getAllPersonsByHobby" placeholder="getAllPersonsByHobby">
            <input type="button" id="getAllPersons" placeholder="Get all persons in the API">
            
            <button class="btn btn-default" id="btnsend"> Submit </button>
            <br/>
            <div class="row">
                <div class="col-md-6">

                    <table id="tbl" class="table">
                        <thead>
                        <th>firstName</th><th>ID</th>
                        </thead>
                        <!-- >TODO: Dynamically create the rows with data fetched from the API, and insert into the table here -->
                        <tbody id="tblbody"></tbody>
                    </table>
                </div>
            </div>
        </div>

        <script  src="ca2.js"></script>

    </body>
</html>
