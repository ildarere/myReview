'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());
function ready() {
document.getElementById("02").addEventListener('click',()=>{
            console.log();
            let url  = window.location.href;
            let strs =  url.split('/');
            let id = strs.at(-1);
            let sendURL1 = '/'+ id + '/getViewed';
            let xhr = new XMLHttpRequest();
            xhr.open('POST', sendURL1, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('isViewed=' + document.getElementById("02").checked);

});

document.getElementById("select-541a").addEventListener('change',(event)=>{
            let url  = window.location.href;
            let strs =  url.split('/');
            let id = strs.at(-1);
            let sendURL1 = '/'+ id + '/setList';
            let xhr = new XMLHttpRequest();
            xhr.open('POST', sendURL1, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            xhr.send('list=' + event.target.value);
});

}