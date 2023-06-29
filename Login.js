const url = "http://localhost:8080/" //storing the base URL in this variable for cleaner code below

document.getElementById("loginButton").onclick = login
document.getElementById("Register").onclick= register

async function register(){
    window.location.href = "Register.html"
}


async function login(){

    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let loginDTO = {
        username:username,
        password:password
    }
 
    console.log(loginDTO) 

  await fetch(url + "auth/login", {

        method: "POST", 
        headers: {
            "Content-Type":"application/json"

        }, 
        body: JSON.stringify(loginDTO) 

    })

 
    .then((response) => response.json()) 
    .then((data) => { 

        //Globally visible data(across JS files)
        document.cookie = data.accessToken
        
        console.log("data",data)
        console.log("docCookie",document.cookie)

        if(parseJwt(data.accessToken).Role === "Employee"){
            console.log("Employee id:", parseJwt(data.accessToken).Id)
            window.location.href = "Employee.html"
        } else if(parseJwt(data.accessToken).Role === "Financial Manager"){
             window.location.href = "Manager.html"
        }

    })
    .catch((error)=> console.log ("Error: ", error))
    // .catch((error) => document.getElementById("header").innerHTML = "Login Failed! Try again...")
    .finally(() => alert("hi"))

}



//standard JWT parser, which should give us our payload (important user info)
function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
