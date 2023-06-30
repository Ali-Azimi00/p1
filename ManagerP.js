const url = "http://localhost:8080/"

let loggedInUser = parseJwt(document.cookie)
console.log('manager',loggedInUser)

document.getElementById("approveDeny").onclick = adReq

document.getElementById("showAll").onclick = showAllTickets
document.getElementById("showApproved").onclick = showApproved
document.getElementById("showDenied").onclick = showDenied
document.getElementById("goBack").onclick= goBack

async function goBack(){
    window.location.href = "Login.html"
}


async function adReq(){
    window.location.href = "ManagerAD.html"
}

async function showDenied(){
    window.location.href = "ManagerD.html"
}

async function showApproved(){
    window.location.href = "ManagerA.html"
}

function showAllTickets(){
    window.location.href = "Manager.html"
}


window.onload = async function(){


    await fetch(url + `tickets/manager/Pending`,{
        method: "GET",
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Bearer: " + document.cookie
        }
    })
    .then((response)=>response.json())
    .then((data)=>{
        console.log(data)

        //approveBtn.className= "btn btn-success"


        for(let ticket of data){
            
            let row = document.createElement("tr");
            let cell = document.createElement("td")
            cell.innerText = ticket.user.id;
            
            row.appendChild(cell)
            document.getElementById("tableBody").appendChild(row)

            let cell2 = document.createElement("td")
            cell2.innerText = ticket.user.firstName;
            row.appendChild(cell2)
            document.getElementById("tableBody").appendChild(row)

            let cell3 = document.createElement("td")
            cell3.innerText = ticket.user.lastName;
            row.appendChild(cell3)
            document.getElementById("tableBody").appendChild(row)

            let cell4 = document.createElement("td")
            cell4.innerText = ticket.reimb_id;
            row.appendChild(cell4)
            document.getElementById("tableBody").appendChild(row)

            let cell5 = document.createElement("td")
            cell5.innerText = ticket.status.status_name;
            row.appendChild(cell5)
            // cell5.setAttribute("style", "background: yellow")
            document.getElementById("tableBody").appendChild(row)

            let cell6 = document.createElement("td")
            cell6.innerText = "$" + ticket.amount;
            row.appendChild(cell6)
            document.getElementById("tableBody").appendChild(row)
            
            let cell7 = document.createElement("td")
            cell7.innerText = ticket.description;
            row.appendChild(cell7)
            document.getElementById("tableBody").appendChild(row)

        }
    })
}


// let statusColor=(status)=>{
//     let color = "yellow"
//     if(status == 'Approved'){
//         color= "Green"
//     }
//     else if(status == "Denied"){
//         color = "Red"
//     }
//     return cell5.setAttribute("style", "background: red")
// }


function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}


