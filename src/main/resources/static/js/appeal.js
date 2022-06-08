'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());
function ready() {
document.querySelectorAll('#delete').forEach(e => e.addEventListener('click', ()=>{
            let id = e.value;
            let xhr = new XMLHttpRequest();
            xhr.open('POST', "/appeal/delete", true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('id=' + id);
            document.getElementById("id"+id).remove();
}));








}