'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());
function ready() {
sendReview.addEventListener('click', ()=>{
            let rating = 0;
            rating = document.querySelector('input[name="rating"]:checked').value;
            let review = document.getElementById('message-6797').value;
            let name = document.getElementById('text-4af6').value;
            let rev = {};
            rev.text = review;
            rev.nameReview = name;
            let url  = window.location.href;
            let strs =  url.split('/');
            let id = strs.at(-2);
            let sendURL1 = '/'+ id + '/writeReview/addReview';
            let sendURL2 = '/'+ id + '/writeReview/addRating';
            if(review!==''){
                let xhr = new XMLHttpRequest();
                xhr.open('POST', sendURL1, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
                xhr.send('review=' + JSON.stringify(rev));
                let xhr1 = new XMLHttpRequest();
                xhr1.open('POST', sendURL2, true);
                xhr1.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
                xhr1.send('rating=' + rating);
            }


       	});
}