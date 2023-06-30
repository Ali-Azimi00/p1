const url = "http://localhost:8080/"

let loggedInUser = parseJwt(document.cookie)

console.log('user',loggedInUser)
console.log('userID',`tickets/employee/${loggedInUser.Id}`)

// document.getElementById("submitTicketBtn").onclick= createTicket
document.getElementById("submitTicketBtn").onclick = newTicket
document.getElementById("goBack").onclick= goBack

async function goBack(){
    window.location.href = "Login.html"
}

async function newTicket(){
    window.location.href = "NewTicket.html"
}


//GET ALL Tickets
//Thanks to window.onload, get all courses will happen automatically
window.onload = async function(){

    //we need to send a fetch request to get all courses. Remember, fetch requests send GETs by default
    await fetch(url + `tickets/employee/${loggedInUser.Id}`
    ,{
        method: "GET",
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Bearer: " + document.cookie
    }
    })

    .then((response) => response.json()) //extracting the JSON data, and turning it into JS
    .then((data) => {

        //print out the incoming data to make sure we can see it
        console.log(data)

        for(let ticket of data){
            
            let row = document.createElement("tr");
            let cell = document.createElement("td")
            cell.innerText = ticket.reimb_id;
            row.appendChild(cell)
            document.getElementById("tableBody").appendChild(row)

            let cell2 = document.createElement("td")
            cell2.innerText = ticket.description;
            row.appendChild(cell2)
            document.getElementById("tableBody").appendChild(row)

            let cell3 = document.createElement("td")
            cell3.innerText = "$" + ticket.amount;
            row.appendChild(cell3)
            document.getElementById("tableBody").appendChild(row)

            let cell4 = document.createElement("td")
            cell4.innerText = ticket.status.status_name;
            row.appendChild(cell4)
            document.getElementById("tableBody").appendChild(row)

        }

    })
    .catch((error) => {
        console.log("ERROR:", error)
        // console.log("header", document.getElementById("header"))

        // document.getElementById("header").innerHTML = "Login Failed! Try again..."
    })
}
//------------------------------------

// async function createTicket(){
 

//     let newTicket={
//         id: document.getElementById("userId").value,
//         description: document.getElementById("ticketDesc").value,
//         amount: document.getElementById("ticketAmout").value
//     }

//     console.log(newTicket)

//     console.log(document.cookie)

//     await fetch(url + `tickets/${loggedInUser.Id}`, {
//         method: "POST",
//         headers: {
//             "Content-type": "application/json",
//             "Authorization":"Bearer: " + document.cookie
        
//     },

//         body: JSON.stringify(newTicket)
//     })
//     .then((response)=> response.json())
//     .then((data)=>{
//         console.log(data)
//         alert("Ticket created!")
//     })
//     .catch((error)=>{
//         alert("failed to create" + error)
//     })



// }



function parseJwt (token) {
    console.log(token)
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
























