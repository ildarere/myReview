'use strict'
document.addEventListener("DOMContentLoaded", ()=>ready());

function ready() {
sortBtn.addEventListener('click', ()=>{
            let select = document.getElementById('select-541a');
            let countryS=  select.options[select.selectedIndex].value;
            select = document.getElementById('select-8ad7');
            let genreS= select.options[select.selectedIndex].value;
            let yearI =document.getElementById('text-341b').value;
            let filter ={
                country: countryS,
                genre: genreS,
                years: yearI
            };


       		console.log(filter);
       		let xhr = new XMLHttpRequest();
       		xhr.open('POST', '/library/getFilmsByFilter', true);
       		xhr.addEventListener('readystatechange', ajaxFilterCallback.bind(xhr) );
       		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
       		xhr.send('filter=' + JSON.stringify(filter));

       	});
}
function ajaxFilterCallback() {
    let xhr=this;
	if (xhr.readyState !== 4) {
		return;
	}

	if (xhr.status === 200) {
	        let data = xhr.responseText;
            let dataJson = JSON.parse(data);
	        let blocks = document.querySelectorAll('.u-repeater-item');
            for(let b of blocks){
                b.remove();
            }

            if (data.length > 0) {
            try {

                 let repeater = document.querySelector('.u-repeater-1');

                 console.log(dataJson);
                 dataJson.forEach(p=>{
                         let div =document.createElement('div');
                         div.classList.add("u-container-style");
                         div.classList.add("u-list-item");
                         div.classList.add("u-repeater-item");
                         let div2 = document.createElement('div');
                         div2.classList.add("u-container-layout");
                         div2.classList.add("u-similar-container");
                         div2.classList.add("u-container-layout-1");
                         let div3 = document.createElement('div');
                         div3.classList.add("u-border-1");
                         div3.classList.add("u-border-grey-dark-1");
                         div3.classList.add("u-container-style");
                         div3.classList.add("u-custom-item");
                         div3.classList.add("u-expanded-width");
                         div3.classList.add("u-group");
                         div3.classList.add("u-radius-10");
                         div3.classList.add("u-shape-round");
                         div3.classList.add("u-group-1");
                         let div4 = document.createElement('div');
                         div4.classList.add("u-container-layout");
                         div4.classList.add("u-container-layout-2");
                         let img = document.createElement('img');
                         img.classList.add("u-image");
                         img.classList.add("u-image-default");
                         img.classList.add("u-image-1");
                         let pict = "images/"+p.name+".svg";
                         img.scr = pict;
                         let h1= document.createElement('h4');
                         h1.classList.add("u-text");
                         h1.classList.add("u-text-default");
                         h1.classList.add("u-text-1");
                         h1.innerHTML= "Рейтинг: "+p.rating;
                         let h2= document.createElement('h4');
                         h2.classList.add("u-text");
                         h2.classList.add("u-text-default");
                         h2.classList.add("u-text-2");
                         h2.innerHTML= p.name;
                         let a= document.createElement('a');
                         let link = "/film"+p.id;
                         a.href = link;
                         a.appendChild(h2);
                         let p1= document.createElement('p');
                         p1.classList.add("u-text");
                         p1.classList.add("u-text-default");
                         p1.classList.add("u-text-3");
                         p1.innerHTML= "Жанр: "+p.name;
                         let p2= document.createElement('p');
                         p2.classList.add("u-text");
                         p2.classList.add("u-text-default");
                         p2.classList.add("u-text-5");
                         p2.innerHTML= "Страна: "+p.country;
                         let p3= document.createElement('p');
                         p3.classList.add("u-text");
                         p3.classList.add("u-text-default");
                         p3.classList.add("u-text-4");
                         p3.innerHTML= "Страна: "+p.date;
                         div4.appendChild(img);
                         div4.appendChild(h1);
                         div4.appendChild(a);
                         div4.appendChild(p1);
                         div4.appendChild(p3);
                         div4.appendChild(p2);
                         div3.appendChild(div4);
                         div2.appendChild(div3);
                         div.appendChild(div2);
                         repeater.appendChild(div);

                    });
                 }catch(e){

                 }
            }

    }else {
		alert('Ajax error appear');
	}
}