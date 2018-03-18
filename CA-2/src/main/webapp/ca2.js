document.getElementById("btnsend").addEventListener("click", getPersonsByZip);
document.getElementById("btnsend").addEventListener("click", getPersonById);
document.getElementById("btnsend").addEventListener("click", getAllPersons);
document.getElementById("btnsend").addEventListener("click", getPersonsByHobby);


function getPersonsByZip() {
    var zipcode = document.getElementById("getPersonsByZip").value;

    console.log("zipcode " + zipcode);
    fetch("http://localhost:8084/CA-2/api/person/zip/" + zipcode)
            .then(function (res) {
                return res.json();
            }).then(function (data) {
//        temp = [];
//        temp = data;
//        console.log(temp);
        console.log(data);
        var newArray = data.map(function (element) {
            return "<tr><td>" + element.firstName + "</td><td>" + element.id + "</td></tr>";
        });
        document.getElementById("tbl").innerHTML = newArray.join("");
    });
}
function getPersonById() {
    var id = document.getElementById("getPersonById").value;

    console.log("id " + id);
    fetch("http://localhost:8084/CA-2/api/person/id/" + id)
            .then(function (res) {
                return res.json();
            }).then(function (data) {
        console.log(data);

        document.getElementById("tbl").innerHTML = "<tr><td>" + data.firstName + "</td><td>" + data.id + "</td></tr>"
    });
}
function getAllPersons() {
    fetch("http://localhost:8084/CA-2/api/person" )
            .then(function (res) {
                return res.json();
            }).then(function (data) {
//        temp = [];
//        temp = data;
//        console.log(temp);
        console.log(data);
        var newArray = data.map(function (element) {
            return "<tr><td>" + element.firstName + "</td><td>" + element.hobbyIds + "</td><td>" + element.id + "</td></tr>";
        });
        document.getElementById("tbl").innerHTML = newArray.join("");
    });
    }
function getPersonsByHobby() {
    var hobby = document.getElementById("getPersonsByHobby").value;

    console.log("hobby " + hobby);
    fetch("http://localhost:8084/CA-2/api/person/hobby/" + hobby)
            .then(function (res) {
                return res.json();
            }).then(function (data) {
//        temp = [];
//        temp = data;
//        console.log(temp);
        console.log(data);
        var newArray = data.map(function (element) {
            return "<tr><td>" + element.firstName + "</td><td>" + element.hobbyIds + "</td><td>" + element.id + "</td></tr>";
        });
        document.getElementById("tbl").innerHTML = newArray.join("");
    });
}



