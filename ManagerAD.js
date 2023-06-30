const url = "http://localhost:8080/"

let loggedInUser = parseJwt(document.cookie)

let managerAuth= document.cookie

document.getElementById("goBack").onclick = goBack

async function goBack(){

    window.location.href ="Manager.html"
}



window.onload = async function(){


    await fetch (url+"tickets/manager/Pending",{
        method:"GET",
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Bearer"+ document.cookie
        }
    })
    .then((response)=> response.json())
    .then((data)=>{
        
        

        for(let ticket of data){

            let row = document.createElement("tr");
            let cell = document.createElement("td")
            cell.innerText = ticket.user.id;
            row.appendChild(cell)
            // row.setAttribute("style", "background: red")
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
            document.getElementById("tableBody").appendChild(row)

            let cell6 = document.createElement("td")
            cell6.innerText = "$" + ticket.amount;
            row.appendChild(cell6)
            document.getElementById("tableBody").appendChild(row)
            
            let cell7 = document.createElement("td")
            cell7.innerText = ticket.description;
            row.appendChild(cell7)
            document.getElementById("tableBody").appendChild(row)
    
            //BUTTONS
            let cell8 = document.createElement("td")
            let cell9 = document.createElement("td")

            let reimbId = ticket.reimb_id
            let approved = 2
            let denied = 3

            var approveBtn = document.createElement("button")
            approveBtn.innerText = "Approve"
            approveBtn.className= "btn btn-success"            
            approveBtn.onclick =()=> approveDenyFunction(reimbId,approved)

            var denyBtn = document.createElement("button")
            denyBtn.innerText = "Deny"
            denyBtn.className= "btn btn-danger"
            denyBtn.onclick =()=> approveDenyFunction(reimbId,denied)

            cell8.appendChild(approveBtn)
            row.appendChild(cell8)

            cell9.appendChild(denyBtn)
            row.appendChild(cell9)
        }

    })
    .catch((error) => {
        console.log("ERROR:", error)
        // console.log("header", document.getElementById("header"))

        // document.getElementById("header").innerHTML = "Login Failed! Try again..."
    })
}


function approveDenyFunction(ticketId,statusId){    

    let updatedStatus = {
        reimb_id: ticketId,
        status: {id: statusId}
    }  

    fetch(url+"tickets/manager/Pending"
    ,{
        method:"PUT",
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Bearer: " + document.cookie
        },
        body: JSON.stringify(updatedStatus)
    })
    .then((response)=>response.json())
    .then((data)=>{
        
        let stat =  statusId == 2? "Approved": "Denied"
        console.log(data)
        alert("Ticket #" +ticketId + "'s status has been updated to " + stat)
        window.location.href = "ManagerAD.html"

    })
    .catch((error)=> console.log ("Catch Error: ", error))




}


function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
