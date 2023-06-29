const url = "http://localhost:8080/"


document.getElementById("backToLogin").onclick = goBack
document.getElementById("Register").onclick = register


async function goBack(){
    console.log("goback pressed")
    window.location.href="Login.html"
}

async function register(){

    let firsname = document.getElementById("firstName").value
    let lastname = document.getElementById("lastName").value
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let registerDTO = {
        firstName:firsname,
        lastName:lastname,
        username:username,
        password:password
    }

    console.log("registerDTO",registerDTO)
    
    await fetch(url + "auth/register",{
        method:"POST",
        headers:{
            "Content-Type": "application/json"
            
        },
        body:JSON.stringify(registerDTO)
    })
    .then((data)=>{
        if(data.status == 400){
            alert("Username taken, try picking a different name")


        }
        else if(data.status == 201){
            alert("Successfully Added Employee")
            goBack()

        }
        console.log(".then data", data)
    })
    .catch((error)=>{
        console.log("Error:",error)
       // document.getElementById("header").innerHTML = "Login Failed! Try again..."
    })


    
}