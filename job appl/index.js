document.getElementById("butn").addEventListener("click", function(event){
    event.preventDefault();
    update();
    clear();
    alert("Form updated,Data stored locally on the browser");
});

function update() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let position = document.getElementById("position").value;
    let skills = document.getElementById("skills").value;

    let obj = {
        name: name,
        email: email,
    };

    if (phone.length !== 10) {
        alert("Please enter a valid phone number!");
    } else {
        obj.phone = phone;
    }

    if (position === "" || skills === "") {
        alert("Your position or skill column is empty, please fill it!");
    } else {
        obj.position = position;
        obj.skills = skills;
    }

    let data = JSON.stringify(obj);
    localStorage.setItem("FormData", data);
}
function clear(){
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("position").value = "";
    document.getElementById("skills").value = "";
    document.getElementById("resume").value = "";
    document.getElementById("cover_letter").value = "";
    document.getElementById("experience").value = "";
}