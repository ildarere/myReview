'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());
function ready() {
document.getElementById("deleteReview").addEventListener('click',()=>{
            console.log();
            let url  = window.location.href;
            let strs =  url.split('/');
            let id = strs.at(-1);
            let sendURL1 = '/'+ id + '/delete';
            let xhr = new XMLHttpRequest();
            xhr.open('POST', sendURL1, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('delete=' + 1);

});

document.getElementById("appearReview").addEventListener('click',()=>{

            let url  = window.location.href;
            let strs =  url.split('/');
            let id = strs.at(-1);
            let sendURL1 = '/'+ id + '/appearReview';
            let xhr = new XMLHttpRequest();
            xhr.open('POST', sendURL1, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('appearReview=' + 1);

});

}