const url = "http://localhost:8080/"

document.getElementById("backToList").onclick= goBack
document.getElementById("submitTicketBtn").onclick= createTicket

let loggedInUser = parseJwt(document.cookie)

console.log('user',loggedInUser)
//TODO submit ticket, copy register 

async function goBack(){
    window.location.href = "Employee.html"
}


async function createTicket(){
 

    let newTicket={
        id: loggedInUser.Id,
        description: document.getElementById("ticketDesc").value,
        amount: document.getElementById("ticketAmout").value
    }

    console.log(newTicket)

    console.log(document.cookie)

    if(newTicket.description != '' && newTicket.amount != ''){
        await fetch(url + `tickets/${loggedInUser.Id}`, {
            method: "POST",
            headers: {
                "Content-type": "application/json",
                "Authorization":"Bearer: " + document.cookie
            
        },
    
            body: JSON.stringify(newTicket)
        })
        .then((response)=> response.json())
        .then((data)=>{
            console.log(data)
    
            if(data.status == 400){
                alert("Something went wrong, please try again")
            }
            else{
                alert("Ticket created!")           
                goBack()
            }
    
            
            window.location.href = "Employee.html"
        })
        .catch((error)=>{
            alert("failed to create" + error)
        })
    }else{
        alert("Both fields must be filled for submission of a new ticket")
    }


    



}


function parseJwt (token) {
    console.log(token)
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
























