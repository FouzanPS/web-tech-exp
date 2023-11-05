document.getElementById("butn").addEventListener("click", function(event){
    event.preventDefault();
    update();
    clear();
});

function update() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let position = document.getElementById("position").value;
    let skills = document.getElementById("skills").value;


    if (phone.length !== 10 || position === "" || skills === "") {
        alert("Your phonerno is correct or positon or skills is empty please fill it properly.");
    } else {
        let obj = {
            name: name,
            email: email,
        };
        obj.phone = phone;
        obj.position = position;
        obj.skills = skills;
        let data = JSON.stringify(obj);
        localStorage.setItem("FormData", data);
        alert("Form updated,Data stored locally on the browser");
    }


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