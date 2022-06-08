'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());
function ready() {

document.getElementById("searchBtn").addEventListener('click',()=>{
            let name=  document.getElementById("searchField").value;


            let xhr = new XMLHttpRequest();
            xhr.open('POST', "/library/search", true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('name=' + name);

});


}